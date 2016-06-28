var uid;
$(function(){
    //获得旅行社的团队
    //alert('团队');
    if(document.cookie.split('=')[1] == undefined){
		window.location.href="unlogin.html";
	}
    uid = document.cookie.split('=')[1];
    $('#tm').datagrid({    
	    url:'../REST/REST/Service/getListTeam/'+uid, 
        singleSelect:true,   
	    columns:[[    
	        {field:'id',title:'旅行团ID',width:100,align:'right'},    
	        {field:'name',title:'名称',width:100,align:'right'}, 
            {field:'principal',title:'负责人',width:100,align:'right'}, 
            {field:'prinphone',title:'负责人电话',width:100,align:'right'},    
	        {field:'starttime',title:'开始时间',
	        	formatter:function(value,row,index){
	        		var a = new Date(value);
	        		return a.toLocaleString();
				},
	        	width:200,align:'right'},  
	        {field:'endtime',title:'结束时间',
        		formatter:function(value,row,index){
                    if (value==null) {
                        return "";
                    }
	        		var a = new Date(value);
	        		return a.toLocaleString();
				},
	        	width:200,align:'right'},
            {field:'type',title:'类型',width:200,align:'right',
                formatter(value,rec){
                    if (value!=null) {
                        if (rec.type== 0 ) {
                            return "小型(1-30)";
                        }else if (rec.type== 1) {
                            return "中型(31-100)";
                        }else{
                            return "大型(100人以上)";
                        }
                    }else{
                        return "";
                    }
                }
            },
	        {field:'status',title:'状态',width:100,align:'right',
	    		 formatter(value,rec){
                    if (value!=null) {
                        if (rec.status== 0 ) {
                            return "成立";
                        }else {
                            return "解散";
                        }
                    }else{
                        return "";
                    }
                }
            }
	    ]],
        onDblClickRow: function(rowIndex, rowData){
            var tid=rowData.id;
            //alert(tid);
            $("#dlg").dialog("open").dialog('setTitle', '旅行团成员');  
            $('#traveller').datagrid({
                method:'post',
                url:'../REST/REST/Service/getTraverllerByTeam/'+tid,
                loadMsg:'正在查询...',
                rownumbers:true,
                fit:true,
                fitColumns:true,
                columns:[[    
                    {field:'id',title:'旅客ID',width:100}, 
                    {field:'name',title:'姓名',width:100}, 
                    {field:'sex',title:'性别',width:100},  
                    {field:'phone',title:'电话',width:100},
                    {field:'idcard',title:'身份证',width:200}          
                ]]   
               
            });
        }     
	});   
});

