/**
 * 
 */
$(function(){    
	if(document.cookie.split('=')[1] == undefined){
		document.getElementById("out").style.display="none"; 
		//$("out").setAttribute('visibility', 'hidden');
	}else {
		document.getElementById("in").style.display="none";
		//$("in").setAttribute('visibility', 'hidden');
		var uid = document.cookie.split('=')[1];
	    $.ajax({
	        url:'../REST/REST/Service/getAgencyInfoByAgencyid/'+uid,
	        success:function(data){
	            //alert(data+"shihua");
	            $('#user').html(data.name)
	        }
	    });
   
	}

   
}); 

function login(){
	window.location.href="login.html";
}

function DelCookie(name) {
var exp = new Date();
exp.setTime(exp.getTime() - 1);
document.cookie = name + "=; expires=" + exp.toGMTString();
}

function loginout(){
	DelCookie('userid');
	window.location.href="index.html";
	
}

function addTab(title, url){
	if ($('#tt').tabs('exists', title)){
		$('#tt').tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0" ' +
		    'src="'+url+'" style="width:100%;height:99%;"></iframe>';
		$('#tt').tabs('add',{
			title:title,
			content:content,
			closable:true,
			tabWidth:150,
			tabHeight:150
		});
	}
}