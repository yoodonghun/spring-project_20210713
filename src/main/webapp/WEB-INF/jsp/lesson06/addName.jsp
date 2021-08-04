<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 추가하기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
   <div class="container">
	    <b>이름:</b><br>
	    <div class="d-flex justify-content-start">
	      <input type="text" id="name" class="form-control col-4" placeholder="이름을 입력하세요">
	      <button type="button" id="overlapName" class="btn btn-warning ">중복 확인</button><br>
	      
	      <div id="statusArea"><span class="text-info"></span></div>
	      
	      
	    </div>  
	    <button type="submit" id="joinBtn" class="btn btn-primary mt-4">가입하기</button>
   </div>
   
   <script>
   $(document).ready(function() {
		// 중복확인 버튼 클릭
		$('#overlapName').on('click', function() {
			var name = $('#name').val().trim();
			
			$('#statusArea').empty(); // div 태그 안에있는 모든 태그를 비운다.
			
			// validation check
			
			// 이름이 입력되어 있는지 확인
			if (name == '') {
				$('#statusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
				return;
			}
			
			// 이름이 중복되는지 확인(DB에서 조회) -> AJAX 통신
			$.ajax({
				type:'get',
				url:'/lesson06/ex02/is_duplication',
				data:{'name':name},
				success: function(data) {
					//alert(data.is_duplication);
					if (data.is_duplication == true) {
						$('#statusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
					}
				},
				error: function(e) {
					alert("실패:" + e);
				}
			});
		});
    	 //회원가입 버튼 클릭
    	 $('#joinBtn').on('click', function(e) {
    			e.preventDefault(); // 바로 서브밋 되는 것 방지
    			
    			console.log($('#statusArea').children().length);
    			
    			// 만약 nameStatusArea에 아무 자식노드(태그)가 없다면 서브밋을 한다.
    			if ($('#statusArea').children().length == 0) {
    				alert("서브밋 가능");
    			} else {
    				alert("서브밋 불가");
    			}
    		});
    	});
   </script>
</body>
</html>