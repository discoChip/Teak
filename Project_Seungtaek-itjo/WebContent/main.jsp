<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
			$("#user").hide();
			$("#admin").hide();
			
	})
	
	function funLoad(){
        var Cheight = $(window).height();
        $('#menu').css({'height':Cheight+'px'});
    }
    window.onload = funLoad;
    window.onresize = funLoad;
    
    function show(){
    	$("#menu").show();
    	$("#b").hide();
    }
    
    function hide(){
    	$("#menu").hide();
    	$("#b").show();
    }
</script>
<title>Main</title>

<link rel="stylesheet" type="text/css" href="resources/menu.css" />
<style type="text/css">
	#metro7{
		width: 1189px;
		margin: auto;
		margin-top: 250px;
	}
</style>
</head>
<body>
	<div id="metro7">
		<img alt="train" src="img/train.png" id="train" usemap="#line" title="train">
		
		<map name="line">
			<area alt="line9" shape="rect" coords="171,0, 345,175" href="index.jsp" title="line 9">
			<area alt="line2" shape="poly" coords="0,175, 0,363, 189,360" href="" title="line 2">
			<area alt="line3" shape="poly" coords="0,175, 250,419, 505,175" href="index.jsp" title="line 3">
			<area alt="line4" shape="poly" coords="505,175, 322,360, 683,360" href="index.jsp" title="line 4">
			<area alt="line5" shape="poly" coords="504,177,684,358,858,357,687,178" href="index.jsp" title="line 5">
			<area alt="line6" shape="poly" coords="1185,177,926,418,689,178" href="index.jsp" title="line 6">
			<area alt="line7" shape="poly" coords="1187,179,1001,356,1180,358" href="index.jsp" title="line 7">
		</map>
	</div>
	
	<div id="menu">
		<p><button onclick="hide()" id="bX" class="menuButton"><img alt="×" src="img/buttonX.png"></button></p>
		<a href="index.jsp">Index</a><br>
		<a href="siteInfo.html">사이트 소개</a><br>
		<a>공지사항</a><br>
		<a>커뮤니티</a><br>
		<p id="def"><a>로그인</a></p>
		<p id="user"><a>내 정보</a><br><a>로그아웃</a></p>
		<p id="admin"><a>회원 열람</a><br><a>로그아웃</a></p>
	</div>
	
	<button onclick="show()" style="float: right" id="b" class="menuButton"><img alt="Menu" src="img/button.png"></button>
	
	<footer>
		<a href="http://www.seoul.go.kr/main/index.html">서울시청</a>
		<a href="http://www.seoulmetro.co.kr/">서울메트로</a>
		<a href="">사이트맵</a>
		Copyright © Taekdo-Eopjo. All rights reserved.
	</footer>
	
</body>
</html>