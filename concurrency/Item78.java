import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Item78 {
	private static volatile boolean stopRequested;
	private static volatile int nextSerialNumber = 0;
	private static final AtomicLong nextSerialNum = new AtomicLong();
	
	//public Item78(){}
	
	public static void main(String[] args) throws InterruptedException {
		//Item78 theItem = new Item78();
		//Item78.stopThread();
		
		//Item78.synchronizedThread();
		
		//raceCondition();
		
		for(int i = 0; i < 100; i++) {
			System.out.println(generateSerialNumberAtomic());
		}
	}
	
	public static void stopThread() throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			int i = 0;
			while (!stopRequested) {
				i++;
			}
		});
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
	
	private static synchronized void requestStop() {
		stopRequested = true;
	}
	
	private static synchronized boolean getStopRequested() {
		return stopRequested;
	}
	
	public static void synchronizedThread() throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			int i = 0;
			while (!getStopRequested()) {
				i++;
			}
		});
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		requestStop();
		
	}
	
	public static void raceCondition() {
		Thread[] threadArray = new Thread[7];
		for(int i = 0; i < 7; i++) {
			Thread newThread = new Thread(() -> {
				while(true){
					System.out.println(generateSerialNumber());
				}
			});
			threadArray[i] = newThread;
		}
		
		for (Thread thread : threadArray) {
			thread.start();
		}
		
		Thread thread = new Thread(() -> {performWork();});
		Thread thread2 = new Thread(() -> {performWork();});
		Thread thread3 = new Thread(() -> {performWork();});
		Thread thread4 = new Thread(() -> {performWork();});
		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
	
	private static void performWork() {
		while(true){
			System.out.println(generateSerialNumber());
		}
	}
	
	public static int generateSerialNumber() {
		return nextSerialNumber++;
	}
	
	private static long generateSerialNumberAtomic() {
		return nextSerialNum.getAndIncrement();
	}
	
	
}