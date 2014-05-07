$(document).ready(function(){
	// 화면 로딩이 완료되면, 로그인 버튼의 리스너를 등록한다.
	$('#btnLogin').on('click', function(event){
		event.preventDefault();
		if ($('#email').val().length == 0 ||
				$('#password').val().length == 0) {
			alert('이메일과 암호는 필수 입력입니다.');
			return;
		}
		
		$.ajax('login.ajax', {
			type: 'POST',
			dataType: 'json', /*서버에서 보내는 데이터의 형식 지정 */
			data: { /* 서버쪽으로 보내는 데이터 */
				email: $('#email').val(),
				password: $('#password').val(),
				saveEmail: ($('#saveEmail:checked').length > 0) ? 
						'true':'false'
			},
			success: function(data){
				console.log(data);
				if (data.status == "ok" && data.result == "success") {
					location.href="../subject/list.bit";
				} else {
					alert('이메일 또는 암호가 맞지 않습니다.');
				}
			},
			error: function(xhr, status, errorThrown){
				alert('로그인 실행 중 오류 발생!');
				console.log(status);
				console.log(errorThrown);
			}
		});
		
		// 로그인 성공 후에 해야할 작업을 여기에 기술한다면,당신은 바보!
		//location.href="../subject/list.bit";
	});
});


















