/**
 * 
 */
package fr.univnantes.petri.alarm;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author khocef
 *
 */
public interface IAlarm extends Remote {
	
	public static final int RingAgainAfter = 5;
	
	public void switchOn() throws RemoteException;

	public void switchOff() throws RemoteException;

	public void ring() throws RemoteException;
	
	public void snooze() throws RemoteException;

	public boolean isOn() throws RemoteException;
	
	public boolean isOff() throws RemoteException;
	
	public boolean isRinging() throws RemoteException;
	
	public Date now() throws RemoteException;

	public Date getRingingDate() throws RemoteException;
	
	public void setRingingTime(Date date) throws RemoteException;
}
