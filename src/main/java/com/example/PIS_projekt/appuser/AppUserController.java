package com.example.PIS_projekt.appuser;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name = "backend", contextId = "AppUserController")
public interface AppUserController {

    @PostMapping("testing")
    public static String testing() {
        return "worked";
    }
}
