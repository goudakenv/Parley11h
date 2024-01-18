package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PartyDAO;
import domain.Party;

@WebServlet("/item/party")
public class PartyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // PartyDAOを使用して同窓会データのリストを取得
        PartyDAO partyDao = DaoFactory.selectPartyDAO();
        List<Party> partyList = partyDao.getAllParties();

        // 取得した同窓会データをリクエスト属性にセット
        request.setAttribute("partyList", partyList);

        // partyList.jspにフォワード
        request.getRequestDispatcher("/WEB-INF/view/partyList.jsp").forward(request, response);
        
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Post送信は文字化けする。文字化け対策は必須
        request.setCharacterEncoding("UTF-8");

        
        
        // フォームからのデータを取得
        String attendeeCount = request.getParameter("attendeeCount");
        String attendeeName = request.getParameter("attendeeName");
        String eventLocation = request.getParameter("eventLocation");
        String organizerName = request.getParameter("organizerName");
        String comments = request.getParameter("comments");

        // Partyオブジェクトに設定
        Party party = new Party();
        party.setAttendeeCount(attendeeCount);
        party.setAttendeeName(attendeeName);
        party.setEventLocation(eventLocation);
        party.setOrganizerName(organizerName);
        party.setComments(comments);

        // PartyDAOを取得
        PartyDAO partyDAO = DaoFactory.selectPartyDAO();

        // データベースに同窓会情報を追加
        partyDAO.addParty(party);

        // doGetメソッドを呼び出して同窓会一覧を再取得
        doGet(request, response);
        
        
        
     // フォームから送信された検索キーワードを取得
        String searchAttendeeName = request.getParameter("searchAttendeeName");
        
     // 検索結果を設定（実際にはデータベースから取得することが一般的）
        String searchResult = searchAttendeeInDatabase(searchAttendeeName);
        
        // 検索結果をリクエスト属性にセット
        request.setAttribute("searchResult", searchResult);

        // JSPにフォワード
        request.getRequestDispatcher("/partyList.jsp").forward(request, response);


    }
        private String searchAttendeeInDatabase(String name) {
            // ここでデータベースなどを検索して結果を取得する処理を実装
            // このサンプルでは簡単に文字列の一致を返す
            if ("John Doe".equals(name)) {
                return "John Doe さんが見つかりました。";
            } else {
                return "該当する参加者はいません。";
            }
    }
}
