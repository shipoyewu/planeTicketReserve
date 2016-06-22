  function check() {
                
                var phone = document.getElementById("phonel").value;
                var pwd = document.getElementById("password").value;
                if ("" == phone || "" == pwd) {
                    alert('用户名或者密码不能为空');
                } else {
                    $.ajax({
                        type :'post',
                        url : '../REST/REST/Service/checkLoginUser',
                        data : phone+"&"+pwd,
                        success : function(msg) {
                                  alert(msg);
                                  //此处存cookies
                        }
                    });
                     
                }
            }
  
  	function registerCheck(){
  		var contacts = document.getElementById("contacts").value;
  		var phone = document.getElementById("phone").value;
  		var agencyname = document.getElementById("agencyname").value;
  		var address = document.getElementById("address").value;
  		var psw2 = document.getElementById("passwordsignup").value;
  		var psw1 = document.getElementById("passwordsignup_confirm").value;
  		//alert(name+phone+psw1+psw2+agencyname+address);
  	
  		if(phone.length != 11){
  			alert("请正确输入11位手机号");
  			return 0;
  		}
  		else if(psw1 != psw2){
  			alert("两次输入密码不相同");
  			return 0;
  		}
  		return 1;
  	}
  	
  	function register(){
  		if(!registerCheck())
  			return;
  		var contacts = document.getElementById("contacts").value;
  		var phone = document.getElementById("phone").value;
  		var agencyname = document.getElementById("agencyname").value;
  		var address = document.getElementById("address").value;
  		var psw2 = document.getElementById("passwordsignup").value;
  		var psw1 = document.getElementById("passwordsignup_confirm").value;
  		//alert('begin to submit');
  		if(psw1 != psw2){
  			alert("两次输入密码不相同");
  			return;
  		}
  		$.ajax({
  			type :'post',
            url : '../REST/REST/Service/register',
            data : contacts+'&'+phone+'&'+agencyname+'&'+psw1+'&'+address,
            success : function(msg){
            	alert("注册成功！");
            }
  		});
  	}	