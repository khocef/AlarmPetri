/**
 * 
 */
package fr.univnantes.petri.human;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author khocef
 *
 */
public interface IHuman extends Remote {
	public static final int WakeUpAfter = 480;
	public static final int SleepAfterMin = 840; // 14 hours  
	
	public void wakeUp() throws RemoteException;

	public void sleep() throws RemoteException;

	public boolean isAwake() throws RemoteException;

	public boolean isAsleep() throws RemoteException;
	
	public boolean isSleepy() throws RemoteException;

	public void switchAlarmOn(Date date) throws RemoteException;
	
	public void switchAlarmOff() throws RemoteException;
	
	public Date getTime() throws RemoteException;
}
