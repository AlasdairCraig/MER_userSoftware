

import java.awt.Font;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JFrame implements Runnable {
	
	int hour,minute,second;
	JLabel timeStampLabel = new JLabel();
	
	public Clock() {
		this.setTitle("Time:");
		this.setSize(250,100);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		this.setVisible(true);

		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while(true) {
			Calendar cal = Calendar.getInstance();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String timeText =timestamp.toString();
			hour = cal.get(Calendar.HOUR_OF_DAY);
			minute = cal.get(Calendar.MINUTE);
			second = cal.get(Calendar.SECOND);
			
			SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss");
			Date date = cal.getTime();
			String time24 = sdf24.format(date);
			
			timeStampLabel.setText(timeText);
			timeStampLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
			this.setContentPane(timeStampLabel);
			
			
		}		
	}
}
