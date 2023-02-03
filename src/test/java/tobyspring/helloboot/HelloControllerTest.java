package tobyspring.helloboot;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class HelloControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void hello_리턴한다() throws Exception {
    mockMvc.perform(get("/hello")
        .param("name", "spring"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("spring")));
  }

}