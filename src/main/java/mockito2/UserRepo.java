package mockito2;

public class UserRepo {


    //id si verilen useri bulma
    public String findUserNameById(int userId) {
        if (userId == 1) {
            return "Sumeyye";
        } else if (userId == 2) {
            return "Fahir";
        }else if (userId==3){
            return "Faruk";
        }else {
            return null;
        }
    }
}
