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
        Random rand = new Random();
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(rand.nextInt(10));
        }
        targetNum = "";
        for (Integer num : numbers) {
            targetNum += Integer.toString(num);
        }
        System.out.println(targetNum);
    }

    public char[] target() {
        return targetNum.toCharArray();
    }

    public void checkGuess(JTextField txtGuess1, JTextField txtGuess2, JTextField txtGuess3, JTextArea txtHint, JButton btnOK) {
        guessCount++;

        String input1 = txtGuess1.getText();
        String input2 = txtGuess2.getText();
        String input3 = txtGuess3.getText();

        int fermiCount = 0;
        int picoCount = 0;
        int nanoCount = 0;

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

        StringBuilder hint = new StringBuilder();
        hint.append("Guesses: ").append(input1).append(" ").append(input2).append(" ").append(input3).append(": ");
        for (int i = 0; i < fermiCount; i++) {
            // System.out.println("Fermi ");
            hint.append("Fermi ");
        }
        for (int i = 0; i < picoCount; i++) {
            // System.out.println("Pico ");
            hint.append("Pico ");
        }
        for (int i = 0; i < nanoCount; i++) {
            // System.out.println("Nano ");
            hint.append("Nano ");
        }
        if (fermiCount == 3) {
            hint.append("You win! It took you ").append(guessCount).append(" guesses.");
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
    
    public void resetGuessCount() {
        guessCount = 0;
    }



}
