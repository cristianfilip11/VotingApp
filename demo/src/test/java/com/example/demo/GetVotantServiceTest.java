package com.example.demo;


import com.example.demo.Exceptions.VotantNotFoundException;
import com.example.demo.Votant.Model.Votant;
import com.example.demo.Votant.Model.VotantDTO;
import com.example.demo.Votant.Services.GetVotantService;
import com.example.demo.Votant.VotantRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetVotantServiceTest {

        @Mock
        private VotantRepository votantRepository;

        @InjectMocks
        private GetVotantService getVotantService;

        @BeforeEach
        public void setup(){
            //initializes the repository and the service class
            MockitoAnnotations.openMocks(this);
        }
        //given, when, then
        @Test
        public void given_votant_exists_when_get_product_service_returns_votant_dto(){
            //given
            Votant votant = new Votant();
            votant.setId(1);
            votant.setNume("Testus Testius");
            votant.setAdresa("Adresa de test");
            votant.setVarsta(30);

            //chiar daca scrie when, tot e parte din given
            when(votantRepository.findById(1)).thenReturn(Optional.of(votant));

            //when
            ResponseEntity<VotantDTO> response = getVotantService.execute(1);

            //then                                 expected         actual
           // assertEquals(ResponseEntity.ok(new VotantDTO(votant)), response);
            assertEquals(response.getBody().getId(), new VotantDTO(votant).getId());
            assertEquals(response.getBody().getVarsta(), new VotantDTO(votant).getVarsta());
            assertEquals(response.getBody().getNume(), new VotantDTO(votant).getNume()  );

            //System.out.println(response);

            //verifica daca votantRepository a fost apelat o singura data
            verify(votantRepository, times(1)).findById(1);


        }

        @Test
        public void given_votant_does_not_exist_when_get_votant_service_throw_votant_not_found_exception(){
            //given
            when(votantRepository.findById(1)).thenReturn(Optional.empty());

            //when/then
            assertThrows(VotantNotFoundException.class, () -> getVotantService.execute(1));
            verify(votantRepository, times(1)).findById(1);
        }
}
