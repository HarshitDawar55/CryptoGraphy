
public class RSA {
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

    

    public static void main(String[] args) {

    }
}
