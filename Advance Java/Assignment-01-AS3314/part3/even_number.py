#checking even number
def filter_even_numbers(numbers):
    return [num for num in numbers if num % 2 == 0]

# Take dynamic input for list of numbers
numbers_input = input("Enter numbers separated by commas: ")

# Convert the input string into a list of integers
numbers = [int(num) for num in numbers_input.split(',')]

# Call the function and print the result
even_numbers = filter_even_numbers(numbers)
print("Original List:", numbers)
print("Even Numbers:", even_numbers)
