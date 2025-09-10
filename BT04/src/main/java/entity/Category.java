package entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Category(int id, String categoryname, Users user) {
		super();
		this.id = id;
		this.categoryname = categoryname;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Column(name = "categoryname", nullable = false, unique = true, columnDefinition = "NVARCHAR(200)")
	private String categoryname;


    // nhiều category thuộc 1 user
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false) // cột FK trên bảng Categories
    private Users user;

    public Category() {}

    // getters/setters ...
    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }
}
