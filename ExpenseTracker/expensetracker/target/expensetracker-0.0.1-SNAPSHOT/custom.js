$(document).ready(function(){
	$("#add").click(function(e){
		event.preventDefault();
		$("#items").append('<div><div class="bottom-row"><div class="field-wrap" id="field"> <input id="field1" type="text" name="accountnumber" value="account number" required autocomplete="off" width="48%"/></div><div class="field-wrap" id="field"><input id="field1" type="text" name="nickname" value="nickname" required autocomplete="off"/></div>'+
				'<input type="button" value="delete" id="delete"/></div>');
	});
	
	$('body').on('click', '#delete', function(e){
		$(this).parent('div').remove();
	});
});