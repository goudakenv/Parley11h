package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Post;

public class PostDAO {
    private DataSource ds;

    public PostDAO(DataSource ds) {
        this.ds = ds;
    }

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
             
              
                post.setMessage(resultSet.getString("message"));
                post.setCreatedAt(resultSet.getTimestamp("created_at"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public void addPost(Post post) {
        String query = "INSERT INTO posts (username, message) VALUES (?, ?)";

        try (Connection con = ds.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, post.getUsername());
            stmt.setString(2, post.getMessage());
      
    
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
