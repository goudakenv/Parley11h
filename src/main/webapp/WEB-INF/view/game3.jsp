<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.List" %>
<%@ page import="domain.Contact" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <title>アンケート画面</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/TUGames1.js"></script>
    <script src="js/main.js"></script>
    <script src="js/script.js"></script>
    
   
</head>
<body style="margin:0px;overflow:hidden">
    <!-- ナビゲーションメニュー -->
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
    <h1>RPGゲーム</h1>
    
    <!-- ゲーム用のキャンバス -->
    <canvas id="main"></canvas>
    
    
</body>
</html>
