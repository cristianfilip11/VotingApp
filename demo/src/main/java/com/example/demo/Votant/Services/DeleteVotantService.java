package com.example.demo.Votant.Services;

import com.example.demo.Command;
import com.example.demo.Exceptions.VotantNotFoundException;
import com.example.demo.Votant.Model.Votant;
import com.example.demo.Votant.VotantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteVotantService implements Command<Integer, Void> {

    private final VotantRepository votantRepository;

    public DeleteVotantService(VotantRepository votantRepository) {
        this.votantRepository = votantRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Votant> votantOptional = votantRepository.findById(id);
        if(votantOptional.isPresent()){
            votantRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new VotantNotFoundException();
    }
}
