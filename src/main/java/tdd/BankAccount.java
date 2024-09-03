package tdd;

import java.util.ArrayList;
import java.util.List;

/*
        ***********************************
               Banka Hesap Uygulamasi
        ***********************************
        Uygulamada yazilacak metodlar(işlevleri):
            *   Hesap Olusturma
            *   Para Cekme ( Bakiye yetersiz kontrolu, Gunluk Cekim Limiti Kontrolu, Negatif Giris kontrolu )
            *   Para Yatirma ( Negatif Giris kontrolu )
            *   Hesap Gecmisi Alabilme kontrolu
 */
public class BankAccount {

    private String accountNumber;

    private double balance;

    private double dailyWithDrawLimit;

    private double dailyWithDrawnAmount;

    private List<String> history=new ArrayList<>();

    //param const

    public BankAccount(String accountNumber, double balance, double dailyWithDrawLimit) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dailyWithDrawLimit = dailyWithDrawLimit;
    }


    //getter-setter


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDailyWithDrawLimit() {
        return dailyWithDrawLimit;
    }

    public void setDailyWithDrawLimit(double dailyWithDrawLimit) {
        this.dailyWithDrawLimit = dailyWithDrawLimit;
    }

    public double getDailyWithDrawnAmount() {
        return dailyWithDrawnAmount;
    }

    public void setDailyWithDrawnAmount(double dailyWithDrawnAmount) {
        this.dailyWithDrawnAmount = dailyWithDrawnAmount;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    //işlevsel metodları
    //para çekme
    public Boolean withdraw(double amount){

        if(amount>0 && amount<=this.balance &&
                this.dailyWithDrawnAmount+amount<=this.dailyWithDrawLimit){
            this.balance-=amount;
            this.history.add("Para çekme : "+amount);
            this.dailyWithDrawnAmount+=amount;
            return true;
        }
        return false;
    }

    //para yatırma
    public void deposit(double amount){

        if (amount>0){
            this.balance+=amount;
            this.history.add("Para yatırma : "+amount);
        }else{
            throw new RuntimeException("Miktar pozitif olmalı!");
        }
    }



}
