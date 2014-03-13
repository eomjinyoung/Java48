var http = require('http');
var twitterAPI = require('node-twitter-api');
var twitter = new twitterAPI({
    consumerKey: '21JW7YoILVb1gBrdhsgZkQ', // API key
    consumerSecret: 'vMWICXPx2ytmUvQ5spi9PBxlHAOQ7qGxjzoic65MxA', // API Secret Key
    callback: 'http://192.168.200.43:8884/getAccessToken' // 로그인 성공 후 자동 접속할 주소
});
var reqToken, reqTokenSec;
var accToken, accTokenSec;
var pageControlMap = {};

pageControlMap['/getRequestToken'] = function(req, res, urlObj) {
	// 트위터로부터 요청토큰을 얻는다.
	res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
	  
	twitter.getRequestToken(function(error, requestToken, requestTokenSecret, results){
	    if (error) {
	      console.log("Error getting OAuth request token : ");
	      console.log(error);
	      res.end();
	    } else {
	      reqToken = requestToken;
	      reqTokenSec = requestTokenSecret;
	      res.write('{');
	      res.write('  "requestToken": "' + requestToken + '"');
	      res.write('}'); 
	      res.end();
	    }
	  });	
};

pageControlMap['/getAccessToken'] = function(req, res, urlObj) {
	// 트위터로부터 액세스토큰을 발급받는다.
  res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
  var oauth_verifier = urlObj.query.oauth_verifier;
  twitter.getAccessToken(
		  reqToken, // 요청토큰 
		  reqTokenSec, // 요청토큰 보안키
		  oauth_verifier, // 사용자 검증키
		  function(error, accessToken, accessTokenSecret, results) {
    if (error) {
      console.log("Error getting OAuth access token : ");
	  console.log(error);
	  res.end();
	} else {
	  accToken = accessToken;    
	  accTokenSec = accessTokenSecret;
	  
	  res.write('<html><head><title>redirect main</title>');
	  res.write('<meta http-equiv="refresh"');
	  res.write(' content="1;url=http://localhost:8080/twitter/main.html">');
	  res.write('</head><body>');
	  res.write('<p>잠시후 메인 화면으로 이동합니다.</p>');
	  res.write('</body></html>');
	  
	  res.end();
	}
  });	
};

pageControlMap['/getUserTimeline'] = function(req, res, urlObj) {
	res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
	twitter.getTimeline(
		'user_timeline', // type 
		{screen_name: urlObj.query.screen_name}, // params
		accToken, // accessToken
		accTokenSec, // accessTokenSecret
		function(error, data){ // callback: 작업을 완료했을 때 호출할 함수
			if (error) {
				console.log(error);
				res.write('{"error": "오류!"');
			} else {
				res.write('[');
				var isFirst = true;
				data.forEach(function(item){
					isFirst || res.write(',');
					isFirst && (isFirst = false);
					res.write('{');
					res.write('"text":' + JSON.stringify(item.text));
					res.write(',"created_at":' + JSON.stringify(item.created_at));
					res.write(',"retweet_count": "' + item.retweet_count + '"');
					res.write(',"favorite_count":"' + 
						(item.retweeted_status?
							item.retweeted_status.favorite_count : '0') + '"');
					res.write('}')
				});
				res.write(']');
			}
			res.end();
		}
	);
}

http.createServer(function (req, res) {
  res.setHeader('Access-Control-Allow-Origin', '*');
  
  try {
	 //1. URL 분석: req.url -> /getRequestToken
	 //- 쓰기 좋도록 하기 위해
	var urlObj = require('url').parse(req.url, true);

	var pageControl = pageControlMap[urlObj.pathname];
	if (pageControl) {
		pageControl(req, res, urlObj);
	} else {
		throw '요청하는 서비스를 찾을 수 없습니다.';
	}
  } catch (err) {
	res.write('{ "error": "' + err + '" }');
	res.end();
  }
  
}).listen(8884, '192.168.200.43');
console.log('Server running at http://192.168.200.43:8884/');










