package com.example.myteambackend;

public class Driver {
    private int driverID;
    private String nachname;
    private String vorname;
    private int jahrgang;
    private String nationalitaet;
    private int teamIDFS;

    public Driver(int driverID, String nachname, String vorname, int jahrgang, String nationalitaet, int teamIDFS) {
        this.driverID = driverID;
        this.nachname = nachname;
        this.vorname = vorname;
        this.jahrgang = jahrgang;
        this.nationalitaet = nationalitaet;
        this.teamIDFS = teamIDFS;
    }

    public int getDriverID() {
        return driverID;
    }
    public void setDriverID(int driverID) {
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
    public int getTeamIDFS() {
        return teamIDFS;
    }
    public void setTeamIDFS(int teamIDFS) {
        this.teamIDFS = teamIDFS;
    }
}
