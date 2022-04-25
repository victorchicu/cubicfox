package com.cubicfox.controllers;

import com.cubicfox.TestBase;
import com.cubicfox.dto.UserDto;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerIT extends TestBase {
    @Test
    public void should_list_users_then_expect_200_http_status_and_same_count_for_each_request() throws Exception {
        for (int i = 0; i < 10; i++) {
            String jsonString = fetchUsers().andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
            List<UserDto> users = toList(jsonString, new TypeReference<List<UserDto>>() {});
            Assertions.assertFalse(users.isEmpty(), "users must not be empty");
            Assertions.assertEquals(10, users.size());
            saveUsers(users);
        }
    }
}
