

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
	var sex = $("#sex").textbox("getValue");

	if(!isCardNo(idcard)){
		$.messager.alert('提示','身份证号格式错误');
		return false;
	}if(!checkMobile(tel)){
		$.messager.alert('提示','手机号格式错误');
		return false;
	}
	var s;
	if(sex == "man")	s = "男"
	else s = "女";
	var uid = document.cookie.split('=')[1];
	$('#traveller').form('submit', {    
	    url:"../REST/REST/Service/saveOrUpdatesTraveller/"+name+'/'+s+'/'+idcard+'/'+tel+'/'+uid,    
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
	var uid = document.cookie.split('=')[1];
	//alert(uid);
	if(name == "all"){
	    $('#dg').datagrid({
    	    url:'../REST/REST/Service/getAllTraveller/'+uid,///这里应该放agencyid
    	    columns:[[
    	        {field:'id',title:'旅客ID',width:100},
    	        {field:'name',title:'姓名',width:100},
    	        {field:'sex',title:'性别',width:50},
    	        {field:'phone',title:'联系方式',width:130,align:'center'},
    	        {field:'idcard',title:'身份证号',width:300,align:'center',
    	        	formatter: function(value,row,index){	//不知道为什么传身份证号后两位得到会为0，
    	        		var cardnum = row.idcard;			//在idcard后加了'F'传过来的
    	        		return cardnum.split('F')[0];
    				}
    	        },
    	    ]]
    	});
	}
	else{
		 $('#dg').datagrid({
	    	    url:'../REST/REST/Service/getTravellerByIdCard/'+value+'/'+uid,///这里应该放agencyid
	    	    columns:[[
	    	        {field:'id',title:'旅客ID',width:100},
	    	        {field:'name',title:'姓名',width:100},
	    	        {field:'sex',title:'性别',width:50},
	    	        {field:'phone',title:'联系方式',width:130,align:'center'},
	    	        {field:'idcard',title:'身份证号',width:300,align:'center',
	    	        	formatter: function(value,row,index){
	    	        		var cardnum = row.idcard;
	    	        		return cardnum.split('F')[0];
	    				}
	    	        },
	    	    ]]
	    	});
	}

   }
var rownum;//全局变量传值
function edit(){
	var row = $("#dg").datagrid("getSelected");
	rownum = row.id;
	if(row != null){
		$('#editdialog').dialog({    
		    title: '编辑',    
		    width: 400,    
		    height: 200,    
		    closed: false,    
		    cache: false,    
		    modal: true   
		});    
		$('#editdialog').dialog('refresh', 'TravellerEdit.html');
	}
	else{
		$.messager.alert('提示','请先选中需要修改的行');
	}
}
function updateEdit(){
	//alert(rownum);
	rname = document.getElementById("rname").value;
	rtel = document.getElementById("rtel").value;
	if(!checkMobile(rtel)){
		$.messager.alert('提示','手机号格式错误');
		return false;
	}
	else if(rname == ''){
		$.messager.alert('提示','请输入用户名');
		return false;
	}
		
	$.ajax({
		type :'get',
        url : '../REST/REST/Service/updatesTraveller/'+rownum+'/'+rname+'/'+rtel,
        success : function(msg){
        	if(msg == 'succ')
        		$.messager.alert('提示','信息修改成功!');
        	else 
        		$.messager.alert('提示','信息修改失败,请重试！');
        }
		});
}
/**
 * 显示不同页面
 * @param name
 */

function showcontent(name){
	var lc=document.getElementById("agc");
    if (name=="add") 
    {
    	lc.src= "AddTraveller.html ";
    }
    else 
         {
         	lc.src = "TravellerSearch.html";
         }
}


//登陆验证
$(function(){ 
	if(document.cookie.split('=')[1] == undefined){
		window.location.href="unlogin.html";
	}
}); 
