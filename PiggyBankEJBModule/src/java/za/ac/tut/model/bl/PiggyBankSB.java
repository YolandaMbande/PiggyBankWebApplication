/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import javax.ejb.Stateful;

/**
 *
 * @author MemaniV
 */
@Stateful
public class PiggyBankSB implements PiggyBankSBLocal {
    private Double balance = 0.0;
    
    @Override
    public void deposit(Double amt) {
        balance+=amt;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void reset() {
        balance = 0.0;
    }

}
