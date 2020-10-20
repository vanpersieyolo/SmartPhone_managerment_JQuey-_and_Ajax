package com.codegym.controller;

import com.codegym.model.SmartPhone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("sPhone",new SmartPhone());
        return "create";
    }
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone saveSmartphone(@RequestBody SmartPhone smartPhone){
        return smartphoneService.save(smartPhone);
    }
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<SmartPhone> listSmartphone(){
        return smartphoneService.findAll();
    }
//    @GetMapping("")
//    @ResponseBody
//    public ResponseEntity<Iterable<SmartPhone>> listSmartphone(){
//        return new ResponseEntity<>(smartphoneService.findAll());
//    }
    @GetMapping("")
    public String allPhonePage(Model model){
            model.addAttribute("allphones",listSmartphone());
        return "list";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone deleteSmartphone(@PathVariable Integer id){
        return smartphoneService.remove(id);
    }
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id,Model model){
        SmartPhone smartPhone = smartphoneService.findById(id);
        model.addAttribute("sPhone",smartPhone);
        return "edit";
    }
    @PostMapping(value = "/edit/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone editSmartPhone(@RequestBody SmartPhone smartPhone, @PathVariable Integer id){
        smartPhone.setId(id);
        return smartphoneService.save(smartPhone);
    }
}
