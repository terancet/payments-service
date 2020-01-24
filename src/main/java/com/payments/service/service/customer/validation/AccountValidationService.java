package com.payments.service.service.customer.validation;

import com.payments.service.model.Account;
import com.payments.service.model.exceptions.AccountException;

import java.math.BigDecimal;

public class AccountValidationService implements ValidationService<Account> {
    public void validate(Account account) {
        BigDecimal amount = account.getAmount();
        if (amount == null) {
            throw new AccountException("Account cannot have null amount");
        }
        if (BigDecimal.ZERO.compareTo(amount) > 0) {
            throw new AccountException("Account amount cannot be negative");
        }
    }
}