<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="domain.Post" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>同窓会</title>
    <link rel="stylesheet" href="../css/style.css">
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

        <p></p>   
    <h1>同窓会</h1>

    <form action="" method="post">
        参加する人: <input type="text" name="attendeeCount" required><br>
        参加してほしい人: <input type="text" name="attendeeName" required><br>
        開催してほしい場所:
        <select name="eventLocation" required>
            <option value="東京">東京</option>
            <option value="宮城">宮城</option>
            <option value="その他">その他</option>
        </select><br>
        <p></p>
        幹事してほしい人: <input type="text" name="organizerName" required><br>
        コメント: <textarea name="comments" rows="4" cols="50"></textarea><br>
        <input type="submit" value="送信">
    </form>

<% 
    // フォームが送信された場合、データを表示する
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String attendeeCount = request.getParameter("attendeeCount");
        String attendeeName = request.getParameter("attendeeName");
        String eventLocation = request.getParameter("eventLocation");
        String organizerName = request.getParameter("organizerName");
        String comments = request.getParameter("comments");
%>

    <h2>送信された内容:</h2>
    <p>参加する人: <%= attendeeCount %></p>
    <p>参加してほしい人: <%= attendeeName %></p>
    <p>開催してほしい場所: <%= eventLocation %></p>
    <p>幹事してほしい人: <%= organizerName %></p>
    <p>コメント: <%= comments %></p>

<%
    }
%>
</body>
</html>
