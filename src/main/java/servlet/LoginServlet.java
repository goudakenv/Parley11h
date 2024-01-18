package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContactDAO;
import dao.DaoFactory;
import dao.UserDao;
import domain.Post;
import domain.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ログイン画面の表示
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ContactDAOを使用して投稿データのリストを取得
        ContactDAO contactDAO = DaoFactory.selectContactDAO();
        List<Post> contactList = contactDAO.getAllPosts();
        
        // 取得した投稿データをリクエスト属性にセット
        request.setAttribute("contactList", contactList);

        // login.jspにフォワード
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    // ログイン処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字化け防止
        request.setCharacterEncoding("UTF-8");

        // ログイン情報
        String loginId = request.getParameter("id");
        String loginPass = request.getParameter("pass");
        
        // 追加情報（アンケートフォームの入力データ）
        String username = request.getParameter("username");
        String message = request.getParameter("message");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        // 投稿情報の処理
        Post post = new Post();
        post.setUsername(username);
        post.setMessage(message);
        post.setName(name);
        post.setAge(age);
        
        // ContactDAOを使用して投稿情報を追加
        ContactDAO contactDao = DaoFactory.selectContactDAO();
        contactDao.addPost(post);

        // バリデーション
        if (loginId == null || loginPass == null || loginId.isEmpty() || loginPass.isEmpty()) {
            request.setAttribute("error", "ログインIDまたはパスワードが未入力です。");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            return;
        }

        // Daoを使いID、PASSをチェック
        UserDao userDao = DaoFactory.createUserDao();
        User user = userDao.findByLoginAndPass(loginId, loginPass);

        if (user == null) {
            request.setAttribute("error", "ログインIDまたはパスワードが間違っています。");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            return;
        }

        // ログイン成功時の処理
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // ログイン後の画面にリダイレクト
        response.sendRedirect(request.getContextPath() + "/item/post");
    }
}
