package com.homeflow.controllers;

import com.homeflow.model.entities.Flow;
import com.homeflow.model.serv.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by vladimir on 08.12.16.
 */
@RestController
public class FlowController {

    @Autowired
    FlowService flowService;

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
}
