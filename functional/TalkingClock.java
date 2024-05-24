import java.awt.event.ActionListener; // awt = abstract window toolkit
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.time.Instant;
import javax.swing.Timer;
import javax.swing.JOptionPane;

class TalkingClock {
	boolean shouldTalk;
	TimePrinter timePrinter;
	
	TalkingClock(boolean shouldTalk){
		this.shouldTalk = shouldTalk;
		timePrinter = new TimePrinter();
	}
	
	public class TimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println(" At the tone, the time is " + Instant.ofEpochMilli( event.getWhen()));
			if (TalkingClock.this.shouldTalk) Toolkit.getDefaultToolkit().beep();
		}
	}
	
	public static void main(String[] args) {
		TalkingClock talkingClock = new TalkingClock(true);
		Timer t3 = new Timer(1000, talkingClock.timePrinter::actionPerformed);
		t3.start();
		
		// keep program running until the user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
	
	
}