package com.example.demo.Sectie.Validators;

import com.example.demo.Exceptions.ErrorMessages;
import com.example.demo.Exceptions.SectieNotValidException;
import com.example.demo.Sectie.Model.Sectie;
import io.micrometer.common.util.StringUtils;

public class SectieValidator {
    private SectieValidator(){

    }

    public static void execute(Sectie sectie){
        if(StringUtils.isEmpty(sectie.getNume())){
            throw new SectieNotValidException(ErrorMessages.NUME_SECTIE_REQUIRED.getMessage());
        }
        if(StringUtils.isEmpty(sectie.getAdresa())){
            throw new SectieNotValidException(ErrorMessages.ADRESA_SECTIE_REQUIRED.getMessage());
        }
        if(sectie.getNumar().toString().isEmpty()){
            throw new SectieNotValidException(ErrorMessages.NUMAR_SECTIE_REQUIRED.getMessage());
        }
        if(sectie.getNumar() <= 0){
            throw new SectieNotValidException(ErrorMessages.NUMAR_SECTIE_NOT_VALID.getMessage());
        }


    }

}
