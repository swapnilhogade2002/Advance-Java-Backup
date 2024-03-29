#taking student names
student_name= input("Enter the students name: ").split(',')
print(student_name)

# total student
total_students=len(student_name)
print("Total number of students:  ",total_students)

#avergae length of student names
total_length = sum(len(name.strip()) for name in student_name)
average_length = total_length / total_students

print("Average length of students' names: ", average_length)


