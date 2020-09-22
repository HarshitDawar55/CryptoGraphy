import java.util.Arrays;
import java.util.Scanner;

public class RowTranspositionCipher {

    static int []keyGenerator(String Key){
        int []numericKey = new int[Key.length()];
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int position = 1;

        // Outer Loop to check each character of key in the alphabets & Inner loop to to match the key characters & store them in order
        for(int i = 0; i < alphabets.length(); i++){
            for(int j = 0; j < Key.length(); j++) {
                if(alphabets.charAt(i) == Key.charAt(j)){
                    numericKey[j] = position;
                    position += 1;
                }
            }
        }
        //Arrays.sort(numericKey);
        return numericKey;
    }

    static void calculateMatrixDimensions(String Text, String Key){
        int numberOfRows = Text.length() / Key.length();
        int numberOfColumns = Key.length();
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Key;
        int []numKey;
        System.out.println("Enter the key");
        Key = sc.nextLine();
        numKey = keyGenerator(Key);
        System.out.println(Arrays.toString(numKey));
    }
}
