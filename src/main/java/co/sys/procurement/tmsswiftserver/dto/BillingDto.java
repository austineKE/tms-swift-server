package co.sys.procurement.tmsswiftserver.dto;

public class BillingDto {
    private String paymentType;
    private String dataOfPayment;
    private String amount;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDataOfPayment() {
        return dataOfPayment;
    }

    public void setDataOfPayment(String dataOfPayment) {
        this.dataOfPayment = dataOfPayment;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
