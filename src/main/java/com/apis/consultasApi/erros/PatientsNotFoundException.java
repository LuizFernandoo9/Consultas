package com.apis.consultasApi.erros;

public class PatientsNotFoundException extends RuntimeException{

    public PatientsNotFoundException(){
        super("Paciente não cadastrado");
    }

}
