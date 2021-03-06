package com.payments.service.service.validation;

import com.payments.service.model.Account;
import com.payments.service.model.exceptions.AccountException;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class AccountValidationService implements ValidationService<Account> {
    public void validate(Account account) {
        var amount = account.getAmount();
        if (amount == null) {
            throw new AccountException("Account cannot have null amount");
        }
        if (ZERO.compareTo(amount) > 0) {
            throw new AccountException("Account amount cannot be negative");
        }
    }
}
