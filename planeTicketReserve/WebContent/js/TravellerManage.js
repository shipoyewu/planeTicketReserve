/**
 * 旅客信息查询
 */
/*
 * 37048119940312031X
 *  13027711594
 */
function submitForm(){
	var idcard = document.getElementById("idcard").value;	
	var tel = document.getElementById("tel").value;
	var name = document.getElementById("name").value;
	var sex = document.getElementById("sex").value;
	alert(sex);
	if(!isCardNo(idcard)){
		$.messager.alert('提示','身份证号格式错误');
		return false;
	}if(!checkMobile(tel)){
		$.messager.alert('提示','手机号格式错误');
		return false;
	}
	var s;
	if(sex == "man")	s = "男";
		else s = "女";
	$('#traveller').form('submit', {    
	    url:"../REST/REST/Service/saveOrUpdatesTraveller/"+name+'/'+s+'/'+idcard+'/'+tel,    
	    onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit;  
	    },
	    success:function(data){
	        $.messager.alert('提示','提交成功'); 
	    }    
	}); 
}
function checkMobile(str) {
   var re = /^1\d{10}$/
   if (re.test(str)) {
       return true;
   } else {
       return false;
   }
}
function isCardNo(card)  
{  
   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
   if(reg.test(card) === false)  
   {  
       return false;  
   }
   return true;
} 
/*
 * 搜索框搜索旅客信息
 */
function qq(value,name){
	if(name == "all"){
	    $('#dg').datagrid({
    	    url:'../REST/REST/Service/getAllTraveller/'+"2",///这里应该放agencyid
    	    columns:[[
    	        {field:'id',title:'旅客ID',width:100},
    	        {field:'name',title:'姓名',width:100},
    	        {field:'sex',title:'性别',width:50},
    	        {field:'phone',title:'联系方式',width:130,align:'center'},
    	        {field:'idcard',title:'身份证号',width:250,align:'center'},
    	    ]]
    	});
	}
	else{
		 $('#dg').datagrid({
	    	    url:'../REST/REST/Service/getTravellerByIdCard/'+value+'/'+"2",///这里应该放agencyid
	    	    columns:[[
	    	        {field:'id',title:'旅客ID',width:100},
	    	        {field:'name',title:'姓名',width:100},
	    	        {field:'sex',title:'性别',width:50},
	    	        {field:'phone',title:'联系方式',width:130,align:'center'},
	    	        {field:'idcard',title:'身份证号',width:250,align:'center'},
	    	    ]]
	    	});
	}
   }
var rownum;//全局变量传值
function edit(){
	var row = $("#dg").datagrid("getSelected");
	rownum = row.id;
	if(row == null){
		$.messager.alert('提示','请先点击需要修改的行'); 
	}
	else{
		$('#editdialog').dialog({    
		    title: '编辑',    
		    width: 400,    
		    height: 400,    
		    closed: false,    
		    cache: false,    
		    modal: true   
		});    
		$('#editdialog').dialog('refresh', 'TravellerEdit.html');  
	}
}
function updateEdit(){
	alert(rownum);
	$.ajax({
			type :'post',
        url : '../REST/REST/Service/register',
        data : contacts+'&'+phone+'&'+agencyname+'&'+psw1+'&'+address,
        success : function(msg){
        	alert("注册成功！");
        }
		});
}