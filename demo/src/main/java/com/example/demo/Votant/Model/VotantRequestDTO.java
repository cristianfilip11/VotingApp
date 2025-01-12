package com.example.demo.Votant.Model;

public class VotantRequestDTO {
    private String nume;
    private String adresa;
    private Integer varsta;
    private Integer sectieId;
    private String cnp;

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    // Getters and Setters
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public Integer getSectieId() {
        return sectieId;
    }

    public void setSectieId(Integer sectieId) {
        this.sectieId = sectieId;
    }
}
