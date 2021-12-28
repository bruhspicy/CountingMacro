package CountingMacro;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class Frame extends JFrame implements ActionListener {
    private JFrame frame;
    private JButton start;
    private JButton stop;
    private JPanel panel;
    private JTextField input;
    private CountingMacro m;
    private static boolean run = false;

    public Frame() {
        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        panel = new JPanel();
        input = new JTextField(10);
        start = new JButton("Start");
        stop = new JButton("Stop");

        input.addActionListener(this);
        // input.setFocusable(false);

        start.addActionListener(this);
        // start.setFocusable(false);

        stop.addActionListener(this);
        // stop.setFocusable(false);

        panel.setLayout(new BorderLayout());
        panel.add(input, BorderLayout.NORTH);
        panel.add(start, BorderLayout.CENTER);
        panel.add(stop, BorderLayout.SOUTH);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        
        panel.setVisible(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        JButton actionSource = (JButton) e.getSource();

        int initialValue = Integer.parseInt(input.getText());

        if (actionSource.equals(start)) {
            m = new CountingMacro();
            setRun(true);
            m.setInitialValue(initialValue);
            m.start();
        } else if (actionSource.equals(stop)) {
            setRun(false);
        }
    }

    public static boolean getRun() {
        return run;
    }

    public static void setRun(boolean b) {
        run = b;
    }

}
