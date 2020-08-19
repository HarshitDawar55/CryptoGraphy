import java.util.Scanner;

class encrypt_decrypt{
    // Creating a function to encrypt the Text
    static String encrypt(String Text, int key){
        StringBuilder encrypted_Text = new StringBuilder();
        char []temp = Text.toCharArray();
        for(char character : temp){
            if(Character.isSpaceChar(character)){
                encrypted_Text.append((char) character);
            }
            else if(Character.isUpperCase(character)){
                encrypted_Text.append((char) ((((int) character + key - 65) % 26) + 65));
            }
            else {
                encrypted_Text.append((char) ((((int) character + key - 97) % 26) + 97));
            }
        }
        return encrypted_Text.toString();
    }

    // Creating a function to decrypt the Text
    static String decrypt(String Text, int key){
        StringBuilder decrypted_Text = new StringBuilder();
        char []temp = Text.toCharArray();
        for(char character : temp){
            if(Character.isSpaceChar(character)){
                decrypted_Text.append((char) character);
            }
            else if(Character.isUpperCase(character)){
                decrypted_Text.append((char) ((((int) character - key - 65) % 26) + 65));
            }
            else {
                decrypted_Text.append((char) ((((int) character - key - 97) % 26) + 97));
            }
        }
        return decrypted_Text.toString();
    }
}

public class ceaser_cipher extends encrypt_decrypt{
    public static void main(String[] args) {
        System.out.println("Enter the Text to be Encrypted!");
        String Text, encrypted_Text, decrypted_Text; int key;
        Scanner take_input = new Scanner(System.in);

        Text = take_input.nextLine();

        System.out.println("Enter the key for the Encryption!");

        key = take_input.nextInt();

        encrypted_Text = encrypt(Text, key);
        decrypted_Text = decrypt(encrypted_Text, key);

        System.out.println(encrypted_Text);
        System.out.println(decrypted_Text);

    }
}
