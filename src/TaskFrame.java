

import javax.swing.JFrame;

public class TaskFrame extends JFrame {

	TaskFrame(int track){
		
		this.setTitle("Track 0" + track + " task pad");
		this.setSize(1017,1040);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setContentPane(new TaskPanel());
		
		this.setVisible(true);	
		
		if(MyFrame.trackDone==true) {
			this.setVisible(false);
		}
	}
}

