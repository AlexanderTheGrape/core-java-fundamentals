import java.awt.event.ActionListener; // awt = abstract window toolkit
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.time.Instant;
import javax.swing.Timer;
import javax.swing.JOptionPane;

class Minion extends Person implements ActionListener {
	
	int secondsToSendAwayFor;
	
	public Minion(String name, int secondsToSendAwayFor) {
		super(name);
		this.secondsToSendAwayFor = secondsToSendAwayFor;
	}
	
	public void goAwayMinion() {
		Timer t = new Timer(secondsToSendAwayFor*1000, this);
		t.start();
		
		// keep program running until the user selects "OK"
		JOptionPane.showMessageDialog(null, "I'm back! Exit?");
		
		System.exit(0);
	}
	
	public String getDescription() {
		return "A minion with the name " + super.getName();
	}
	
	public void actionPerformed(ActionEvent event) {
		System.out.println("BEEP!");
		System.out.println("At the beep, the time is " + Instant.ofEpochMilli(event.getWhen()));
		Toolkit.getDefaultToolkit().beep();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Program started");
		var johnnyMinion = new Minion("Johnny", 3);
		johnnyMinion.goAwayMinion();
	}
}