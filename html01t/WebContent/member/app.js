window.onload = function() {
	loadMemberList();
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
};

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
		method: 'GET',
		success: function(members){
			var memberTable = $("#memberTable");
			clearMemberList();
			var tr = null, td = null, a = null;
			members.forEach(function(member){
				tr = document.createElement('tr');
				tr.setAttribute('class', 'dataRow');
				[member.no,
				 member.name,
				 member.email,
				 member.tel].forEach(function(value,index,arr){
					td = document.createElement('td');
					if (index == 1) {
						td.innerHTML = '<a href="#"' +
							' onclick="readMember(' + arr[0] +
							'); return false;">' +
							value + '</a>';
					} else {
						td.innerHTML = value;
					} 
					tr.appendChild(td);
				});
				td = document.createElement('td');
				a = document.createElement('a');
				a.href = '#';
				a.onclick = function(event) {
					deleteMember(member.no);
					event.preventDefault();
				};
				a.innerHTML = '삭제';
				td.appendChild(a);
				tr.appendChild(td);
				
				memberTable.append(tr);
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


























