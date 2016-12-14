package com.homeflow.model.serv;

import com.homeflow.model.entities.Category;
import com.homeflow.model.entities.Flow;

import java.util.List;

/**
 * Created by vladimir on 14.12.16.
 */
public interface CategoryService {
    public Category create(Category category);
    public Category delete(int id) throws Exception;
    public List<Category> findAll();
    public Category update(Category category) throws Exception;
    public Category findById(int id);
    public Category findByName(String name);
}
