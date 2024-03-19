import javax.swing.*;
import javax.swing.border.*;
// import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;



public class Window extends JFrame {


    private JLabel lblHint;
    private JLabel lblGuess;
    private JLabel lblTitle;
    private JTextField txtGuess1;
    private JTextField txtGuess2;
    private JTextField txtGuess3;
    private JButton btnOK;
    private JButton btnReset;
    private JTextArea txtHint;
    private TextFieldValidator validator1;
    private TextFieldValidator validator2;
    private TextFieldValidator validator3;




    public Window(HintManager hintManager) {

        // Set the title, size, and other properties of the window
        setTitle("Hi Sean");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 330);
        setVisible(true);
        setResizable(false);
        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(0, 5, 5, 5));
        this.add(mainPanel);

        // Create the input panel
        JPanel pnlInput = new JPanel();
        pnlInput.setBorder(new EmptyBorder(0, 5, 5, 5));

        // guts of the input panel

        // create labels
        lblGuess = new JLabel("Enter your guesses (0-9):");
        lblHint = new JLabel("Hints:");
        lblTitle = new JLabel("Fermi guessing game");

        // create text fields
        txtGuess1 = new JTextField(5);
        validator1 = new TextFieldValidator(txtGuess1);
        validator1.setRegExp("^[0-9]$");
        txtGuess2 = new JTextField(5);
        validator2 = new TextFieldValidator(txtGuess2);
        validator2.setRegExp("^[0-9]$");
        txtGuess3 = new JTextField(5);
        validator3 = new TextFieldValidator(txtGuess3);
        validator3.setRegExp("^[0-9]$");


        // create output panel
        JPanel pnlHint = new JPanel();
        

        // create text area
        txtHint = new JTextArea(16, 40);
        txtHint.setLineWrap(true);
        txtHint.setWrapStyleWord(true);
        txtHint.setEditable(false);

        // create scroll pane
        JScrollPane pnlScroll = new JScrollPane(txtHint);
        pnlScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnlScroll.setViewportView(txtHint);
        pnlHint.add(pnlScroll);

        // create buttons
        btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isValid1 = validator1.check();
                boolean isValid2 = validator2.check();
                boolean isValid3 = validator3.check();
                if (!isValid1 || !isValid2 || !isValid3) {
                    return;
                }
                hintManager.checkGuess(txtGuess1, txtGuess2, txtGuess3, txtHint, btnOK);
            }
        });



        btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtGuess1.setText("");
                txtGuess2.setText("");
                txtGuess3.setText("");
                txtHint.setText("");
                hintManager.numGen();
                hintManager.resetGuessCount();
                txtGuess1.setEnabled(true);
                txtGuess2.setEnabled(true);
                txtGuess3.setEnabled(true);
                btnOK.setEnabled(true);
            }
        });

        // set up main panel layout
        mainPanel.setLayout(new MigLayout("", "[][]", "[]"));
        mainPanel.add(pnlInput, "cell 0 0");
        mainPanel.add(pnlHint, "cell 1 0");

        // set up input panel layout
        pnlInput.setLayout(new MigLayout("", "[]", "[][][][][][]100[]"));

        // add components to input panel
        pnlInput.add(lblTitle, "cell 0 0");
        pnlInput.add(lblGuess, "cell 0 1, alignx center");
        pnlInput.add(txtGuess1, "cell 0 2");
        pnlInput.add(txtGuess2, "cell 0 3");
        pnlInput.add(txtGuess3, "cell 0 4");
        pnlInput.add(btnOK, "cell 0 5");
        pnlInput.add(btnReset, "cell 0 6");

        // set up hint panel layout
        pnlHint.setLayout(new MigLayout("", "[]", "[][][]"));
        pnlHint.add(lblHint, "cell 0 1");
        pnlHint.add(pnlScroll, "cell 0 2, alignx center");



    }

    public static void main(String[] args) {
        HintManager hintManager = new HintManager();
        Window window = new Window(hintManager);
        window.setVisible(true);
        hintManager.numGen();
        };
    
}