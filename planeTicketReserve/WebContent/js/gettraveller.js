/**
 * 
 */
function doSearch(){
    var tid=document.getElementById("tid").value;
    //alert(pid);
    $('#travaller').datagrid({
        method:'get',
        //url:'./json/package.json?packageId='+pid,
       //url:"",
        loadMsg:'正在查询...',
        singleSelect:true,
        rownumbers:true,
        fit:true,
        fitColumns:true,
        sortName:'packageId',  
        sortOrder:'asc',
        columns:[[    
            {field:'travallerName',title:'旅客名字',width:100}, 
            {field:'sex',title:'性别',width:100},  
            {field:'tel',title:'电话',width:100},
            {field:'idcard',title:'身份证',width:100}          
        ]]   
       
    });

    
}