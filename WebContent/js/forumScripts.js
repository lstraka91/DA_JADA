jQuery(document).ready(function() {
	jQuery("time.timeago").timeago();
});

$(function() {
	$("li").click(function() {
		// remove classes from all
		$("li").removeClass("active");
		// add class to the one we clicked
		$(this).addClass("active");
	});
});

$(document)
		.ready(
				function() {
					var topicstable = $('#topicsTable')
							.DataTable(
									{
										"dom" : '<t><"row"ip><"row"l>',
										"ordering" : false
									});

					$('#searchTopics').keyup(function() {
						topicstable.search($(this).val()).draw();
					});
				});

$(function() {
	$('.kw-button').click(function() {
		var text = $('#searchTopics');
		text.val(text.val() + $(this).val() + ' ');
		$('#searchTopics').keyup();
	});
});