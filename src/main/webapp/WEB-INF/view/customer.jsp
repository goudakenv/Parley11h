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
       <script src="js/script.js"></script>
</head>
<body>
      <ul>
        <li><a href="item/post">ホーム</a></li>
        <li><a href="board">掲示板</a></li>
        <li><a href="item/party">同窓会</a></li>
        <li><a href="searchResult">同窓会検索</a></li>
        <li><a href="customer">お問い合わせ</a></li>
        <li>
            <a href="game">ゲーム</a>
            <ul class="submenu">
                
                <li><a href="game">アクション</a></li>
                <li><a href="game2">シューティング</a></li>
                <li><a href="game3">RPG</a></li>
       
            </ul>
        </li>
    </ul>
        
    <p></p>
    <h1>お問い合わせ</h1>
    
    <form action="customer" method="post"> <!-- Assuming the data is sent to "contact" servlet -->
        ネーム: <input type="text" name="name" required><br>
        ジャンル: <input type="text" name="hobbyGenre" required><br>
        要望: <input type="text" name="request" required><br>
        メッセージ<br>
        <textarea name="message" rows="4" cols="50" required></textarea>
        <br> 
        <input type="submit" value="送信">
    </form>

    <!-- アンケート一覧表示の部分 -->
<%--  <c:forEach var="contact" items="${contactList}"> --%>
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
