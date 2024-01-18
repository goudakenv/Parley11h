package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.User;

public class UserDaoImpl implements UserDao{
	private DataSource ds;
	
	public UserDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public void insert(User user) {
		//SQLを準備
		String sql = "INSERT INTO users(login_id, login_pass) VALUES(?, ?)";
		//パスワードをハッシュ化
		//getLoginPassはDTOのゲッターメソッド
		String loginPass = user.getLoginPass();
		String hashed = 
				BCrypt.hashpw(loginPass, BCrypt.gensalt());
		System.out.println(hashed);
		try(Connection con = ds.getConnection()) {
			//SQLを実行
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,user.getLoginId());
			stmt.setString(2,hashed);
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public User findByLoginAndPass(String loginId, String loginPass) {
		//SQLを準備
		String sql = "SELECT * FROM users WHERE login_id = ?";
		try(Connection con = ds.getConnection()) {
			//SQLを実行
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,loginId);
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			//ログインチェック
			if(rs.next()) {
				if(!BCrypt.checkpw(loginPass, rs.getString("login_pass"))) {
					System.out.println("0");
					return null;
				}
				return new User(rs.getInt("id"), loginId, null);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}

}