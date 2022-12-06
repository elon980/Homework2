import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        playAction();
    }

    public static void playAction() {
        int guessCounter = 0;
        Random random = new Random(5 - 25);
        int secretLvlTries = random.nextInt();
        int userLevel = userLevelChoose();
        if (userLevel == 1) {
            guessCounter = 20;
        } else if (userLevel == 2) {
            guessCounter = 15;
        } else if (userLevel == 3) {
            guessCounter = 10;
        } else if (userLevel == 4) {
            guessCounter = secretLvlTries;
        }
        String generatedNumbers = generateRandomNumbers();
        String userNumbers = getUserNumbers();
        isNumberRight(userNumbers, generatedNumbers, guessCounter, userLevel);
    }

    public static int userLevelChoose() {
        int userChoose;

        System.out.println("Choose the mode you want to play: ");
        System.out.println("1) Easy mode - 20 Tries.");
        System.out.println("2) Moderate mode - 15 Tries.");
        System.out.println("3) Hard mode - 10 Tries.");
        System.out.println("4) Surprise mode - Unknown number between 5~25 tires. ;) ");
        Scanner scanner = new Scanner(System.in);
        do {
            userChoose = scanner.nextInt();
        } while (userChoose > 4 || userChoose < 1);
        return userChoose;
    }

    public static void guessingCounter(int counter, String randomNumber, int userLevel) {
        String userInput = getUserNumbers();
        isNumberRight(userInput, randomNumber, counter, userLevel);
    }

    public static String getUserNumbers() {
        String userGuess;
        Scanner scanner;
        do {
            System.out.println("Enter 4 numbers between 1 ~ 6");
            scanner = new Scanner(System.in);
            userGuess = scanner.nextLine();
        } while (userGuess.length() != 4);
        return userGuess;
    }


    public static int isNumberRight(String userNumbers, String randomNumber, int guessCounter, int userLevel) {
        int charAtDifferentPos = 0, correctCharPos = 0,i;
        boolean duplicate = false;
        if(randomNumber.contains(userNumbers)){
            System.out.println("You guessed the correct number!  "+randomNumber);
            guessCounter = 0;
        }
        else {
            for (i = 0; i < userNumbers.length(); i++) {
                char ch = userNumbers.charAt(i);
                int index = randomNumber.indexOf(ch);
                if (i == index) {
                    correctCharPos++;
                } else if (index != -1) {
                    charAtDifferentPos++;
                }
            }
            char duplicateChecker;
            for (i = 0; i < userNumbers.length(); i++) {
                duplicateChecker = userNumbers.charAt(i);
                if (i + 1 != userNumbers.length()) {
                    String cutStr = userNumbers.substring(i + 1);
                    if (cutStr.indexOf(duplicateChecker) != -1) {
                        duplicate = true;
                        break;
                    }
                }
            }
            if (duplicate) {
                guessCounter -= 2;
                System.out.println("Your guess contained duplicate number! Your Fined in 2 attempts");
                if (userLevel != 4) {
                    System.out.println("You got: " + guessCounter + " tries left.");
                }
            } else {
                guessCounter--;
                System.out.println("right number in the right position: " + correctCharPos);
                System.out.println("right number in a wrong position: " + charAtDifferentPos);
                if (userLevel != 4) {
                    System.out.println("You got: " + guessCounter + " tries left.");
                }
            }
            if (guessCounter == 0) {
                System.out.println("Your number tries have reached to 0, you didnt guessed the correct number: " + randomNumber + " Thanks for playing!");
            } else {
                guessingCounter(guessCounter, randomNumber, userLevel);
            }
        }
        return guessCounter;
    }
    public static String generateRandomNumbers() {
        String arrayString = "";
        int[] arrayRandom = new int[4];
        Random generator = new Random();
        for (int i = 0; i < 4; i++) {
            do {
                arrayRandom[i] = generator.nextInt(6);
            } while (arrayRandom[i] == 0);
            for (int j = 0; j < i; j++) {
                if (arrayRandom[i] == arrayRandom[j]) {
                    i--;
                }
            }
        }
        arrayString = Arrays.toString(arrayRandom);
        arrayString = arrayString.replace(",","");
        arrayString = arrayString.replace(" ","");
        arrayString = arrayString.replace("[","");
        arrayString = arrayString.replace("]","");
        return arrayString;
    }
}