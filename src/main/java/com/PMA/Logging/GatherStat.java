package com.PMA.Logging;

import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.ServiceInstance;

import java.io.IOException;
import java.net.URL;
import java.util.Timer;


public class GatherStat {
	public static ServiceInstance si;
	public static HostSystem vmHost = null;

	public static void main(String[] args) throws IOException, InterruptedException {

		//VirtualMachine vm;
		String hostName = "130.65.159.14";
		String vmName = "vm2-team6";

        Timer timer = new Timer();  //At this line a new Thread will be created

		try {
			si = new ServiceInstance(new URL(Util.VCENTER_URL), Util.VCENTER_USERNAME, Util.VCENTER_PASSWORD, true);

			//while(true){
				StatWriter writeStat = new StatWriter();
				writeStat.setVmName(vmName);
				writeStat.setHostName(hostName);
              //  writeStat.start();
              //  writeStat.join();
			//}
            timer.schedule(writeStat, 10000, 5*1000); //delay in milliseconds (5sec)
		}
		catch (Exception e) {
			System.out.println("Error in getStatistics" + e.getMessage());
		}
	}


}
