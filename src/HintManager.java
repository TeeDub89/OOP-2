import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The HintManager class is responsible for generating hints and checking user guesses in a number guessing game.
 */
public class HintManager {
    
    private String targetNum;
    private int guessCount;
    
    /**
     * Generates a random 3-digit number and sets it as the target number.
     */
    public void numGen() {
        // generate a random 3 digit number
        Random rand = new Random();
        // set to store the numbers to ensure no duplicates
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            // add a random number < 10 to the set
            numbers.add(rand.nextInt(10));
        }
        targetNum = "";
        // convert the set to a string to get the target number
        for (Integer num : numbers) {
            targetNum += Integer.toString(num);
        }
        System.out.println(targetNum);
    }
    
    /**
     * Checks the user's guess and updates the hint text area accordingly.
     * @param txtGuess1 The JTextField for the first digit of the guess.
     * @param txtGuess2 The JTextField for the second digit of the guess.
     * @param txtGuess3 The JTextField for the third digit of the guess.
     * @param txtHint The JTextArea to display the hint.
     * @param btnOK The JButton to disable if the user wins.
     */
    public void checkGuess(JTextField txtGuess1, JTextField txtGuess2, JTextField txtGuess3, JTextArea txtHint, JButton btnOK) {
        guessCount++;
        // get the user's guess
        String input1 = txtGuess1.getText();
        String input2 = txtGuess2.getText();
        String input3 = txtGuess3.getText();

        int fermiCount = 0;
        int picoCount = 0;
        int nanoCount = 0;
        // compare the user's guess to the target number by breaking it into substrings and checking each digit
        for (int i = 0; i < 3; i++) {
            String input = "";
            if (i == 0) {
                input = input1;
            } else if (i == 1) {
                input = input2;
            } else if (i == 2) {
                input = input3;
            }
            
            if (input.equals(targetNum.substring(i, i + 1))) {
                fermiCount++;
            } else if (targetNum.indexOf(input) != -1) {
                picoCount++;
            } else {
                nanoCount++;
            }
        }
        // win condition
        String hint = generateHint(fermiCount, picoCount, nanoCount, input1, input2, input3);
        if (fermiCount == 3) {
            hint += "\nYou win! Guesses: " + guessCount;
            txtGuess1.setText("");
            txtGuess2.setText("");
            txtGuess3.setText("");
            txtGuess1.setEnabled(false);
            txtGuess2.setEnabled(false);
            txtGuess3.setEnabled(false);
            btnOK.setEnabled(false);
        }
        txtHint.append(hint.toString().trim());
        txtHint.append("\n");
    }
    
    /**
     * Generates a hint based on the user's guess.
     * @param fermiCount The number of correct digits in the correct position (Fermi count).
     * @param picoCount The number of correct digits in the wrong position (Pico count).
     * @param nanoCount The number of incorrect digits (Nano count).
     * @param input1 The first digit of the user's guess.
     * @param input2 The second digit of the user's guess.
     * @param input3 The third digit of the user's guess.
     * @return The generated hint as a string.
     */
    private String generateHint(int fermiCount, int picoCount, int nanoCount, String input1, String input2, String input3) {
        StringBuilder hint = new StringBuilder();
        hint.append(input1).append(" ").append(input2).append(" ").append(input3).append(": ");
        for (int i = 0; i < fermiCount; i++) {
            hint.append("Fermi ");
        }
        for (int i = 0; i < picoCount; i++) {
            hint.append("Pico ");
        }
        for (int i = 0; i < nanoCount; i++) {
            hint.append("Nano ");
        }
        return hint.toString();
    }
    
    /**
     * Resets the guess count to 0.
     */
    public void resetGuessCount() {
        guessCount = 0;
    }
}
