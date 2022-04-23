package com.cubicfox.controllers;

import com.cubicfox.TestBase;
import com.cubicfox.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;

public class UserControllerIT extends TestBase {
    @Test
    public void should_list_users() throws Exception {
        List<UserDto> actualUsers = fetchUsers();
        Assert.notEmpty(actualUsers, "Users are empty");
    }
}
