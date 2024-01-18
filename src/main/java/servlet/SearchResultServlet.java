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

@WebServlet("/searchResult")
public class SearchResultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // PartyDAOを使用して同窓会データのリストを取得
        PartyDAO partyDao = DaoFactory.selectPartyDAO();
        List<Party> partyList = partyDao.getAllParties();

        // 取得した同窓会データをリクエスト属性にセット
        request.setAttribute("partyList", partyList);
        request.setAttribute("flag", true);

        // partyList.jspにフォワード
        request.getRequestDispatcher("/WEB-INF/view/searchResult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Post送信は文字化けする。文字化け対策は必須
        request.setCharacterEncoding("UTF-8");

        // フォームからのデータを取得
        String attendeeCount = request.getParameter("attendeeCount");


        // PartyDAOを取得
        PartyDAO partyDAO = DaoFactory.selectPartyDAO();

        
        // データベースから同窓会情報を検索
        List<Party> searchResult = partyDAO.getParties(attendeeCount);
        if(searchResult == null) {
        	
        }

        // 検索結果をリクエスト属性にセット
        request.setAttribute("searchResult", searchResult);

        // JSPにフォワード
        request.getRequestDispatcher("/WEB-INF/view/searchResult.jsp").forward(request, response);
    
        
        
        doGet(request, response);
    }

  
}
