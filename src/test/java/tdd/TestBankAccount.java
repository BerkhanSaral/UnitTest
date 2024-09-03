package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
        ***********************************
               Banka Hesap Uygulamasi
        ***********************************
        Uygulamada yazilacak metodlar(işlevleri):
            *   Hesap Olusturma
            *   Para Cekme ( Bakiye yetersiz kontrolu, Gunluk Cekim Limiti Kontrolu, Negatif Giris kontrolu )
            *   Para Yatirma ( Negatif Giris kontrolu )
            *   Hesap Gecmisi Alabilme kontrolu
 */
public class TestBankAccount {

    //hesap oluşturma
    @Test
    void testCreationAccount(){

        BankAccount account=new BankAccount("12345",100.0,1000.0);

        assertNotNull(account);
        assertEquals("12345",account.getAccountNumber());
        assertEquals(100.0,account.getBalance());
        assertEquals(1000.0,account.getDailyWithDrawLimit());
    }

    //para yatırma testleri
    //pozitif senaryo: pozitif miktar
    @Test
    void testDeposit(){

        //given
        BankAccount account=new BankAccount("12345",100.0,1000.0);
        int size=account.getHistory().size();

        //when
        account.deposit(200.0);//balance + 200

        //then
        assertEquals(300.0,account.getBalance());
        assertEquals(size+1,account.getHistory().size());

    }

    //negatif senaryo: pozitif olmayan miktar girilirse
    @Test
    void testDepositNonPositiveAmount(){
        //given
        BankAccount account=new BankAccount("12345",100.0,1000.0);
        int size=account.getHistory().size();

        assertThrows(RuntimeException.class,()->account.deposit(-100));
        assertEquals(100.0,account.getBalance());
        assertEquals(size,account.getHistory().size());

    }


    //para çekme testleri
    @Test
    void testWithdraw(){

        BankAccount account=new BankAccount("12345",500.0,1000.0);
        double amount= account.getDailyWithDrawnAmount();//şuana kadar çekilen para miktarı: 0.0
        int size=account.getHistory().size();

        assertTrue(account.withdraw(200.0));
        assertEquals(300.0,account.getBalance());
        assertEquals(size+1,account.getHistory().size());
        assertEquals(amount+200.0,account.getDailyWithDrawnAmount());

    }

    //yetersiz bakiye
    @Test
    void testWithdrawUnsufficientBalance(){

        BankAccount account=new BankAccount("12345",500.0,1000.0);
        double amount= account.getDailyWithDrawnAmount();//şuana kadar çekilen para miktarı: 0.0
        int size=account.getHistory().size();

        assertFalse(account.withdraw(600.0));
        assertEquals(500.0,account.getBalance());
        assertEquals(size,account.getHistory().size());
        assertEquals(amount,account.getDailyWithDrawnAmount());

    }

    //pozitif olmayan miktar girilirse
    @Test
    void testWithdrawNonPositiveParam(){
        BankAccount account=new BankAccount("12345",500.0,1000.0);
        double amount= account.getDailyWithDrawnAmount();//şuana kadar çekilen para miktarı: 0.0
        int size=account.getHistory().size();

        assertFalse(account.withdraw(-200.0));
        assertEquals(500.0,account.getBalance());
        assertEquals(amount,account.getDailyWithDrawnAmount());
        assertEquals(size,account.getHistory().size());

    }

    //günlük limit aşılırsa
    @Test
    void testWithdrawOverDailyWithdrawLimit(){
        BankAccount account=new BankAccount("12345",1500.0,1000.0);
        double amount= account.getDailyWithDrawnAmount();//şuana kadar çekilen para miktarı: 0.0
        int size=account.getHistory().size();

        assertTrue(account.withdraw(1000.0));//500.0 amount:1000.0
        assertFalse(account.withdraw(100.0));
        assertEquals(500.0,account.getBalance());
        assertEquals(size+1,account.getHistory().size());
        assertEquals(1000.0,account.getDailyWithDrawnAmount());
    }






}

