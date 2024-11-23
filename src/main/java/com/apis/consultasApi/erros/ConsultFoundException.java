package com.apis.consultasApi.erros;

public class ConsultFoundException extends RuntimeException{

    public ConsultFoundException(){
        super("Consulta já agendada nesta data");
    }
}
