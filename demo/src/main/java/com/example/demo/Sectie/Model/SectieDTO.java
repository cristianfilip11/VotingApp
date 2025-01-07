package com.example.demo.Sectie.Model;

public class SectieDTO {

    private Integer id;
    private String nume;
    private String adresa;
    private Integer numar;

    public SectieDTO(Sectie sectie){
        this.nume = sectie.getNume();
        this.adresa = sectie.getAdresa();
        this.numar = sectie.getNumar();
        this.id = sectie.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public Integer getNumar() {
        return numar;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setNumar(Integer numar) {
        this.numar = numar;
    }

}
