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
        Map<List<Integer>, List<Integer>> S_Box_Substitution = new HashMap<List<Integer>, List<Integer>>();
        List<Integer> FirstHalf = new ArrayList<>(), SecondHalf = new ArrayList<>(), temp = new ArrayList<>(), FinalKey1 = new ArrayList<>(), FinalKey2 = new ArrayList<>();
        List<Integer> SecondSubKeyCopy = new ArrayList<>();
        SecondSubKeyCopy.addAll(SubKey2);

        // Initializing HashMap
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
//        System.out.println("SubKey2: " + SubKey2 + "\n" + "Temp: " + temp);
//        System.out.println(S_Box_Substitution + "\n" + S_Box_Substitution.get(temp));

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
        List<Integer> W0 = new ArrayList<>(), W1 = new ArrayList<>(), Key1, Key2, Key3;
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
                

            }
        }
    }
}
