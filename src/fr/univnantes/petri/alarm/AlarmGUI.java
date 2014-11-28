/**
 * 
 */
package fr.univnantes.petri.alarm;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * @author khocef
 *
 */
public class AlarmGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IAlarm alarm;
	private DigitalClock clock;

	public AlarmGUI(IAlarm alarm) {
		this.alarm = alarm;
		this.clock = new DigitalClock();

		this.setTitle("Alarm Server");
		this.setSize(380, 150);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JPanel controlPanel = new JPanel();
		// controlPanel.setLayout(new FlowLayout());

		this.setLayout(new BorderLayout());
		this.add(this.clock, BorderLayout.CENTER);

		// JLabel timerLbl = new JLabel("23:23:23", JLabel.CENTER);
		// Font font = new Font("Courier", Font.BOLD, 70);
		// timerLbl.setFont(font);
		// timerLbl.setOpaque(true);
		//
		// controlPanel.add(timerLbl);

		// this.add(controlPanel);

		this.setVisible(true);

	}
}
