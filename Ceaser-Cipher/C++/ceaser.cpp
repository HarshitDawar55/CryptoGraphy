#include<iostream>
#include<string.h>
using namespace std;

string encrypt(string p, int n){
    string s = "";
    for (int i = 0; i < p.length(); i++){
        if(p[i] == ' '){
           s += p[i]; 
        }
        else if(isupper(p[i])){
            s += (((p[i] + n) - 65) % 26) + 65;
        }
        else
        {
            s += (((p[i] + n) - 97) % 26) + 97;
        }
    }
    return s;
}

int main(){
    string str; int key;

    cout<<"Enter the Text to be Encrypted!"<<endl;
    getline(cin, str);
    cout<<"Enter the Key for the Encryption!"<<endl;
    cin>>key;
    string s1;
    //s1 = encrypt(str, key);

    cout<<"Encrpyted Text: "<<encrypt(str, key)<<endl<<"Decrypted Text: "<<encrypt(encrypt(str, key), (26 - key))<<endl;

    return 0;
}