package mockito1;

/*

Senaryo: PaymentService sınıfı, bir ödeme geçmişi tutan bir PaymentManager sınıfına bağımlıdır.
    PaymentService, ödeme geçmişini kontrol etmek için PaymentHistoryManager'ı kullanır. Bizim test
    senaryomuzda, PaymentService'in checkPaymentStatus metodunu test edeceğiz ve PaymentHistoryManager'ın
    gerçek bir örneğini kullanmak yerine mock bir nesneyle değiştireceğiz.
 */

public class PaymentService {


    private PaymentManager paymentManager;

    //constructor

    public PaymentService(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public String checkPaymentStatus(int id) {
        String str = "STATUS : ";
        String status = paymentManager.getPaymentStatus(id);

        return str + status;

    }

}
