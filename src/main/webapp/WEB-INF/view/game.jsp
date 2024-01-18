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
    <style>
        canvas {
            display: block;
            margin: 0 auto;
            background-color: #f0f0f0;
            border: 1px solid #000;
        }
    </style>
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
    <h1>アクションゲーム</h1>
    
<!--     <iframe src="https://plicy.net/GameEmbed/170304" width="420" scrolling="no" style="border:solid 1px;width:420px !important; height: 270px !important; max-width:100% !important;" frameborder="0"><a href="https://plicy.net/GamePlay/170304">Ⅾ</a></iframe> -->
    
<canvas id="game" width="480" height="320"></canvas>
    <script src="js/script2.js"></script>
</body>
</html>
