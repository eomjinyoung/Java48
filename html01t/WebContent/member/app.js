window.onload = function() {
	loadMemberList();
	clearForm();
	
	$('memberForm').onsubmit = function() {
		try {
			validateForm();
			addMember();
		} catch (err) {
			alert(err);
		}
		return false;
	};
	
	$('btnCancel').onclick = function() {
		$('noSpan').style.display = 'none';
		$('btnUpdate').style.display = 'none';
		$('btnDelete').style.display = 'none';
		$('btnCancel').style.display = 'none';
		$('btnAdd').style.display = '';
	};
	
	$('btnUpdate').onclick = function() {
		updateMember();
	};
	
	$('btnDelete').onclick = function() {
		deleteMember($('no').value);
	};
};

function validateForm() {
	var pass1 = $('pass1').value;
	var pass2 = $('pass2').value;
	if (pass1 != pass2) {
		throw '암호가 일치하지 않습니다!';
	}
	var name = $('name').value;
	var email = $('email').value;
	if (name == '' || email == '') {
		throw '이름과 이메일은 필수 입력 항목입니다!';
	}
}

function loadMemberList() {
	$.ajax('http://localhost:8080/web02/member/ajax/list.do', {
		method: 'GET',
		success: function(members){
			var memberTable = $("memberTable");
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
				
				memberTable.appendChild(tr);
			});
		},
		error: function(msg){
			alert('회원 정보를 읽을 수 없습니다!');
			console.log(msg);
		}
	});
}

function clearMemberList() {
	var memberTable = $("memberTable");
	var trList = document.querySelectorAll('.dataRow');
	for (var i = 0; i < trList.length; i++) {
		memberTable.removeChild(trList[i]);
	}
}

function addMember() {
	$.ajax('http://localhost:8080/web02/member/ajax/add.do', {
		method: 'POST',
		data: {
			name: encodeURIComponent($('name').value),
			email: encodeURIComponent($('email').value),
			password: $('pass1').value,
			tel: encodeURIComponent($('tel').value),
			age: $('age').value
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
	var event = new MouseEvent('click', {
		view: window,
		bubbles: true,
		cancelable: true
	});
	$('btnCancel').dispatchEvent(event);
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
			$('no').value = result.no;
			$('name').value = result.name;
			$('email').value = result.email;
			$('tel').value = result.tel;
			$('age').value = result.age;
			
			$('noSpan').style.display = '';
			$('btnUpdate').style.display = '';
			$('btnDelete').style.display = '';
			$('btnCancel').style.display = '';
			$('btnAdd').style.display = 'none';
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
			no: $('no').value,
			name: encodeURIComponent($('name').value),
			email: encodeURIComponent($('email').value),
			tel: encodeURIComponent($('tel').value),
			age: $('age').value
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


























