package service;

import model.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
	
	void insert(User user);
	boolean register(String email, String password, String username, String
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	
	   // thêm hàm này cho Forget Password
    boolean updatePassword(String email, String newPassword);
}
