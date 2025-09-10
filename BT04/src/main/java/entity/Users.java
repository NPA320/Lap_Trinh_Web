package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "[Users]")
@NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, unique = true, nullable = false)
    private String username;

    @Column(length = 150)
    private String fullname;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 150, unique = true, nullable = false)
    private String email;

    @Column(length = 20, unique = true, nullable = true)
    private String phone;

    @Column(name = "roleid")
    private int roleid;

    // 1 user có nhiều category
    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    private List<Category> categories = new ArrayList<>();

    public Users() {}

    // helper methods để đồng bộ 2 chiều
    public void addCategory(Category c) {
        categories.add(c);
        c.setUser(this);
    }
    public void removeCategory(Category c) {
        categories.remove(c);
        c.setUser(null);
    }

    // constructor đầy đủ
    public Users(int id, String username, String fullname, String password,
                 String email, String phone, int roleid, List<Category> categories) {
        super();
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roleid = roleid;
        this.categories = categories;
    }

    // getters/setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getRoleid() { return roleid; }
    public void setRoleid(int roleid) { this.roleid = roleid; }

    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
}
