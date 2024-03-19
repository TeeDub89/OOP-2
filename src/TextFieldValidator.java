import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFieldValidator {
    private String regExp = "\\w";
    private Color errorColor = Color.RED;
    private JTextField target;
    private Border originalBorder;

    public TextFieldValidator(JTextField myTarget, Color myErrorColor) {
        this.target = myTarget;
        this.errorColor = myErrorColor;
        this.originalBorder = myTarget.getBorder();
    }

    public TextFieldValidator(JTextField myTarget) {
        this(myTarget, Color.RED);
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
            target.setBorder(BorderFactory.createLineBorder(errorColor, 2));
            return false;
        } else {
            reset();
            return true;
        }
    }

    public void reset() {
        target.setBorder(originalBorder);
    }
}