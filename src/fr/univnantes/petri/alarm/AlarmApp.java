/**
 * 
 */
package fr.univnantes.petri.alarm;

import java.io.IOException;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author khocef
 *
 */
public class AlarmApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Alarm alarm = new Alarm();
			AlarmGUI ui = new AlarmGUI(alarm);
			// Add Observer

			LocateRegistry.createRegistry(3000).rebind("wakeup", alarm);

			System.out.println("Server running on port 3000...");
		} catch (IOException e) {
			System.out.println("Error setting up server:  " + e);
			System.exit(0);
		}
	}

}
