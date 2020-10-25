
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

    public static void main(String[] args) {

    }
}
