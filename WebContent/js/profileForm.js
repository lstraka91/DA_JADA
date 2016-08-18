$("#ssave").hide();
$("#back").hide();
$("#passwordField").hide();
$('#edit').click(function() {
	if (this.id == 'edit') {
		$("#fullname").prop("disabled", false);
		$("#email").prop("disabled", false);
		$("#ssave").show();
		$("#back").show();
		$('#edit').hide();
		$("#changePass").hide();
		$('#oldpass').removeAttr('required');
		$('#passsword').removeAttr('required');
		$('#confirm_passsword').removeAttr('required');}

});

$(document).ready(function() {
	$("#birthday").datepicker({
		dateFormat : 'dd.mm.yy',
		changeMonth : true,
		changeYear : true,
		yearRange : "1900:+nn"
	});

});

$('#changePass').click(function() {
	if (this.id == 'changePass') {
		$("#changePass").hide();
		$("#profile").hide();
		$("#passwordField").show();
		$("#ssave").show();
		$("#back").show();
		$('#edit').hide();
	}

});

$('#back').click(function() {
	if (this.id == 'back') {
		document.location = "userProfile"
	}
});

$("#oldpass").change(function() {
	var pass = $("#oldpass").val();

	$.ajax({
		type : "POST",
		url : "checkOldPassword",
		data : "password=" + pass,
		success : function(msg) {
			console.log(msg);
			if (msg === 'OK') {
				$("#oldpass").removeClass('object_error'); // if necessary
				$("#oldpass").removeClass('form-control');
				$("#oldpass").addClass("object_ok");
				$("#oldpassword").html('');
				$("#ssave").attr("disabled", false);
				$("#ssave").prop("disabled", false);
			} else {
				$("#oldpass").removeClass('object_ok'); // if necessary
				$("#oldpass").removeClass('form-control');
				$("#oldpass").addClass("object_error");
				$("#oldpassword").html(msg);
				$("#ssave").attr("disabled", true);
				$("#ssave").prop("disabled", true);
			}
		}

	});
});
$("#passsword").change(function() {
	$("#register").attr("disabled", true);
	$("#ssave").attr("disabled", true);
	$("#ssave").prop("disabled", true);
var pass = $("#passsword").val();
 
if(pass.length >= 8){
	$("#passsCheck").html('<img src="images/loader.gif" align="absmiddle">&nbsp;Checking availability...');
 
    	$.ajax({ 
    		type: "POST", 
    		url: "checkPasswordStrong", 
    		data: "password="+ pass, 
    		success: function(msg){ 
    			console.log(msg);
    			if(msg === 'OK'){
    				$("#passsword").removeClass('object_error'); // if necessary
    				$("#passsword").removeClass('form-control');
    				$("#passsword").addClass("object_ok");
    				$("#passsCheck").html('');
    				$("#register").attr("disabled", false);
    				$("#save").attr("disabled", false);
    				$("#save").prop("disabled", false);
    			} else{ 
    				$("#passsword").removeClass('object_ok'); // if necessary
    				$("#passsword").removeClass('form-control');
    				$("#passsword").addClass("object_error");
    				$("#passsCheck").html(msg);
    				$("#register").attr("disabled", true);
    				$("#ssave").attr("disabled", true);
    				$("#ssave").prop("disabled", true);
    			} 
    		}
    
    	});
 
	}else{
		$("#passsCheck").html('<font color="red"> The password should have at least <strong>8</strong> characters.</font>');
		
	}
 
});

	$("#confirm_passsword").change(function() {
		$("#register").attr("disabled", true);
		$("#ssave").attr("disabled", true);
		$("#ssave").prop("disabled", true);
	var passC = $("#confirm_passsword").val();
	var pass = $("#passsword").val();
	 
	if(pass.length >= 8){
		$("#passsValidation").html('<img src="images/loader.gif" align="absmiddle">&nbsp;Checking validate password...');
	 
	    	$.ajax({ 
	    		type: "POST", 
	    		url: "validatePass", 
	    		data: "password="+ pass + "&passC="+passC ,
	    		success: function(msg){ 
	    			console.log(msg);
	    			if(msg === 'OK'){
	    				$("#confirm_passsword").removeClass('object_error'); // if necessary
	    				$("#confirm_passsword").removeClass('form-control');
	    				$("#confirm_passsword").addClass("object_ok");
	    				//$("#passCheck").html('&nbsp;<img src="images/tick.gif" align="absmiddle">');
	    				$("#passsValidation").html('');
	    				$("#register").attr("disabled", false);
	    				$("#ssave").attr("disabled", false);
	    				$("#ssave").prop("disabled", false);
	    			} else{ 
	    				$("#confirm_passsword").removeClass('object_ok'); // if necessary
	    				$("#confirm_passsword").removeClass('form-control');
	    				$("#confirm_passsword").addClass("object_error");
	    				$("#passsValidation").html(msg);
	    				$("#register").attr("disabled", true);
	    				$("#ssave").attr("disabled", true);
	    				$("#ssave").prop("disabled", true);
	    			} 
	    		}
	    
	    	});
	 
		}else{
			$("#passsValidation").html('<font color="red"> The password should have at least <strong>8</strong> characters.</font>');
			
		}
	 
	});
	

