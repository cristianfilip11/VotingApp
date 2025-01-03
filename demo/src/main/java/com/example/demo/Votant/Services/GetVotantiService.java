package com.example.demo.Votant.Services;

import com.example.demo.Query;
import com.example.demo.Votant.Model.Votant;
import com.example.demo.Votant.Model.VotantDTO;
import com.example.demo.Votant.VotantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetVotantiService implements Query<Void, List<VotantDTO>> {


    private final VotantRepository votantRepository;

    public GetVotantiService(VotantRepository votantRepository) {
        this.votantRepository = votantRepository;
    }

    @Override
    public ResponseEntity<List<VotantDTO>> execute(Void input) {
       List<Votant> votanti =  votantRepository.findAll();
       List<VotantDTO> votantiDTO = votanti.stream().map(VotantDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(votantiDTO);
    }

}
