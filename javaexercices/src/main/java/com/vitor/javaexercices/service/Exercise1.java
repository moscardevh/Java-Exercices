package com.vitor.javaexercices.service;

public class Exercise1 {
    public double parseAltura(String altura){
        altura = altura.replace(",",".");
        return Double.parseDouble(altura);
    }
    
    public int parseIdade(String idade){
        return Integer.parseInt(idade);
    }

}