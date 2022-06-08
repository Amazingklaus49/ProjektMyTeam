package com.example.myteambackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
//@CrossOrigin("https://localhost:3000")
@RequestMapping("/f1team")
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

    @GetMapping("driver/{id}")
    public Driver getDriverByID(@PathVariable long id) {
        return driverRepository.findById(id).get();
    }

    @PostMapping("driver/")
    public void createDriver(@RequestBody Driver driver) {
        driverRepository.save(driver);
    }

    @PutMapping ("driver/{id}")
    public Driver updateDriverByID(@PathVariable long id, @RequestBody Driver driver) {
        Driver toUpdate = driverRepository.findById(id).get();
        toUpdate.setVorname(driver.getVorname());
        toUpdate.setNachname(driver.getNachname());
        toUpdate.setJahrgang(driver.getJahrgang());
        toUpdate.setNationalitaet(driver.getNationalitaet());
        toUpdate.setTeam(driver.getTeam());
        return toUpdate;
    }

    @DeleteMapping("driver/{id}")
    public void deleteDriverByID(@PathVariable long id) {
        driverRepository.deleteById(id);
    }

    @DeleteMapping("driver")
    public void deleteDrivers() {
        driverRepository.deleteAll();
    }

}
