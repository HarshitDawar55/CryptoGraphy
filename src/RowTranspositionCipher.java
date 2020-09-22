import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("IntegerDivisionInFloatingPointContext")
public class RowTranspositionCipher {

    static int []keyGenerator(String Key){
        int []numericKey = new int[Key.length()];
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int position = 1;

        // Outer Loop to check each character of key in the alphabets & Inner loop to to match the key characters & store them in order
        for(int i = 0; i < alphabets.length(); i++){
            for(int j = 0; j < Key.length(); j++) {
                if(alphabets.charAt(i) == Key.charAt(j)){
                    numericKey[j] = position;
                    position += 1;
                }
            }
        }
        //Arrays.sort(numericKey);
        return numericKey;
    }

    static String calculateDummyCharacters(String Text, int []Key, int numberOfRows, int numberOfColumns){
        int numberOfDummyCharacters = Key.length - (numberOfRows % numberOfColumns);
        StringBuilder newText = new StringBuilder(Text);
        // Calculating there is a need of dummy characters
        if ( numberOfDummyCharacters != 0){
            String []dummyCharacters = {"X", "Y", "Z"};

            Random rand = new Random();
            for(int i = 0; i < numberOfDummyCharacters; i++){
                newText.append(
                        dummyCharacters[
                                rand.nextInt(dummyCharacters.length)
                                ]
                );
            }
        }
        return newText.toString();
    }

    static  String Encryption(String Text, int[] Key, int numberOfColumns){
        int numberOfRows = (int) Math.ceil(Text.length() / Key.length);
        char [][]encryptionGrid = new char[numberOfRows][numberOfColumns];
        StringBuilder EncryptedText = new StringBuilder();
        int position = 0;

        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                encryptionGrid[i][j] = Text.charAt(position);
                position += 1;
            }
        }

        System.out.println("Grid Created for the Text Message!");

        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                if(j == numberOfColumns - 1){
                    System.out.println(encryptionGrid[i][j]);
                }
                else{
                    System.out.print(encryptionGrid[i][j]);
                }
            }
        }

        // Generating the actual order in which the columns have to be chosen for the encryption of the Text
        int []actualNumberingForEncryption = new int[Key.length];
        int index = 0;
        for(int keyword = 1; keyword < Key.length + 1; keyword++){
            for(int k = 0; k < Key.length; k++){
                if(keyword == Key[k]){
                    actualNumberingForEncryption[index] = k;
                    index += 1;
                }
            }
        }

        // Encrypting the String
        for(int column = 0; column < numberOfColumns; column++){
            for(int row = 0; row < numberOfRows; row ++){
                EncryptedText.append(
                  encryptionGrid[row][
                            actualNumberingForEncryption[column]
                          ]
                );
            }
        }

        return EncryptedText.toString();
    }

    static String Decryption(String Text, int []Key, int numberOfColumns){
        int numberOfRows = (int) Math.ceil(Text.length() / Key.length);
        char [][]decryptionGrid = new char[numberOfRows][numberOfColumns];
        StringBuilder DecryptedText = new StringBuilder();
        int position = 0;

        
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Key, Text, EncryptedText, DecryptedText;
        int []numKey;
        int numberOfRows, numberOfColumns;

        System.out.println("Enter the Text");
        Text = sc.nextLine().toUpperCase().replace(" ", "");

        System.out.println("Enter the key");
        Key = sc.nextLine().toUpperCase();

        numKey = keyGenerator(Key);
        System.out.println(Arrays.toString(numKey));

        numberOfRows = Text.length() / numKey.length;
        numberOfColumns = numKey.length;

        if(Text.length() % numKey.length != 0 ){
            Text = calculateDummyCharacters(Text, numKey, numberOfRows, numberOfColumns);
        }

        System.out.println(Text);

        EncryptedText = Encryption(Text, numKey, numberOfColumns);
        System.out.println("Encrypted String: " + EncryptedText);

    }
}
