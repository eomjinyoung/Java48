var http = require('http');
http.createServer(function (req, res) {
  console.log(req.url);
  var urlObj = require('url').parse(req.url, true);
  var pathname = urlObj.pathname;
  var params = urlObj.query;
  try {
	  if (pathname == '/calc') {
		var result = 0;
		var a = Number(params.a);
		var b = Number(params.b);
		
		if (params.op == 'plus') {
		  result = a + b;	
		} else if (params.op == 'minus') {
		  result = a - b;
		} else {
		  result = '지원하지 않는 연산자이거나 또는 값이 옳지 않습니다.';
		}
		
	    res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
	    res.write(String(result));
	  }
  } catch (err) {
	  res.write(String(err));
  }
  res.end();
}).listen(8882, '192.168.200.43');
console.log('Server running at http://192.168.200.43:8882/');










