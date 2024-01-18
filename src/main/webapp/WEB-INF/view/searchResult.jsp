
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>同窓会 - 検索結果</title>
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
    
   <h2>参加者検索フォーム</h2>
    <form action="searchResult" method="post">
        参加者の名前: <input type="text" name="attendeeCount" required><br>
        <input type="submit" value="検索">
    </form>



 <div>
        <c:if test="${not empty searchResult}">
                    <p>${param.attendeeCount}</p>
            <p>検索結果: あります</p>
        </c:if>
        
        <c:if test="${empty searchResult}">
                    <p>${param.attendeeCount}</p>
            <p>検索結果: ありません</p>
        </c:if>
    </div>

</body>
</html>
