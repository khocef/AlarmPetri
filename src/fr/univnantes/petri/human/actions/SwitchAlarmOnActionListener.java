package fr.univnantes.petri.human.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.JOptionPane;

import fr.univnantes.petri.human.AlarmTimeSelectionDialog;
import fr.univnantes.petri.human.IHuman;

/**
 * 
 * @author khocef
 *
 */
public class SwitchAlarmOnActionListener implements ActionListener {

	private IHuman human;

	public SwitchAlarmOnActionListener(IHuman human) {
		this.human = human;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Date ringingDate = new Date();
		int res = JOptionPane.showConfirmDialog(null,
				AlarmTimeSelectionDialog.getPanel(ringingDate),
				"Please select time you wish to wakeup at: ",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (res == JOptionPane.OK_OPTION) {
			System.out.println("Alarm will ring at: " + ringingDate);
			try {
				this.human.switchAlarmOn(ringingDate);
				this.human.sleep();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}

		}
	}
}
