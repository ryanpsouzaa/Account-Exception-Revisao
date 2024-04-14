package model.entities;

import model.exception.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){

    }
    public Account(Integer number, String holder, Double balance, Double withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }
    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        this.balance += amount;
    }
    public void withdraw(Double amount){
        if(this.balance < amount){
            throw new DomainException("Não há saldo disponível para o saque desejado.");
        }
        if(this.withdrawLimit < amount){
            throw new DomainException("Este saque excede o limite de saque informado");
        }
        this.balance -= amount;
    }
    @Override
    public String toString(){
        return "Titular: " + this.holder + ", Saldo: " + String.format("%.2f",this.balance);
    }
}
