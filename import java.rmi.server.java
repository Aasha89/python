import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class BankImpl extends UnicastRemoteObject implements Bank {
    private double balance;

    protected BankImpl() throws RemoteException {
        balance = 0.0;
    }

    public void deposit(double amount) throws RemoteException {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws RemoteException {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double showBalance() throws RemoteException {
        return balance;
    }
}