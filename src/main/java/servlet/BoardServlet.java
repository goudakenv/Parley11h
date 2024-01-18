package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PostDAO;
import domain.Post;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ログイン画面の表示
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// PostDAOを使用して投稿データのリストを取得
        PostDAO postDao = DaoFactory.selectPostDAO();
        List<Post> postList = postDao.getAllPosts();
        
        // 取得した投稿データをリクエスト属性にセット
        request.setAttribute("postList", postList);
        
        // itemList.jspにフォワード
        request.getRequestDispatcher("/WEB-INF/view/board.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字コードの設定
        request.setCharacterEncoding("UTF-8");

        // フォームから送信されたデータの取得
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String message = request.getParameter("message");

        // 投稿情報の処理
        Post post = new Post();
        post.setUsername(username);
        post.setMessage(message);
        post.setName(name);
        post.setAge(age);

        // PostDAOを使用して投稿情報を追加
        PostDAO postDao = DaoFactory.selectPostDAO();
        postDao.addPost(post);

        // リクエスト属性にデータをセット
        request.setAttribute("username", username);
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.setAttribute("message", message);

        // レスポンスの設定（任意）
        response.setContentType("text/html; charset=UTF-8");

        // 送信後の画面にリダイレクト
        request.getRequestDispatcher("/WEB-INF/view/password.jsp").forward(request, response);
    }
}