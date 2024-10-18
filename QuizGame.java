import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuizQuestion {
    private String prompt;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String answerKey;

    public QuizQuestion(String prompt, String choiceA, String choiceB, String choiceC, String choiceD, String answerKey) {
        this.prompt = prompt;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.answerKey = answerKey;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public boolean validateAnswer(String userAnswer) {
        return answerKey.equalsIgnoreCase(userAnswer);
    }
}

public class QuizGame {
    private static final String QUESTION_FILE_PATH = "questions.txt";
    private static final int POINTS_PER_CORRECT = 10;

    private List<QuizQuestion> quizQuestions;
    private int totalScore;

    public void loadQuizQuestions() throws FileNotFoundException {
        File file = new File(QUESTION_FILE_PATH);
        Scanner fileScanner = new Scanner(file);

        quizQuestions = new ArrayList<>();
        int lineNumber = 1;

        while (fileScanner.hasNextLine()) {
            String currentLine = fileScanner.nextLine().trim();

            if (currentLine.startsWith("Prompt:")) {
                String promptText = extractText(currentLine);
                String optionAText = extractText(fileScanner.nextLine());
                String optionBText = extractText(fileScanner.nextLine());
                String optionCText = extractText(fileScanner.nextLine());
                String optionDText = extractText(fileScanner.nextLine());
                String answerKey = extractText(fileScanner.nextLine());

                QuizQuestion quizQuestion = new QuizQuestion(promptText, optionAText, optionBText, optionCText, optionDText, answerKey);
                quizQuestions.add(quizQuestion);
            } else {
                System.out.println("Error: Invalid format on line " + lineNumber);
            }
            lineNumber++;
        }
        fileScanner.close();
    }

    private String extractText(String line) {
        int delimiterIndex = line.indexOf(":");
        if (delimiterIndex != -1) {
            return line.substring(delimiterIndex + 1).trim();
        } else {
            System.out.println("Error: Invalid text format in line: " + line);
            return "";
        }
    }

    public void beginQuiz() {
        totalScore = 0;
        System.out.println("Welcome to Tristan's Quiz Game!\n");

        for (int i = 0; i < quizQuestions.size(); i++) {
            QuizQuestion currentQuestion = quizQuestions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getPrompt());
            System.out.println("A. " + currentQuestion.getChoiceA());
            System.out.println("B. " + currentQuestion.getChoiceB());
            System.out.println("C. " + currentQuestion.getChoiceC());
            System.out.println("D. " + currentQuestion.getChoiceD());

            String userResponse = getUserResponse();

            if (currentQuestion.validateAnswer(userResponse)) {
                System.out.println("Correct!\n");
                totalScore += POINTS_PER_CORRECT;
            } else {
                System.out.println("Incorrect!\n");
            }
        }

        displaySummary();
    }

    private String getUserResponse() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter your answer: ");
        return inputScanner.nextLine().toUpperCase();
    }

    private void displaySummary() {
        System.out.println("Quiz Results:");
        System.out.println("Total Questions: " + quizQuestions.size());
        System.out.println("Correct Answers: " + (totalScore / POINTS_PER_CORRECT));
        System.out.println("Incorrect Answers: " + ((quizQuestions.size() * POINTS_PER_CORRECT - totalScore) / POINTS_PER_CORRECT));
        System.out.println("Final Score: " + totalScore + "%\n");

        System.out.println("Thanks for playing!");
    }

    public static void main(String[] args) {
        QuizGame quizGame = new QuizGame();

        try {
            quizGame.loadQuizQuestions();
            quizGame.beginQuiz();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to load quiz questions from file: " + QUESTION_FILE_PATH);
        }
    }
}
