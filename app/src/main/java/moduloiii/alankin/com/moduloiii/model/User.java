package moduloiii.alankin.com.moduloiii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALANKIN on 16/6/16.
 */
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String picture_url;
    private List<Post> posts;

    public User() {
        this.id = 0;
        this.username = "";
        this.email = "";
        this.password = "";
        this.picture_url = "";
        this.posts = new ArrayList<Post>();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getPictureUrl() {
        return picture_url;
    }

    public void setPictureUrl(String pictureUrl) {
        this.picture_url = pictureUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return username;
    }
}
