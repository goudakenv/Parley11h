<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.List" %>
<%@ page import="domain.Post" %>
<%@ page import="domain.Contact" %>


<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ログイン画面</title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>


    <h1>ログイン</h1>
	<c:if test="${!empty error}">
		<p>${error}</p>
	</c:if>
	<form action="" method="post">
		<p>ログインID：
		  <input type="text" name="id"/>
		</p>
		<p>ログインPASS：
		  <input type="text" name="pass"/>
		</p>
		<p>
			<input type="submit" value="ログイン">
		</p>
	</form>
	
<!-- 	<a href="register">新規登録</a> -->
	
	<hr>
	
	<p>簡単なアンケートにお答えいただき、是非、当サービスシステムをご利用ください</p>
	<a href="contact">アンケート</a>
    

</body>
</html>
