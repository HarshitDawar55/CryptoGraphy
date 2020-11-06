import java.util.*;

public class SDES {

    public static List<Integer> P10(List<Integer> Key){
        List<Integer> P10Key = new ArrayList<Integer>();

        // Changing the Key to the specified numbering of P10 block that is [3, 5, 2, 7, 4, 10, 1, 9, 8, 6]
        P10Key.add(Key.get(2));
        P10Key.add(Key.get(4));
        P10Key.add(Key.get(1));
        P10Key.add(Key.get(6));
        P10Key.add(Key.get(3));
        P10Key.add(Key.get(9));
        P10Key.add(Key.get(0));
        P10Key.add(Key.get(8));
        P10Key.add(Key.get(7));
        P10Key.add(Key.get(5));

        return P10Key;
    }

    public static Map<String, List<Integer>> LeftShift(List<Integer> Key, int numberOfPositions){
        // Declaring two Array Lists for left half & right half of the original Key
        List<Integer> LeftHalf = new ArrayList<Integer>();
        List<Integer> RightHalf = new ArrayList<Integer>();

        for(int i = 0; i < Key.size() / 2; i ++){
            LeftHalf.add(Key.get(i));
            RightHalf.add(Key.get(i + Key.size() / 2));
        }

        for(int pos = 1; pos <= numberOfPositions; pos++){
            // Performing Left Shift
            int temp = LeftHalf.remove(0);
            LeftHalf.add(temp);

            temp = RightHalf.remove(0);
            RightHalf.add(temp);
        }

        // Initializing the HashMap for the lists
        Map<String, List<Integer>> ShiftedKeys = new HashMap<String, List<Integer>>();
        ShiftedKeys.put("LeftHalf", LeftHalf);
        ShiftedKeys.put("RightHalf", RightHalf);

        // Returning the Shifted Keys
        return ShiftedKeys;
    }

    public static List<Integer> P8(List<Integer> Key){
        List<Integer> P8Key = new ArrayList<Integer>();

        // Changing the Key to the specified numbering of P10 block that is [6, 3, 7, 4, 8, 5, 10, 9]
        P8Key.add(Key.get(5));
        P8Key.add(Key.get(2));
        P8Key.add(Key.get(6));
        P8Key.add(Key.get(3));
        P8Key.add(Key.get(7));
        P8Key.add(Key.get(4));
        P8Key.add(Key.get(9));
        P8Key.add(Key.get(8));

        return P8Key;
    }

    public static List<Integer> InitialPermutation(String Text){
        List<Integer> IP = new ArrayList<Integer>();

        // Using the Initial Permutation Combination for the String i.e. [2, 6, 3, 1, 4, 8, 5, 7]
        IP.add(Text.charAt(1) - '0');
        IP.add(Text.charAt(5) - '0');
        IP.add(Text.charAt(2) - '0');
        IP.add(Text.charAt(0) - '0');
        IP.add(Text.charAt(3) - '0');
        IP.add(Text.charAt(7) - '0');
        IP.add(Text.charAt(4) - '0');
        IP.add(Text.charAt(6) - '0');

        return IP;
    }

