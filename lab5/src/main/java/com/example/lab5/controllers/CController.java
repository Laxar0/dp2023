package com.example.lab5.controllers;

import com.example.lab5.entities.EEntity;
import com.example.lab5.repositories.RRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CController {

    @Autowired
    private RRepository cRepo;

    @GetMapping("/listOfEntityes")
    public ModelAndView showEntityes() {
        ModelAndView mav = new ModelAndView("index");
        List<EEntity> list = cRepo.findAll();
        mav.addObject("entityes", list);
        return mav;
    }

    @GetMapping("/addEntityForm")
    public ModelAndView addEntityForm() {
        ModelAndView mav = new ModelAndView("add-entity-form");
        EEntity newEntity = new EEntity();
        mav.addObject("entity", newEntity);
        return mav;
    }

    @PostMapping("/saveEntity")
    public String saveEntity(@ModelAttribute EEntity entity) {
        cRepo.save(entity);
        return "redirect:/listOfCars";
    }

    @GetMapping("/updateEntityForm")
    public ModelAndView showUpdateForm(@RequestParam Integer Id) {
        ModelAndView mav = new ModelAndView("add-entity-form");
        EEntity existing = cRepo.findById(Id).get();
        mav.addObject("entity", existing);
        return mav;
    }

    @GetMapping("/deleteEntity")
    public String deleteEntity(@RequestParam Integer Id) {
        cRepo.deleteById(Id);
        return "redirect:/listOfCars";
    }
}
