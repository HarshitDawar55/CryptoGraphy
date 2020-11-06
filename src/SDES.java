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

    public static Map<String, List<Integer>> LeftShift(List<Integer> Key){
        // Declaring two Array Lists for left half & right half of the original Key
        List<Integer> LeftHalf = new ArrayList<Integer>();
        List<Integer> RightHalf = new ArrayList<Integer>();

        for(int i = 0; i < Key.size() / 2; i ++){
            LeftHalf.add(Key.get(i));
            RightHalf.add(Key.get(i + Key.size() / 2));
        }

        // Performing Left Shift
        int temp = LeftHalf.remove(0);
        LeftHalf.add(temp);

        temp = RightHalf.remove(0);
        RightHalf.add(temp);

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> Key = new ArrayList<Integer>();
        List<Integer> P10K;
        List<Integer> LeftHalf, RightHalf;

        // Taking Key as Input from the User!
        System.out.println("Enter the Key for Encryption!");
        while(sc.hasNextInt()){
            Key.add(sc.nextInt());
        }

        // Generating P10 key
        System.out.println(Key);
        P10K = P10(Key);
        System.out.println("P10 Key: " + P10K);

        // Generating Left & Half Key for First Round
        LeftHalf = LeftShift(P10K).get("LeftHalf");
        RightHalf = LeftShift(P10K).get("RightHalf");
        System.out.println("LH: " + LeftHalf + " " + "RH: " + RightHalf);

        // Assigning Transformed Key Parts to the Original Key
        P10K.clear();
        System.out.println(P10K);
        P10K.addAll(LeftHalf);
        P10K.addAll(RightHalf);
        System.out.println(P10K);
    }
}
