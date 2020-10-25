import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class RSA {
    // Function to check whether a given number is prime or not
    public static boolean PrimeCheck(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i < Math.sqrt(n) + 1; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    // Function to calculate gcd of 2 numbers in the best way.
    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        else{
            return gcd(b % a, a);
        }
    }

    // Function to calculate Euler Totient Function.
    public static int cal_Euler_Totient_Function(int p, int q){
        return (p - 1) * (q - 1);
    }

    // Function to create Keys
    public static ArrayList Key_Generator(){
        Scanner sc = new Scanner(System.in);
        ArrayList Elements = new ArrayList();

        System.out.println("Enter the 2 Prime Numbers");
        int p = sc.nextInt();
        int q = sc.nextInt();

        if (!PrimeCheck(p) || !PrimeCheck(q)){
            exit(0);
        }

        int n = p * q;
        int phi = cal_Euler_Totient_Function(p, q);
        int e = 2, d = 1;

        while (!(gcd(e, phi) == 1) && e < phi){
            e += 1;
        }

        System.out.println("e: " + e);

        while (!((d * e) % phi == 1)){
            d += 1;
        }
        System.out.println("d: " + d);

        // Adding Elements to the ArrayList
        Elements.add(e);
        Elements.add(d);
        Elements.add(n);

        return Elements;
    }

    public static void main(String[] args) {
        ArrayList<Integer> Elements = new ArrayList<Integer>();
        Elements = Key_Generator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Text! ");

        // Calculating length of the Plain Text
        int plainText = sc.nextLine().length();
        int cipherText = (int) Math.pow(plainText, Elements.get(0)) % Elements.get(2);
        int decryptedText = (int) Math.pow(cipherText, Elements.get(1)) % Elements.get(2);

        System.out.println("PlainText Length: " + plainText + "\n" + "CipherText: " + cipherText + "\n" + "DecryptedText: " + decryptedText);
    }
}
