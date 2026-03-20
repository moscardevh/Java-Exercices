package com.vitor.javaexercices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExerciseController {

    @GetMapping("/exercicio1")
    public String exercicio1() {
        return "exercicio1";
    }

    @GetMapping("/exercicio2")
    public String exercicio2() {
        return "exercicio2";
    }
    @GetMapping("/exercicio3")
    public String exercicio3() {    
        return "exercicio3";
    }
    @GetMapping("/exercicio4")
    public String exercicio4() {
        return "exercicio4";
    }
    @GetMapping("/exercicio5")
    public String exercicio5() {
        return "exercicio5";
    }
    @GetMapping("/exercicio6")
    public String exercicio6() {
        return "exercicio6";
    }

    @GetMapping("/exercicio7")
    public String exercicio7() {
        return "exercicio7";
    }
    @GetMapping("/exercicio8")
    public String exercicio8() {
        return "exercicio8";
    }
    @GetMapping("/exercicio9")
    public String exercicio9() {
        return "exercicio9";
    }
    @GetMapping("/exercicio10")
    public String exercicio10() {
        return "exercicio10";
    }
}