<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.List" %>
<%@ page import="domain.Contact" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>アンケート画面</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>アンケート</h1>
    <form action="contact" method="post"> <!-- Assuming the data is sent to "contact" servlet -->
        ネーム: <input type="text" name="name" required><br>
        趣味: <input type="text" name="hobbyGenre" required><br>
        要望: <input type="text" name="request" required><br>
        メッセージ<br>
        <textarea name="message" rows="4" cols="50" required></textarea>
        <br> 
        <input type="submit" value="送信">
    </form>
    
    <h2><a href="login">ログイン画面へ</a></h2>
    
 <!-- アンケート一覧表示の部分 -->
<%-- <c:forEach var="contact" items="${contactList}"> --%>
<%--     <p>番号: ${contact.id}</p> --%>
<%--     <p>ネーム: ${contact.name}</p> --%>
<%--     <p>趣味: ${contact.hobbyGenre}</p> --%>
<%--     <p>要望: ${contact.request}</p> --%>
<%--     <p>メッセージ: ${contact.message}</p> --%>
<%--     <p>投稿時刻: ${contact.createdAt}</p> --%>
<!--     <hr> -->
<%-- </c:forEach> --%>
 
</body>
</html>
