package com.silauras.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Silauras on 07.01.2021 at 15:31
 */

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) String aInput,
                                 @RequestParam(value = "b", required = false) String bInput,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model) {

        int a = 0;
        int b = 0;
        if (aInput!= null & bInput != null) {
            a = Integer.parseInt(aInput);
            b = Integer.parseInt(bInput);
        }
        if (action != null) {
            switch (action) {
                case "multiplication" -> model.addAttribute("result", a + " * " + b + " = " + (a * b));
                case "addition" -> model.addAttribute("result", a + " + " + b + " = " + (a + b));
                case "subtraction" -> model.addAttribute("result", a + " - " + b + " = " + (a - b));
                case "division" -> model.addAttribute("result", a + " / " + b + " = " + (a / b));
                default -> model.addAttribute("result", "invalid input data");
            }
        }

        return "first/calculator";
    }
}
