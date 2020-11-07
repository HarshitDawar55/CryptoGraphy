import java.util.*;

public class S_AES {
    private static final Map<List<Integer>, List<Integer>> S_Box_Substitution = new HashMap<>();
    static {
        S_Box_Substitution.put(Arrays.asList(0, 0, 0, 0), Arrays.asList(1, 0, 0, 1));
        S_Box_Substitution.put(Arrays.asList(0, 0, 0, 1), Arrays.asList(0, 1, 0, 0));
        S_Box_Substitution.put(Arrays.asList(0, 0, 1, 0), Arrays.asList(1, 0, 1, 0));
        S_Box_Substitution.put(Arrays.asList(0, 0, 1, 1), Arrays.asList(1, 0, 1, 1));

        S_Box_Substitution.put(Arrays.asList(0, 1, 0, 0), Arrays.asList(1, 1, 0, 1));
        S_Box_Substitution.put(Arrays.asList(0, 1, 0, 1), Arrays.asList(0, 0, 0, 1));
        S_Box_Substitution.put(Arrays.asList(0, 1, 1, 0), Arrays.asList(1, 0, 0, 0));
        S_Box_Substitution.put(Arrays.asList(0, 1, 1, 1), Arrays.asList(0, 1, 0, 1));

        S_Box_Substitution.put(Arrays.asList(1, 0, 0, 0), Arrays.asList(0, 1, 1, 0));
        S_Box_Substitution.put(Arrays.asList(1, 0, 0, 1), Arrays.asList(0, 0, 1, 0));
        S_Box_Substitution.put(Arrays.asList(1, 0, 1, 0), Arrays.asList(0, 0, 0, 0));
        S_Box_Substitution.put(Arrays.asList(1, 0, 1, 1), Arrays.asList(0, 0, 1, 1));

        S_Box_Substitution.put(Arrays.asList(1, 1, 0, 0), Arrays.asList(1, 1, 0, 0));
        S_Box_Substitution.put(Arrays.asList(1, 1, 0, 1), Arrays.asList(1, 1, 1, 0));
        S_Box_Substitution.put(Arrays.asList(1, 1, 1, 0), Arrays.asList(1, 1, 1, 1));
        S_Box_Substitution.put(Arrays.asList(1, 1, 1, 1), Arrays.asList(0, 0, 0, 1));
    }

    public static List<Integer> ConcatenateSubKeys(List<Integer> SubKey1, List<Integer> SubKey2){
        List<Integer> MergedKey = new ArrayList<>();

        MergedKey.addAll(SubKey1);
        MergedKey.addAll(SubKey2);

        return MergedKey;
    }

    public static Map<String, List<Integer>> GenComplexKeys(List<Integer> SubKey1, List<Integer> SubKey2, List<Integer> XORList){
        Map<String, List<Integer>> ComplexKeys = new HashMap<>();
        List<Integer> FirstHalf = new ArrayList<>(), SecondHalf = new ArrayList<>(), temp = new ArrayList<>(), FinalKey1 = new ArrayList<>(), FinalKey2 = new ArrayList<>();
        List<Integer> SecondSubKeyCopy = new ArrayList<>(SubKey2);

        // Generating First XOR Part of the FirstHalf of the Complete FirstHalf Key.
        for(int i = 0; i < 8; i++){
            FirstHalf.add(SubKey1.get(i) ^ XORList.get(i));
        }

        // Rotating Nibbles of the SubKey2
        for(int i = 0; i < 4; i++){
            temp.add(SubKey2.remove(0));
        }
        SubKey2.addAll(temp);
        temp.clear();

        // Generating S-Box Substitutions for the SubKeys
        for(int i = 0; i < 4; i++){
            temp.add(SubKey2.get(i));
        }
        SecondHalf.addAll(S_Box_Substitution.get(temp));
        temp.clear();
        for(int i = 4; i < 8; i++){
            temp.add(SubKey2.get(i));
        }
        SecondHalf.addAll(S_Box_Substitution.get(temp));

        // Generating the Complete 8 bit Final Key1 (First Part of the Total 16 bit key)
        for(int i = 0; i < 8; i++){
            FinalKey1.add(FirstHalf.get(i) ^ SecondHalf.get(i));
        }

        // Generating the Complete 8 bit Final Key2 (Second Part of the Total 16 bit key)
        for(int i = 0; i < 8; i++){
            FinalKey2.add(FinalKey1.get(i) ^ SecondSubKeyCopy.get(i));
        }

        // Clearing the Temporary Lists
        FirstHalf.clear();
        SecondHalf.clear();
        temp.clear();

        // Generating the Map for the Keys
        ComplexKeys.put("FirstPart", FinalKey1);
        ComplexKeys.put("SecondPart", FinalKey2);

        System.out.println(ComplexKeys);
        return ComplexKeys;
    }
    public static void main(String[] args) {
        String tempkey, tempText;
        List<Integer> W0 = new ArrayList<>(), W1 = new ArrayList<>(), Key1, Key2, Key3, PlainText = new ArrayList<>();
        List<Integer> EncryptedText1 = new ArrayList<>(), temp = new ArrayList<>();
        Map<String, List<Integer>> Keys, TempKeys;
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
                // Generating Key1
                Key1 = ConcatenateSubKeys(W0, W1);
                System.out.println("Key1: " + Key1);

                // Generating Key 2
                Keys = GenComplexKeys(W0, W1, Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0));
                Key2 = ConcatenateSubKeys(Keys.get("FirstPart"), Keys.get("SecondPart"));
                System.out.println("Key2: " + Key2);

