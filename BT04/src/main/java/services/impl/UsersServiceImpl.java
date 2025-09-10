package services.impl;

import java.util.List;
import java.util.ArrayList;

import dao.UsersDao;
import dao.impl.UsersDaoImpl;
import entity.Users;
import services.UsersService;

public class UsersServiceImpl implements UsersService {
	
    private final UsersDao usersDao = new UsersDaoImpl();

    @Override
    public List<Users> findAll() {
        return usersDao.findAll();
    }

    @Override
    public void create(Users user) {
        usersDao.create(user);
    }

    @Override
    public void update(Users user) {
        usersDao.update(user);
    }

    @Override
    public void delete(int id) {
        usersDao.delete(id);
    }

    @Override
    public Users findById(int id) {
        return usersDao.findById(id);
    }

    @Override
    public Users login(String username, String password) {
        Users user = this.get(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public Users get(String username) {
        return usersDao.get(username);
    }

    @Override
    public boolean register(String username, String password, String email,
                            String fullname, String phone) {
        // kiểm tra tồn tại username/email/phone
        if (usersDao.checkExistUsername(username) || 
            usersDao.checkExistEmail(email) || 
            usersDao.checkExistPhone(phone)) {
            return false;
        }


        int defaultRole = 3;

        // id = 0 để DB tự sinh, categories = rỗng khi mới tạo
        Users newUser = new Users(
            0,
            username,
            fullname,
            password,
            email,
            phone,
            defaultRole,
            new ArrayList<>()
        );

        usersDao.insert(newUser);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return usersDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return usersDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return usersDao.checkExistPhone(phone);
    }

    @Override
    public void insert(Users user) {
        usersDao.insert(user);
    }

    @Override
    public boolean updatePassword(String email, String newPassword) {
        return usersDao.updatePassword(email, newPassword);
    }
}
