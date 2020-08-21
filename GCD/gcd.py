# Best function to calculate the GCD using the remainder concept!
def gcd(a, b):
    if a == 0:
        return b
    else:
        return gcd(b % a, a)

# Advanced Input Taking Statement Integrating the concepts of Integer Mapping & List Unpacking!
n1, n2 = list(map(int, input("Enter 2 Numbers\n").split()))

# Statement to Print the GCD/HCF of the 2 numbers!
print(gcd(n1, n2))
