#include<iostream>
#include<string>
using namespace std;

string encrypt(string p, int n){
    string s = "";
    for (int i = 0; i < p.length(); i++){
        if(isupper(p[i])){
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
    string str;
    cin>>str;

    string s1;
    s1 = encrypt(str, 5);
    cout<<"Encrpyted Text: "<<s1<<endl;

    return 0;
}