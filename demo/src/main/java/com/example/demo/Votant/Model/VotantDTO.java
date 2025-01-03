package com.example.demo.Votant.Model;

import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;

public class VotantDTO {

    private Integer id;
    private String nume;
    private Integer varsta;
    private SectieDTO sectieDTO;

    public VotantDTO(Votant votant){
        this.id = votant.getId();
        this.nume = votant.getNume();
        this.varsta = votant.getVarsta();
        this.sectieDTO = new SectieDTO(votant.getSectie());
    }

    public SectieDTO getSectieDTO() {
        return sectieDTO;
    }

    public void setSectieDTO(SectieDTO sectieDTO) {
        this.sectieDTO = sectieDTO;
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

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }
}
