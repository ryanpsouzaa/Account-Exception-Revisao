package model.entities;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> AccountList = new ArrayList<>();

    public void registerAccount(Account accountElement){
        this.AccountList.add(accountElement);
    }
    public void accountListDeposit(Integer number, String holder, Double amount){
        for(Account a : this.AccountList){
            if (a.getHolder().equals(holder) && a.getNumber().equals(number)) {
                a.deposit(amount);
            }
        }
    }
    public void accountListWithdraw(Integer number, String holder, Double amount){
        for(Account a : this.AccountList){
            if (a.getHolder().equals(holder) && a.getNumber().equals(number)) {
                a.withdraw(amount);
            }
        }
    }
    public Account searchAccount(Integer number, String holder){
        for(Account a : this.AccountList){
            if (a.getHolder().equals(holder) && a.getNumber().equals(number)) {
                return a;
            }
        }
        return null;

    }
}