                // Generating Key 3
                TempKeys = GenComplexKeys(Keys.get("FirstPart"), Keys.get("SecondPart"), Arrays.asList(0, 0, 1, 1, 0, 0, 0, 0));
                Key3 = ConcatenateSubKeys(TempKeys.get("FirstPart"), TempKeys.get("SecondPart"));
                System.out.println("Key3: " + Key3);

                // ---------------------------------------- Key Generation Process Complete ----------------------------------------
                // ---------------------------------------- Starting Encryption Process Now ----------------------------------------
                // Round 1 (Add Round Key)
                for(int i = 0; i < 16; i++){
                    // Creating List for the Plain Text
                    PlainText.add(Key1.get(i) ^ tempText.charAt(i) - '0');
                }
                System.out.println("Text after Round 1 of Encryption: " + PlainText);

                // Round 2 (Main Round)
                for(int i = 0; i < 16; i = i + 4){
                    temp = PlainText.subList(i, i + 4);
                    EncryptedText1.addAll(S_Box_Substitution.get(temp));
                }

                System.out.println("Text after Round 2 S Box Substitution: " + EncryptedText1);

                // Swapping the 2nd & 4th Nibble
                List<Integer> Nibble2 = new ArrayList<>(), Nibble4 = new ArrayList<>(), Nibble3 = new ArrayList<>();
                for(int i = 0; i < 4; i++){
                    Nibble2.add(EncryptedText1.get(i + 4));
                    Nibble3.add(EncryptedText1.get(i + 8));
                    Nibble4.add(EncryptedText1.get(i + 12));
                }
                EncryptedText1.subList(4, EncryptedText1.size()).clear();
                EncryptedText1.addAll(Nibble4);
                EncryptedText1.addAll(Nibble3);
                EncryptedText1.addAll(Nibble2);
                System.out.println("Text after Nibble shuffle: " + EncryptedText1);
                Nibble2.clear();
                Nibble3.clear();
                Nibble4.clear();

                // Mix Column Operation which is the longest one in this complete round
                List<Integer> MixColumnText = new ArrayList<>();
                MixColumnText.add(EncryptedText1.get(0) ^ EncryptedText1.get(6));
                MixColumnText.add(EncryptedText1.get(1) ^ EncryptedText1.get(4) ^ EncryptedText1.get(7));
                MixColumnText.add(EncryptedText1.get(2) ^ EncryptedText1.get(4) ^ EncryptedText1.get(5));
                MixColumnText.add(EncryptedText1.get(3) ^ EncryptedText1.get(5));

                MixColumnText.add(EncryptedText1.get(2) ^ EncryptedText1.get(4));
                MixColumnText.add(EncryptedText1.get(0) ^ EncryptedText1.get(3) ^ EncryptedText1.get(5));
                MixColumnText.add(EncryptedText1.get(0) ^ EncryptedText1.get(1) ^ EncryptedText1.get(6));
                MixColumnText.add(EncryptedText1.get(1) ^ EncryptedText1.get(7));

                MixColumnText.add(EncryptedText1.get(8) ^ EncryptedText1.get(14));
                MixColumnText.add(EncryptedText1.get(9) ^ EncryptedText1.get(12) ^ EncryptedText1.get(15));
                MixColumnText.add(EncryptedText1.get(10) ^ EncryptedText1.get(12) ^ EncryptedText1.get(13));
                MixColumnText.add(EncryptedText1.get(11) ^ EncryptedText1.get(13));

                MixColumnText.add(EncryptedText1.get(10) ^ EncryptedText1.get(12));
                MixColumnText.add(EncryptedText1.get(8) ^ EncryptedText1.get(11) ^ EncryptedText1.get(13));
                MixColumnText.add(EncryptedText1.get(8) ^ EncryptedText1.get(9) ^ EncryptedText1.get(14));
                MixColumnText.add(EncryptedText1.get(9) ^ EncryptedText1.get(15));

                System.out.println("Mix Column Text: " + MixColumnText);

                
            }
        }
    }
}
