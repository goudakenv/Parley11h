package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/game2")
public class GameServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ログイン画面の表示
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 

        // customer.jspにフォワード
        request.getRequestDispatcher("/WEB-INF/view/game2.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字コードの設定
        request.setCharacterEncoding("UTF-8");

        // レスポンスの設定（任意）
        response.setContentType("text/html; charset=UTF-8");

        // 送信後の画面にリダイレクト
//        request.getRequestDispatcher("/WEB-INF/view/password2.jsp").forward(request, response);
    }
}
