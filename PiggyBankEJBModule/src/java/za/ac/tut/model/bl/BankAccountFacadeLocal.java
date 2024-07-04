/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.BankAccount;

/**
 *
 * @author yolan
 */
@Local
public interface BankAccountFacadeLocal {

    void create(BankAccount bankAccount);

    void edit(BankAccount bankAccount);

    void remove(BankAccount bankAccount);

    BankAccount find(Object id);

    List<BankAccount> findAll();

    List<BankAccount> findRange(int[] range);

    int count();
    
}
