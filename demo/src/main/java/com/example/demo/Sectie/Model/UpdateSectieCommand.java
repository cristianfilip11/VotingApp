package com.example.demo.Sectie.Model;



public class UpdateSectieCommand {
    private Integer id;
    private Sectie sectie;

    public UpdateSectieCommand(Integer id, Sectie sectie){
        this.id = id;
        this.sectie = sectie;
    }

    public Integer getId() {
        return id;
    }

    public Sectie getSectie() {
        return sectie;
    }
}
