

$(function(){ 
	if(document.cookie.split('=')[1] == undefined){
		window.location.href="unlogin.html";
	}
}); 

function showcontent(name){
    	var lc=document.getElementById("agc");
        if (name=="agencyinfo") 
        {
        	lc.src= "agencyinfo.html ";
        }else if (name=="team")
            {
             	lc.src = "team.html";
            }else if(name=="adtraveller")
            	{
            	    lc.src="adtraveller.html";
            	}else{
                		lc.src="gettraveller.html";
                    }
             
}