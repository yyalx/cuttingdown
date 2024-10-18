package org.example.cuttingdown.controller;

import jakarta.annotation.Resource;
import org.example.cuttingdown.common.AppResponse;
import org.example.cuttingdown.entity.Account;
import org.example.cuttingdown.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/register")
    public AppResponse register(@RequestBody Account registerDTO) {
        // TODO escape html

        accountService.register(registerDTO);
        return AppResponse.success();
    }


    @PostMapping("/login")
    public AppResponse login(@RequestBody Account registerDTO) {
        boolean success = accountService.login(registerDTO);
        if (success){
            return AppResponse.success();
        }else {
            return AppResponse.failure(403, "wrong password!");
        }
    }
}
