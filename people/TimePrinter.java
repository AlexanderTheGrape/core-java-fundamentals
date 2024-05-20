import java.awt.event.ActionListener; // awt = abstract window toolkit
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.time.Instant;
import javax.swing.Timer;
import javax.swing.JOptionPane;

class TimePrinter implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		System.out.println(" At the tone, the time is " + Instant.ofEpochMilli( event.getWhen()));
		Toolkit.getDefaultToolkit().beep();
	}
	
	public static void main(String[] args) {
		var listener = new TimePrinter();
		Timer t = new Timer(1000, listener);
		//t.start();
		
		Timer t2 = new Timer(1000, event -> {
			System.out.println(" At the tone, the time is " + Instant.ofEpochMilli( event.getWhen()));
			Toolkit.getDefaultToolkit().beep();
		});
		t2.start();
		
		// keep program running until the user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		
		System.exit(0);
	}
}