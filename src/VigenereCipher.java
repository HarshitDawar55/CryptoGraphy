import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        // Declaring Scanner for the Input
        Scanner sc = new Scanner(System.in);
        String Text, CipherText, Key;

        System.out.println("Enter the Text to be Encrypted");
        Text = sc.nextLine();

        System.out.println("Enter the Key for the Encryption");
        Key = sc.nextLine();
    }
}
