package com.example.demo.Votant.Services;

import com.example.demo.Exceptions.VotantNotFoundException;
import com.example.demo.Query;
import com.example.demo.Votant.Model.Votant;
import com.example.demo.Votant.Model.VotantDTO;
import com.example.demo.Votant.VotantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetVotantService implements Query<Integer, VotantDTO> {

    private final VotantRepository votantRepository;

    public GetVotantService(VotantRepository votantRepository) {
        this.votantRepository = votantRepository;
    }


    @Override
    public ResponseEntity<VotantDTO> execute(Integer input) {
        Optional<Votant> votantOptional = votantRepository.findById(input);
        if(votantOptional.isPresent()){
            return ResponseEntity.ok(new VotantDTO(votantOptional.get()));
        }

        throw new VotantNotFoundException();
    }

}
