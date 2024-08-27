package test1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test03_BeforeAllAfterAll {

    /*
    veritabanı bağlantısını açma ve kapama vs
    büyük hazırlıklarda kullanılabilir
     */

    @BeforeAll
    static void beforeAll(){
        System.out.println("veri tabanı bağlantısı başladı.");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("veri tabanı bağlantısı kapatıldı.");
    }

    //split
    @Test
    void testSplit(){

        String[] actual="Junit bir unit test kütüphanesidir.".split(" ");
        String[] exp={"Junit","bir","unit","test","kütüphanesidir."};

        assertArrayEquals(exp,actual);
        //beklenen ve gerçek dizileri karşılaştırmada kullanılır
        System.out.println("split testi çalıştı");

    }

    //Math min
    @Test
    void testMathMin(){

        int act=Math.min(999,22);
        int exp=22;

        assertEquals(exp,act);
        //veya
        assertTrue(act==22);
        //assertFalse()


        System.out.println("min testi çalıştı");



    }



}