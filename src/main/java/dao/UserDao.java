package dao;

import domain.User;

public interface UserDao {
	//ユーザーの登録
	void insert(User user);
	
	//ログイン認証
	//正しいID,Passの場合、Userを返す
	//正しくなかったらnullを返す
	User findByLoginAndPass(String loginId, String loginPass);
	
	//ユーザー一覧
	//ユーザー情報の更新
	//ユーザーの削除
}