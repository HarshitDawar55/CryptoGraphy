#include<stdio.h>
#include<ctype.h>

char *encrypt(char p[], int n){
    char *s;
    for (int i = 0; p[i] != '\0'; i++){
        if(isupper(p[i])){
            s[i] += (((p[i] + n) - 65) % 26) + 65;
        }
        else
        {
            s[i] += (((p[i] + n) - 97) % 26) + 97;
        }        
    }
    return s;

}

int main(){
    char *str; int key;
    printf("Enter the string!\n");
    scanf("%s", str);
    printf("Enter the key for Encryption!\n");
    scanf("%d", &key);

    // Printing the Encrypted String
    printf("Encrypted String is: \n");
    printf("%s\n", encrypt(str, key));

    // Printing the Decrypted String
    //printf("Decrypted String is: \n");
    //encrypt(encrypt(str), 26 - key);
    return 0;
}