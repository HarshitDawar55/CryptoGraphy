import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SDES {
    public static List<Integer> P10(ArrayList<Integer> Key){
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

        // Appending into Left Half & Right Half
        LeftHalf = Key.subList(0, Key.size() / 2);
        RightHalf = Key.subList(Key.size() / 2, Key.size());

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

    public static void main(String[] args) {

    }
}
