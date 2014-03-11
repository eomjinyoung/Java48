$(document).ready(function() {
	loadMemberList();
	clearForm();
	
	$('#memberTable').on('click', '.btnMemberDelete', function(){
		deleteMember($(this).attr('data-no'));
	});
	
	$('#btnCancel').click(function() {
		$('.editMode').css('display', 'none');
		$('.newMode').css('display', '');
	});
	
	$('#btnAdd').click(function() {
		try {
			validateForm();
			addMember();
		} catch (err) {
			alert(err);
		}
	});
	
	$('#btnDelete').click( function() {
		deleteMember($('#no').val());
	});
	
	$('#btnUpdate').click(function() {
		updateMember();
	});
	
});

function validateForm() {
	var pass1 = $('#pass1').val();
	var pass2 = $('#pass2').val();
	if (pass1 != pass2) {
		throw '암호가 일치하지 않습니다!';
	}
	var name = $('#name').val();
	var email = $('#email').val();
	if (name == '' || email == '') {
		throw '이름과 이메일은 필수 입력 항목입니다!';
	}
}

function loadMemberList() {
	$.ajax('http://localhost:8080/web02/member/ajax/list.do', {
		type: 'GET',
		dataType: 'json',
		success: function(result){
			var members = result.jsonResult.data;
			var memberTable = $("#memberTable");
			clearMemberList();
			$.each(members, function(index, member){
				$('<tr></tr>')
					.addClass('dataRow')
					.append($('<td></td>').html(member.no)) // 번호
					.append($('<td></td>')
							.append($('<a></a>')
								.attr('href', '#')
								.attr('data-no', member.no)
								.html(member.name)
								.click(function(){
									readMember($(this).attr('data-no'));
								}))) // 이름
					.append($('<td></td>').html(member.email)) // 이메일
					.append($('<td></td>').html(member.tel)) // 전화
					.append($('<td></td>').append($('<a>삭제</a>')
							.addClass('btnMemberDelete')
							.attr('href', '#')
							.attr('data-no', member.no))) // 삭제버튼
					.appendTo(memberTable); 
			});
		},
		error: function(msg){
			alert('회원 정보를 읽을 수 없습니다!');
			console.log(msg);
		}
	});
}

function clearMemberList() {
	$('.dataRow').remove();
}

function addMember() {
	$.post('http://localhost:8080/web02/member/ajax/add.do', {
			name: encodeURIComponent($('#name').val()),
			email: encodeURIComponent($('#email').val()),
			password: $('#pass1').val(),
			tel: encodeURIComponent($('#tel').val()),
			age: $('#age').val()
		}, function(){
			loadMemberList();
			clearForm();
		});
}

function clearForm() {
	$('#btnCancel').trigger('click');
}

function deleteMember(no) {
	$.get('http://localhost:8080/web02/member/ajax/delete.do?no=' + no, 
		function(){
			loadMemberList();
			clearForm();
		});
}

function readMember(no) {
	$.getJSON('http://localhost:8080/web02/member/ajax/read.do?no=' + no, 
		function(result){
			var member = result.jsonResult.data;
			$('#no').val(member.no);
			$('#name').val(member.name);
			$('#email').val(member.email);
			$('#tel').val(member.tel);
			$('#age').val(member.age);
			
			$('.editMode').css('display', '');
			$('.newMode').css('display', 'none');
	});
}

function updateMember() {
	$.ajax({
		url: 'http://localhost:8080/web02/member/ajax/update.do', 
		type: 'POST',
		data: {
			no: $('#no').val(),
			name: encodeURIComponent($('#name').val()),
			email: encodeURIComponent($('#email').val()),
			tel: encodeURIComponent($('#tel').val()),
			age: $('#age').val()
		},
		success: function(result){
			if(result.jsonResult.resultStatus == 0) {
				loadMemberList();
				clearForm();
			} else {
				alert('서버가 바쁩니다. \n계속 문제 발생 시 관리자(1234)에게 연락바랍니다.');
				console.log(result.jsonResult.error);
			}
		},
		error: function(xhr, status, msg){
			alert('회원 변경 실패!');
			console.log('========>', msg);
		}
	});
}


























