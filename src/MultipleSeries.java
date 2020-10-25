import java.util.Scanner;

public class MultipleSeries {
    public static boolean PrimeCheck(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return  true;
    }

    public static void Series(int st, int stopPosition){
        int count = 0, index = 0, tnindex= 0, sindex = 0;
        int[] start = new int[1000];
        int[] stop = new int[1000];
        int[] totalNumbers = new int[1000];

        for(int i = st; i <= stopPosition; i++){
            if(!PrimeCheck(i)){
                count += 1;
                if(count == 6){
                    start[index] = i - count + 1;
                    index += 1;
                }
            }
            else if(count >= 6 && PrimeCheck(i)){
                totalNumbers[tnindex] = count;
                tnindex += 1;
                count = 0;
                stop[sindex] = i - 1;
                sindex += 1;
            }
            else {
                count = 0;
            }
        }

        for(int i = 0; i < tnindex; i++){
            System.out.println(start[i] + " " + stop[i] + " " + totalNumbers[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int a, b;
        a = sn.nextInt();
        b = sn.nextInt();
        Series(a, b);
    }
}
