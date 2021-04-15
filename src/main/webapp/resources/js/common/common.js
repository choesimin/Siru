function noSpace(obj) {
    var str_space = /\s/;
    if (str_space.exec(obj.value)) {
        obj.focus();
        obj.value = obj.value.replace(' ','');
        return false;
    }
}

function noSpecialSymbol(obj) {
	var regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi; 
	if (regExp.test(obj.value)) {
		obj.value = obj.value.substring(0, obj.value.length - 1 );
	}
}
			

function onlyAlphabet(obj) {
	obj.value = obj.value.replace(/[^\\!-z]/gi,"");
}

function onlyHangul(obj) {
	obj.value = obj.value.replace(/[a-z]/g, "");
};


$(function(){
	$(".no_space").on("keyup paste", function() {
		for (var i = 0; i < 50; i++) {
			noSpace(this);
		}
	});

	$(".no_special").on("keyup paste", function() {
		for (var i = 0; i < 50; i++) {
			noSpecialSymbol(this);
		}
	});

	$(".only_alphabet").on("keyup paste", function() {
		for (var i = 0; i < 50; i++) {
			onlyAlphabet(this);
		}
	});

	$(".only_hangul").on("keyup paste", function() {
		for (var i = 0; i < 50; i++) {
			onlyHangul(this);
		}
	});
});