$(function() {
	
	$("#selectall").click(function() {
		if($('#selectall').is(':checked'))
				$('.case').prop('checked', true);
			else
				$('.case').prop('checked', false);
	});
	
	$(".case").click(function() {
		if ($(".case").length == $(".case:checked").length) {
			$("#selectall").prop("checked", true);
		} else {
			$("#selectall").prop("checked", false);
		}

	});
	
});