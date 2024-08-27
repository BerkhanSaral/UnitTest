package test2;

import mockito2.UserRepo;
import mockito2.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TestUserMethods {

    //1-UserServicede getUserm methodunu test edelim
    //1-id:1(,2,3) return Dear Sumeyya
    //2-repo`nun findUserNameById methodunu 1 kere cagirmali
    //3-id : 9 beklenen : RuntimeException


    @Test
    void testGetUser() {

        UserRepo repo = mock(UserRepo.class);
        when(repo.findUserNameById(1)).thenReturn("Sumeyya");
        when(repo.findUserNameById(9)).thenReturn(null);

        UserService service = new UserService(repo);

        //id:1
        assertEquals("Dear Sumeyya", service.getUser(1));
        verify(repo, times(1)).findUserNameById(1);

        //id:9
        assertThrows(RuntimeException.class, () -> service.getUser(9));
        verify(repo, times(1)).findUserNameById(9);
    }
}
