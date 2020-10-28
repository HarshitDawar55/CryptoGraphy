#include<iostream>
#include<math.h>
#include<vector>
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

int KeyGenerator(){
	std::vector<int> vec;
	int p, q;

	cout<<"Enter two prime numbers!"<<endl;
	cin>>p>>q;

	if(!primeCheck(p) || !primeCheck(q)){
		exit(0);
	}

	int n = p * q;
	int phi = cal_Euler_Totient_Function(p, q);

	int k = 2, v = 1;

	while (!(gcd(k, phi) == 1)){

		k += 1;
	}

	cout<<"k: "<<k<<endl;

	while (!((k * v) % phi == 1)){
		v += 1;
	}

	vec[0] = k;
	vec[1] = v;
	vec[2] = n;

	return v;

}

int main(){

	int plainText, cipherText, decryptedText;

	cout<<"Enter Plain Text to be encrypted!"<<endl;
	cin>> plainText; 
	return 0;
}

