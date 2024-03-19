import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The TextFieldValidator class is used to validate text fields in a GUI. It can be used to check if the text field contains a valid input.
 */
public class TextFieldValidator {
    private String regExp = "\\w";
    private Color errorColor = Color.RED;
    private JTextField target;
    private Border originalBorder;

    /**
     * Constructs a TextFieldValidator object with the specified target text field and error color.
     * @param myTarget the target text field to be validated
     * @param myErrorColor the color to be used for indicating errors in the text field
     */
    public TextFieldValidator(JTextField myTarget, Color myErrorColor) {
        target = myTarget;
        errorColor = myErrorColor;
        originalBorder = myTarget.getBorder();
    }

    /**
     * Constructs a TextFieldValidator object with the specified target text field and the default error color (RED).
     * @param myTarget the target text field to be validated
     */
    public TextFieldValidator(JTextField myTarget) {
        this(myTarget, Color.RED);
    }

    /**
     * Sets the regular expression pattern to be used for validation.
     * @param myRegExp the regular expression pattern
     */
    public void setRegExp(String myRegExp) {
        regExp = myRegExp;
    }

    /**
     * Sets the color to be used for indicating errors in the text field.
     * @param myColor the color to be used for indicating errors
     */
    public void setErrorColor(Color myColor) {
        errorColor = myColor;
    }

    /**
     * Checks if the text field contains a valid input.
     * @return true if the text field contains a valid input, false otherwise
     */
    public boolean check() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(target.getText());
        if (!matcher.matches()) {
            target.setBorder(BorderFactory.createLineBorder(errorColor, 2));
            return false;
        } else {
            reset();
            return true;
        }
    }

    /**
     * Resets the border of the text field to its original border.
     */
    public void reset() {
        target.setBorder(originalBorder);
    }
}