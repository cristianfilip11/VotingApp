    package com.example.demo.Votant.Services;

    import com.example.demo.Command;
    import com.example.demo.Sectie.Model.Sectie;
    import com.example.demo.Sectie.SectieRepository;
    import com.example.demo.Votant.Model.Votant;
    import com.example.demo.Votant.Model.VotantDTO;
    import com.example.demo.Votant.Model.VotantRequestDTO;
    import com.example.demo.Votant.Validators.VotantValidator;
    import com.example.demo.Votant.VotantRepository;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;

    import java.util.Optional;

    @Service
    public class CreateVotantService implements Command<VotantRequestDTO, VotantDTO> {

        private final VotantRepository votantRepository;
        private final SectieRepository sectieRepository;

        public CreateVotantService(VotantRepository votantRepository, SectieRepository sectieRepository) {
            this.votantRepository = votantRepository;
            this.sectieRepository = sectieRepository;
        }

        @Override
        public ResponseEntity<VotantDTO> execute(VotantRequestDTO votantRequestDTO) {
            //validate before saving

            //validareVotant(votant);
            Votant votant = new Votant();
            votant.setNume(votantRequestDTO.getNume());
            votant.setAdresa(votantRequestDTO.getAdresa());
            votant.setVarsta(votantRequestDTO.getVarsta());
            votant.setCnp(votantRequestDTO.getCnp());

            VotantValidator.execute(votant);
            Optional<Sectie> sectie = sectieRepository.findById(votantRequestDTO.getSectieId());
            if(sectie.isPresent()){
                votant.setSectie(sectie.get());
            }else{
                votant.setSectie(null);
            }
            Votant savedVotant = votantRepository.save(votant);
            return ResponseEntity.status(HttpStatus.CREATED).body(new VotantDTO(savedVotant));
        }

    }
