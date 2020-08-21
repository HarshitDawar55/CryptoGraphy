def gcd(a, b):
    if a == 0:
        return b
    else:
        return gcd(b % a, a)

n1, n2 = list(map(int, input("Enter 2 Numbers\n").split()))

print(gcd(n1, n2))
