<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 추가</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
   <div class="container">
      <h1>회원정보 추가</h1>
      
      <form method="post" action="/lesson06/ex01/add_new_user" id="addform">
         <b>이름:</b>
         <input type="text" class="form-control col-3" name="name" placeholder="이름을 입력하세요"><br>
         
         <b>생년월일:</b>
         <input type="text" class="form-control col-3" name="yyyymmdd" placeholder="예) 19930516"><br>
         
         <b>이메일:</b>
         <input type="text" class="form-control col-3" name="email" placeholder="이메일을 입력하세요"><br>
         
         <b>자기소개:</b>
         <textarea name="introduce" class="form-control" rows="10" cols="20" ></textarea>
         <br>
         
         <button type="button" id="addBtn" class="btn btn-warning form-control col-1">추가</button> 
         <a href="#" class="btn btn-info" id="aBtn">추가 요청</a>
      </form>
      
      <script>
	        $(document).ready(function() {
	        	//1) JQuery의 submit 기능 이용하기
	        	$("#addform").on("submit", function(e) {
	        		//e.preventDefault();
	        		
	        		
	        		//validation => return이 되더라도 submit이 되어버린다
	        		let name = $("input[name=name]").val().trim();
	        		if(name == ""){
	        			alert("이름을 입력해주세요");
	        			return;
	        		}
	        		
	        		let yyyymmdd = $("input[yyyymmdd=yyyymmdd]").val().trim();
	        		if(yyyymmdd == ""){
	        			alert("생년월일을 입력해주세요");
	        			return;
	        		}
	        		
	        		//$("#addform").submit();
	        	});
	        
	        $("#aBtn").on("click", function(e){
	        	e.preventDefault();
	        });
	        
	        //2) JQeury의 AJAX 통신을 이용하기 ->form 태그 사용하지 않음
	        $("#addBtn").on("click", function(e){
	        	//alert("추가버튼 클릭");
	        	
	        	//validation
	        	let name = $("input[name=name]").val().trim();
        		if(name == ""){
        			alert("이름을 입력해주세요");
        			return;
        		}
        		
        		let yyyymmdd = $("input[name=yyyymmdd]").val().trim();
        		if(yyyymmdd == ""){
        			alert("생년월일을 입력해주세요");
        			return;
        		}
	        	
        		if(isNaN(yyyymmdd)) {
        			alert("숫자만 입력하세요");
        			return;
        		}
	        	
        		let email = $("input[name=email]").val().trim();
        		
        		let introduce = $("textarea[name=introduce]").val().trim();
        		
	        	console.log("email:" + email);
	        	console.log("introduce:" + introduce);
	        	
	        	//AJAX : form 태그와 상관없이 비동기로 별도 요청 (request)
	        	$.ajax({
	        		type: 'POST'
	        		,url: '/lesson06/ex01/add_new_user'
	        		,data: {"name": name, "yyyymmdd" : yyyymmdd, "email": email, "introduce" : introduce}
	        		,success: function(data){
	        			alert(data);
	        			location.href= "/lesson06/ex01/getUser"
	        		}, complete: function(data){
	        			alert("완료");
	        		}, error: function(e){ //error의 e임
	        			alert("error" + e);
	        		}
	        	});
	        });
        	
        });
      </script>
   </div>
</body>
</html>