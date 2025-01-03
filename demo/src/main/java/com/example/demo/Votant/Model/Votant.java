package com.example.demo.Votant.Model;

import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;
import jakarta.persistence.*;

@Entity
@Table(name="votant")
public class Votant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "varsta")
    private Integer varsta;


    @ManyToOne
    @JoinColumn(name = "sectie_id", referencedColumnName = "id", nullable = false)
    private Sectie sectie;



    public Sectie getSectie() {
        return sectie;
    }

    public void setSectie(Sectie sectie) {
        this.sectie = sectie;
    }

    public Integer getId() {
        return id;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNume() {
        return nume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }
}
