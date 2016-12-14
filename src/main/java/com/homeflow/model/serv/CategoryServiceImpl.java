package com.homeflow.model.serv;

import com.homeflow.model.entities.Category;
import com.homeflow.model.entities.Flow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vladimir on 14.12.16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryRepository categoryRepository;

    @Transactional
    @Override
    public Category create(Category category) {
        Category createdCategory = category;
        return categoryRepository.save(createdCategory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Category delete(int id) throws Exception {
        Category deletedCategory = categoryRepository.findOne((long) id);
        if (deletedCategory == null)
            throw new Exception();
        categoryRepository.delete(deletedCategory);
        return deletedCategory;
    }

    @Transactional
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Category update(Category category) throws Exception {
        Category updatedCategory = categoryRepository.findOne(category.getId());
        if (updatedCategory == null)
            throw new Exception();
        updatedCategory.setName(category.getName());
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findOne((long) id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
