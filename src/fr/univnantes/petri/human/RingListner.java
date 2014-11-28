package fr.univnantes.petri.human;

import java.rmi.RemoteException;

import fr.univnantes.petri.alarm.IAlarm;

/**
 * 
 * @author khocef
 *
 */
public class RingListner extends Thread {

	private boolean stop = false;
	private IAlarm alarm;
	private IHuman human;

	public RingListner(IAlarm alarm, IHuman human) {
		super();
		this.alarm = alarm;
		this.human = human;
	}

	public void run() {
		System.out.println("Listen for alarm to ring start now.");
		while (!stop) {
			try {
				if (this.alarm.isRinging()) {
					this.human.wakeUp();
					System.out.println("Stopping listening for alarm to ring ");
					this.stopListen();
				}
			} catch (RemoteException e) {
				System.err
						.println("Unable to listen the alarm... May be it is ringing, may be not...");
				e.printStackTrace();
			}
		}
		System.out.println("Listening for alarm ring stopped.");
	}

	public void stopListen() {
		this.stop = true;
	}
}
