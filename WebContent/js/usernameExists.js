$(document).ready(function(){
 
$("#userName").change(function() {
	$("#register").attr("disabled", true);
var usr = $("#userName").val();
 
if(usr.length >= 4){
	$("#status").html('<img src="images/loader.gif" align="absmiddle">&nbsp;Checking availability...');
 
    	$.ajax({ 
    		type: "POST", 
    		url: "checkUsername", 
    		data: "userName="+ usr, 
    		success: function(msg){ 
    			console.log(msg);
    			if(msg === 'OK'){
    				$("#userName").removeClass('object_error'); // if necessary
    				$("#userName").removeClass('form-control');
    				$("#userName").addClass("object_ok");
    				$("#status").html('&nbsp;<img src="images/tick.gif" align="absmiddle">');
    				$("#register").attr("disabled", false);
    			} else{ 
    				$("#userName").removeClass('object_ok'); // if necessary
    				$("#userName").removeClass('form-control');
    				$("#userName").addClass("object_error");
    				$("#status").html(msg);
    				$("#register").attr("disabled", true);
    			} 
    		}
    
    	});
 
	}else{
		$("#status").html('<font color="red"> The username should have at least <strong>4</strong> characters.</font>');
		$("#userName").removeClass('object_ok'); // if necessary
		$("#userName").addClass("object_error");
	}
 
});
 
});