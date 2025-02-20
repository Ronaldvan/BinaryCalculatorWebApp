package com.ontariotechu.sofe3980u;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryController {

    @PostMapping("/")
    public String postBinaryOperation(@RequestParam(name = "operand1") String operand1,
                                      @RequestParam(name = "operator") String operator,
                                      @RequestParam(name = "operand2") String operand2,
                                      Model model) {
        String result = "";
        try {
            if (operator.equals("+")) {
                result = Integer.toBinaryString(Integer.parseInt(operand1, 2) + Integer.parseInt(operand2, 2));
            } else if (operator.equals("*")) {
                result = Integer.toBinaryString(Integer.parseInt(operand1, 2) * Integer.parseInt(operand2, 2));
            } else if (operator.equals("&")) {
                result = Integer.toBinaryString(Integer.parseInt(operand1, 2) & Integer.parseInt(operand2, 2));
            } else if (operator.equals("|")) {
                result = Integer.toBinaryString(Integer.parseInt(operand1, 2) | Integer.parseInt(operand2, 2));
            } else {
                return "calculator";
            }
        } catch (NumberFormatException e) {
            return "calculator";
        }
        model.addAttribute("operand1", operand1);
        model.addAttribute("result", result);
        return "result";
    }
}
