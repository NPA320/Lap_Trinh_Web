package services.impl;

import java.util.List;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import entity.Category;
import services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
    private CategoryDao cateDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return cateDao.findAll();
    }

    @Override
    public void create(Category category) {
        cateDao.create(category);
    }

    @Override
    public void update(Category category) {
        cateDao.update(category);
    }

    @Override
    public void delete(int id) {
        cateDao.delete(id);
    }

    @Override
    public Category findById(int id) {
        return cateDao.findById(id);
    }
    
   
    
    @Override
    public List<Category> findByUserId(int userId) {
        return cateDao.findByUserId(userId);
    }
    
    @Override
    public List<Category> findByRole(int roleid) {
        return cateDao.findByRole(roleid);
    }
}
