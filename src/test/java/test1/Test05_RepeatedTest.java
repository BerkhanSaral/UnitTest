package test1;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test05_RepeatedTest {

    //bazı test senaryolarında bir testi aynı/benzer koşullarda
    //tekrar tekrar çalıştırmak isteyebiliriz

    @RepeatedTest(5)
    void testSubstring(){

        assertEquals("Java","Java is beatiful".substring(0,4));

    }

    //repeated test çoğunlukla random değerler ile
    //yapılan test senaryolarında tercih edilir
    @RepeatedTest(5)
    void testAddExact(){
        Random rd=new Random();
        int sayi1=rd.nextInt(100);
        int sayi2=rd.nextInt(100);

        assertEquals(sayi1+sayi2,Math.addExact(sayi1,sayi2));
        System.out.println("sayi1 : "+sayi1+" --- sayı2 :"+sayi2);
    }


}