function regist() {
	var title = $("input[name='title'");
	var content = $("textarea[name='content'");
	var writer = $("input[name='writer'");

	if (title.val() == "") {
		title.focus();
	} else if (writer.val() == "") {
		writer.focus();
	} else if (content.val() == "") {
		content.focus();
	} else {
		$("#write_form").attr({
			action : "/admin/banner/regist",
			method : "post"
		});
		$("#write_form").submit();
	}
}

$(function() {
	$("#regist_button").click(function() {
		regist();
	});
});