import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;  import java.util.TimerTask;
public class DigitalClock {
    
    private JFrame frame;
    private JLabel clockLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        frame = new JFrame("DIGITAL CLOCK");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color slate800 = new Color(30, 41, 59); // Slate-800
                GradientPaint gp = new GradientPaint(0, 0, slate800, 0, h, slate800);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        gradientPanel.setLayout(new BorderLayout());
        frame.setContentPane(gradientPanel);

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 80));
        clockLabel.setForeground(new Color(34,197,94)); // Green text
        clockLabel.setBackground(new Color(0,0,0,0));
        clockLabel.setOpaque(false);
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