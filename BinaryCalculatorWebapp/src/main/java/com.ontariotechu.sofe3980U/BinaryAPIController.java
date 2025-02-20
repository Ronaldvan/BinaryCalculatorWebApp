package com.ontariotechu.sofe3980u;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String add(@RequestParam(name = "operand1") String operand1,
                      @RequestParam(name = "operand2") String operand2) {
        int result = Integer.parseInt(operand1, 2) + Integer.parseInt(operand2, 2);
        return Integer.toBinaryString(result);
    }

    @GetMapping("/add_json")
    public BinaryAPIResult addJson(@RequestParam(name = "operand1") String operand1,
                                   @RequestParam(name = "operand2") String operand2) {
        int result = Integer.parseInt(operand1, 2) + Integer.parseInt(operand2, 2);
        return new BinaryAPIResult(operand1, operand2, Integer.toBinaryString(result), "add");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "operand1") String operand1,
                           @RequestParam(name = "operand2") String operand2) {
        int result = Integer.parseInt(operand1, 2) * Integer.parseInt(operand2, 2);
        return Integer.toBinaryString(result);
    }

    @GetMapping("/multiply_json")
    public BinaryAPIResult multiplyJson(@RequestParam(name = "operand1") String operand1,
                                       @RequestParam(name = "operand2") String operand2) {
        int result = Integer.parseInt(operand1, 2) * Integer.parseInt(operand2, 2);
        return new BinaryAPIResult(operand1, operand2, Integer.toBinaryString(result), "multiply");
    }

    @GetMapping("/and")
    public String and(@RequestParam(name = "operand1") String operand1,
                      @RequestParam(name = "operand2") String operand2) {
        int result = Integer.parseInt(operand1, 2) & Integer.parseInt(operand2, 2);
        return Integer.toBinaryString(result);
    }

    @GetMapping("/and_json")
    public BinaryAPIResult andJson(@RequestParam(name = "operand1") String operand1,
                                   @RequestParam(name = "operand2") String operand2) {
        int result = Integer.parseInt(operand1, 2) & Integer.parseInt(operand2, 2);
        return new BinaryAPIResult(operand1, operand2, Integer.toBinaryString(result), "and");
    }

    @GetMapping("/or")
    public String or(@RequestParam(name = "operand1") String operand1,
                     @RequestParam(name = "operand2") String operand2) {
        int result = Integer.parseInt(operand1, 2) | Integer.parseInt(operand2, 2);
        return Integer.toBinaryString(result);
    }

    @GetMapping("/or_json")
    public BinaryAPIResult orJson(@RequestParam(name = "operand1") String operand1,
                                  @RequestParam(name = "operand2") String operand2) {
        int result = Integer.parseInt(operand1, 2) | Integer.parseInt(operand2, 2);
        return new BinaryAPIResult(operand1, operand2, Integer.toBinaryString(result), "or");
    }
}
