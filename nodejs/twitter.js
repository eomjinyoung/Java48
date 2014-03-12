var http = require('http');
var twitterAPI = require('node-twitter-api');
var twitter = new twitterAPI({
    consumerKey: 'e4eotjb8TZvdo3GrcxIBGA', // API key
    consumerSecret: 'tCXx7yZ9LKfAEMg45foMnsGA0tlFYOVkLZg5Opy6Urk', // API Secret Key
    callback: 'http://java.bitacademy.net:8884/goMain' // 로그인 성공 후 자동 접속할 주소
});
http.createServer(function (req, res) {
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
	      throw '트위터 요청토큰 얻기 오류';
	    } else {
	      res.write('{');
	      res.write('  "requestToken": "서버로부터 받은 요청토큰값"');
	      res.write('}'); 
	      res.end();
	    }
	  });
	}
  } catch (err) {
	res.write('{ "error": "' + err + '" }');
	res.end();
  }
  
}).listen(8884, '192.168.200.43');
console.log('Server running at http://192.168.200.43:8884/');










