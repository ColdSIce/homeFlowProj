package com.homeflow.controllers;

import com.homeflow.model.entities.Category;
import com.homeflow.model.entities.Flow;
import com.homeflow.model.serv.CategoryService;
import com.homeflow.model.serv.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.RequestWrapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 08.12.16.
 */
@RestController
public class FlowController {

    @Autowired
    FlowService flowService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value="/flow/{id}", method= RequestMethod.GET)
    @ResponseBody
    public Flow getFlow(@PathVariable Integer id) {
        return flowService.findById(id);
    }

    @RequestMapping(value="/flows", method= RequestMethod.GET)
    @ResponseBody
    public List<Flow> getFlows() {
        return flowService.findAll();
    }

    @RequestMapping(value="/flows/bycategory/{categoryid}", method= RequestMethod.GET)
    @ResponseBody
    public List<Flow> getFlowsByCategory(@PathVariable Integer categoryid) {
        int id = (int)categoryid;
        List<Flow> fList = new ArrayList<>();
        fList = flowService.getByCategoryId((long) id);
        return fList;
    }

    @RequestMapping(value="/categories", method= RequestMethod.GET)
    @ResponseBody
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @RequestMapping(value="/category/{id}", method= RequestMethod.GET)
    @ResponseBody
    public Category getCategory(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    @RequestMapping(value = "/flow/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Flow> updateFlow(@PathVariable("id") int id, @RequestBody Flow flow) {

        Flow currentFlow = flowService.findById(id);

        if (currentFlow==null) {
            return new ResponseEntity<Flow>(HttpStatus.NOT_FOUND);
        }

        currentFlow.setName(flow.getName());
        currentFlow.setCategory(flow.getCategory());
        currentFlow.setType(flow.getType());
        currentFlow.setSumma(flow.getSumma());
        currentFlow.setComment(flow.getComment());
        currentFlow.setMoment(flow.getMoment());
        currentFlow.setQty(flow.getQty());

        try {
            flowService.update(currentFlow);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Flow>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Flow>(currentFlow, HttpStatus.OK);
    }

    @RequestMapping(value = "/flow", method = RequestMethod.POST)
    public ResponseEntity<Void> createFlow(@RequestBody Flow flow, UriComponentsBuilder ucBuilder) {

        int id = (int)((long)flow.getId());
        if (flowService.findById(id) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        flowService.create(flow);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/flow/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Flow> deleteFlow(@PathVariable("id") int id) {

        Flow flow = flowService.findById(id);
        if (flow == null) {
            return new ResponseEntity<Flow>(HttpStatus.NOT_FOUND);
        }

        try {
            flowService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Flow>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Flow>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {

        Category currentCategory = categoryService.findById(id);

        if (currentCategory==null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setName(category.getName());

        try {
            categoryService.update(currentCategory);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {

        int id = (int)((long)category.getId());
        if (categoryService.findById(id) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        categoryService.create(category);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") int id) {

        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        try {
            categoryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/flow/update", method = RequestMethod.PUT)
    public ResponseEntity<Flow> updateFlow(
            @RequestParam("flow_id") int flow_id,
            @RequestParam("name") String name,
            @RequestParam("type") int type,
            @RequestParam("summa") double summa,
            @RequestParam("comment") String comment,
            @RequestParam("moment") long moment,
            @RequestParam("qty") int qty,
            @RequestParam("category_id") int category_id
    ) {

        Flow currentFlow = flowService.findById(flow_id);

        if (currentFlow==null) {
            return new ResponseEntity<Flow>(HttpStatus.NOT_FOUND);
        }

        currentFlow.setName(name);
        Category c = categoryService.findById(category_id);
        if(c != null){
            currentFlow.setCategory(c);
        }else{
            return new ResponseEntity<Flow>(HttpStatus.NOT_FOUND);
        }

        currentFlow.setType(type);
        currentFlow.setSumma(summa);
        currentFlow.setComment(comment);
        currentFlow.setMoment(new Date(moment));
        currentFlow.setQty(qty);

        try {
            flowService.update(currentFlow);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Flow>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Flow>(currentFlow, HttpStatus.OK);
    }

    @RequestMapping(value = "/flow/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createFlow(
            @RequestParam("name") String name,
            @RequestParam("type") int type,
            @RequestParam("summa") double summa,
            @RequestParam("comment") String comment,
            @RequestParam("moment") long moment,
            @RequestParam("qty") int qty,
            @RequestParam("category_id") int category_id
    ) {

        Flow currentFlow = new Flow();

        currentFlow.setName(name);

        Category c = categoryService.findById(category_id);
        if(c != null){
            currentFlow.setCategory(c);
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        currentFlow.setType(type);
        currentFlow.setSumma(summa);
        currentFlow.setComment(comment);
        currentFlow.setMoment(new Date(moment));
        currentFlow.setQty(qty);

        try {
            flowService.create(currentFlow);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCategory(@RequestParam("name") String name) {

        if (categoryService.findByName(name) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        categoryService.create(new Category(name));

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/update", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@RequestParam("id") int id, @RequestParam("name") String name) {

        Category currentCategory = categoryService.findById(id);

        if (currentCategory==null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setName(name);

        try {
            categoryService.update(currentCategory);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }

}
