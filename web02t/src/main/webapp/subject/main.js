var currPageNo = 1;
var pageSize = 10;

$(document).ready(function(){
	$('#header').load('../header.html');
	$('#footer').load('../footer.html');
	
	$('#prevPage').click(function(event){
		if (currPageNo > 1) {
			loadSubjectList(currPageNo - 1);
		}
	});
	
	$('#nextPage').click(function(event){
		loadSubjectList(currPageNo + 1);
	});
	
	$(document).on('click', 'button.rowDelBtn', function(){
		$.getJSON(
			bit.contextRoot + 
				'/subject/delete.ajax?no=' + 
				$(this).attr('data-no'),
			function(jsonObj) {
				var result = jsonObj.ajaxResult;
				if (result.status == "ok") {
					loadSubjectList(currPageNo);
				}
			});
	});
	
	$(document).on('click', 'a.titleLink', function(){
		$.getJSON(
			bit.contextRoot + 
				'/subject/detail.ajax?no=' + 
				$(this).attr('data-no'),
			function(jsonObj) {
				var result = jsonObj.ajaxResult;
				if (result.status == "ok") {
					console.log(result.data);
				} else {
					console.log('해당 과목이 없습니다.');
				}
			});
	});
	
	$('#btnAdd').click(function(){
		$.post(
			bit.contextRoot + '/subject/insert.ajax'
			,{
				title: $('#title').val(),
				description: $('#description').val()
			}
			,function(jsonObj) {
				loadSubjectList(currPageNo);
				$('#btnReset').click();
			}
			,'json');
	});
	
	$('#btnChange').click(function(){});
	$('#btnDelete').click(function(){});
	$('#btnReset').click(function(){});
	
	
	loadSubjectList(1);
});

function loadSubjectList(pageNo) {
	$.getJSON(
			bit.contextRoot + 
				'/subject/list.ajax?pageNo=' + pageNo + 
				'&pageSize=' + pageSize, 
			function(jsonObj){
				var result = jsonObj.ajaxResult;
				
				if (result.data.length > 0) {
					var table = $('#subjectList');
					$('.dataRow').remove();
					$.each(result.data, function(index, subject){
						$('<tr>')
							.addClass("dataRow")
							.append('<td>' + subject.no + '</td>')
							.append( $('<td>')
								.append( $('<a>')
									.addClass('titleLink')
									.attr('data-no', 	subject.no)
									.text(subject.title) 
							))
							.append( $('<td>')
								.append( $('<button>삭제</button>')
									.addClass('rowDelBtn')
									.addClass('btn')
									.addClass('btn-danger')
									.attr('data-no',subject.no)
							))
							.appendTo(table);
					});
					currPageNo = pageNo;
					$('#currPageNo').text(pageNo);
				}
			});
}















