var http = require('http');
http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.write('Hello World\n');
  res.write('ohora world!\n');
  res.end();
}).listen(8881, '127.0.0.1');
console.log('Server running at http://127.0.0.1:8881/');