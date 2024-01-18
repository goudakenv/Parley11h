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
    <title>掲示板一覧画面</title>
        <link rel="stylesheet" href="css/style2.css">
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
    
<h2 style="display: flex; justify-content: space-between;">掲示板一覧
<!-- <a href="login" style="margin-left: 30px;">ログイン画面へ</a> -->
</h2>

<div class="post-container">
   <c:forEach var="post" items="${postList}">
      <div class="post">
         <div style="display: flex; flex-direction: row;">
            <p style="margin-right: 30px;">番号: ${post.getId()}</p>
            <p>ユーザーネーム: ${post.getUsername()}</p>
         </div>
         <p class="bold-text" style="font-weight: bold;">メッセージ: ${post.getMessage()}</p>
         <p>投稿時刻: ${post.getCreatedAt()}</p>
      </div>
   </c:forEach>
</div>

</body>
</html>
