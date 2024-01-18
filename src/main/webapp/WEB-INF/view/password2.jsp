<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

<title>IDパスワード画面</title>
    <link rel="stylesheet" href="css/style.css">


</head>
<body>
	<h1>ご回答ありがとうございました</h1>
<!--     <p>ログインID：test2</p> -->
<!--     <p>ログインPASS：test2</p> -->
    
            <h2><a href="customer">戻る</a></h2>
    

    <!-- レスポンスの設定（任意） -->
  	<%
    response.setContentType("text/html; charset=UTF-8");
    // Assuming you have the parameters set somewhere
    String name = request.getParameter("name");
    String hobbyGenre = request.getParameter("hobbyGenre");
    String requestValue = request.getParameter("request");
    String message = request.getParameter("message");
%>

<hr>

<p>
    ネーム: <%= name %>
</p>
<p>
    ジャンル: <%= hobbyGenre %>
</p>
<p>
    要望: <%= requestValue %>
</p>
<p>
    メッセージ: <%= message %>
</p>
    </body>
    </html>

</body>
</html>