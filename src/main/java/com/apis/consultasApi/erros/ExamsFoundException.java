package com.apis.consultasApi.erros;

public class ExamsFoundException extends RuntimeException{

    public ExamsFoundException(){
        super("Exame já cadastrado");
    }
}
