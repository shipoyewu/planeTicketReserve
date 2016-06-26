
$(function(){
    //获得旅行社的团队
    //alert('团队');
    //先手动写入一个数据
    $('#tm').datagrid({    
	    url:'../REST/REST/Service/getListTeam/'+1, 
        singleSelect:true,   
	    columns:[[    
	        {field:'teamid',title:'teamid',width:100,align:'right'},    
	        {field:'teamname',title:'teamname',width:100,align:'right'},    
	        {field:'starttime',title:'starttime',width:100,align:'right'},  
	        {field:'endtime',title:'endtime',width:100,align:'right'},
	        {field:'state',title:'state',width:100,align:'right',
	    		 formatter(value,rec){
                    if (value!=null) {
                        if (rec.state== 0 ) {
                            return "成立";
                        }else {
                            return "解散";
                        }
                    }else{
                        return "";
                    }
                }
            }
	    ]]    
	});   
});

function reload(){
	$('#tm').datagrid('reload'); 
}

function add(){
    //alert("tianjia");
    
    $("#dlga").dialog("open").dialog('setTitle', '添加团队');

}

function myformatter(date){ 
    var date= new Date(Date.parse(date));
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
}  

function myparser(s){  
    if (!s) return new Date();  
    var ss = (s.split('-'));  
    var y = parseInt(ss[0],10);  
    var m = parseInt(ss[1],10);  
    var d = parseInt(ss[2],10);  
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){  
        return new Date(y,m-1,d);  
    } else {  
        return new Date();  
    }  
}  

function edit(){
    //alert("xiugai");
    var row = $("#tm").datagrid("getSelected");
    if (row) {
        //alert(row.packageId);
        var tid=row.teamid;
        $("#dlge").dialog("open").dialog('setTitle', '修改团队信息');

        $.ajax({
            url:'../js/data.json',
            type:'get',
            success:function(data){
                var pack = eval(data);
                $("#teamide").textbox('setValue',pack[0].teamid);
                $("#teamnamee").textbox('setValue',pack[0].teamname);
                $('#starttimee').datebox('setValue', myformatter(pack[0].starttime));
                $('#endtimee').datebox('setValue',myformatter(pack[0].endtime));
                if (pack[0].state==0) {
                    $("#statee").combobox('select',0);
                }else{
                    $("#statee").combobox('select',1);
                }
            }
        });
    }else{
        alert("请选择数据！");
    }
}
      
function save(){
    alert("save");
    $('#fteama').form('submit', {           
        url:'../js/data.json',
        onSubmit: function(){
            var isValid = $(this).form('validate');
            return isValid; // 返回false终止表单提交
            },
        success: function(data){
                //$.messager.progress('close');   // 如果提交成功则隐藏进度条
                
                //alert("创建成功！");
                $("#tm").datagrid("reload",{ });
                $("#dlga").dialog('close');
                alert(data);
            }
        });
}

function update(){
    alert("update");
    $('#fteame').form('submit', {           
        url:'js/data.json',
        onSubmit: function(){
            var isValid = $(this).form('validate');
            return isValid; // 返回false终止表单提交
            },
        success: function(data){
                //$.messager.progress('close');   // 如果提交成功则隐藏进度条
                
                //alert("创建成功！");
                $("#tm").datagrid("reload",{ });
                $("#dlge").dialog('close');
                alert(data);
            }
        });
}