    public static Map<String, List<Integer>> ExpandedPermutation(List<Integer> RightHalf, List<Integer> LeftHalf, List<Integer> Key){
        List<Integer> ExpandedRightHalf = new ArrayList<Integer>();
        List<Integer> TransformedNumbers = new ArrayList<>();
        List<Integer> LeftPart = new ArrayList<>();
        List<Integer> RightPart = new ArrayList<>();
        List<Integer> Temp = new ArrayList<>();
        String OPS0;
        String OPS1;
        int rowS0;
        int rowS1;
        int columnS0;
        int columnS1;


        // Adding the elements in the order [4, 1, 2, 3, 2, 3, 4, 1]
        ExpandedRightHalf.add(RightHalf.get(3));
        ExpandedRightHalf.add(RightHalf.get(0));
        ExpandedRightHalf.add(RightHalf.get(1));
        ExpandedRightHalf.add(RightHalf.get(2));
        ExpandedRightHalf.add(RightHalf.get(1));
        ExpandedRightHalf.add(RightHalf.get(2));
        ExpandedRightHalf.add(RightHalf.get(3));
        ExpandedRightHalf.add(RightHalf.get(0));

        for(int i = 0; i < Key.size(); i++){
            TransformedNumbers.add(ExpandedRightHalf.get(i) ^ Key.get(i));
        }

        // Generating S Boxes
        int[][] S0 = {
                {1, 0, 3, 2},
                {3, 2, 1, 0},
                {0, 2, 1, 3},
                {3, 1, 3, 2}
        };
        int[][] S1 = {
                {0, 1, 2, 3},
                {2, 0, 1, 3},
                {3, 0, 1, 0},
                {2, 1, 0, 3}
        };

//        System.out.println("Expanded Right Half: " + ExpandedRightHalf);
//        System.out.println("Transformed Numbers: " + TransformedNumbers);
//        System.out.println(String.valueOf(TransformedNumbers.get(0)) + String.valueOf(TransformedNumbers.get(3)));
//        System.out.println(String.valueOf(TransformedNumbers.get(1)) + String.valueOf(TransformedNumbers.get(2)));
//        System.out.println(String.valueOf(TransformedNumbers.get(4)) + String.valueOf(TransformedNumbers.get(7)));
//        System.out.println(String.valueOf(TransformedNumbers.get(5)) + String.valueOf(TransformedNumbers.get(6)));

        rowS0 = Integer.parseInt(String.valueOf(TransformedNumbers.get(0)) + String.valueOf(TransformedNumbers.get(3)), 2);
        columnS0 = Integer.parseInt(String.valueOf(TransformedNumbers.get(1)) + String.valueOf(TransformedNumbers.get(2)), 2);

        rowS1 = Integer.parseInt(String.valueOf(TransformedNumbers.get(4)) + String.valueOf(TransformedNumbers.get(7)), 2);
        columnS1 = Integer.parseInt(String.valueOf(TransformedNumbers.get(5)) + String.valueOf(TransformedNumbers.get(6)), 2);

        OPS0 = Integer.toBinaryString(S0[rowS0][columnS0]);
        OPS1 = Integer.toBinaryString(S1[rowS1][columnS1]);

        if(OPS0.equals("0")){
            OPS0 = "00";
        }
        if(OPS1.equals("0")){
            OPS1 = "00";
        }

//        System.out.println("OPS0 " + OPS0);
//        System.out.println("OPS1 " + OPS1);

        Temp.add(OPS0.charAt(0) - '0');
        Temp.add(OPS0.charAt(1) - '0');
        Temp.add(OPS1.charAt(0) - '0');
        Temp.add(OPS1.charAt(1) - '0');

        for(int i = 0; i < 4; i++){
            RightPart.add(Temp.get(i) ^ (LeftHalf.get(i)));
            LeftPart.add(RightHalf.get(i));
        }

        Map<String, List<Integer>> ShiftedText = new HashMap<String, List<Integer>>();
        ShiftedText.put("LeftHalf", LeftPart);
        ShiftedText.put("RightHalf", RightPart);

        return ShiftedText;
    }

