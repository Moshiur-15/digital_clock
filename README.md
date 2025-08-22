##Digital Clock 

    A simple digital clock application built using Java Swing. The clock updates every second and displays the current time in HH:mm:ss format.

##Features

    Displays real-time digital clock.
    Updates every second.
    Simple and clean user interface.
##Technologies Used

    Java: Programming language used for the application.
    Swing: Used for building the graphical user interface (GUI).
    Timer: For updating the clock every second.
##Setup Instructions

    Ensure you have Java installed on your machine.
    Clone or download the repository to your local machine.
    Compile and run the DigitalClock.java file:
        javac DigitalClock.java
        java DigitalClock

##Usage

    Once the application is launched, a window will appear with the current time displayed in a digital format. The time will update automatically every second.

##License

    This project is open-source and available under the MIT License.













    
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock {

    private JFrame frame;
    private JLabel clockLabel;
    private JLabel dateLabel;
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dateFormat;

    public DigitalClock() {
        frame = new JFrame("DIGITAL CLOCK");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gradient background panel
        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color slate800 = new Color(30, 41, 59);
                GradientPaint gp = new GradientPaint(0, 0, slate800, 0, h, slate800);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        gradientPanel.setLayout(new GridBagLayout()); // Center everything
        frame.setContentPane(gradientPanel);

        // Time format (12-hour with AM/PM)
        timeFormat = new SimpleDateFormat("hh:mm a");
        // Date format (day, date-month-year)
        dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        // Clock Label
        clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 80));
        clockLabel.setForeground(new Color(34, 197, 94));

        // Date Label
        dateLabel = new JLabel("", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        dateLabel.setForeground(Color.WHITE);

        // Panel to hold time + date vertically
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false); // transparent panel
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(clockLabel);
        centerPanel.add(Box.createVerticalStrut(20)); // gap between time & date
        centerPanel.add(dateLabel);

        // Add to gradient panel (center)
        gradientPanel.add(centerPanel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Timer to update clock
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        }, 0, 1000);
    }

    private void updateClock() {
        Date now = new Date();
        clockLabel.setText(timeFormat.format(now)); // show time
        dateLabel.setText(dateFormat.format(now));  // show date
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}

