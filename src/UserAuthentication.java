import java.util.Scanner;

public class UserAuthentication {
    public static void main(String[] args) {
        String username, password;
        Scanner sc = new Scanner((System.in));

        System.out.println("Enter the Username!");
        username = sc.nextLine();

        System.out.println("Enter the Password!");
        password = sc.nextLine();

        System.out.println("Username Entered: " + username);
        System.out.print("Password Entered: ");
        for(int i = 0; i < password.length(); i++){
            System.out.print("*");
        }
    }
}
