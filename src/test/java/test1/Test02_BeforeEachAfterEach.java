package test1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Test02_BeforeEachAfterEach {

        /*
    @BeforeEach
    Test senaryoları başlamadan önce ortak kaynakların
    (örneğin, veritabanı bağlantıları, nesne oluşturma)
    ayarlanması veya başlangıç değerlerinin belirlenmesi

    @AfterEach
    Test sonrasında kaynakların serbest bırakılması
    (örneğin, dosya kapatma, veritabanı bağlantısını sonlandırma)
    veya geçici verilerin temizlenmesi

     gibi işler yapılır.
     */

    String str;

    @BeforeEach
    void beforeEach() {
        str = "merhaba";
        System.out.println("before each calisti");
    }


    @AfterEach
    void afterEach() {
        str = null;
        System.out.println("after each calisti");
    }

    //upperCase methodunu test edelim
    @Test
    void testUpperCase() {

        String actual = str.toUpperCase();
        String expected = "MERHABA";
        assertEquals(expected, actual);

        System.out.println("testUppercase calisti");
    }

    @Test
    void testContains() {
        boolean actual = str.contains("z");
        boolean expected = false;

        assertEquals(expected, actual);
        //veya
        assertFalse(actual);

        System.out.println("testContains calisti");


    }
}
