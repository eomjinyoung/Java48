function bit(id) {
  return document.getElementById(id);
}

var $ = bit;

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
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//var obj = eval('(' + xhr.responseText + ')');
			var members = JSON.parse(xhr.responseText).jsonResult.data;
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
				/*
				td.innerHTML = '<a href="#"' + 
					' onclick="deleteMember(' + member.no + 
					'); event.preventDefault();">삭제</a>';
				*/
				tr.appendChild(td);
				
				memberTable.appendChild(tr);
			});
		}	  
	};
	xhr.open('GET', 'http://localhost:8080/web02/member/ajax/list.do', true);
	xhr.send(null);
}

function clearMemberList() {
	var memberTable = $("memberTable");
	var trList = document.querySelectorAll('.dataRow');
	for (var i = 0; i < trList.length; i++) {
		memberTable.removeChild(trList[i]);
	}
}

function addMember() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var result = JSON.parse(xhr.responseText).jsonResult; 
			if (result.resultStatus != 0) {
				alert('회원 등록 실패!');
				console.log(result.error);
			} else {
				loadMemberList();
				clearForm();
			}
		}
	};
	xhr.open('POST', 'http://localhost:8080/web02/member/ajax/add.do', true);
	
	var data = 'name=' + encodeURIComponent($('name').value) +
		'&email=' + encodeURIComponent($('email').value) +
		'&password=' + $('pass1').value +
		'&tel=' + encodeURIComponent($('tel').value) +
		'&age=' + $('age').value;
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(data);
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
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var status = JSON.parse(xhr.responseText).jsonResult.resultStatus;
			if (status != 0) {
				alert('삭제 실패입니다!');
			} else {
				loadMemberList();
				clearForm();
			}
		}	  
	};
	xhr.open('GET', 
		'http://localhost:8080/web02/member/ajax/delete.do?no=' + no, 
		true);
	xhr.send(null);
}

function readMember(no) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var result = JSON.parse(xhr.responseText).jsonResult;
			if (result.resultStatus != 0) {
				alert('해당 멤버 정보를 읽을 수 없습니다!');
			} else {
				$('no').value = result.data.no;
				$('name').value = result.data.name;
				$('email').value = result.data.email;
				$('tel').value = result.data.tel;
				$('age').value = result.data.age;
				
				$('noSpan').style.display = '';
				$('btnUpdate').style.display = '';
				$('btnDelete').style.display = '';
				$('btnCancel').style.display = '';
				$('btnAdd').style.display = 'none';
			}
		}	  
	};
	xhr.open('GET', 
		'http://localhost:8080/web02/member/ajax/read.do?no=' + no, 
		true);
	xhr.send(null);	
}

function updateMember() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var result = JSON.parse(xhr.responseText).jsonResult; 
			if (result.resultStatus != 0) {
				alert('회원 변경 실패!');
				console.log(result.error);
			} else {
				loadMemberList();
				clearForm();
			}
		}
	};
	xhr.open('POST', 'http://localhost:8080/web02/member/ajax/update.do', true);
	
	var data = 'name=' + encodeURIComponent($('name').value) +
		'&email=' + encodeURIComponent($('email').value) +
		'&tel=' + encodeURIComponent($('tel').value) +
		'&age=' + $('age').value + 
		'&no=' + $('no').value;
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(data);
}


























