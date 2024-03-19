import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFieldValidator {
    private String regExp = "\\w";
    private Color errorColor = Color.RED;
    private Color originalColor;
    private JTextField target;

    public TextFieldValidator(JTextField myTarget, Color myErrorColor) {
        this.target = myTarget;
        this.errorColor = myErrorColor;
    }

    public TextFieldValidator(JTextField myTarget) {
        this.target = myTarget;
    }

    public void setRegExp(String myRegExp) {
        this.regExp = myRegExp;
    }

    public void setErrorColor(Color myColor) {
        this.errorColor = myColor;
    }

    public boolean check() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(target.getText());
            if (!matcher.matches()) {
                target.setBackground(errorColor);
                return false;
            }
        return true;
    }

    public void reset() {
        target.setBackground(originalColor);

    }
}