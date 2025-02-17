import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock {
    private JFrame frame;
    private JLabel clockLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        frame = new JFrame("Digital Clock");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Set the background color of the frame to white
        frame.getContentPane().setBackground(Color.WHITE);

        // Set font style and text color
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 50));
        clockLabel.setForeground(Color.BLACK); // Black text
        clockLabel.setBackground(Color.WHITE); // White background
        clockLabel.setOpaque(true);

        // Add the clock label to the frame
        frame.add(clockLabel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);

        // Timer to update the clock every second
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        }, 0, 1000);
    }

    private void updateClock() {
        String currentTime = timeFormat.format(new Date());
        clockLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}