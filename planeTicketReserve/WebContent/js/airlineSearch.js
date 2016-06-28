(function($){

	function pagerFilter(data){
	if ($.isArray(data)){	// is array
		data = {
			total: data.length,
			rows: data
		}
	}
	var target = this;
	var dg = $(target);
	var state = dg.data('datagrid');
	var opts = dg.datagrid('options');
	if (!state.allRows){
		state.allRows = (data.rows);
	}
	if (!opts.remoteSort && opts.sortName){
		var names = opts.sortName.split(',');
		var orders = opts.sortOrder.split(',');
		state.allRows.sort(function(r1,r2){
			var r = 0;
			for(var i=0; i<names.length; i++){
				var sn = names[i];
				var so = orders[i];
				var col = $(target).datagrid('getColumnOption', sn);
				var sortFunc = col.sorter || function(a,b){
					return a==b ? 0 : (a>b?1:-1);
				};
				r = sortFunc(r1[sn], r2[sn]) * (so=='asc'?1:-1);
				if (r != 0){
					return r;
				}
			}
			return r;
		});
	}
	var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = state.allRows.slice(start, end);
	return data;
}

var loadDataMethod = $.fn.datagrid.methods.loadData;
var deleteRowMethod = $.fn.datagrid.methods.deleteRow;
$.extend($.fn.datagrid.methods, {
	clientPaging: function(jq){
		return jq.each(function(){
			var dg = $(this);
            var state = dg.data('datagrid');
            var opts = state.options;
            opts.loadFilter = pagerFilter;
            var onBeforeLoad = opts.onBeforeLoad;
            opts.onBeforeLoad = function(param){
                state.allRows = null;
                return onBeforeLoad.call(this, param);
            }
            var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNum, pageSize){
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh',{
						pageNumber:pageNum,
						pageSize:pageSize
					});
					dg.datagrid('loadData',state.allRows);
				}
			});
            $(this).datagrid('loadData', state.data);
            if (opts.url){
            	$(this).datagrid('reload');
            }
		});
	},
    loadData: function(jq, data){
        jq.each(function(){
            $(this).data('datagrid').allRows = null;
        });
        return loadDataMethod.call($.fn.datagrid.methods, jq, data);
    },
    deleteRow: function(jq, index){
    	return jq.each(function(){
    		var row = $(this).datagrid('getRows')[index];
    		deleteRowMethod.call($.fn.datagrid.methods, $(this), index);
    		var state = $(this).data('datagrid');
    		if (state.options.loadFilter == pagerFilter){
    			for(var i=0; i<state.allRows.length; i++){
    				if (state.allRows[i] == row){
    					state.allRows.splice(i,1);
    					break;
    				}
    			}
    			$(this).datagrid('loadData', state.allRows);
    		}
    	});
    },
    getAllRows: function(jq){
    	return jq.data('datagrid').allRows;
    }
})
})(jQuery);


function myformatter(date){  
    var y = date.getFullYear();  
    var m = date.getMonth()+1;  
    var d = date.getDate();  
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
}
var obj;
$(function(){  
　  var curr_time = new Date();     
 　 $("#date").datebox("setValue",myformatter(curr_time));
  $('#date').datebox('calendar').calendar({
		validator: function(date){
			var now = new Date();
			var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
			var d2 = new Date(now.getFullYear(), now.getMonth(), now.getDate()+30);
			return d1<=date && date<=d2;
		}
	});
   $.ajax({
		url:'city.json',
		method:'GET',
		async: false,
		success: function(data){
			obj =eval(data);
			$('#start').combobox('loadData',obj);
			$('#end').combobox('loadData',obj);
		}
  });
});
function find(){
	var s = $('#start').textbox('getValue');
	var e = $('#end').textbox('getValue');
	
	if(s)if(e){
		var cc = 0;
		for(var i = 0;i < obj.length;i++){
			if(obj[i]['cnCityName']==s){
				cc ++;
			}
			if(obj[i]['cnCityName']==e){
				cc +=2;
			}
		}
		if(cc == 3){
			findDate = $('#date').datebox('getValue');
			$.messager.progress();
			$('#ff').form('submit',{
				url:'../REST/REST/Service/getAirLines',
				onSubmit:function(){
					
				},
				success:function(data){
					var cc = eval(data);
					for(var i = 0;i < cc.length;i++){
						cc[i].StartTime= findDate + " " + cc[i].StartTime;
						cc[i].ArriveTime= findDate + " " + cc[i].ArriveTime;
					}
					$.messager.progress('close');	
					$('#dd').datagrid('loadData',cc);
					$('#dd').datagrid('reloadFooter');
					$('#dd').datagrid('clientPaging');
					                     
				}
			});
		}else{
			alert("城市选择有错！请重新选择")
		}
	}
}
