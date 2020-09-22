import java.util.Scanner;

public class login_system {
    public static void main(String[] args) {
        String username = "Harshit Dawar", password = "3579", loginUser, loginPass;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the username for Login");
        loginUser = sc.nextLine();

        System.out.println("Enter the Password for Login (4 Digit Pin)");
        loginPass = sc.nextLine();

        if(loginPass.equals(password) && loginUser.equals(username)){
            System.out.println("Login Successful");
        }
        else{
            System.out.println("Wrong Credentials");
        }
    }
}
