package com.homeflow.model.serv;

import com.homeflow.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by vladimir on 14.12.16.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where c.name = :name")
    public Category findByName(@Param("name") String name);
}
