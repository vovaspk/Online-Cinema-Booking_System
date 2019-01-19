package controller.passwordController;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPass(String plainPassword, String hashPassword){
        if(BCrypt.checkpw(plainPassword,hashPassword)){
            System.out.println("The password matches");
            return true;
        }else{
            System.out.println("The password doesnt match");
            return false;
        }
    }


}
