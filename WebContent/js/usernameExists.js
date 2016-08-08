$(document).ready(function(){
 
$("#userName").change(function() {
 
var usr = $("#userName").val();
 
if(usr.length >= 4)
{
//$("#status").html('<img src="loader.gif" align="absmiddle">&nbsp;Checking availability...');
 
    $.ajax({ 
    type: "POST", 
    url: "CheckUsername", 
    data: "userName="+ usr, 
    success: function(msg){ 
    
   $("#status").ajaxComplete(function(event, request, settings){
 
    if(msg == 'OK')
    {
        $("#userName").removeClass('object_error'); // if necessary
        $("#userName").addClass("object_ok");
       // $(this).html('&nbsp;<img src="tick.gif" align="absmiddle">');
    } 
    else 
    { 
        $("#userName").removeClass('object_ok'); // if necessary
        $("#userName").addClass("object_error");
        $(this).html(msg);
    } 
    
   });
 
 }
    
  });
 
}
else
    {
    $("#status").html('<font color="red">' +
'The username should have at least <strong>4</strong> characters.</font>');
    $("#userName").removeClass('object_ok'); // if necessary
    $("#userName").addClass("object_error");
    }
 
});
 
});