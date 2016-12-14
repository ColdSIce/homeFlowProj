package com.homeflow.model.serv;

import com.homeflow.model.entities.Category;
import com.homeflow.model.entities.Flow;

import java.util.List;

/**
 * Created by vladimir on 08.12.16.
 */
public interface FlowService {
    public Flow create(Flow flow);
    public Flow delete(int id) throws Exception;
    public List<Flow> findAll();
    public Flow update(Flow flow) throws Exception;
    public Flow findById(int id);
    public List<Flow> getByCategory(Category category);
    public List<Flow> getByCategoryId(Long id);
}
