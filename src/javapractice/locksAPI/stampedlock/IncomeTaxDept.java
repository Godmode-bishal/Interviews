package javapractice.locksAPI.stampedlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class IncomeTaxDept {
    private double totalRevenue;
    private List<TaxPayer> taxPayerList;
    private final StampedLock s1 = new StampedLock();

    public IncomeTaxDept(long revenue, int numberOfTaxPayers) {
        this.totalRevenue = revenue;
        taxPayerList = new ArrayList(numberOfTaxPayers);
    }

    public void payTax(TaxPayer taxpayer) {
        double taxAmount = taxpayer.getTaxAmount();
        long stamp = s1.writeLock();
        try {
            totalRevenue += taxAmount;
        }
        finally {
            s1.unlockWrite(stamp);
        }
    }

    public double getTotalRevenue() {
        long stamp = s1.readLock();
        try {
            return this.totalRevenue;
        }
        finally {
            s1.unlockRead(stamp);
        }
    }

    public double getTotalRevenueOptimisticRead() {
        long stamp = s1.tryOptimisticRead();
        double balance = this.totalRevenue;
        if(!s1.validate(stamp)) {
            stamp = s1.readLock();
        }
        try {
            balance = this.totalRevenue;
        }
        finally {
            s1.unlockRead(stamp);
        }
        return balance;
    }

    public double getStateTaxReturnUsingConvertToWriteLock(TaxPayer taxPayer) {
        double incomeTaxReturnAmount = taxPayer.getTaxAmount();
        long stamp = s1.readLock();
        stamp = s1.tryConvertToWriteLock(stamp);
        if(stamp==0L) {
            System.out.println("Stamp is 0. Couldn't occupy lock");
            stamp = s1.writeLock();
        }
        try {
            this.totalRevenue -= incomeTaxReturnAmount;
        }
        finally {
            s1.unlockWrite(stamp);
        }
        return incomeTaxReturnAmount;

    }

    public void registerTaxPayer(TaxPayer taxPayer){
        taxPayerList.add(taxPayer);

    }

    public List<TaxPayer> getTaxPayerList() {
        return taxPayerList;
    }

    public double getFederalTaxReturn(TaxPayer taxPayer) {
        double incomeTaxReturnAmount = taxPayer.getTaxAmount();
        long stamp = s1.writeLock();
        try {
            this.totalRevenue -= incomeTaxReturnAmount;
        }
        finally {
            s1.unlock(stamp);
        }
        return incomeTaxReturnAmount;
    }
}
