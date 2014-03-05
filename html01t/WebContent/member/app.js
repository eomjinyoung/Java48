window.onload = function() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      //var obj = eval('(' + xhr.responseText + ')');
      var members = JSON.parse(xhr.responseText).jsonResult.data;
      var memberTable = document.getElementById("memberTable");
      var tr = null;
      members.forEach(function(member){
    	tr = document.createElement('tr');
    	[member.no,member.name,member.email,member.tel].forEach(function(value){
      	  td = document.createElement('td');
  	      td.innerHTML = value;
  	      tr.appendChild(td);
      	});
      	memberTable.appendChild(tr);
      });
    }	  
  };
  xhr.open('GET', 'http://localhost:8080/web02/member/ajax/list.do', true);
  xhr.send(null);
  
  
  
  
};










