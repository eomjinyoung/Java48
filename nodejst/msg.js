var http = require('http');
var totalMsg = [];
http.createServer(function (req, res) {
  try {
	  var params = require('url').parse(req.url, true).query;
	  totalMsg.push(params.me + ":" + params.msg);
	  
	  res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
	  totalMsg.forEach(function(item, index){
		  res.write(item + '\n');
	  });
  } catch (err) {
	  res.write(String(err));
  }
  res.end();
}).listen(8883, '192.168.200.43');
console.log('Server running at http://192.168.200.43:8883/');










