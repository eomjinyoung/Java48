var http = require('http');
http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>트위터 로그인</title>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  </head>
  <body>
  <a id='btnLogin' style='display:none;' href=''>트위터 로그인</a>
     

  </body>
  </html>



















  res.end();
}).listen(8881, '127.0.0.1');
console.log('Server running at http://127.0.0.1:8881/');