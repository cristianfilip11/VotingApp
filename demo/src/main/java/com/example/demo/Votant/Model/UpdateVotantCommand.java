package com.example.demo.Votant.Model;


public class UpdateVotantCommand {
    private Integer id;
    private VotantRequestDTO votant;

    public UpdateVotantCommand(Integer id, VotantRequestDTO votant) {
        this.id = id;
        this.votant = votant;
    }

    public Integer getId() {
        return id;
    }

    public VotantRequestDTO getVotant() {
        return votant;
    }
}
