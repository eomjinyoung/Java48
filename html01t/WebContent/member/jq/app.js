$(document).ready(function() {
	loadMemberList();
/*	
	clearForm();

	$('#btnAdd').click(function() {
		try {
			validateForm();
			addMember();
		} catch (err) {
			alert(err);
		}
	});

	$('#btnCancel').click(function() {
		$('.editMode').css('display', 'none');
		$('.newMode').css('display', '');
	});

	$('#btnUpdate').click(function() {
		updateMember();
	});
	
	$('#btnDelete').click( function() {
		deleteMember($('#no').val());
	});
*/	
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
			//clearMemberList();
			console.log(members);
			$.each(members, function(index, member){
				$('<tr></tr>')
					.addClass('dataRow')
					.append($('<td></td>').html(member.no)) // 번호
					.append($('<td></td>').html(member.name)) // 이름
					.append($('<td></td>').html(member.email)) // 이메일
					.append($('<td></td>').html(member.tel)) // 전화
					.append($('<td></td>').html('삭제')) // 삭제버튼
					.appendTo(memberTable); 
				/*
				$.each([member.no,member.name,member.email, member.tel], 
						function(index, value){
					td = $('<td>');
					if (index == 1) {
						td.append($('<a></a>',{
							href: '#'
						}).html(value));
					} else {
						td.html(value);
					} 
					tr.append(td);
				});
				td = $('<td></td>').append($('<a>',{
							href: '#'
						}).click(function(event) {
							deleteMember(member.no);
							event.preventDefault();
						}).html('삭제')).appendTo(tr);
				memberTable.append(tr);
				*/
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
	$.ajax('http://localhost:8080/web02/member/ajax/add.do', {
		method: 'POST',
		data: {
			name: encodeURIComponent($('#name').val()),
			email: encodeURIComponent($('#email').val()),
			password: $('#pass1').val(),
			tel: encodeURIComponent($('#tel').val()),
			age: $('#age').val()
		},
		success: function(result){
			loadMemberList();
			clearForm();
		},
		error: function(msg){
			alert('회원 등록 실패!');
			console.log(msg);
		}
	});
}

function clearForm() {
	$('#btnCancel').dispatchEvent('click');
}

function deleteMember(no) {
	$.ajax('http://localhost:8080/web02/member/ajax/delete.do?no=' + no, {
		method: 'GET',
		success: function(result){
			loadMemberList();
			clearForm();
		},
		error: function(msg){
			alert('회원 삭제 실패!');
			console.log(msg);
		}
	});
}

function readMember(no) {
	$.ajax('http://localhost:8080/web02/member/ajax/read.do?no=' + no, {
		method: 'GET',
		success: function(result){
			$('#no').val(result.no);
			$('#name').val(result.name);
			$('#email').val(result.email);
			$('#tel').val(result.tel);
			$('#age').val(result.age);
			
			$('.editMode').css('display', '');
			$('.newMode').css('display', 'none');
		},
		error: function(msg){
			alert('해당 멤버 정보를 읽을 수 없습니다!');
			console.log(msg);
		}
	});
}

function updateMember() {
	$.ajax('http://localhost:8080/web02/member/ajax/update.do', {
		method: 'POST',
		data: {
			no: $('#no').val(),
			name: encodeURIComponent($('#name').val()),
			email: encodeURIComponent($('#email').val()),
			tel: encodeURIComponent($('#tel').val()),
			age: $('#age').val()
		},
		success: function(result){
			loadMemberList();
			clearForm();
		},
		error: function(msg){
			alert('회원 변경 실패!');
			console.log(msg);
		}
	});
}


























