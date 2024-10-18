package org.example.cuttingdown.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("c_account")
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
