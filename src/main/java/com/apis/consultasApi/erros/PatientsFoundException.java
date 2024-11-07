package com.apis.consultasApi.erros;

public class PatientsFoundException extends RuntimeException{

    public PatientsFoundException(){
        super("Paciente já cadastrado na plataforma");
    }
}
