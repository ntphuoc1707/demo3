package com.example.demo3.controllers;

import com.example.demo3.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.example.demo3.controllers;
 * Created by Phuoc -19127520
 * Date 24/05/2022 - 04:01 CH
 * Description: ...
 */

@Controller
@RequestMapping(path = "classes")
public class ClassController {
    @Autowired
    private ClassRepository classRepository;

    @RequestMapping(path = "classes", method = RequestMethod.GET)
    public String getAllClass(ModelMap modelMap){
        return "";
    }
}
