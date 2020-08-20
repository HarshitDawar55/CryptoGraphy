#include<iostream>
#include<string>
#include<algorithm> // Will Provide the reverse funciton if needed
#include<vector>    // WIll Provide the Vector (Dynamic Array)
using namespace std;

string swap_reverse(string Text){
    // Variable to have the count of spaces
    int count = 0;
    vector<int> space_positions;

    // Loop to Swap the Case
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
        // Variable to store the transoformed Text if it contains Spaces
        string answer = "";
        // Variable to store the parts of Text seperated by Spaces
        string part_of_Text = "";
        
        //  Loop to extract each word in the sentence & arrange it in the order.
        for(int i = count; i >= 0; i--){
            if(i == count){
               part_of_Text = Text.substr(space_positions[i - 1] + 1, Text.length() - 1);
               answer += part_of_Text + ' ';  
            }
            if( (i != 0) && (i != count) ){
                part_of_Text = Text.substr(space_positions[i - 1] + 1, space_positions[i] - space_positions[i - 1] - 1);
                answer += part_of_Text + ' ';   
            }
            if(i == 0)
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