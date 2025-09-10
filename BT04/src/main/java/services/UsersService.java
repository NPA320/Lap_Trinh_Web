package services;

import java.util.List;


import entity.Users;

public interface UsersService {
	List<Users> findAll();
	void create (Users category);
	void update(Users category);
	void delete (int id);
	Users findById(int id);
	
	
	Users login(String username, String password);
	Users get(String username);
	
	void insert(Users user);
	boolean register(String email, String password, String username, String
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	
	   // thêm hàm này cho Forget Password
    boolean updatePassword(String email, String newPassword);
}
