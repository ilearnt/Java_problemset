/* counting semaphore is used to synchronize access to a shared resource,   
 itmaintains a specified number of passes or permissions, and the Current Thread must obtain 
 a permit to access a shared resource. If a permit is already exhausted by threads other than that, 
 it may wait until the permit becomes available as a result of the release of permits from various threads8 */
public class counting_Semaphore {

	private static final int MOS_ACCESS= 3;  // the maximum number of permessions
	private static int availtable = MOS_ACCESS;

	public synchronized void request() throws InterruptedException{ //Request a permission to access shared resource 
          if (availtable == 0)
        	  wait();
          availtable--;
	 }

	 public synchronized void release() throws InterruptedException{ //A thread release a permission
		 availtable++;  
		 if(availtable > 0)
		    this.notify();
	 }

}
