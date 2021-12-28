package finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClientFromMaster extends Thread {

	private BufferedReader readFromMaster;

	public ClientFromMaster(BufferedReader readFromMaster) {
		this.readFromMaster = readFromMaster;
	}
	
	@Override
	public void run() {
		while (MasterToClient.currentThread().isAlive()) {
			String jobFromMaster;
			try {
				while ((jobFromMaster = readFromMaster.readLine()) != null) {
					System.out.println("Client received completed job " + jobFromMaster);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		}
	}
}
