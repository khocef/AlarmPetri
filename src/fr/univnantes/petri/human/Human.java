/**
 * 
 */
package fr.univnantes.petri.human;

import java.rmi.RemoteException;
import java.util.Date;

import fr.univnantes.petri.alarm.IAlarm;

/**
 * @author khocef
 *
 */
public class Human implements IHuman {

	private boolean awake = true; // default human state
	private boolean sleepy = false;
	private boolean asleep = false;
	private IAlarm alarm;
	private RingListner ringListner;

	public Human(IAlarm alarm) {
		this.alarm = alarm;
	}

	@Override
	public void wakeUp() throws RemoteException {
		this.asleep = false;
		this.awake = true;
		if(this.ringListner != null){
			this.ringListner.stopListen();
		}
	}

	@Override
	public void sleep() throws RemoteException {
		this.asleep = true;
		this.awake = false;
		this.ringListner = new RingListner(this.alarm, this);
		this.ringListner.start();
		System.out.println("Sleeping");
	}

	@Override
	public boolean isAwake() throws RemoteException {
		return this.awake == true;
	}

	@Override
	public boolean isAsleep() throws RemoteException {
		return this.asleep == true;

	}

	@Override
	public boolean isSleepy() throws RemoteException {
		return this.asleep == true;
	}

	@Override
	public void switchAlarmOn(Date date) throws RemoteException {
		this.alarm.switchOn();
	}

	@Override
	public void switchAlarmOff() throws RemoteException {
		this.alarm.switchOff();
	}

	@Override
	public Date getTime() throws RemoteException {
		return new Date();
	}
}
