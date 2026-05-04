import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ScheduleGUI {

    Period p;
    JTextArea area;
    JLabel time;
    JLabel countdown;

    public ScheduleGUI(Period ref) {

        p = ref;

        JFrame f = new JFrame("Schedule GUI");
        f.setSize(500, 500);

        area = new JTextArea();
        area.setEditable(false);

        time = new JLabel("", SwingConstants.CENTER);
        countdown = new JLabel("", SwingConstants.CENTER);

        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        JButton del = new JButton("Delete");

        JPanel panel = new JPanel();
        panel.add(add);
        panel.add(edit);
        panel.add(del);

        f.add(time, BorderLayout.NORTH);
        f.add(new JScrollPane(area), BorderLayout.CENTER);
        f.add(countdown, BorderLayout.SOUTH);
        f.add(panel, BorderLayout.PAGE_END);

        add.addActionListener(e -> {
            String n = JOptionPane.showInputDialog("Name:");
            String s = JOptionPane.showInputDialog("Start:");
            String en = JOptionPane.showInputDialog("End:");
            p.addOrUpdatePeriod(n, s, en);
        });

        edit.addActionListener(e -> {
            String i = JOptionPane.showInputDialog("Number:");
            int index = Integer.parseInt(i) - 1;
            String n = JOptionPane.showInputDialog("New name:");
            String s = JOptionPane.showInputDialog("Start:");
            String en = JOptionPane.showInputDialog("End:");
            p.names[index] = n;
            p.startTimes[index] = s;
            p.endTimes[index] = en;
        });

        del.addActionListener(e -> {
            String i = JOptionPane.showInputDialog("Delete number:");
            int index = Integer.parseInt(i) - 1;

            for (int j = index; j < p.count - 1; j++) {
                p.names[j] = p.names[j + 1];
                p.startTimes[j] = p.startTimes[j + 1];
                p.endTimes[j] = p.endTimes[j + 1];
            }

            p.count--;
        });

        new Timer(1000, e -> update()).start();

        f.setVisible(true);
    }

    public void update() {

        time.setText(TimeUtil.getTimeString());

        int now = TimeUtil.getCurrentMinutes();

        String text = "";

        int current = -1;

        for (int i = 0; i < p.count; i++) {

            int s = TimeUtil.toMinutes(p.startTimes[i]);
            int e = TimeUtil.toMinutes(p.endTimes[i]);

            if (now >= s && now < e) current = i;
        }

        for (int i = 0; i < p.count; i++) {

            if (i == current) {
                text += "[CURRENT] ";
            } else {
                text += "          ";
            }

            text += (i + 1) + ". " + p.names[i] + " " +
                    p.startTimes[i] + "-" + p.endTimes[i] + "\n";
        }

        area.setText(text);

        if (current != -1) {
            countdown.setText("Ends in: " +
                TimeUtil.minutesUntil(p.endTimes[current]) + " min");
        } else {
            countdown.setText("No current class");
        }
    }
}
