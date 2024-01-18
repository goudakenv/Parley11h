<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.Post"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
    <link rel="stylesheet" href="../css/style2.css">
   <script src="js/script.js"></script>
</head>
<body>
 <ul>
  <li><a href="../item/post">ホーム</a></li>
  <li><a href="../board">掲示板</a></li>
    <li><a href="../item/party">同窓会</a></li>
        <li><a href="../searchResult">同窓会検索</a></li>
  <li><a href="../customer">お問い合わせ</a></li>
  <li>
            <a href="../game">ゲーム</a>
            <ul class="submenu">
               <li><a href="../game">アクション</a></li>
                <li><a href="../game2">シューティング</a></li>
                <li><a href="../game3">RPG</a></li>
            </ul>
        </li>
</ul>

<div style="display: flex; justify-content: space-between; align-items: center;">
  <h1>掲示板</h1>
  
  <div>
    ${user.loginId}
    <form action="out" method="post">
      <input type="submit" value="ログアウト" />
    </form>
  </div>
</div>


	
	<form action="" method="post">
	
		ユーザーネーム<input type="text" name="username" required><br>
		
		メッセージ<br>
		<textarea name="message" rows="4" cols="50" required></textarea>
		<br> 
		
		<input type="submit" value="送信">
		
	</form>
	
	
	
	<hr>
	
	
	
<h2>掲示板一覧</h2>
<c:if test="${not empty postList}">
    <c:forEach var="post" items="${postList}">
<div class="post">
      <div style="display: flex; flex-direction: row;">
        <p style="margin-right: 30px;">番号: ${post.getId()}</p>
        <p style=>ユーザーネーム: ${post.getUsername()}</p>
      </div>
      <p class="bold-text" style="font-weight: bold;">メッセージ: ${post.getMessage()}</p>
      <p>投稿時刻: ${post.getCreatedAt()}</p>
    </div>    </c:forEach>
</c:if>




	

</body>
</html>