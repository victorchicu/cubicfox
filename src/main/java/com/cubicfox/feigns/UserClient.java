package com.cubicfox.feigns;

import com.cubicfox.configs.FeignConfig;
import com.cubicfox.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "cubifox", url = "https://jsonplaceholder.typicode.com", configuration = {FeignConfig.class})
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<UserDto> listUsers();
}
