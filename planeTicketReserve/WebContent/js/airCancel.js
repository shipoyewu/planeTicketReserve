$(function(){
	
	$('#flight').combobox({
		valueField:'flight',   
		textField:'flight',
		
		url:'http://localhost:8080/planeTicketReserve/REST/REST/Service/getFlight'
		
		
	});

});
function doSearch(){
	var flight=$('#flight').combobox('getValue');
	alert(flight);
	var start=$('#starttime').textbox('getValue');
	alert(flight+"liushuo"+start);
	$('#search').form('submit',{
		    url:""+flight+start,
		    onSubmit: function(){
				var isValid = $(this).form('validate');
				
				return isValid;	// 返回false终止表单提交
			},
			success:function(data){
		       		
			}
	})
}