package javapractice.locksAPI.stampedlock;

public class TaxPayer {
    private String taxPayerName;

    public String getTaxPayerName() {
        return taxPayerName;
    }

    public void setTaxPayerName(String taxPayerName) {
        this.taxPayerName = taxPayerName;
    }

    public String getTaxpayerSsn() {
        return taxpayerSsn;
    }

    public void setTaxpayerSsn(String taxpayerSsn) {
        this.taxpayerSsn = taxpayerSsn;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    private String taxpayerSsn;
    private double taxAmount;


}
