package com.homeflow.model.entities;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vladimir on 06.12.16.
 */
@Entity
@Table(name = "flow")
public class Flow extends AbstractEntity{

    public Flow() {
    }

    public Flow(Category category, Date moment, int type, String name, int qty, double summa, String comment) {

        Assert.notNull(category);
        Assert.notNull(moment);
        Assert.isTrue(type == 0 || type == 1, "Wrong flow type!");
        Assert.hasText(name);
        Assert.isTrue(qty > 0, "Quantity must be > 0");
        Assert.isTrue(summa > 0, "Summa must be > 0");

        this.category = category;
        this.moment = moment;
        this.type = type;
        this.name = name;
        this.qty = qty;
        this.summa = summa;
        this.comment = comment;
    }


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "f_date", nullable = false)
    private Date moment;

    @Column(name = "f_type", nullable = false)
    private int type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    private double summa;

    private String comment;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        Assert.notNull(category);
        this.category = category;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        Assert.notNull(moment);
        this.moment = moment;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        Assert.isTrue(type == 0 || type == 1, "Wrong flow type!");
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Assert.hasText(name);
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        Assert.isTrue(qty > 0, "Quantity must be > 0");
        this.qty = qty;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        Assert.isTrue(summa > 0, "Summa must be > 0");
        this.summa = summa;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
