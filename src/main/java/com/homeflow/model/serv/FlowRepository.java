package com.homeflow.model.serv;

import com.homeflow.model.entities.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vladimir on 08.12.16.
 */
public interface FlowRepository extends JpaRepository<Flow, Long> {

    @Query("select f from Flow f where f.category.id = :category_id")
    List<Flow> getAllByCategoryId(@Param("category_id")Long category_id);

}
