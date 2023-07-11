package io.github.joaoleo.backendnoticiasjava.services;

public class ObjetoNaoEncontrado extends RuntimeException{
    public ObjetoNaoEncontrado(String msg){
        super(msg);
    }
}
