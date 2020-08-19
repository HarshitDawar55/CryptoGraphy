import java.util.Scanner;

public class gcd {
    static int cal_gcd(int a, int b){
        if(a != 0){
            cal_gcd((b % a), a);
        }
        return b;
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
