package test1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Test01_Assertions {

    @Test//bu bir test metodudur ve tek başına çalıştırılabilir.
    public void test() {
        //A metodu için bir test metodu
    }


    @Test
    public void testLength() {

        String str = "Hello World!";
        int gercekDeger = str.length();//12
        int beklenenDeger = 12;

        assertEquals(beklenenDeger, gercekDeger, "Yanlis karakter sayisi");
    }

    //Math addExact
    @Test
    public void testAddExact(){

        int actual=Math.addExact(9,6);
        int expected=15;
        int notExpected=25;

        assertEquals(expected,actual);
        assertEquals(15,Math.addExact(9,6));

        assertNotEquals(notExpected,actual);

    }

    /*
assertEquals metodu,
 JUnit testlerinde iki değerin birbirine eşit olup olmadığını
 kontrol etmek için kullanılır.
 Eğer bu iki değer eşitse, test başarılı olarak geçer;
 eğer eşit değilse, test başarısız olur ve bir hata mesajı döndürülür.
 */


}
