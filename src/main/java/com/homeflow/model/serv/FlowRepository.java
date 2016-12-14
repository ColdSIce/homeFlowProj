package com.homeflow.model.serv;

import com.homeflow.model.entities.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladimir on 08.12.16.
 */
public interface FlowRepository extends JpaRepository<Flow, Long> {
}
