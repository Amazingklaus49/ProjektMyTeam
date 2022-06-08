package com.example.myteambackend;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long driverID;
    private String nachname;
    private String vorname;
    private int jahrgang;
    private String nationalitaet;
    @ManyToOne
    @JoinColumn(name="teamIDFS", nullable=false)
    @JsonIgnore
    private Team team;

    public long getDriverID() {
        return driverID;
    }
    public void setDriverID(long driverID) {
        this.driverID = driverID;
    }
    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public int getJahrgang() {
        return jahrgang;
    }
    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }
    public String getNationalitaet() {
        return nationalitaet;
    }
    public void setNationalitaet(String nationalitaet) {
        this.nationalitaet = nationalitaet;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
}
