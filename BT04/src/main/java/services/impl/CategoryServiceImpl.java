package services.impl;

import java.util.List;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import entity.Category;
import services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
    // Nên dùng interface thay vì class để dễ thay đổi về sau
    private CategoryDao cateDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return cateDao.findAll();
    }

    @Override
    public void create(Category category) {
        cateDao.create(category);   // gọi DAO để thêm mới
    }

    @Override
    public void update(Category category) {
        cateDao.update(category);   // gọi DAO để cập nhật
    }

    @Override
    public void delete(int id) {
        cateDao.delete(id);         // gọi DAO để xóa
    }

    @Override
    public Category findById(int id) {
        return cateDao.findById(id);  // gọi DAO để tìm theo id
    }
    
    public List<Category> findByUserId(int userId) {
        return cateDao.findByUserId(userId);
    }
}
