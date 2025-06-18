import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("User Registration Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Center the window

        // Name Label and Field
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(140, 30, 200, 25);
        frame.add(nameField);

        // Email Label and Field
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setBounds(30, 70, 100, 25);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(140, 70, 200, 25);
        frame.add(emailField);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 110, 100, 25);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(140, 110, 200, 25);
        frame.add(passwordField);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(140, 160, 100, 30);
        frame.add(registerButton);

        // Button Action
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                JOptionPane.showMessageDialog(frame,
                        "Registration Successful!\n\nName: " + name +
                                "\nEmail: " + email +
                                "\nPassword: " + password,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // Make frame visible
        frame.setVisible(true);
    }
}
