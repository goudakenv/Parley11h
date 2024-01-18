package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import domain.Contact;
import domain.Post;

public class ContactDAO {
    private DataSource ds;

    public ContactDAO(DataSource ds) {
        this.ds = ds;
    }

    // すべての連絡先情報を取得する
    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM contacts ORDER BY created_at DESC";

        try (Connection con = ds.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setHobbyGenre(resultSet.getString("HobbyGenre"));
                contact.setRequest(resultSet.getString("request"));
                contact.setMessage(resultSet.getString("message"));
                contact.setCreatedAt(resultSet.getTimestamp("created_at"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }

    // 連絡先情報を追加する
    public void addContact(Contact contact) {
        String query = "INSERT INTO contacts (name, HobbyGenre, request, message) VALUES (?, ?, ?, ?)";

        try (Connection con = ds.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getHobbyGenre());
            stmt.setString(3, contact.getRequest());
            stmt.setString(4, contact.getMessage());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // すべての投稿情報を取得する
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM posts ORDER BY created_at DESC";

        try (Connection con = ds.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setUsername(resultSet.getString("username"));
                post.setName(resultSet.getString("name"));
                post.setAge(resultSet.getString("age"));
                post.setMessage(resultSet.getString("message"));
                post.setCreatedAt(resultSet.getTimestamp("created_at"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    // 投稿情報を追加する
    public void addPost(Post post) {
        String query = "INSERT INTO posts (username, message, name, age) VALUES (?, ?, ?, ?)";

        try (Connection con = ds.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, post.getUsername());
            stmt.setString(2, post.getMessage());
            stmt.setString(3, post.getName());
            stmt.setString(4, post.getAge());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
