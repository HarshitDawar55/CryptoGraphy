import java.util.Scanner;


public class VigenereCipher {

    static String generateKey(String Text, String Key){
        String[] temp;
        temp = Text.split(" ");
        StringBuilder tempBuilder = new StringBuilder();

        // Constructing String back after removing the spaces
        for(String word : temp){
            tempBuilder.append(word);
        }

        Text = tempBuilder.toString();

        int strLen = Text.length(), keyLen = Key.length();
        if(strLen == keyLen){
            return Key;
        }
        int i = 0;
        StringBuilder KeyBuilder = new StringBuilder(Key);
        while (keyLen < strLen){
            KeyBuilder.append(KeyBuilder.charAt(i));
            keyLen += 1;
            i += 1;
        }
        Key = KeyBuilder.toString();
        return Key;
    }

    public static void main(String[] args) {
        // Declaring Scanner for the Input
        Scanner sc = new Scanner(System.in);
        String Text, CipherText, Key;

        System.out.println("Enter the Text to be Encrypted");
        Text = sc.nextLine();

        System.out.println("Enter the Key for the Encryption");
        Key = sc.nextLine();

        Key = generateKey(Text, Key);
        System.out.println(Key);
    }
}
