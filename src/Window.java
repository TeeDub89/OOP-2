import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
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




    public Window() {
        // Set the title, size, and other properties of the window
        setTitle("Hi Sean");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        setVisible(true);
        setResizable(false);
        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.add(mainPanel);

        // Create the input panel
        JPanel pnlInput = new JPanel();
        pnlInput.setBorder(new EmptyBorder(5, 5, 5, 5));

        // guts of the input panel

        // create labels
        lblGuess = new JLabel("Enter your guesses (0-9):");
        lblHint = new JLabel("Hints:");
        lblTitle = new JLabel("Fermi guessing game");

        // create text fields
        txtGuess1 = new JTextField(5);
        txtGuess2 = new JTextField(5);
        txtGuess3 = new JTextField(5);


        // create output panel
        JPanel pnlHint = new JPanel();
        

        // create text area
        txtHint = new JTextArea(16, 20);
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
                
            }
        });



        btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtGuess1.setText("");
                txtGuess2.setText("");
                txtGuess3.setText("");
                txtHint.setText("");
            }
        });

        // set up main panel layout
        mainPanel.setLayout(new MigLayout("debug", "[][]", "[]"));
        mainPanel.add(pnlInput, "cell 0 0, grow");
        mainPanel.add(pnlHint, "cell 1 0, grow");

        // set up input panel layout
        pnlInput.setLayout(new MigLayout("debug", "[]", "[][][][][][]100[]"));

        // add components to input panel
        pnlInput.add(lblTitle, "cell 0 0");
        pnlInput.add(lblGuess, "cell 0 1, alignx center");
        pnlInput.add(txtGuess1, "cell 0 2");
        pnlInput.add(txtGuess2, "cell 0 3");
        pnlInput.add(txtGuess3, "cell 0 4");
        pnlInput.add(btnOK, "cell 0 5");
        pnlInput.add(btnReset, "cell 0 6");

        // set up hint panel layout
        pnlHint.setLayout(new MigLayout("debug", "[]", "[][][]"));
        pnlHint.add(lblHint, "cell 0 1");
        pnlHint.add(pnlScroll, "cell 0 2, alignx center");



    }

    public static void main(String[] args) {
        Window window = new Window();
        window.setVisible(true);
        HintManager hintManager = new HintManager();
        hintManager.numGen();
        };
    
}