package fr.univnantes.petri.human;

import java.util.Date;
/**
 * @author khocef
 */

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AlarmTimeSelectionDialog {
	public static JPanel getPanel(Date date) {
		final Date fRingingDate = date;
		JPanel dialog = new JPanel();

		JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner,
				"dd MMMM yyyy HH:mm");

		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(date);
		timeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				fRingingDate.setTime(((Date) timeSpinner.getValue()).getTime());
			}
		});

		dialog.add(timeSpinner);

		return dialog;
	}
}
