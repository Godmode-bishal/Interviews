package javapractice.locksAPI.stampedlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncomeTaxClient {
    private static final int NUMBER_OF_TAX_PAYER = 1000;
    private static IncomeTaxDept incomeTaxDept = new IncomeTaxDept(10000, NUMBER_OF_TAX_PAYER);

    public static void main(String[] args) {
        registerTaxPayers();
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for(TaxPayer taxPayer : incomeTaxDept.getTaxPayerList()) {
            executorService.submit(()-> {
                try {
                    incomeTaxDept.payTax(taxPayer);
                    double revenue = incomeTaxDept.getTotalRevenue();

                    double returnAmount = incomeTaxDept.getFederalTaxReturn(taxPayer);
                    revenue = incomeTaxDept.getTotalRevenueOptimisticRead();

                    double stateReturnAmount = incomeTaxDept.getStateTaxReturnUsingConvertToWriteLock(taxPayer);
                    revenue = incomeTaxDept.getTotalRevenueOptimisticRead();

                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void registerTaxPayers() {
        for(int i = 1; i<NUMBER_OF_TAX_PAYER+1; i++) {
            TaxPayer taxPayer = new TaxPayer();
            taxPayer.setTaxAmount(2000);
            taxPayer.setTaxPayerName("Payer - " + i);
            taxPayer.setTaxpayerSsn("xx-xxx-xxxx" + i);
            incomeTaxDept.registerTaxPayer(taxPayer);
        }
    }
}
