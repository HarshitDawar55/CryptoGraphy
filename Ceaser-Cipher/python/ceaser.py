def ceaser_cipher_encrypt(text, key):
    encrypted_text = ""
    for i in text:
        if i == " ":
            encrypted_text += i
        elif i.isupper():
            encrypted_text += chr((((ord(i) + key) - 65 )% 26) + 65)
        else:
            encrypted_text += chr((((ord(i) + key) - 97 )% 26) + 97)

    return encrypted_text


def ceaser_cipher_decrypt(text, key):
    decrypted_text = ""
    for i in text:
        if i == " ":
            decrypted_text += i
        elif i.isupper():
            decrypted_text += chr((((ord(i) - key) - 65 )% 26) + 65)
        else:
            decrypted_text += chr((((ord(i) - key) - 97 )% 26) + 97)

    return decrypted_text


text = input("Enter the Text to Encrypt!\n")
key = int(input("Enter the Key for Encryption!\n"))

print("Encrypted Text: {}".format(ceaser_cipher_encrypt(text=text, key=int(key))))

print("Decrypted Text: {}".format(ceaser_cipher_decrypt(
        text=ceaser_cipher_encrypt(text=text, key=int(key)), key=int(key))
        )
    )

