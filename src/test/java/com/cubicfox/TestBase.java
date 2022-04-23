package com.cubicfox;

import com.cubicfox.dto.UserDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource("classpath:application.properties")
@AutoConfigureMockMvc
public class TestBase {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    protected List<UserDto> fetchUsers() throws Exception {
        String jsonString = this.mockMvc.perform(get("/api/users")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        return toList(jsonString, new TypeReference<List<UserDto>>() {});
    }

    private <T> List<T> toList(String jsonString, TypeReference<List<T>> typeReference) throws IOException {
        return objectMapper.readValue(jsonString, typeReference);
    }
}
