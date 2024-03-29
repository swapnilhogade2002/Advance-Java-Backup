# function for quiz game
def quiz():
    questions = [
        {
            "question": "What is the capital of France?",
            "options": ["A. London", "B. Paris", "C. Rome", "D. Berlin"],
            "answer": "B"
        },
        {
            "question": "Which planet is known as the Red Planet?",
            "options": ["A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"],
            "answer": "B"
        },
        {
            "question": "What is the largest mammal in the world?",
            "options": ["A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Hippopotamus"],
            "answer": "B"
        }
    ]

    score = 0

    # Iterate through each question
    for question in questions:
        print(question["question"])
        for option in question["options"]:
            print(option)

        user_answer = input("Enter your answer (A, B, C, or D): ").upper()

        # Check if the answer is correct
        if user_answer == question["answer"]:
            print("Correct!\n")
            score += 1
        else:
            print(f"Wrong! The correct answer is {question['answer']}.\n")

    # Print the final score
    print("Quiz ended! Your final score:", score)


# Call the quiz function to start the game
quiz()




