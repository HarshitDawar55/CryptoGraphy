#include<iostream>
#include<math.h>
#include<vector>
#include<cstring>
#include<boost/multiprecision/cpp_int.hpp>
using namespace std;
using namespace boost::multiprecision;

bool primeCheck(int n){
	if(n < 2){
		return false;
	}
	for(int i = 2; i * i < n + 1; i++){
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

std::vector<int> KeyGenerator(){
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

	while (!(gcd(k, phi) == 1) && k < phi){

		k += 1;
	}

	cout<<"k: "<<k<<endl;

	while (!((k * v) % phi == 1)){
		v += 1;
	}

	cout<<"v: "<<v<<endl;

	vec.insert(vec.end(), k);
	vec.insert(vec.end(), v);
	vec.insert(vec.end(), n);
	return vec;

}

int main(){

	int plainText;
	int128_t cipherText, decryptedText;
    string p; 
    

	cout<<"Enter Plain Text to be encrypted!"<<endl;
	getline(cin, p);

	plainText = p.length();

	std::vector<int> v = KeyGenerator();

	/*for(auto i : v){
		cout<<i<<" ";
	}*/

	cipherText = int(pow(plainText, v[0])) % v[2];
	decryptedText = int128_t(pow(cipherText, v[1])) % v[2];

	cout<<"PlainText: "<<plainText<<endl<<"cipherText: "<<cipherText<<endl<<"decryptedText: "<<decryptedText<<endl;
	

	return 0;
}

