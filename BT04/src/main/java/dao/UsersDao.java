package dao;

import java.util.List;


import entity.Users;

public interface UsersDao {
    List<Users> findAll();
    void create(Users user);
    void update(Users user);
    void delete(int id);
    Users findById(int id);
	Users get(String username);
	
	
	void insert(Users user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	boolean updatePassword(String email, String newPassword);
}
