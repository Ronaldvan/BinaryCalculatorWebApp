package com.ontariotechu.sofe3980u;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCalculator_NoOperands_ReturnsEmptyCalculator() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    public void getCalculator_WithOperand1_ReturnsCalculatorWithOperand1Populated() throws Exception {
        mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postBinaryOperation_Addition_ValidOperands_ReturnsCorrectSum() throws Exception {
        mvc.perform(post("/")
                        .param("operand1", "111")
                        .param("operator", "+")
                        .param("operand2", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111")); // operand1 should retain its value
    }

    @Test
    public void postBinaryOperation_Multiplication_ValidOperands_ReturnsCorrectProduct() throws Exception {
        mvc.perform(post("/")
                        .param("operand1", "10")
                        .param("operator", "*")
                        .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "110"))
                .andExpect(model().attribute("operand1", "10"));
    }

    @Test
    public void postBinaryOperation_And_ValidOperands_ReturnsCorrectResult() throws Exception {
        mvc.perform(post("/")
                        .param("operand1", "1010")
                        .param("operator", "&")
                        .param("operand2", "1100"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1000"))
                .andExpect(model().attribute("operand1", "1010"));
    }

    @Test
    public void postBinaryOperation_Or_ValidOperands_ReturnsCorrectResult() throws Exception {
        mvc.perform(post("/")
                        .param("operand1", "1010")
                        .param("operator", "|")
                        .param("operand2", "1100"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "1010"));
    }
}
