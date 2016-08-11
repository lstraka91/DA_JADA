$("#save").hide();
$("#back").hide();
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
