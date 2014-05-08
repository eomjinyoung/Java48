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
									.attr('href', 
											contextRoot + 
											'/subject/detail.bit?no=' + 
											subject.no)
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















