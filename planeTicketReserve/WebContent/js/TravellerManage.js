/**
 * 旅客信息查询
 */

function submitForm(){
	$('#traveller').form('submit', {    
	    url:"",    
	    onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit;    
	    },    
	    success:function(data){    
	        alert(data);
	        $.messager.alert('提示','提交成功'); 
	    }    
	}); 
}

/*
 * 搜索框搜索旅客信息
 */
function qq(value,name){
     $.messager.alert('提示','value+":"+name')
   }