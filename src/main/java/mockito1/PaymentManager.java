package mockito1;

public class PaymentManager {

    //yapilan odemenin statusunu gosteren bir method

    public String getPaymentStatus(int paymentId) {
        if (paymentId == 100) {
            return "SUCCES";
        } else if (paymentId == 101) {
            return "FAILURE";
        } else {
            return "UNKNOWN";
        }
    }

}
