package org.example.cuttingdown.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.cuttingdown.entity.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    int createAccount(@Param("account") Account account);

    Account login(@Param("account") Account account);
}
