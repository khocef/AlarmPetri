/**
 * 
 */
package fr.univnantes.petri.alarm;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author khocef
 *
 */
public class Alarm extends UnicastRemoteObject implements IAlarm {

	private static final long serialVersionUID = 1L;
	private boolean off = true;
	private boolean on = false;
	private boolean ringing = false;
	private Date ringingDate;
	private Timer timer;
	private Clip clip;

	public Alarm() throws RemoteException {
		super();
	}

	@Override
	public void switchOn() throws RemoteException {
		this.on = true;
		this.off = false;
		this.timer = new Timer(this);
		this.timer.start();
	}

	@Override
	public void switchOff() throws RemoteException {
		this.off = true;
		this.on = false;
		if (this.timer != null) {
			this.timer.stopTimer();
		}
	}

	@Override
	public void ring() throws RemoteException {
		if (this.timer != null) {
			this.timer.stopTimer();
		}

		this.ringing = true;
		// Play sound or do something
		System.out.println("Ring Ring Ring Ring Ring Ring");
		try {
			this.clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(new File(System
							.getProperty("user.dir")
							+ "/bin/ring.wav"));
			System.out.println( new File(System
					.getProperty("user.dir")
					+ "/bin/ring.wav").getAbsolutePath());
			this.clip.open(inputStream);
			this.clip.start();

			while (this.clip.getMicrosecondLength() != this.clip
					.getMicrosecondPosition()) {
			}
			this.stopRinging();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopRinging() {
		this.ringing = false;
		if (this.clip != null) {
			this.clip.stop();
		}
	}

	@Override
	public boolean isOn() throws RemoteException {
		return this.on;
	}

	@Override
	public boolean isOff() throws RemoteException {
		return this.off;
	}

	@Override
	public boolean isRinging() throws RemoteException {
		return this.ringing;
	}

	@Override
	public Date now() throws RemoteException {
		return new Date();
	}

	@Override
	public Date getRingingDate() throws RemoteException {
		return this.ringingDate;
	}

	public void setRingingTime(Date date) {
		this.ringingDate = date;
	}

	@Override
	public void snooze() throws RemoteException {
		this.ringingDate = new Date();
		this.ringingDate.setTime(this.ringingDate.getTime() + 60000);

		this.timer = new Timer(this);
		this.timer.start();
	}
}
