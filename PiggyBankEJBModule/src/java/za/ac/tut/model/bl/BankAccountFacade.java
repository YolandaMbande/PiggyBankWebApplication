/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.BankAccount;

/**
 *
 * @author yolan
 */
@Stateless
public class BankAccountFacade extends AbstractFacade<BankAccount> implements BankAccountFacadeLocal {

    @PersistenceContext(unitName = "PiggyBankEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BankAccountFacade() {
        super(BankAccount.class);
    }
    
}
