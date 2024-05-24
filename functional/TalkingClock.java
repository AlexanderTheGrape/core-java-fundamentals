import java.awt.event.ActionListener; // awt = abstract window toolkit
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.time.Instant;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.util.ArrayList;

class TalkingClock {
	boolean shouldTalk;
	TimePrinter timePrinter;
	
	TalkingClock(boolean shouldTalk){
		this.shouldTalk = shouldTalk;
		timePrinter = new TimePrinter();
	}
	
	void startUsingAnonInnerClass() {
		// This line creates a new object of an anonymous class that implements the ActionListener interface, where the required
		// method actionPerformed is the one defined inside the braces { }.
		var listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(" At the tone, the time is " + Instant.ofEpochMilli( event.getWhen()));
				if (TalkingClock.this.shouldTalk) Toolkit.getDefaultToolkit().beep();
				
				System.out.println("Anon class is: " + new Object(){}.getClass().getEnclosingClass().toString());
				System.out.println("Anon class is: " + new Object(){}.getClass().getEnclosingClass().getName());
			}
		};
		System.out.println(listener);
		Timer timer = new Timer(1000, listener::actionPerformed);
		timer.start();
	}
	
	public void invite(ArrayList attendees) {
		attendees.forEach(attendee -> System.out.println(attendee));
	}
	
	void start() {
		class TimePrinter implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.out.println(" At the tone, the time is " + Instant.ofEpochMilli( event.getWhen()));
				if (TalkingClock.this.shouldTalk) Toolkit.getDefaultToolkit().beep();
			}
		}
		
		TimePrinter timePrinter = new TimePrinter();
		Timer timer = new Timer(1000, timePrinter::actionPerformed);
		timer.start();
	}
	
	public static void main(String[] args) {
		TalkingClock talkingClock = new TalkingClock(true);
		//Timer t3 = new Timer(1000, talkingClock.timePrinter::actionPerformed);
		//t3.start();
		
		//talkingClock.start();
		talkingClock.startUsingAnonInnerClass();
		
		// double brace initialisatoin. Tricky and rarely useful. Outer braces make an anonymous
		// subclass of ArrayList. The inner braces are an object initialization block.
		talkingClock.invite(new ArrayList<String>() {{ add("Harry"); add("Juliet"); }});
		
		// keep program running until the user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
	
	
}