package com.example.demo.Exceptions;

public enum ErrorMessages {
    VOTANT_NOT_FOUND("Votantul nu a fost gasit"),
   // NAME_REQUIRED("Numele este obligatoriu."),
    NUME_REQUIRED("Numele este obligatoriu."),
    //ADDRESS_REQUIRED("Adresa este obligatorie"),
    ADRESA_REQUIRED("Adresa este obligatorie"),
    //AGE_LESS_18("The voter must be over 18.),
    VARSTA_LESS_18("Votantul trebuie sa fie major"),
    NUME_SECTIE_REQUIRED("Numele sectiei este obligatoriu"),
    ADRESA_SECTIE_REQUIRED("Adresa sectiei este obligatorie"),
    NUMAR_SECTIE_REQUIRED("Numarul sectiei este obligatoriu"),
    NUMAR_SECTIE_NOT_VALID("Numarul sectiei trebuie sa fie un numar pozitiv"),
    SECTIE_NOT_FOUND("Sectia nu a fost gasita.");


    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

}
