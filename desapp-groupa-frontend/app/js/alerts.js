
function successAlert(text) {
	swal({
		title: "GREAT!",
		text: text,
		timer: 2000,
		type: "success",
		showConfirmButton: false
	});
}

function errorAlert(text) {
	swal({
		title: "FUCK!",
		text: text,
		timer: 2000,
		type: "error",
		showConfirmButton: false
	});
}
