/**
 * 
 */
package fr.univnantes.petri.human;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.univnantes.petri.alarm.IAlarm;

/**
 * @author khocef
 *
 */
public class HumanApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			IAlarm alarm = (IAlarm) Naming.lookup("//"
					+ InetAddress.getLocalHost().getHostAddress()
					+ ":3000/wakeup");
			System.out.println("Human Connected to server");

			Human human = new Human(alarm);
			HumanGUI gui = new HumanGUI(human);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

}
