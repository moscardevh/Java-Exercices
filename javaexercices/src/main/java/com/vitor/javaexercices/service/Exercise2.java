package com.vitor.javaexercices.service;

public class Exercise2 {
    public static double calcular(double num1, String operator, double num2) {        
            switch(operator){
            case "somar":
                return num1 + num2;
            case "subtrair":
                return num1 - num2;
            case "multiplicar":
                return num1 * num2;
            case "dividir":
                if(num2 == 0){
                    throw new ArithmeticException("Divisão por zero não é permitida.");
                }
                else{
                return num1 / num2;
                }
            case "porcentagem":
                return (num1 / 100) * num2;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
            }
    }    
}
