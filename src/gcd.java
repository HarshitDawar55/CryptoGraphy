import java.util.Scanner;

public class gcd {
    static int cal_gcd(int a, int b){
        // Wrong approach
        /*if(a != 0){
            System.out.println("a = " + a + " b = " + b);
            cal_gcd((b % a), a);
        }
        return b;*/

        // Right Approach
        //return a == 0 ? b : (cal_gcd(b % a, a));
        if (a == 0){
            return b;
        }
        return cal_gcd(b % a, a);
    }

    public static void main(String[] args) {
        Scanner take_input = new Scanner(System.in);
        System.out.println("Enter 2 Numbers space separated");
        String []input;

        input = take_input.nextLine().split(" ");

        int []values = new int[input.length];

        for(int i = 0; i < input.length; i++){
            values[i] = Integer.parseInt(input[i]);
        }

        System.out.println(cal_gcd(values[0], values[1]));
    }
}
