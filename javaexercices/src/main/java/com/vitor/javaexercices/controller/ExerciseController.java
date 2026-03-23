package com.vitor.javaexercices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitor.javaexercices.service.Exercise1;

import org.springframework.ui.Model;

@Controller
public class ExerciseController {

    @GetMapping("/exercise1")
    public String exercise1() {
        return "exercise1";
    }

    @PostMapping("/exercise1/result")
    public String exercise1Result(@RequestParam String nome,@RequestParam String idade,@RequestParam String altura, Model model) {
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
    public String exercise2() {
        return "exercise2";
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