package com.fukufuku.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    InformationRepositoryInterface repositoryInterface;

    @GetMapping
    public String adminTop(Model model){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -2);
        model.addAttribute(new InformationForm());
        model.addAttribute("messages", repositoryInterface.findAll());
        model.addAttribute("limitCalender", calendar);
        return "admin";
    }

    @PostMapping
    public String register(InformationForm form, Model model) {
        InformationEntity entity = new InformationEntity(form.getValue(), new Date());
        repositoryInterface.save(entity);
        return adminTop(model);
    }

}