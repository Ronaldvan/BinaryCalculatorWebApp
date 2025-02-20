package com.ontariotechu.sofe3980U;

public class BinaryAPIResult {

    private String operand1;
    private String operand2;
    private String result;
    private String operator;

    public BinaryAPIResult(String operand1, String operand2, String result, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.operator = operator;
    }

    // Getters and setters
    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
