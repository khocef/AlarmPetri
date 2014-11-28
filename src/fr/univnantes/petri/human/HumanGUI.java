/**
 * 
 */
package fr.univnantes.petri.human;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.univnantes.petri.human.actions.SwitchAlarmOnActionListener;

/**
 * @author khocef
 *
 */
public class HumanGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton armBtn = new JButton("Switch On");
	private JButton disarmBtn = new JButton("Switch Off");
	private JButton snoozeBtn = new JButton("Snooze");
	private JLabel stateLbl = new JLabel();
	private AlarmTimeSelectionDialog timeSelectionDialog;
	
	private IHuman human;
	public HumanGUI(IHuman human) {
		
		this.human = human;
		
		this.setTitle("Alarm Client");
		this.setSize(200, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout gl = new GridLayout(3, 1, 5, 5);
		this.setLayout(gl);

		this.getContentPane().add(armBtn);
		this.getContentPane().add(disarmBtn);
		this.getContentPane().add(snoozeBtn);

		armBtn.addActionListener(new SwitchAlarmOnActionListener(human));

		this.setVisible(true);
	}
}
