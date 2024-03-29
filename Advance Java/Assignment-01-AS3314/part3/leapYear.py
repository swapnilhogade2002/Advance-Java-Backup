#leap year function
def is_leap_year(year):
    if year % 4 == 0:
        return True
    else:
        return False

#implementation of function
input_year=int(input("Enter a year: "))
if is_leap_year(input_year):
    print(f"{input_year} is a leap year")
else:
    print(f"{input_year} is not leap year")

