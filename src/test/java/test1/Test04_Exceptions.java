package test1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test04_Exceptions {

    //kodumuz exception fırlatıyorsa bunu da test etmeliyiz.
    //NullPointerException
    @Test
    void testLengthException(){
        String str="Hello World!";
        String str2=null;

        // str2.length() ---> NullPointerException

        assertThrows(NullPointerException.class,()->{
            str2.length();
        });

        assertDoesNotThrow(()->str.length());


    }


}
