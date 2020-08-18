#include<stdio.h>
#include<ctype.h>

void encrypt(char p[], int n){
    char *s;
    for (int i = 0; p[i] != '\0'; i++){
        if(isupper(p[i])){
            s[i] += ((*(p + i) + n - 65) % 26) + 65;
        }
        else
        {
            s[i] += ((*(p + i) + n - 97) % 26) + 97;
        }        
    }
    s += '\0';
    printf("%s\n", s);

    char *decrypted_string;

    for(int j = 0; s[j]!='\0'; j++){
        if(isupper(s[j])){
           decrypted_string[j] += ((*(s + j) - n - 65) % 26) + 65; 
        }
        else
        {
            decrypted_string[j] += ((*(s + j) - n - 97) % 26) + 97; 
        }
    }
    decrypted_string += '\0';
    printf("Decrypted String: %s\n", decrypted_string);
}


int main(){
    char *str;
    int key;
    printf("Enter the string!\n");
    gets(str);
    printf("Enter the key for Encryption!\n");
    scanf("%d", &key);

    // Printing the Encrypted String
    printf("Encrypted String is: \n");
    encrypt(str, key);
    return 0;
}