$(document).ready(function(){
$("#confirm_password").change(function() {
	$("#register").attr("disabled", true);
	$("#save").attr("disabled", true);
	$("#save").prop("disabled", true);
var passC = $("#confirm_password").val();
var pass = $("#password").val();
 
if(pass.length >= 8){
	$("#passValidation").html('<img src="images/loader.gif" align="absmiddle">&nbsp;Checking validate password...');
 
    	$.ajax({ 
    		type: "POST", 
    		url: "validatePass", 
    		data: "password="+ pass + "&passC="+passC ,
    		success: function(msg){ 
    			console.log(msg);
    			if(msg === 'OK'){
    				$("#confirm_password").removeClass('object_error'); // if necessary
    				$("#confirm_password").removeClass('form-control');
    				$("#confirm_password").addClass("object_ok");
    				//$("#passCheck").html('&nbsp;<img src="images/tick.gif" align="absmiddle">');
    				$("#passValidation").html('');
    				$("#register").attr("disabled", false);
    				$("#save").attr("disabled", false);
    				$("#save").prop("disabled", false);
    			} else{ 
    				$("#confirm_password").removeClass('object_ok'); // if necessary
    				$("#confirm_password").removeClass('form-control');
    				$("#confirm_password").addClass("object_error");
    				$("#passValidation").html(msg);
    				$("#register").attr("disabled", true);
    				$("#save").attr("disabled", true);
    				$("#save").prop("disabled", true);
    			} 
    		}
    
    	});
 
	}else{
		$("#passValidation").html('<font color="red"> The password should have at least <strong>8</strong> characters.</font>');
		
	}
 
});
});