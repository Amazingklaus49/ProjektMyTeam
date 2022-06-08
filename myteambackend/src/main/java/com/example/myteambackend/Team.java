package com.example.myteambackend;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long teamID;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy="team")
    private List<Driver> drivers;

    public long getTeamID() {
        return teamID;
    }
    public void setTeamID(long teamID) {
        this.teamID = teamID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Driver> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
