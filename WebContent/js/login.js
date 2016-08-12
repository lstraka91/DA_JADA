				$(document).ready(function(){
					$("#login").click(function() {
						var username = $("#username").val();
						var pass = $("#pass").val();
						$("#status").html('<img src="images/loader.gif" align="absmiddle">&nbsp; Trying to log in...');
					    	$.ajax({ 
					    		type: "POST", 
					    		url: "loginCheck", 
					    		data: "userName="+ username+ "&password="+pass, 
					    		success: function(msg){ 
					    			console.log(msg);
					    			if(msg === 'error'){
					    				$("#failedLogin").html('<div class="alert alert-danger" role="alert"><strong><span class="glyphicon glyphicon-exclamation-sign"></span> Login Error!</strong> Invalid username or password, try again!!!</div>');
					    				$("#status").html('');
					    			} else if(msg === 'notActivated'){
					    				$("#failedLogin").html('<div class="alert alert-danger" role="alert"><strong><span class="glyphicon glyphicon-exclamation-sign"></span> Not aproved user!</strong> Admin have to activate your acount!!!</div>');
					    				$("#status").html('');
					    			}else{
					    				document.location="forum"
					    			}
					    		}
					    
					    	});
						});
					 
					});
				
				