    public static void InverseInitialPermutation(List<Integer> Text){
        StringBuilder FinalEncryptedString = new StringBuilder();
        // Using the Inverse Initial permutation for the Final String. Ordering: [4, 1, 3, 5, 7, 2, 8, 6]
        FinalEncryptedString.append(Text.get(3));
        FinalEncryptedString.append(Text.get(0));
        FinalEncryptedString.append(Text.get(2));
        FinalEncryptedString.append(Text.get(4));
        FinalEncryptedString.append(Text.get(6));
        FinalEncryptedString.append(Text.get(1));
        FinalEncryptedString.append(Text.get(7));
        FinalEncryptedString.append(Text.get(5));

        System.out.println("Final Encrypted String is: " + FinalEncryptedString.toString());
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("01", 2) + " " + Integer.parseInt("11", 2));
        Scanner sc = new Scanner(System.in);
        List<Integer> Key = new ArrayList<Integer>();
        List<Integer> P10K;
        List<Integer> LeftHalf, RightHalf, StringLeftHalf, StringRightHalf, FinalLeft, FinalRight, tempList = new ArrayList<>();
        List<Integer> Key1, Key2, RH = new ArrayList<>(), LH = new ArrayList<>(), IPText;
        String PlainText, tempKey;

        System.out.println("Enter the 8 Digit Text to be Encrypted!");
        PlainText = sc.nextLine();

        // Taking Key as Input from the User!
        System.out.println("Enter the Key for Encryption!");
        tempKey = sc.nextLine();
        for(int i = 0; i < tempKey.length(); i++){
            Key.add(tempKey.charAt(i) - '0');
        }

        // Generating P10 key
        System.out.println("Entered Key: " + Key);
        P10K = P10(Key);
        System.out.println("P10 Key: " + P10K);

        // Generating Left & Half Key for First Round
        LeftHalf = LeftShift(P10K, 1).get("LeftHalf");
        RightHalf = LeftShift(P10K, 1).get("RightHalf");
        System.out.println("Left Half Initial: " + LeftHalf + " " + "Right Half Initial: " + RightHalf);

        // Assigning Transformed Key Parts to the Original Key
        P10K.clear();
//        System.out.println(P10K);
        P10K.addAll(LeftHalf);
        P10K.addAll(RightHalf);
        System.out.println("After Shifting P10 Key: " + P10K);

        // Obtaining Key1
        Key1 = P8(P10K);
        System.out.println("Key1: " + Key1.toString());

        // Generating Left & Right Part for the Key 2!
        LeftHalf = LeftShift(P10K, 2).get("LeftHalf");
        RightHalf = LeftShift(P10K, 2).get("RightHalf");
        System.out.println("LH for Key 2: " + LeftHalf + " " + "RH for Key 2: " + RightHalf);

        // Assigning Transformed Key Parts to the Original Key
        P10K.clear();
//        System.out.println(P10K);
        P10K.addAll(LeftHalf);
        P10K.addAll(RightHalf);
        System.out.println("P10 for Key 2: " + P10K);

        // Obtaining Key1
        Key2 = P8(P10K);
        System.out.println("Key2: " + Key2.toString());

        // Encryption Process Starts
        IPText = InitialPermutation(PlainText);
        System.out.println("Text after Initial Permutation:" + IPText);
        for(int i = 0; i < 4; i++){
            LH.add(IPText.get(i));
            RH.add(IPText.get(i + 4));
        }

        System.out.println("Left Half of the String: " + LH + "\n" + "Right Half of the String: " + RH);
        StringLeftHalf = ExpandedPermutation(RH, LH, Key1).get("LeftHalf");
        StringRightHalf = ExpandedPermutation(RH, LH, Key1).get("RightHalf");

//        System.out.println("SLH: " + StringLeftHalf + "\n" + "SRH: " + StringRightHalf);

        // Passing one more time for the Final Encryption!
//        System.out.println(ExpandedPermutation(StringRightHalf, StringLeftHalf, Key2));
        FinalLeft = ExpandedPermutation(StringRightHalf, StringLeftHalf, Key2).get("RightHalf");
        FinalRight = ExpandedPermutation(StringRightHalf, StringLeftHalf, Key2).get("LeftHalf");

        // Building the Final String for the Final Inverse Initial Permutation Step!
        tempList.addAll(FinalLeft);
        tempList.addAll(FinalRight);
//        System.out.println(tempList);
        // Final Function Call to get the Encrypted String!
        InverseInitialPermutation(tempList);
    }
}
