import java.net.URL;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ResourceTest {

	public static void main(String[] args) {
		try {
			Class cl = ResourceTest.class;
			URL tacoCloudImageURL = cl.getResource("taco_cloud_alex.PNG");
			var icon = new ImageIcon(tacoCloudImageURL);
			
			InputStream stream = cl.getResourceAsStream("testTextFile.txt");
			var alexStory = new String(stream.readAllBytes(), "UTF-8").trim();
			
			stream = cl.getResourceAsStream("title.txt");
			var title = new String(stream.readAllBytes(), StandardCharsets.UTF_8).trim();
			
			JOptionPane.showMessageDialog(null, alexStory, title, JOptionPane.INFORMATION_MESSAGE, icon);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}