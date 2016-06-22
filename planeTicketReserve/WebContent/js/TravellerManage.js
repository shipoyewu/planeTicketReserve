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
	$('#traveller').form('submit', {    
	    url:"../REST/REST/Service/saveOrUpdatesTraveller/"+name+'/'+sex=='man'?"男":"女"+'/'+idcard+'/'+tel,    
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
     $.messager.alert('提示', value+""+name);
     
   }