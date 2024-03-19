import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HintManager {
    
    private String targetNum;
    private int guessCount;
    
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
        // convert the set to a string
        for (Integer num : numbers) {
            targetNum += Integer.toString(num);
        }
        System.out.println(targetNum);
    }
    // return the target number as a char array
    public char[] target() {
        return targetNum.toCharArray();
    }
    // check the user's guess
    public void checkGuess(JTextField txtGuess1, JTextField txtGuess2, JTextField txtGuess3, JTextArea txtHint, JButton btnOK) {
        guessCount++;
        // get the user's guess
        String input1 = txtGuess1.getText();
        String input2 = txtGuess2.getText();
        String input3 = txtGuess3.getText();

        int fermiCount = 0;
        int picoCount = 0;
        int nanoCount = 0;
        // check if the user's guess is correct by comparing each input to an element of the char array
        if (input1.equals(targetNum.substring(0, 1))) {
            fermiCount++;
        } else if (targetNum.indexOf(input1) != -1) {
            picoCount++;
        } else {
            nanoCount++;
        }
        if (input2.equals(targetNum.substring(1, 2))) {
            fermiCount++;
        } else if (targetNum.indexOf(input2) != -1) {
            picoCount++;
        } else {
            nanoCount++;
        }
        if (input3.equals(targetNum.substring(2, 3))) {
            fermiCount++;
        } else if (targetNum.indexOf(input3) != -1) {
            picoCount++;
        } else {
            nanoCount++;
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
    // generate the hint based on the user's guess
    private String generateHint(int fermiCount, int picoCount, int nanoCount, String input1, String input2, String input3) {
        StringBuilder hint = new StringBuilder();
        hint.append("Guess: ").append(input1).append(" ").append(input2).append(" ").append(input3).append(": ");
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

    
    public void resetGuessCount() {
        guessCount = 0;
    }



}
