package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Clock {
    private JFrame frame;
    private JLabel timeLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Clock window = new Clock();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Clock() {
        initialize();
        updateTime();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        timeLabel = new JLabel("00:00:00");
        frame.getContentPane().add(timeLabel);

        JButton openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        frame.getContentPane().add(openButton);

        JButton timeZoneButton = new JButton("Chỉnh múi giờ");
        timeZoneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String selectedTimeZone = JOptionPane.showInputDialog(frame, "Nhập múi giờ:");
                if (selectedTimeZone != null) {
                    updateTime(selectedTimeZone);
                }
            }
        });
        frame.getContentPane().add(timeZoneButton);
    }

    private void updateTime() {
        updateTime("0");
    }

    private void updateTime(String timeZone) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        String time = sdf.format(calendar.getTime());
        timeLabel.setText(time);
    }
}
