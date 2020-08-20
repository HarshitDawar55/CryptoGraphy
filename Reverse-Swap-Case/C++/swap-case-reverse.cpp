#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
using namespace std;

string swap_reverse(string Text){
    string answer = "";
    int count = 0;
    vector<int> space_positions;

   for(int i = 0; Text[i] != '\0'; i++){
       if(Text[i] == ' '){
           Text[i] = Text[i];
           space_positions.push_back(i);
           count += 1;
       }
       else if(islower(Text[i])){
           Text[i] = toupper(Text[i]);
       }
       else
       {
           Text[i] = tolower(Text[i]);
       }
   }

    if(count >= 1){
       // cout<<"HELLO"<<count<<endl;
        string part_of_Text = "";
        for(int i = count - 1; i >= 0; i--){
            if(i != 0){
                part_of_Text = Text.substr(space_positions[i] + 1, Text.length() - 1);
                answer += part_of_Text + ' ';   
            }
            else
            {
                part_of_Text = Text.substr(0, space_positions[i]);
                answer += part_of_Text + ' ';
            }
                        
        }
        return answer;
    }
   return Text;
}

int main(){
    cout<<"Enter the String"<<endl;
    string t;
    getline(cin, t);
    cout<<swap_reverse(t)<<endl;
    return 0;
}