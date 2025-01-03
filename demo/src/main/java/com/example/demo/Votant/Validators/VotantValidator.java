package com.example.demo.Votant.Validators;

import com.example.demo.Exceptions.ErrorMessages;
import com.example.demo.Exceptions.VotantNotValidException;
import com.example.demo.Votant.Model.Votant;
import io.micrometer.common.util.StringUtils;

public class VotantValidator {
    private VotantValidator(){

    }

    public static void execute(Votant votant){
        if(StringUtils.isEmpty(votant.getNume())){
            throw new VotantNotValidException(ErrorMessages.NUME_REQUIRED.getMessage()); //mai multe verificari peste nume.
        }
        if(StringUtils.isEmpty(votant.getAdresa())){
            throw new VotantNotValidException(ErrorMessages.ADRESA_REQUIRED.getMessage());
        }
        if(votant.getVarsta() < 18){
            throw new VotantNotValidException(ErrorMessages.VARSTA_LESS_18.getMessage());
        }
    }
}
