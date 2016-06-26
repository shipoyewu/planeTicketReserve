/**
 * 
 */
$(function(){    
   	var uid = document.cookie.split('=')[1];
    //alert(uid+"login");
    $.ajax({
        url:'../REST/REST/Service/getAgencyInfoByAgencyid/'+uid,
        success:function(data){
            //alert(data+"shihua");
            $('#user').html(data.name)
        }
    });
   
}); 


 function addTab(title, url){
		if ($('#tt').tabs('exists', title)){
			$('#tt').tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0" ' +
			    'src="'+url+'" style="width:99.5%;height:99%;"></iframe>';
			$('#tt').tabs('add',{
				title:title,
				content:content,
				closable:true,
				tabWidth:150,
				tabHeight:150
			});
		}
	}