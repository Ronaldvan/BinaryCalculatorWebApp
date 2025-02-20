package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello_NoNameParameter_ReturnsDefaultWorld() throws Exception {
        this.mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", "World"))
                .andExpect(content().string(containsString("Hello World!"))); // Check content
    }

    @Test
    public void getHello_WithNameParameter_ReturnsProvidedName() throws Exception {
        this.mvc.perform(get("/hello?name=Doe"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", "Doe"))
                .andExpect(content().string(containsString("Hello Doe!"))); // Check content
    }

    @Test
    public void getHello_WithEmptyNameParameter_ReturnsDefaultWorld() throws Exception { // Edge case: empty parameter
        this.mvc.perform(get("/hello?name="))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", "World"))  // Should still default to "World"
                .andExpect(content().string(containsString("Hello World!")));
    }

    // Example of testing for proper escaping (if applicable)
    @Test
    public void getHello_WithSpecialCharacters_EscapesInput() throws Exception {
        this.mvc.perform(get("/hello?name=<script>alert('XSS')</script>"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", "&lt;script&gt;alert('XSS')&lt;/script&gt;"))
                .andExpect(content().string(containsString("Hello &lt;script&gt;alert('XSS')&lt;/script&gt;!"))); // Expecting escaped output
    }
}
