<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

<title>ユーザー登録</title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>


	<h1>ユーザー登録</h1>
	<form action="" method="post">
		<p>ログインID：
		  <input type="text" name="id"/>
		</p>
		<p>ログインPASS：
		  <input type="text" name="pass"/>
		</p>
		<p>
			<input type="submit" value="登録">
		</p>
	</form>


    <h2><a href="login">ログイン画面へ</a></h2>


</body>
</html>