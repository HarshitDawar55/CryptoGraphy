import java.util.Arrays;
import java.util.Scanner;

public class RowTranspositionCipher {

    static int []keyGenerator(String Key){
        int []numericKey = new int[Key.length()];
        for(int i = 0; i < Key.length(); i++){
            numericKey[i] = Key.charAt(i) % 26;
        }
        //Arrays.sort(numericKey);
        return numericKey;
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
