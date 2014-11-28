/**
 * 
 */
package fr.univnantes.petri.alarm;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author khocef
 *
 */
public class Timer extends Thread {
	IAlarm alarm;
	boolean stop = false;

	public Timer(IAlarm alarm) {
		this.alarm = alarm;
	}

	@Override
	public void run() {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm");
			while (!stop) {

				Date current = alarm.now();
				if (this.alarm.isOn()) {
					if (this.alarm.getRingingDate() != null) {
						Date ringingDate = this.alarm.getRingingDate();
						if (format.format(current).equals(
								format.format(ringingDate))) {
							System.out
									.println("Alarm is going to start ringing");
							this.alarm.ring();
						}
					}
				}else{
					this.stopTimer();
				}
			}
		} catch (RemoteException e) {

		}
	}

	public void stopTimer() {
		this.stop = true;
	}
	
	public static void main(String[] args) {
		try {
			Alarm alarm = new Alarm();
			alarm.setRingingTime(new Date());
			Timer timer = new Timer(alarm);
			timer.start();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
