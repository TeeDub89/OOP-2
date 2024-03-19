import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// This class is used to validate text fields in a GUI. It can be used to check if the text field contains a valid
public class TextFieldValidator {
    private String regExp = "\\w";
    private Color errorColor = Color.RED;
    private JTextField target;
    private Border originalBorder;



    // overloading the constructor
    public TextFieldValidator(JTextField myTarget, Color myErrorColor) {
        target = myTarget;
        errorColor = myErrorColor;
        originalBorder = myTarget.getBorder();
    }
    public TextFieldValidator(JTextField myTarget) {
        this(myTarget, Color.RED);
    }



    // setters. These are used to set the regular expression and error color
    public void setRegExp(String myRegExp) {
        regExp = myRegExp;
    }

    public void setErrorColor(Color myColor) {
        errorColor = myColor;
    }


    // This method checks if the text field contains a valid input. If it does, it returns true. If it doesn't, it returns false
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
    // This method resets the border of the text field to its original border
    public void reset() {
        target.setBorder(originalBorder);
    }
}