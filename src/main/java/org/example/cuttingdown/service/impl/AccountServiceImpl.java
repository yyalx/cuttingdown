package org.example.cuttingdown.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.cuttingdown.common.util.EncryptUtils;
import org.example.cuttingdown.entity.Account;
import org.example.cuttingdown.mapper.AccountMapper;
import org.example.cuttingdown.service.AccountService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {


    @Resource
    private AccountMapper accountMapper;

    @Override
    public void register(Account account) {
        // put a vault
        account.setPassword(EncryptUtils.encryptWithSalt(account.getPassword()));
        accountMapper.createAccount(account);
    }

    @Override
    public boolean login(Account account) {
        Account dbAccount = accountMapper.login(account);
        return EncryptUtils.verifyPassword(account.getPassword(), dbAccount.getPassword());
    }
}
