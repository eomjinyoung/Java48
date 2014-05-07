$(document).ready(function(){
	// 화면 로딩이 완료되면, 로그인 버튼의 리스너를 등록한다.
	$('#btnLogin').on('click', function(event){
		event.preventDefault();
		if ($('#email').val().length == 0 ||
				$('#password').val().length == 0) {
			alert('이메일과 암호는 필수 입력입니다.');
		}
		
		$.ajax('login.ajax', {
			type: 'POST',
			data: {
				email: $('#email').val(),
				password: $('#password').val(),
				saveEmail: ($('#saveEmail:checked').length > 0) ? 
						'true':'false'
			},
			success: function(data){
				console.log(data);
			},
			error:function(){
				alert('로그인 실행 중 오류 발생!');
			}
		});
	});
});


















