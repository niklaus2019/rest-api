package com.example.restapi.controller;

import com.example.restapi.dto.GenderDTO;
import com.example.restapi.services.ExternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/gender")
public class GenderController {


    private ExternalService externalService;

    public GenderController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/show")
    public GenderDTO getInfoAboutGender(@RequestParam(name = "name") String name) {
        return externalService.getInfoAboutGender(name);
    }
}
