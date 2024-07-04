/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entity.BankAccount;
import za.ac.tut.entity.Deposits;
import za.ac.tut.model.bl.BankAccountFacadeLocal;
import za.ac.tut.model.bl.PiggyBankSBLocal;


public class ControllerServlet extends HttpServlet {
    @EJB
    PiggyBankSBLocal pbl;
    @EJB
    BankAccountFacadeLocal bafl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        String url = "index.html";

        if (op.equals("deposit")) {
            Double amt = Double.valueOf(request.getParameter("amt"));
            pbl.deposit(amt);
            updateSession(session, amt);
            request.setAttribute("amt", amt);
            url = "deposit_outcome.jsp";
        } else if (op.equals("balance")) {
            Double balance = pbl.getBalance();
            request.setAttribute("balance", balance);
            BankAccount bank = createBalance(balance);
            session.setAttribute("bank", bank);
            url = "balance_outcome.jsp";
        } else if (op.equals("logout")) {
            BankAccount bank = (BankAccount) session.getAttribute("bank");
            if (bank != null) {
                bank.setBalance(pbl.getBalance());
                List<Deposits> deposits = (List<Deposits>) session.getAttribute("deposits");
                if (deposits != null) {
                    bank.setDeposits(deposits);
                }
                bafl.create(bank);
            }
            pbl.reset();
            session.invalidate();
            //url = "logout_outcome.jsp";
        }

        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

    private void updateSession(HttpSession session, Double amt) {
        Integer numDeposits = (Integer) session.getAttribute("numDeposits");
        if (numDeposits == null) {
            numDeposits = 0;
        }
        numDeposits++;

        Deposits dep = createDeposits(amt);
        List<Deposits> deposits = (List<Deposits>) session.getAttribute("deposits");
        if (deposits == null) {
            deposits = new ArrayList<>();
        }
        deposits.add(dep);

        BankAccount bank = (BankAccount) session.getAttribute("bank");
        if (bank == null) {
            bank = new BankAccount();
            session.setAttribute("bank", bank);
        }
        bank.setDeposits(deposits);

        session.setAttribute("numDeposits", numDeposits);
        session.setAttribute("deposits", deposits);
        session.setAttribute("bank", bank);
    }

    private Deposits createDeposits(Double amt) {
        Deposits d = new Deposits();
        d.setAmount(amt);
        return d;
    }

    private BankAccount createBalance(Double balance) {
        BankAccount ba = new BankAccount();
        ba.setBalance(balance);
        return ba;
    }
}