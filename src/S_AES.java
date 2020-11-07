import java.util.*;

public class S_AES {
    public static List<Integer> ConcatenateSubKeys(List<Integer> SubKey1, List<Integer> SubKey2){
        List<Integer> MergedKey = new ArrayList<>();

        MergedKey.addAll(SubKey1);
        MergedKey.addAll(SubKey2);

        return MergedKey;
    }

    public static Map<String, List<Integer>> GenComplexKeys(List<Integer> SubKey1, List<Integer> SubKey2, List<Integer> XORList){
        Map<String, List<Integer>> ComplexKeys = new HashMap<>();
        List<Integer> FirstHalf = new ArrayList<>(), SecondHalf = new ArrayList<>(), temp = new ArrayList<>();

        // Generating First XOR Part of the FirstHalf of the Complete FirstHalf Key.
        for(int i = 0; i < 8; i++){
            FirstHalf.add(SubKey1.get(i) ^ XORList.get(i));
        }

        // Rotating Nibbles of the SubKey2
        for(int i = 0; i < 4; i++){
            temp.add(SubKey2.remove(i));
        }
        SubKey2.addAll(temp);
        temp.clear();


    }
    public static void main(String[] args) {
        String tempkey, tempText;
        List<Integer> W0 = new ArrayList<>(), W1 = new ArrayList<>(), Key1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 16 bit Text to be encrypted");
        tempText = sc.nextLine();
        if(tempText.length() != 16){
            System.exit(0);
        }
        else{
            System.out.println("Enter the 16 Bit Key used for the Encryption!");
            tempkey = sc.nextLine();
            if(tempkey.length() !=  16){
                System.exit(0);
            }
            else {
                // Round Key Generation Process Begins
                for(int i = 0; i < 8; i++){
                    W0.add(tempkey.charAt(i) - '0');
                    W1.add(tempkey.charAt(i + 8) - '0');
                }

                Key1 = ConcatenateSubKeys(W0, W1);
                System.out.println("Key1: " + Key1);
            }
        }
    }
}
