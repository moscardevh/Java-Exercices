package com.vitor.javaexercices.service;

public class Exercise1 {
    public static double parseAltura(String altura){
        altura = altura.replace(",",".");
        return Double.parseDouble(altura);
    }
    
    public static int parseIdade(String idade){
        return Integer.parseInt(idade);
    }
}