#palindrome function
def is_palindrome(number):
    num_str=str(number)

    return num_str==num_str[::-1]

#palindrome function implementation
check_number= input("Enter a number: ")
if is_palindrome(check_number):
    print(f"{check_number} number is palindrome.")
else:
    print(f"{check_number} number is not palindrome.")


