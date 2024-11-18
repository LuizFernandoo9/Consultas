package com.apis.consultasApi.erros;

public class TypeExamsNotFoundException extends RuntimeException{

    public TypeExamsNotFoundException(){   
        super("Tipo de exame não encontrado");
    }
}
