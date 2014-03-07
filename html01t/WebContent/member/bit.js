function bit(selector) {
  var elements = document.querySelectorAll(selector);
  
  elements.click = function(listener) {
	  for (var i = 0; i < this.length; i++) {
		  this[i].onclick = listener;
	  }
  };
  
  elements.css = function(name, value) {
	  for (var i = 0; i < this.length; i++) {
		  this[i].style[name] = value;
	  }
  };
  
  elements.append = function(child) {
	  for (var i = 0; i < this.length; i++) {
		  this[i].appendChild(child);
	  }
  };
  
  elements.remove = function() {
	  for (var i = 0; i < this.length; i++) {
		  this[i].parentNode.removeChild(this[i]);
	  }
  };
  
  elements.dispatchEvent = function(eventType) {
	  var event = null;
	  if (eventType == 'click') {
		  event = new MouseEvent('click', {
				view: window,
				bubbles: true,
				cancelable: true
		  });
	  } else {
		  return;
	  }
	  for (var i = 0; i < this.length; i++) {
		  this[i].dispatchEvent(event);
	  }
  };
  
  elements.val = function(value) {
	  if (arguments.length == 0) {
		  return this[0].value;
	  } else {
		  for (var i = 0; i < this.length; i++) {
			  this[i].value = value;
		  } 
	  }
  };
  
  return elements;
}




function createRequest() {
    try {
        return new XMLHttpRequest();
    } catch (exception) {
        var versions = [
            'Msxml2.XMLHTTP.6.0',
            'Msxml2.XMLHTTP.5.0',
            'Msxml2.XMLHTTP.4.0',
            'Msxml2.XMLHTTP.3.0',
            'Msxml2.XMLHTTP',
            'Microsoft.XMLHttp'
        ];
        for (var i = 0; i < versions.length; i++) {
            try {
                return new ActiveXObject(versions[i]);
            } catch (e) { }
        }
    }
}
/* AJAX 기능 수행 
 * url : 서비스를 가리키는 URL. string
 * options: AJAX 요청시 필요한 값을 담은 객체.
 *    data - 원격 함수에 전달할 데이터
 *    success - 원격 함수의 호출이 성공적으로 끝났을 때 호출될 메서드
 *    error - 원격 함수의 호출이 실패 했을 때 호출될 메서드
 *    method - 원격 함수 호출 방법(요청 방식: GET, POST) 
 */
bit.ajax = function(url, options) {
	//var xhr = new XMLHttpRequest();
	var xhr = createRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var result = JSON.parse(xhr.responseText).jsonResult;
			if (result.resultStatus == 0) { //원격 함수 호출 성공!
				if (options.success) options.success(result.data);
			} else { // 원격 함수 호출 실패!
				if (options.error) options.error(result.error);
			}
		}	  
	};
	xhr.open(options.method, url, true);
	if (options.method == 'GET') {
		xhr.send(null);	
	} else { // POST
		var queryString = '';
		for (var key in options.data) {
			if (queryString.length > 0) queryString += '&';
			queryString += key + '=' + options.data[key];
		}
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(queryString);
	}
};

var $ = bit;





