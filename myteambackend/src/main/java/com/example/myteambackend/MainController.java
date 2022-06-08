package com.example.myteambackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MainController {
    @Autowired //anstatt Constructor
    private DriverRepository driverRepository;

    @GetMapping("") // http://localhost:8080
    public String home(Model model) {
        //umwandlung in normale liste
        List<Driver> drivers = StreamSupport.stream(
                        driverRepository
                                .findAll()
                                .spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("drivers", drivers);
        return "index";
    }
}