function reload(){
	//$('#tm').datagrid('reload'); 
    window.location.reload();
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

/*function myparser(s){  
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
}  */

            

function edit(){
    //alert("xiugai");
    var row = $("#tm").datagrid("getSelected");
    if (row) {
        //alert(row.packageId);
        var tid=row.id;
        $("#dlge").dialog("open").dialog('setTitle', '修改团队信息');
        $("#teamide").textbox('setValue',row.id);
        $("#teamnamee").textbox('setValue',row.name);
        $("#principale").textbox('setValue',row.principal);
        $("#prinphonee").textbox('setValue',row.prinphone);
        $('#starttimee').datebox('setValue',myformatter(row.starttime));
        var d=myformatter(row.starttime);
        var da=new Date(d);
        alert(da);
        $('#endtimee').datebox('calendar').calendar({
            validator: function(date){
                return da<=date;
            }
        });
        /*$('#endtimee').datebox('setValue'," ");*/
        if (row.type==0) {
            $("#typee").combobox('select',0);
        }else if (row.type==1) {
            $("#typee").combobox('select',1);
        }else{
            $("#typee").combobox('select',2);
        }
        if (row.status==0) {
            $("#statee").combobox('select',0);
        }else{
            $("#statee").combobox('select',1);
        }

      
    }else{
        alert("请选择数据！");
    }
}
      
function save(){
    //alert("save");
    $('#fteama').form('submit', {           
        url:'../REST/REST/Service/addTeam',
        onSubmit: function(param){
        	//alert(uid);
            param.agencyid = uid;
            var isValid = $(this).form('validate');
            return isValid; // 返回false终止表单提交
            },
        success: function(data){
                //$.messager.progress('close');   // 如果提交成功则隐藏进度条
                //alert("创建成功！");
                $("#tm").datagrid("reload",{ });
                $("#dlga").dialog('close');
                window.location.reload();
                //alert(data);
            }
        });
}

function update(){
    //alert("update");
    $('#fteame').form('submit', {           
        url:'../REST/REST/Service/updateTeam',
        onSubmit: function(){
            var isValid = $(this).form('validate');
            return isValid; // 返回false终止表单提交
            },
        success: function(){
                //$.messager.progress('close');   // 如果提交成功则隐藏进度条
                
                //alert("创建成功！");
                $("#tm").datagrid("reload",{ });
                $("#dlge").dialog('close');
                //alert(data);
            }
    });

}

function searchname(){
    var uname=$("#principal").textbox('getValue');
    if (uname=="") {
        alert("请输入负责人名字");
    }else{
         //alert(uname+uid);
        $('#tm').datagrid({    
            url:'../REST/REST/Service/findTeamByPar/'+uname+'/'+uid, 
            singleSelect:true,   
            columns:[[    
                {field:'id',title:'旅行团ID',width:100,align:'right'},    
                {field:'name',title:'名称',width:100,align:'right'}, 
                {field:'principal',title:'负责人',width:100,align:'right'}, 
                {field:'prinphone',title:'负责人电话',width:100,align:'right'},    
                {field:'starttime',title:'开始时间',
                    formatter:function(value,row,index){
                        var a = new Date(value);
                        return a.toLocaleString();
                    },
                    width:200,align:'right'},  
                {field:'endtime',title:'结束时间',
                    formatter:function(value,row,index){
                        if (value==null) {
                            return "";
                        }
                        var a = new Date(value);
                        return a.toLocaleString();
                    },
                    width:200,align:'right'},
                {field:'type',title:'类型',width:200,align:'right',
                    formatter(value,rec){
                        if (value!=null) {
                            if (rec.type== 0 ) {
                                return "小型(1-30)";
                            }else if (rec.type== 1) {
                                return "中型(31-100)";
                            }else{
                                return "大型(100人以上)";
                            }
                        }else{
                            return "";
                        }
                    }
                },
                {field:'status',title:'状态',width:100,align:'right',
                     formatter(value,rec){
                        if (value!=null) {
                            if (rec.status== 0 ) {
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
    }
}

//扩展easyui表单的验证
$.extend($.fn.validatebox.defaults.rules, {
    //验证汉子
    CHS: {
        validator: function (value) {
            return /^[\u0391-\uFFE5]+$/.test(value);
        },
        message: '只能输入汉字'
    },
    //移动手机号码验证
    mobile: {//value值为文本框中的值
        validator: function (value) {
            var reg = /^1[3|4|5|8|9]\d{9}$/;
            return reg.test(value);
        },
        message: '输入手机号码格式不准确.'
    },
    //国内邮编验证
    zipcode: {
        validator: function (value) {
            var reg = /^[1-9]\d{5}$/;
            return reg.test(value);
        },
        message: '邮编必须是非0开始的6位数字.'
    },
    //用户账号验证(只能包括 _ 数字 字母) 
    account: {//param的值为[]中值
        validator: function (value, param) {
            if (value.length < param[0] || value.length > param[1]) {
                $.fn.validatebox.defaults.rules.account.message = '用户名长度必须在' + param[0] + '至' + param[1] + '范围';
                return false;
            } else {
                if (!/^[\w]+$/.test(value)) {
                    $.fn.validatebox.defaults.rules.account.message = '用户名只能数字、字母、下划线组成.';
                    return false;
                } else {
                    return true;
                }
            }
        }, message: ''
    }
})