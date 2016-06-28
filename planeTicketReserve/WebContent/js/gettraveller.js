/**
 * 
 */

$(function(){ 
	if(document.cookie.split('=')[1] == undefined){
		window.location.href="unlogin.html";
	}
    var uid = document.cookie.split('=')[1];
  
}); 
function doSearch(){
    var tid=document.getElementById("tid").value;
    //alert(tid);
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