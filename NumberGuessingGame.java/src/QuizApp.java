import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int score;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            displayQuestion(question);

            // Timer (10 seconds)
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    scanner.nextLine(); // Consume newline left by nextInt
                    timer.cancel();
                }
            }, 10000);

            // User answer input
            System.out.print("Your answer (1-" + question.getOptions().size() + "): ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt

            // Check answer
            if (userAnswer == question.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is option " + question.getCorrectOption() + "\n");
            }
        }

        // Display final score and summary
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println("\n" + question.getQuestion());

        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        // Sample quiz questions
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("What is the capital of France?", Arrays.asList("London", "Berlin", "Paris", "Madrid"), 3));
        quizQuestions.add(new QuizQuestion("Which planet is known as the Red Planet?", Arrays.asList("Earth", "Mars", "Jupiter", "Venus"), 2));
        quizQuestions.add(new QuizQuestion("Who wrote 'Romeo and Juliet'?", Arrays.asList("Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain"), 2));

        // Create and start the quiz
        Quiz quiz = new Quiz(quizQuestions);
        quiz.startQuiz();
    }
}
