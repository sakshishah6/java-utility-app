package driver;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
    int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    
    public GUI() {
      frame = new JFrame(); //this is the window
      panel = new JPanel();
      button = new JButton("Click Me!!");
      label = new JLabel("Number of clicks: 10");
      
      label.setSize(100, 100);
      button.addActionListener(this);
      
      panel.setBorder(BorderFactory.createEmptyBorder(200,  200,  200,  200));
      panel.setLayout(new GridLayout(0, 1));
      panel.add(button);
      panel.add(label);
      
      frame.add(panel, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("TESTING");
      frame.pack();
      frame.setVisible(true);
    }

	public static void main(String[] args) {
		new GUI();
	}

  @Override
  public void actionPerformed(ActionEvent e) {
    count ++;
    label.setText("Number of clicks: " + count);
  }

}
