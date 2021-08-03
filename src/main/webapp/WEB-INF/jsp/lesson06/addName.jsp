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
	      <button type="button" id="overlapName" class="btn btn-warning ">중복 확인</button>
	      
	      <div id="statusArea"><span class="text-info"></span></div>
	      
	      
	    </div>  
	    <button type="submit" class="btn btn-primary mt-4">가입하기</button>
   </div>
   
   <script>
     $(document).ready(function(){
    	 //중복확인 버튼 클릭
    	 $("#overlapName").on(function(e){
    		 $("#statusArea").empty();
    		 
    		let name = $("#name").val().trim();
    		
    		if(name == ''){
    			$("#statusArea").append("<small class=\'text-danger\'>이름이 비어있습니다</small>");
    			return;
    		}
    		
    		
    		//이름이 중복되었는지 AJAX로 확인
    		$.ajax({
    			type="get"
    			,data: {'name': name}
    			,url: "/lesson06/ex02/is_duplicationd"
    			,success: function(data){
    				
    				//TODO
    		       //$("#statusArea").append("<small class=\'text-danger\'>이름이 중복되었습니다</small>");
    				
    				
    			}
    			,error: function(e){
    				alert('error': + e);
    			}
    		})
    		
    		
    	 });
    	 
     });
   </script>
</body>
</html>