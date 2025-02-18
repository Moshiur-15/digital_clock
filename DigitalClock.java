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
        frame = new JFrame("DIGITAL CLOCK");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 80));
        clockLabel.setForeground(Color.WHITE);
        clockLabel.setBackground(Color.BLACK);
        clockLabel.setOpaque(true);

        frame.add(clockLabel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

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