function regist() {
	var id = $("#id_regist");
	var password = $("#password_regist");
	var repassword = $("#repassword_regist");
	var nickname = $("#nickname_regist");
	var email = $("#email_regist");
	var guide = $("#regist_guide");
	
	if (id.val() == "") {
		guide.html("아이디를 입력해주세요.");
		id.focus();
	} else if (password.val() == "") {
		guide.html("비밀번호를 입력해주세요.");
		password.focus();
	} else if (repassword.val() == "") {
		guide.html("비밀번호를 재입력해주세요.");
		repassword.focus();
	} else if (nickname.val() == "") {
		guide.html("닉네임을 입력해주세요.");
		nickname.focus();
	} else if (password.val() != repassword.val()) {
		guide.html("비밀번호와 재입력 란의 비밀번호가 다릅니다.");
		password.focus();
	} else if (id.val().length < 6) {
		guide.html("아이디는 6자 이상으로 입력해주세요.");
		id.focus();
	} else if (password.val().length < 6) {
		guide.html("비밀번호는 6자 이상으로 입력해주세요.");
		password.focus();
	} else {
		$.ajax({
			url : "/rest/member/regist",
			method : "post",
			data : {
				id : id.val(),
				password : password.val(),
				nickname : nickname.val(),
				email : email.val()
			},
			success : function(responseData) {
				var responseJson = JSON.parse(responseData);
				guide.html(responseJson.message);
				
				if (responseJson.code == 10) {
					id.val("");
					password.val("");
					repassword.val("");
					nickname.val("");
					email.val("");
				}
			}
		});
	}
}

function login() {
	var id = $("#id_login");
	var password = $("#password_login");
	var guide = $("#login_guide");
	
	$.ajax({
		url : "/rest/member/login",
		method : "post",
		data : {
			id : id.val(),
			password : password.val()
		},
		success : function(responseData) {
			var responseJson = JSON.parse(responseData);
			guide.html(responseJson.message);
			
			if (responseJson.code == 10) {
				location.href = responseJson.url;
			}
		}
	});
}

function showFindId() {
	$("#find_id").css("display", "block");
	$("#change_password").css("display", "none");
}

function showChangePassword() {
	$("#find_id").css("display", "none");
	$("#change_password").css("display", "block");
}

function findId() {
	var email = $("#email_find");
	var guide = $("#find_guide");
	
	if (email.val() != "") {
		$.ajax({
			url : "/rest/member/id/find",
			method : "post",
			data : {
				email : email.val()
			},
			success : function(responseData) {
				var responseJson = JSON.parse(responseData);
				
				var tag = "";
				if (responseJson.code == 10) {
					for (var i = 0; i < responseJson.object.length; i++) {
						tag += responseJson.object[i].id;
						tag += "<br/>";
					}
				} else if (responseJson.code == 1) {
					tag += "이메일을 다시 한 번 확인해주세요.";
				}
				
				console.log(responseJson.code);
				
				guide.html(tag);
			}
		});
	} else {
		guide.html("이메일을 입력해주세요.");
	}
}

function changePassword() {
	var id = $("#id_change");
	var email = $("#email_change");
	var password = $("#password_change");
	var repassword = $("#repassword_change");
	var guide = $("#change_guide");
	
	if (id.val() == "") {
		guide.html("아이디를 입력해주세요.");
		id.focus();
	} else if (email.val() == "") {
		guide.html("이메일을 입력해주세요.");
		email.focus();
	} else if (password.val() == "") {
		guide.html("비밀번호를 입력해주세요.");
		password.focus();
	} else if (repassword.val() == "") {
		guide.html("비밀번호를 재입력해주세요.");
		repassword.focus();
	} else if (password.val().length < 6) {
		guide.html("비밀번호는 6자 이상으로 입력해주세요.");
		password.focus();
	} else if (password.val() != repassword.val()) {
		guide.html("비밀번호와 재입력 란의 비밀번호가 다릅니다.");
		password.focus();
	} else {
		$.ajax({
			url : "/rest/member/password/change",
			method : "post",
			data : {
				id : id.val(),
				email : email.val(),
				password : password.val()
			},
			success : function(responseData) {
				var responseJson = JSON.parse(responseData);
				
				console.log(responseJson);
				
				guide.html(responseJson.message);
				
				if(responseJson.code == 10) {
					id.val("");
					email.val("");
					password.val("");
					repassword.val("");
				}
			}
		});
	}
}

function noSpace(obj) {
    var str_space = /\s/;
    if (str_space.exec(obj.value)) {
        obj.focus();
        obj.value = obj.value.replace(' ','');
        return false;
    }
}

function onlyAlphabet(obj) {
	obj.value = obj.value.replace(/[^\\!-z]/gi,"");
}

function onlyHangul(obj) {
	obj.value = obj.value.replace(/[a-z0-9]|[\[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g, "");
};

$(function(){
	$("#regist_button").on("click", function() {
		regist();
	});

	$("#login_button").on("click", function() {
		login();
	});

	$(".no_space").on("keyup paste", function() {
		for (var i = 0; i < 50; i++) {
			noSpace(this);
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