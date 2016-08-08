$(document).ready(function(){
 
$("#password").change(function() {
	$("#register").attr("disabled", true);
var pass = $("#password").val();
 
if(pass.length >= 8){
	$("#passCheck").html('<img src="images/loader.gif" align="absmiddle">&nbsp;Checking availability...');
 
    	$.ajax({ 
    		type: "POST", 
    		url: "checkPasswordStrong", 
    		data: "password="+ pass, 
    		success: function(msg){ 
    			console.log(msg);
    			if(msg === 'OK'){
    				$("#password").removeClass('object_error'); // if necessary
    				$("#password").removeClass('form-control');
    				$("#password").addClass("object_ok");
    				//$("#passCheck").html('&nbsp;<img src="images/tick.gif" align="absmiddle">');
    				$("#passCheck").html('');
    				$("#register").attr("disabled", false);
    			} else{ 
    				$("#password").removeClass('object_ok'); // if necessary
    				$("#password").removeClass('form-control');
    				$("#password").addClass("object_error");
    				$("#passCheck").html(msg);
    				$("#register").attr("disabled", true);
    				
    			} 
    		}
    
    	});
 
	}else{
		$("#passCheck").html('<font color="red"> The password should have at least <strong>8</strong> characters.</font>');
		
	}
 
});
 
});