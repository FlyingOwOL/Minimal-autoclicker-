import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel headerPanel;
    private JPanel bodyPanel;

    private JLabel clicksPerSecondLabel;
    private JLabel clicksPerMinuteLabel;
    private JLabel clicksPerHourLabel;

    private JTextField clicksPerSecondField;
    private JTextField clicksPerMinuteField;
    private JTextField clicksPerHourField;

    private JButton startStopButton; // Button to start/stop clicking

    public View() {
        this.setTitle("Minimal Auto Clicker");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // Initialize panels
        headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(0, 0, 300, 50);
        
        bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.setBounds(0, 50, 300, 250);

        // Initialize labels
        clicksPerSecondLabel = new JLabel("Clicks Per Second:");
        clicksPerSecondLabel.setBounds(20, 20, 150, 25);
        
        clicksPerMinuteLabel = new JLabel("Clicks Per Minute:");
        clicksPerMinuteLabel.setBounds(20, 60, 150, 25);
        
        clicksPerHourLabel = new JLabel("Clicks Per Hour:");
        clicksPerHourLabel.setBounds(20, 100, 150, 25);

        // Initialize text fields
        clicksPerSecondField = new JTextField("0");
        clicksPerSecondField.setBounds(180, 20, 80, 25);
        
        clicksPerMinuteField = new JTextField("0");
        clicksPerMinuteField.setBounds(180, 60, 80, 25);
        
        clicksPerHourField = new JTextField("0");
        clicksPerHourField.setBounds(180, 100, 80, 25);

        // Initialize button - centered below the text fields
        startStopButton = new JButton("Start/Stop");
        startStopButton.setBounds(150, 150, 100, 30);

        // Add components to body panel
        bodyPanel.add(clicksPerSecondLabel);
        bodyPanel.add(clicksPerSecondField);
        bodyPanel.add(clicksPerMinuteLabel);
        bodyPanel.add(clicksPerMinuteField);
        bodyPanel.add(clicksPerHourLabel);
        bodyPanel.add(clicksPerHourField);
        bodyPanel.add(startStopButton);

        // Add panels to frame
        this.add(headerPanel);
        this.add(bodyPanel);
        this.setVisible(true);
    }

    // getters
    public JTextField getClicksPerSecondField() {
        return clicksPerSecondField;
    }
    public JTextField getClicksPerMinuteField() {
        return clicksPerMinuteField;
    }
    public JTextField getClicksPerHourField() {
        return clicksPerHourField;
    }
    public JButton getStartStopButton() {
        return startStopButton;
    }

    // setters
    public void setStartStopButton(ActionListener e) {
        this.startStopButton.addActionListener(e);
    }
}
