//প্রয়োজনীয় লাইব্রেরি ইমপোর্ট
import javax.swing.*; //GUI তৈরি করার জন্য ব্যবহৃত হয়।
import java.awt.*; //উইন্ডোর ডিজাইন এবং ফন্ট সেট করার জন্য প্রয়োজন।
import java.text.SimpleDateFormat; //সময় ফরম্যাটিংয়ের জন্য ব্যবহৃত হয়।
import java.util.Date; //বর্তমান সময় নেওয়ার জন্য ব্যবহৃত হয়।
import java.util.Timer;  import java.util.TimerTask; //প্রতি সেকেন্ডে সময় আপডেট করার জন্য।

public class DigitalClock {
    //  উইন্ডো তৈরি করার জন্য ব্যবহার করা হয়েছে।সময় দেখানোর জন্য একটি লেবেল।
    private JFrame frame;
    private JLabel clockLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        frame = new JFrame("DIGITAL CLOCK"); //নতুন উইন্ডো তৈরি করা হয়েছে।
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ব্যাকগ্রাউন্ড সাদা (White) ও টেক্সট কালো (Black) করা হয়েছে।
        // সময় "HH:mm:ss" ফরম্যাটে দেখানো হবে।
        // Arial ফন্ট ও 50px ফন্ট সাইজ ব্যবহার করা হয়েছে।
        // ব্যাকগ্রাউন্ডের রঙ সঠিকভাবে সেট করার জন্য।
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

        // টাইমার ব্যবহার করে প্রতি সেকেন্ডে সময় আপডেট করা
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        }, 0, 1000);
    }

    // বর্তমান সময় সংগ্রহ করে clockLabel-এ দেখানো হয়।
    private void updateClock() {
        String currentTime = timeFormat.format(new Date());
        clockLabel.setText(currentTime);
    }

    // এর মাধ্যমে DigitalClock ক্লাসের অবজেক্ট তৈরি করা হয় এবং GUI থ্রেডে রান করানো হয়।
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}