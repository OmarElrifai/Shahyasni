package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.User;
import com.shahyasni.persistence.Entities.UserBankAccount;

public class UserBankAccountDTO {
    private Integer bankAccountId;
    private String accountNo;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public UserBankAccount setUserBankAccountEntity(UserBankAccount userBankAccount, User user){
        userBankAccount.setUser(user);
        userBankAccount.setAccountNo(this.accountNo);
        return userBankAccount;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
