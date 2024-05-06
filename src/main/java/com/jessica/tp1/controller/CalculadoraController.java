package com.jessica.tp1.controller;
import com.jessica.tp1.model.Calculadora;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping
    public String welcome() {
        return "Bem-vindo ao TP1";
    }

    @RequestMapping(value = "/adicao", method = {RequestMethod.GET, RequestMethod.POST})
    public double adicaoPost(@RequestBody Calculadora calculadora) {
        return calculadora.getNum1() + calculadora.getNum2();
    }

    @RequestMapping(value = "/subtracao", method = {RequestMethod.GET, RequestMethod.POST})
    public double subtracao(@RequestBody Calculadora calculadora) {
        return calculadora.getNum1() - calculadora.getNum2();
    }

    @RequestMapping(value = "/multiplicacao", method = {RequestMethod.GET, RequestMethod.POST})
    public double multiplicacao(@RequestBody Calculadora calculadora) {
        return calculadora.getNum1() * calculadora.getNum2();
    }

    @RequestMapping(value = "/divisao", method = {RequestMethod.GET, RequestMethod.POST})
    public double divisao(@RequestBody Calculadora calculadora) {
        if (calculadora.getNum2() == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return calculadora.getNum1() / calculadora.getNum2();
    }

    @RequestMapping(value = "/exponenciacao", method = {RequestMethod.GET, RequestMethod.POST})
    public double exponenciacao(@RequestBody Calculadora calculadora) {
        return Math.pow(calculadora.getNum1(), calculadora.getNum2());
    }

}
