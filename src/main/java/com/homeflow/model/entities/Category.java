package com.homeflow.model.entities;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vladimir on 06.12.16.
 */
@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

    public Category() {
    }

    public Category(String name) {
        Assert.isTrue(!name.equals(""), "Category name must not be empty!");
        this.name = name;
    }

//    public Category(String name, Set<Flow> flows) {
//        Assert.isTrue(!name.equals(""), "Category name must not be empty!");
//        Assert.notNull(flows);
//        this.name = name;
//        this.flows = flows;
//    }

    @Column(name = "name")
    private String name;

    //@OneToMany(mappedBy = "id")
    //private Set<Flow> flows = new HashSet<>(0);

//    public Set<Flow> getFlows() {
//        return flows;
//    }

//    public void setFlows(Set<Flow> flows) {
//        this.flows = flows;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Assert.hasText(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
