package domain;

import java.sql.Timestamp;

public class Contact {
    private int id;
    private String name;
    private String hobbyGenre;
    private String request;
    private String message;
    private Timestamp createdAt;

    // コンストラクタ
    public Contact() {
    }

    // ゲッターとセッター
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbyGenre() {
        return hobbyGenre;
    }

    public void setHobbyGenre(String hobbyGenre) {
        this.hobbyGenre = hobbyGenre;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
