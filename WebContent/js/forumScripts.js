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

// Datatable, datatable's DOM and search function
$(document).ready(
		function() {
			var topicsTable = $('#topicsTable').DataTable({
				"dom" : 'r<t><"row"ip><"row"l>',
				"ordering" : false,
				"oLanguage" : {
					"sEmptyTable" : "No data available",
					"sInfoEmpty" : "No topics found",
					"sInfo" : "Showing _START_ to _END_ of _TOTAL_ topics"
				}
			});

			$('#searchTopics').keyup(
					function() {
						topicsTable.search($(this).val()).draw();
						localStorage.setItem('searchTopicsInput', JSON
								.stringify($(this).val()));
					});
		});

//Adds clicked keyword to search input
$(function() {
	$('.kw-button').click(function() {
		var text = $('#searchTopics');
		text.val(text.val() + $(this).val() + ' ');
		$('#searchTopics').keyup();
	});
});


$("input[type=text]").focus(function() {
	   $(this).select();
	});