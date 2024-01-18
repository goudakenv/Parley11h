package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoFactory {
	public static UserDao createUserDao() {
		return new UserDaoImpl(getDB());
	}
	
	public static PostDAO selectPostDAO() {
		return new PostDAO(getDB());
	}
	
	public static ContactDAO selectContactDAO() {
	    return new ContactDAO(getDB());
	}

	public static PartyDAO selectPartyDAO() {
        return new PartyDAO(getDB());
	}
	
	//DB接続メソッド
	private static DataSource getDB() {
		DataSource ds = null;
			try {
				InitialContext ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/parley_db");
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		return ds;
	}
	
	
	
	
}