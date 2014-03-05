window.onload = function() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      //var obj = eval('(' + xhr.responseText + ')');
      var members = JSON.parse(xhr.responseText).jsonResult.data;
      for (var i in members) {
    	//1.tr 태그를 생성하라.
    	//2.td 태그를 생성하라. -> td 태그의 콘텐츠를 설정하라. 
    	//3.td 태그를 tr에 붙여라 (2 ~ 3을 네번 반복: 번호,이름,이메일,전화)
    	//2.tr 태그를 table 태그에 붙인다.
      }
    }	  
  };
  xhr.open('GET', 'http://localhost:8080/web02/member/ajax/list.do', true);
  xhr.send(null);
};