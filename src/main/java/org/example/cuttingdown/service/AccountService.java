package org.example.cuttingdown.service;

import org.example.cuttingdown.entity.Account;

public interface AccountService {
    void register(Account account);
    boolean login(Account account);
}
