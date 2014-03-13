var http = require('http');
var twitterAPI = require('node-twitter-api');
var twitter = new twitterAPI({
    consumerKey: '21JW7YoILVb1gBrdhsgZkQ', // API key
    consumerSecret: 'vMWICXPx2ytmUvQ5spi9PBxlHAOQ7qGxjzoic65MxA', // API Secret Key
    callback: 'http://java.bitacademy.net:8884/goMain' // 로그인 성공 후 자동 접속할 주소
});
http.createServer(function (req, res) {
  res.setHeader('Access-Control-Allow-Origin', '*');
  res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
  try {
	 //1. URL 분석: req.url -> /getRequestToken
	 //- 쓰기 좋도록 하기 위해
	var urlObj = require('url').parse(req.url, true);
	if (urlObj.pathname == '/getRequestToken') {
	  // 트위터로부터 요청토큰을 얻는다.
      twitter.getRequestToken(function(error, requestToken, requestTokenSecret, results){
	    if (error) {
	      console.log("Error getting OAuth request token : ");
	      console.log(error);
	      res.end();
	    } else {
	      res.write('{');
	      res.write('  "requestToken": "' + requestToken + '"');
	      res.write('}'); 
	      res.end();
	    }
	  });
	} else if (urlObj.pathname == '/goMain') {
	  // 	
	}
  } catch (err) {
	res.write('{ "error": "' + err + '" }');
	res.end();
  }
  
}).listen(8884, '192.168.200.43');
console.log('Server running at http://192.168.200.43:8884/');










