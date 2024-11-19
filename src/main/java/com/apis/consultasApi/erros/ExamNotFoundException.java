package com.apis.consultasApi.erros;

public class ExamNotFoundException extends RuntimeException{

    public ExamNotFoundException(){
        super("Exame não encontrado");
    }
}
