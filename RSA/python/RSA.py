from math import sqrt

def primeCheck(n):
    if n < 2:
        return False
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

def cal_gcd(a, b):
    if a == 0:
        return b
    else:
        return cal_gcd(b % a, a)

def cal_Euler_Totient_Function(p, q):
    return (p - 1) * (q - 1)

def key_generator():
    print("Enter 2 space seperated Prime Numbers")
    p, q = list(map(int, input().split()))
    if primeCheck(p) and primeCheck(q):
        #         print(p, q)
        n = p * q
        phi = cal_Euler_Totient_Function(p, q)

        e = 2
        while not cal_gcd(e, phi) == 1 and e < phi:
            e += 1
        print("e: ", e)

        d = 1
        while not (d * e) % phi == 1:
            d += 1

        print("d: ", d)

        return e, d, n
    else:
        print("Numbers entered are not prime. Exiting!!!")


def RSA():
    e, d, n = key_generator()
    plaintext = len(input("Enter the Text to be ecnrypted! \n"))
    ciphertext = (plaintext ** e) % n
    decryptedText = (ciphertext ** d) % n

    print("PlainText: {} \nCipherText: {} \nDecryptedText: {}".format(plaintext, ciphertext, decryptedText))

RSA()