$(function(){
	
	$('#flight').combobox({
		valueField:'code',   
		textField:'name',
		url:'http://localhost:8080/planeTicketReserve/REST/REST/Service/getFlight'
	});

});
function doSearch(){
	var flight=$('#flight').combobox('getValue');
	//alert(flight);
	var start=$('#starttime').textbox('getValue');
	//alert(flight+"liushuo"+start);
	$('#search').form('submit',{
		    url:"http://localhost:8080/planeTicketReserve/REST/REST/Service/getFlightMessage"+"/"+flight+"/"+start,
		    onSubmit: function(){
				var isValid = $(this).form('validate');
				
				return isValid;	// 返回false终止表单提交
			},
			success:function(data){
				//alert(data.id);
				if( data.id==""){
					//alert("liushuo");
					$.messager.alert('提示','没有该列航班!');
				
					
				}
				var obj=eval("["+data+"]")[0];
				//alert(obj.endtime);
				
				
				$('#flightid').textbox('setValue',obj.flight);
				$('#start').textbox('setValue',obj.starttime);
				$('#endtime').textbox('setValue',obj.endtime);
				$('#startpoint').textbox('setValue',obj.startpoint);
				$('#endpoint').textbox('setValue',obj.endpoint);
		        //alert("lisuhuo"+data);
			}
			
	})
}
function doCancel(){
	    var flight=$('#flight').combobox('getValue');
	    var flightid=$('#flightid').textbox('getValue');
	   //alert(flightid);
	   if(flightid==0){
		   $.messager.alert('提示','没有该列航班!');
	   }
	   else{
		   $.messager.confirm('确认','您确认想要取消航班么？',function(r){    
			    if (r){  
			    	$.ajax({
		                url: "http://localhost:8080/planeTicketReserve/REST/REST/Service/doCancel/"+flight,
		                type: 'GET',
		                Error: function () {
		                    alert(Error);
		                },
		                success: function (data) {
		                	var suc="success"
		                	if(data==suc){
		                		$.messager.alert('提示','取消成功');
		                	}
		                	else{
		                		$.messager.alert('提示','取消失败');
		                	}
		                }
		            }); 
			          
			    }    
			}); 
		
	   }
	
}
function doDelay(){
	var flight=$('#flight').combobox('getValue');
	var flightid=$('#flightid').textbox('getValue');
	 if(flightid==0){
		   $.messager.alert('提示','没有该列航班!');
	   }
	   else{
				$.messager.confirm('确认','您确认想要延迟航班么？',function(r){    
				    if (r){  
				    	$.ajax({
			                url: "http://localhost:8080/planeTicketReserve/REST/REST/Service/doDelay/"+flight,
			                type: 'GET',
			                Error: function () {
			                    alert(Error);
			                },
			                success: function (data) {
			                	var suc="success"
			                	if(data==suc){
			                		$.messager.alert('提示','延迟通知成功');
			                	}
			                	else{
			                		$.messager.alert('提示','发送延迟失败');
			                	}
			                }
			            }); 
				          
				    }    
				}); 
	   }
	
}