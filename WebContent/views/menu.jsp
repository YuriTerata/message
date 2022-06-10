<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="../css/style.css" type="text/css" rel="stylesheet">
<%@include file="header.html"%>

<p class="title">メニュー画面</p>
<section class="menu">
<div>
	<p>
		<input type="button" class="button"
		onclick="location.href='regist.jsp'" value="会員情報登録">
	</p>
	<p>
		<input type="button" class="button"
		onclick="location.href=''" value="会員情報更新">
	</p>
	<p>
		<input type="button" class="button"
		onclick="location.href='delete.jsp'" value="会員情報削除">
	</p>
</div>
</section>
<%@include file="footer.html"%>