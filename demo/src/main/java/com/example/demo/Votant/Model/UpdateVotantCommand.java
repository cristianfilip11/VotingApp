package com.example.demo.Votant.Model;


public class UpdateVotantCommand {
    private Integer id;
    private Votant votant;

    public UpdateVotantCommand(Integer id, Votant votant) {
        this.id = id;
        this.votant = votant;
    }

    public Integer getId() {
        return id;
    }

    public Votant getVotant() {
        return votant;
    }
}
