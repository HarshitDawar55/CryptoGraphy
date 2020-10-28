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

int gcd(int a, int b){
	if(a == 0){
		return b;
	}
	return gcd(b % a, a);
}

int cal_Euler_Totient_Function(int p, int q){
	return (p - 1) * (q - 1);
}



int main(){

	cout<<primeCheck(5);
	return 0;
}
