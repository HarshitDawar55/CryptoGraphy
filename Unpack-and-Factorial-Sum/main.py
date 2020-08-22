def fact(n):
    if n < 2:
        return n

    else:
        return n * fact(n - 1)

def unpack_and_factorial(n):
    sum = 0
    for i in n:
        sum += fact(int(i))
    print(sum)

number = input("Enter a Number \n")

unpack_and_factorial(number)