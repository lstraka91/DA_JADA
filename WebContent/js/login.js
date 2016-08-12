				$(document).ready(function(){
					$("#login").click(function() {
						var username = $("#username").val();
						var pass = $("#pass").val();
						 
					    	$.ajax({ 
					    		type: "POST", 
					    		url: "loginCheck", 
					    		data: "userName="+ username+ "&password="+pass, 
					    		success: function(msg){ 
					    			console.log(msg);
					    			if(msg === 'error'){
					    				$("#failedLogin").html('<div class="alert alert-danger" role="alert"><strong><span class="glyphicon glyphicon-exclamation-sign"></span> Login Error!</strong> Invalid username or password, try again!!!</div>');
					    			} else if(msg === 'notActivated'){
					    				$("#failedLogin").html('<div class="alert alert-danger" role="alert"><strong><span class="glyphicon glyphicon-exclamation-sign"></span> Not aproved user!</strong> Admin have to activate your acount!!!</div>');
					    			}else{
					    				
					    				document.location="forum"
					    			}
					    		}
					    
					    	});
						});
					 
					});
				
				