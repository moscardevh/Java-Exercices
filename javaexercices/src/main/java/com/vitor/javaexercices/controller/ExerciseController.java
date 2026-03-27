package com.vitor.javaexercices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vitor.javaexercices.service.Exercise1;
import com.vitor.javaexercices.service.Exercise2;

import org.springframework.ui.Model;

@Controller
public class ExerciseController {

    @GetMapping("/exercise1")
    public String exercise1() {
        return "exercise1";
    }

    @PostMapping("/exercise1/result")
    public String exercise1Result(@RequestParam String nome,
                                  @RequestParam String idade,
                                  @RequestParam String altura,
                                  Model model) {
            try {
                model.addAttribute("nome", nome);
                int idadeConvertida = Exercise1.parseIdade(idade);
                model.addAttribute("idade", idadeConvertida);
                double alturaConvertida = Exercise1.parseAltura(altura);
                model.addAttribute("altura", alturaConvertida);
                return "exercise1-result";
                }
            catch (NumberFormatException e) {
                model.addAttribute("erro", "Digite uma idade e altura válidas.");
                model.addAttribute("idade", idade);
                model.addAttribute("altura", altura);
                model.addAttribute("nome", nome);
                return "exercise1";
                }
    }

    @GetMapping("/exercise2")
    public String mostrarCalculadora() {
        return "exercise2";
    }
    
    @PostMapping("/exercise2/calcular")
    @ResponseBody
    public String calcular(@RequestParam String numero1, 
                           @RequestParam String operacao, 
                           @RequestParam String numero2) {
        
        // teste de recebimento dos dados
        System.out.println("Recebido para cálculo: " + numero1 + " " + operacao + " " + numero2);

        try {
            double n1 = Double.parseDouble(numero1);
            double n2 = Double.parseDouble(numero2);
            
            
            double resultado = 0;
            
            switch (operacao) {
                case "somar": resultado = n1 + n2; break;
                case "subtrair": resultado = n1 - n2; break;
                case "multiplicar": resultado = n1 * n2; break;
                case "dividir": 
                    if (n2 == 0) return "Erro: Div/0";
                    resultado = n1 / n2; 
                    break;
                case "porcentagem": resultado = (n1 * n2) / 100; break;
            }

            
            return String.valueOf(resultado);

        } catch (NumberFormatException e) {
            return "Erro: Formato";
        } catch (Exception e) {
            return "Erro";
        }
    }

    @GetMapping("/exercise3")
    public String exercise3() {    
        return "exercise3";
    }
    @GetMapping("/exercise4")
    public String exercise4() {
        return "exercise4";
    }
    @GetMapping("/exercise5")
    public String exercise5() {
        return "exercise5";
    }
    @GetMapping("/exercise6")
    public String exercise6() {
        return "exercise6";
    }

    @GetMapping("/exercise7")
    public String exercise7() {
        return "exercise7";
    }
    @GetMapping("/exercise8")
    public String exercise8() {
        return "exercise8";
    }
    @GetMapping("/exercise9")
    public String exercise9() {
        return "exercise9";
    }
    @GetMapping("/exercise10")
    public String exercise10() {
        return "exercise10";
    }
}