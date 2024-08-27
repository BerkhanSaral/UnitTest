package test2;

import mockito1.PaymentManager;
import mockito1.PaymentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestPaymentService {

    //checkPaymentStatus metodunu test edelim
    //1-verilen idye(100) göre STATUS : SUCCESS döndürür
    //2-getPaymentStatus metodunu çağırır
    @Test
    void testCheckPaymentStatus(){

        //1-service objesi için managera ihtiyaç var:pm yerine mock obje kullanalım
        PaymentManager pm=mock(PaymentManager.class);//sahte(vekil) obje
        //sahte(dublör) pm 'a davranış şekillerini gösterelim
        when(pm.getPaymentStatus(100)).thenReturn("SUCCESS");
        //when(pm.getPaymentStatus(101)).thenReturn("FAILURE");
        //getPaymentStatus beklenen işlevi yerine getirdiğini kabul etmiş olduk


        //2-payment service objesi oluşturalım
        PaymentService paymentService=new PaymentService(pm);

        String actual=paymentService.checkPaymentStatus(100);

        assertEquals("STATUS : SUCCESS",actual);

        verify(pm,times(1)).getPaymentStatus(100);

    }
    //ayrıca diğer test classında getPaymentStatus metodunu test etmeliyiz

    @Test
    void testGetPaymentStatus(){

        PaymentManager pm=new PaymentManager();

        assertEquals("SUCCESS",pm.getPaymentStatus(100));

    }



}
