package com.cubicfox;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.IOException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@TestPropertySource("classpath:application.properties")
@AutoConfigureMockMvc
public class TestBase {
    private static final String API_USERS = "/api/users";

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    protected ResultActions fetchUsers() throws Exception {
        return this.mockMvc.perform(get(API_USERS).accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print());
    }

    protected <T> List<T> toList(String jsonString, TypeReference<List<T>> typeReference) throws IOException {
        return objectMapper.readValue(jsonString, typeReference);
    }
}
