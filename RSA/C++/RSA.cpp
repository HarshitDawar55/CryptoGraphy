#include<iostream>
#include<math.h>
using namespace std;

bool primeCheck(int n){
	if(n < 2){
		return false;
	}
	for(int i = 2; i < sqrt(n) + 1; i++){
		if(n % i == 0){
			return false;
		}
	}
	return true;
}

int main(){

	cout<<primeCheck(5);
	return 0;
}