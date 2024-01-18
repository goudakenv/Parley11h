<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.List" %>
<%@ page import="domain.Contact" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>シューティングゲーム</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/shooting.css">
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

<h1 style="color: white;">シューティングゲーム</h1>

    <canvas id="gameScreen" width="450" height="600"></canvas>
    <!-- scoreDisplay を表示するための要素 -->
    <p id="scoreDisplay" class="score">Score: 0</p>
    <!-- 時計を表示するための要素 -->
    <p id="clockDisplay" class="clock"></p>
    <!-- タイマーを表示するための要素 -->
    <p id="timerDisplay" class="timer">Time left: 30</p>
    <!-- ゲーム終了時のスコア表示 -->
    <p id="gameOverDisplay" class="game-over" style="display: none;"></p>

    <script src="js/shooting.js"></script>
    <script>
        // タイマーの初期値（秒）
        var timerValue = 30;

        // スコアの初期値
        var score = 0;

        // タイマーを更新する関数
        function updateTimer() {
            // 残り時間を表示要素に設定
            document.getElementById("timerDisplay").innerHTML = "Time left: " + timerValue;

            // 時間を減少させる
            timerValue--;

            // タイマーが0になったら終了
            if (timerValue < 0) {
                clearInterval(timerInterval); // タイマーを停止
                document.getElementById("timerDisplay").innerHTML = "Time's up!";
                showGameOver();
            }
        }

        // スコアを更新する関数
        function updateScore(points) {
            score += points;
            document.getElementById('scoreDisplay').innerText = `Score: ${score}`;

            // スコアが200以上ならゲームクリア
            if (score >= 200) {
                clearInterval(timerInterval); // タイマーを停止
                document.getElementById("timerDisplay").innerHTML = "Game Clear!";
                showGameOver();
            }
        }

        // ゲーム終了時の処理
        function showGameOver() {
            // ゲームオーバー表示要素にスコアを表示
            document.getElementById('gameOverDisplay').innerText = `Game Over! Your Score: ${score}`;
            document.getElementById('gameOverDisplay').style.display = 'block';

            // ゲーム再開ボタンを表示
            document.getElementById('restartButton').style.display = 'block';
        }

        // ゲーム再開ボタンがクリックされたときの処理
        function restartGame() {
            // ゲームオーバー表示要素を非表示
            document.getElementById('gameOverDisplay').style.display = 'none';

            // ゲーム再開ボタンを非表示
            document.getElementById('restartButton').style.display = 'none';

            // タイマーを再度始動
            timerValue = 30;
            timerInterval = setInterval(updateTimer, 1000);
            updateTimer();

            // スコアをリセット
            score = 0;
            document.getElementById('scoreDisplay').innerText = `Score: ${score}`;
        }

        // 1秒ごとにタイマーを更新
        var timerInterval = setInterval(updateTimer, 1000);

        // 最初に一度タイマーを表示
        updateTimer();
    </script>

    <!-- ゲーム再開ボタン -->
    <button id="restartButton" onclick="restartGame()" style="display: none;">Restart Game</button>
</body>
</html>
