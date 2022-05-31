

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskPanel extends JPanel implements MouseMotionListener, MouseListener {
	
	public static ArrayList<String> data = new ArrayList<>();
	
	int x =490;
	int y =490;
	Timestamp timestamp;
	
	public TaskPanel() {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		String startTimeSt = startTime.toString()+ "$\n";
		
		data.add(startTimeSt);
	}
	
	public void paint(Graphics g) {
				
		super.paint(g);
		super.setBackground(Color.white);
		
		this.setLayout(new BorderLayout());

		JLabel text1 = new JLabel("Excited");
		text1.setFont(new Font("Helvetica", Font.BOLD, 30));
		this.add(text1, BorderLayout.EAST);
		
		JLabel text2 = new JLabel("Calm");
		text2.setFont(new Font("Helvetica", Font.BOLD, 30));
		this.add(text2, BorderLayout.WEST);
		
		JLabel text3 = new JLabel("Happy");
		text3.setFont(new Font("Helvetica", Font.BOLD, 30));
		text3.setHorizontalAlignment(JLabel.CENTER);
		this.add(text3, BorderLayout.NORTH);
		
		JLabel text4 = new JLabel("Sad");
		text4.setFont(new Font("Helvetica", Font.BOLD, 30));
		text4.setHorizontalAlignment(JLabel.CENTER);
		this.add(text4, BorderLayout.SOUTH);
		
		g.fillOval(x, y, 20, 20);
		g.setColor(Color.black);
		
		//draw X-axis
		g.drawLine(500, 0, 500, 1000);
		//draw markers on X-axis
			for(int i=0;i<=1000;i=i+10) {
				g.drawLine(495, i, 505, i);
			}	
			for(int i=0;i<=1000;i=i+50) {
				g.drawLine(490, i, 510, i);
			}		
			for(int i=0;i<=1000;i=i+100) {
				g.drawLine(480, i, 520, i);
			}
		
		//draw Y-axis
		g.drawLine(0, 500, 1000, 500);
		//draw markers on X-axis
			for(int i=0;i<=1000;i=i+10) {
				g.drawLine(i, 495, i, 505);
			}	
			for(int i=0;i<=1000;i=i+50) {
				g.drawLine(i, 490, i, 510);
			}		
			for(int i=0;i<=1000;i=i+100) {
				g.drawLine(i, 480, i, 520);
			}
		
	}

	public void DataCreator(double X, double Y, Timestamp timestamp) throws InterruptedException{
		
		String dataString = Double.toString(X-500) + "," + Double.toString(Y-500) + "," + timestamp + "\n";
	
		data.add(dataString);	
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		timestamp = new Timestamp(System.currentTimeMillis());	
		x = e.getX() - 10;
		y = e.getY() - 10;
		
		int xCoor = e.getX() - 500;
		int yCoor = e.getY() - 500;
		
		System.out.println("X: " + xCoor + ", Y: " + yCoor + ", at " + timestamp);
		
		try {
			DataCreator(x,y,timestamp);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
					
		removeAll();
		revalidate();
		repaint();	
		
		JLabel text1 = new JLabel("Excited");
		text1.setFont(new Font("Helvetica", Font.BOLD, 30));
		this.add(text1, BorderLayout.EAST);
		
		JLabel text2 = new JLabel("Calm");
		text2.setFont(new Font("Helvetica", Font.BOLD, 30));
		this.add(text2, BorderLayout.WEST);
		
		JLabel text3 = new JLabel("Happy");
		text3.setFont(new Font("Helvetica", Font.BOLD, 30));
		text3.setHorizontalAlignment(JLabel.CENTER);
		this.add(text3, BorderLayout.NORTH);
		
		JLabel text4 = new JLabel("Sad");
		text4.setFont(new Font("Helvetica", Font.BOLD, 30));
		text4.setHorizontalAlignment(JLabel.CENTER);
		this.add(text4, BorderLayout.SOUTH);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		timestamp = new Timestamp(System.currentTimeMillis());	
		x = e.getX() - 10;
		y = e.getY() - 10;
		
		int xCoor = e.getX() - 500;
		int yCoor = e.getY() - 500;
		
		System.out.println("X: " + xCoor + ", Y: " + yCoor + ", at " + timestamp);
		
		try {
			DataCreator(x,y,timestamp);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
					
		removeAll();
		revalidate();
		repaint();	
		
		JLabel text1 = new JLabel("Excited");
		text1.setFont(new Font("Helvetica", Font.BOLD, 30));
		this.add(text1, BorderLayout.EAST);
		
		JLabel text2 = new JLabel("Calm");
		text2.setFont(new Font("Helvetica", Font.BOLD, 30));
		this.add(text2, BorderLayout.WEST);
		
		JLabel text3 = new JLabel("Happy");
		text3.setFont(new Font("Helvetica", Font.BOLD, 30));
		text3.setHorizontalAlignment(JLabel.CENTER);
		this.add(text3, BorderLayout.NORTH);
		
		JLabel text4 = new JLabel("Sad");
		text4.setFont(new Font("Helvetica", Font.BOLD, 30));
		text4.setHorizontalAlignment(JLabel.CENTER);
		this.add(text4, BorderLayout.SOUTH);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

	@Override
	public void mouseMoved(MouseEvent e) {	
	}
	
}