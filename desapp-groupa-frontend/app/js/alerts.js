
function successAlert(title, text) {
	swal({
		title: title,
		text: text,
		timer: 2000,
		type: "success",
		showConfirmButton: false
	});
}

function errorAlert(title, text) {
	swal({
		title: title,
		text: text,
		timer: 2000,
		type: "error",
		showConfirmButton: false
	});
}
