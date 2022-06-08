package com.example.myteambackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
//@CrossOrigin("https://localhost:3000")
@RequestMapping("driver")
public class F1RestController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/")
    public List<Driver> getDrivers() {
        return StreamSupport.stream(
                        driverRepository
                                .findAll()
                                .spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Driver getDriverByID(@PathVariable long id) {
        return driverRepository.findById(id).get();
    }
}
