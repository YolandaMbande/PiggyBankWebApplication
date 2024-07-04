package za.ac.tut.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.Deposits;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-07-04T13:52:21")
@StaticMetamodel(BankAccount.class)
public class BankAccount_ { 

    public static volatile SingularAttribute<BankAccount, Double> balance;
    public static volatile SingularAttribute<BankAccount, Long> id;
    public static volatile ListAttribute<BankAccount, Deposits> deposits;

}