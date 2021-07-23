<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core</title>
</head>
<body>
   <h1>변수 정의하기 (c:set)</h1>
   
   <c:set var="number1" value="100" />
   <c:set var="number2">200</c:set>
   
   <h4>number1: ${number1}</h4>
   <h4>number2: ${number2}</h4>
   
   <h4>number1+number2 : ${number1 + number2}</h4>
   
   <h1>변수 출력하기 (c:out)</h1>
   <!-- value 송성에 들어있는 값이 출력 된다. -->
   <h4>number : <c:out value="10"></c:out></h4>
   <h4>number1: <c:out value="${number1}"></c:out></h4>
   <!-- 태그 문구가 그대로 출력 된다 -->
   <%-- <c:out value="<script>alert("출력")</script>" /> --%>
   
   <%-- <c:out value="<script>alert("그대로 출력")</script>" escapeXml="true" /> --%>
   
   <%-- <c:out value="<script>alert("뜬다")</script>" escapeXml="false" /> --%>
   
   <h1>조건문 (c:if)</h1>
   <c:if test="true">
      <h4>조건이 참이다</h4>
   </c:if>
   
   <c:if test="${number1 > 50}">
      <h4>number1은 50보다 크다</h4>
   </c:if>
   
   <!-- JSTL 문법에서 같다 비교시 ==을 잘 사용하지 않는다 -->
   <c:if test="${number1 == 100 }">
     <h4>number1은 100이다</h4>
   </c:if>
   
   <!-- 같다 비교시 eq 사용 권장 -->
   <c:if test="${number1 eq 100 }">
      <h4>number1은 100이다</h4>
   </c:if>
   
   <!-- 비어있지 않다 -->
   <c:if test="${number1 not eq 100 }">
      <h4>number1은 100이다</h4>
   </c:if>
   
  
  
   
   
</body>
</html>