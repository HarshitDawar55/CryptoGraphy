def reverse_swap_case(sentence):
    l = sentence.split()
    l = l[::-1]
    temp = []
    for i in range(len(l)):
        s = ""
        for index, value in enumerate(l[i]):
            #print(index, value)
            if value.isupper():
                s += value.lower()
            else:
                s += value.upper()
        temp.append(s)

    return " ".join(temp)

text = input("Enter a String!\n")
print(reverse_swap_case(text))