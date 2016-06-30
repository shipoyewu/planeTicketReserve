/**
 * 
 */
 var uid;
$(function(){ 
	if(document.cookie.split('=')[1] == undefined){
		window.location.href="unlogin.html";
	}
     uid = document.cookie.split('=')[1];
	/*$('#traveller').datagrid({
        method:'get',
        url:'../REST/REST/Service/getAllTraveller/'+uid,
        loadMsg:'正在查询...',
        fit:true,
        fitColumns:true,
        sortName:'id',  
        sortOrder:'asc',
        columns:[[
            { field:'ck',checkbox:true },    
            {field:'id',title:'id',width:100}, 
            {field:'name',title:'name',width:100}, 
            {field:'sex',title:'sex',width:100},  
            {field:'phone',title:'phone',width:100},
            {field:'idcard',title:'idcard',width:200}          
        ]]   
       
    });*/
});

function join(){
    //alert("join");
    var tid=document.getElementById("teamid").value;
    var checkedItems = $('#traveller').datagrid('getChecked');
                  
    //alert(userid+'+'+tid);
     $('#add').form('submit', {           
        url:'../REST/REST/Service/joinToTeam',
        onSubmit: function(param){
            param.teamid = tid;
            //alert(JSON.stringify(checkedItems));
            param.listtre=JSON.stringify(checkedItems);
            var isValid = $(this).form('validate');
            return isValid; // 返回false终止表单提交
            },
        success: function(data){
                //$.messager.progress('close');   // 如果提交成功则隐藏进度条
                //alert("创建成功！");
                $('#traveller').datagrid('reload'); 
                //alert(data);
            }
        });
} 

function searchid(){
    var tid=$("#teamid").numberbox('getValue');
    if (tid=="") {
        alert("请输入数字");
    }else{
        //alert(tid);
        $('#traveller').datagrid({
            method:'get',
            url:'../REST/REST/Service/getUnpartTraveller/'+uid+'/'+tid,
            loadMsg:'正在查询...',
            fit:true,
            fitColumns:true,
            sortName:'id',  
            sortOrder:'asc',
            columns:[[
                { field:'ck',checkbox:true },    
                {field:'id',title:'旅客ID',width:100}, 
                {field:'name',title:'姓名',width:100}, 
                {field:'sex',title:'性别',width:100},  
                {field:'phone',title:'电话',width:100},
                {field:'idcard',title:'身份证',width:200,
    	        	formatter: function(value,row,index){	//不知道为什么传身份证号后两位得到会为0，
    	        		var cardnum = row.idcard;			//在idcard后加了'F'传过来的
    	        		return cardnum.split('F')[0];
    				}
    	        },
            ]]   
           
        });
    }
    
}