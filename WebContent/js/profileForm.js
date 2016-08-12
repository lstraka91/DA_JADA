$("#save").hide();
$("#back").hide();
$("#passwordField").hide();
$('#edit').click(function() {
	if (this.id == 'edit') {
		$("#fullname").prop("disabled", false);
		$("#email").prop("disabled", false);
		$("#save").show();
		$("#back").show();
		$('#edit').hide();
	}

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
		$("#save").show();
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
				$("#save").attr("disabled", false);
				$("#save").prop("disabled", false);
			} else {
				$("#oldpass").removeClass('object_ok'); // if necessary
				$("#oldpass").removeClass('form-control');
				$("#oldpass").addClass("object_error");
				$("#oldpassword").html(msg);
				$("#save").attr("disabled", true);
				$("#save").prop("disabled", true);
			}
		}

	});
});
