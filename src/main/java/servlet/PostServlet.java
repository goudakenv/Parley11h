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

@WebServlet("/item/post")
public class PostServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // PostDAOを使用して投稿データのリストを取得
        PostDAO postDao = DaoFactory.selectPostDAO();
        List<Post> postList = postDao.getAllPosts();
        
        // 取得した投稿データをリクエスト属性にセット
        request.setAttribute("postList", postList);
        
        // itemList.jspにフォワード
        request.getRequestDispatcher("/WEB-INF/view/postList.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//Post送信は文字化けする。文字化け対策は必須
    			request.setCharacterEncoding("UTF-8");
    	
        // 以下は変更なし
        String username = request.getParameter("username");
        String message = request.getParameter("message");
       
        

        Post post = new Post();
        post.setUsername(username);
        post.setMessage(message);
  

        PostDAO postDao = DaoFactory.selectPostDAO();
        postDao.addPost(post);

        // doGetメソッドを呼び出して投稿一覧を再取得
        doGet(request, response);
    }
}
