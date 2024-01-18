package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO; // Adjusted import statement
import dao.DaoFactory;
import domain.Contact; // Adjusted import statement

@WebServlet("/contact") // Changed the servlet mapping
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ログイン画面の表示
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ContactDAOを使用して連絡先データのリストを取得
        ContactDAO contactDAO = DaoFactory.selectContactDAO();
        List<Contact> contactList = contactDAO.getAllContacts();

        // 取得した連絡先データをリクエスト属性にセット
        request.setAttribute("contactList", contactList);

        // contact.jspにフォワード
        request.getRequestDispatcher("/WEB-INF/view/contact.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字コードの設定
        request.setCharacterEncoding("UTF-8");

        // フォームから送信されたデータの取得
        String name = request.getParameter("name");
        String hobbyGenre = request.getParameter("hobbyGenre");
        String requestText = request.getParameter("request");
        String message = request.getParameter("message");

        // 連絡先情報の処理
        Contact contact = new Contact();
        contact.setName(name);
        contact.setHobbyGenre(hobbyGenre);
        contact.setRequest(requestText);
        contact.setMessage(message);

        // ContactDAOを使用して連絡先情報を追加
        ContactDAO contactDao = DaoFactory.selectContactDAO();
        contactDao.addContact(contact);

        // リクエスト属性にデータをセット
        request.setAttribute("name", name);
        request.setAttribute("hobbyGenre", hobbyGenre);
        request.setAttribute("requestText", requestText);
        request.setAttribute("message", message);

        // レスポンスの設定（任意）
        response.setContentType("text/html; charset=UTF-8");

        // 送信後の画面にリダイレクト
        request.getRequestDispatcher("/WEB-INF/view/password.jsp").forward(request, response);
    }
}
