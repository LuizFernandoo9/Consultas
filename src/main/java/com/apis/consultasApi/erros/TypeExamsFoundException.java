package com.apis.consultasApi.erros;

public class TypeExamsFoundException extends RuntimeException{

    public TypeExamsFoundException(){
        super("Tipo de exame já cadastrado");
    }

}
