<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

<title>IDパスワード画面</title>
<link rel="stylesheet" href="css/style.css">
<style>
#movingImageContainer {
	position: relative;
	height: 300px; /* 画像の高さ + 上下の余白 */
}

#movingImage {
	position: absolute;
	top: 0;
}
</style>


<!-- <script src="/js/script.js" defer></script> -->

</head>
<body>
	<h1>ご回答ありがとうございました</h1>



	<p>ログインID：test2</p>
	<p>ログインPASS：test2</p>

	<h2>
		<a href="login">ログイン画面へ</a>
	</h2>


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
    趣味: <%= hobbyGenre %>
</p>
<p>
    要望: <%= requestValue %>
</p>
<p>
    メッセージ: <%= message %>
</p>
</body>
</html>

<!-- JavaScriptコードを直接埋め込む -->

<div id="movingImageContainer">
	<img id="movingImage"
		src="${pageContext.request.contextPath}/images/tori_tegamiwohakobusiroihato.png"
		alt="感謝" width="200" height="200">
</div>
<script>
        document.addEventListener("DOMContentLoaded", function() {
            var movingImage = document.getElementById("movingImage");
            var direction = 1; // 1: 下方向, -1: 上方向
            var position = 0;

            setInterval(function() {
                position += direction * 5; // 画像が上下に動く距離を調整
                movingImage.style.top = position + "px";

                // 画像が一定の範囲を超えたら方向を反転
                if (position <= 0 || position >= 10) {
                    direction *= -1;
                }
            }, 150); // 100ミリ秒ごとに動く
        });
    </script>
</body>
</html>