import java.util.Scanner;

public class HillCipher {
    static int[][] genKeyMatrix(){
        Scanner sc = new Scanner(System.in);
        String key;

        System.out.println("Enter the Key [Note: Key will be automatically typecasted into UpperCase]");
        key = sc.nextLine().toUpperCase().replace(" ", "");

        if(Math.sqrt(key.length()) - Math.floor(Math.sqrt(key.length())) != 0){
            System.out.println("Key entered does not have length which is a perfect square, exiting!!!");
            System.exit(-1);
        }

        int dimension = (int) Math.sqrt(key.length());
        int [][] keyMatrix = new int[dimension][dimension];
        int index = 0;
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                keyMatrix[i][j] = key.charAt(index) % 65;
                index += 1;
            }
        }

        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                if(j == dimension - 1){
                    System.out.println(keyMatrix[i][j]);
                }
                else{
                    System.out.print(keyMatrix[i][j] + " ");
                }
            }
        }

        return keyMatrix;
    }

    static char []SubPartEncrypt(int []TextVector, int[][]keyMatrix){
        int []subTextEncrypt = new int[TextVector.length];
        for(int i = 0; i < TextVector.length; i++){
            subTextEncrypt[i] = 0;
            for(int j = 0; j < TextVector.length; j++){
                subTextEncrypt[i] += keyMatrix[i][j] * TextVector[j];
            }
            subTextEncrypt[i] %= 26;
        }

        for(int i = 0; i < TextVector.length; i++){
            System.out.println(subTextEncrypt[i]);
        }

        char []subString = new char[TextVector.length];
        for(int i = 0; i < TextVector.length; i++){
            subString[i] = (char) (subTextEncrypt[i] + 65);
        }

        return subString;
    }

    static String EncryptComplete(String Text, int [][]keyMatrix, int vectorLength){
        StringBuilder EncryptedText = new StringBuilder();
        return EncryptedText.toString();
    }

    public static void main(String[] args) {
        int [][]keyMatrix;
        String Text, EncryptedText;


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Text");

        Text = sc.nextLine();
        keyMatrix = genKeyMatrix();

        int MessageVectorLength = keyMatrix.length;

        int []testText = {18, 0, 5};
        System.out.println(SubPartEncrypt(testText, keyMatrix));


    }
}
