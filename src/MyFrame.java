

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrame extends JFrame implements ActionListener {
	
	//TaskPanel taskPanel = new TaskPanel();
	
	JPanel centerPane = new JPanel();
	JPanel leftPane = new JPanel();
	JPanel rightPane = new JPanel();
	JPanel topPane = new JPanel();
	JPanel bottomPane = new JPanel();
	JPanel innerTop = new JPanel();
	JPanel innerBottom = new JPanel();
	JPanel innerCenter = new JPanel();
		
	JLabel topLabel = new JLabel();
	JLabel bottomLabel = new JLabel();
	JLabel centerLabel = new JLabel();
	
	
	JTextArea textArea = new JTextArea();
	
	JButton startButton = new JButton("Start");
	JButton testButton = new JButton("Start Test");
	JButton testDoneButton = new JButton("When you have the volume set to a comfortable level, click here");
	JButton task1Button = new JButton("Start");
	JButton task2Button = new JButton("Start");
	JButton task3Button = new JButton("Start");
	JButton task4Button = new JButton("Start");
	JButton task5Button = new JButton("Start");
	JButton task6Button = new JButton("Start");
	JButton task7Button = new JButton("Start");
	JButton endButton = new JButton("End");

	
	Clip clip;
	List<URL> tracks = new ArrayList<>();
	ArrayList<String> data = TaskPanel.data;
	URL testTrackURL, track1, track2, track3, track4, track5, track6;
	
	
	public static Boolean trackDone = false;
	int trackNum;
	
	MyFrame(){
		//set up closable window with title and size
				this.setTitle("Music & Emotion: Tracker");
				this.setExtendedState(MAXIMIZED_BOTH);
				this.setResizable(false);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				this.setLayout(new BorderLayout());
				
				//add task panel
				//this.add(taskPanel, BorderLayout.CENTER);
				
				setupFrames();
				setupHome();
				sortTracks();
								
				//make everything visible last!
				this.setVisible(true);	
				
			}
	
	private void setupHome() {
		
		//setup homescreen
			topLabel.setText("Music & Mood");
			topLabel.setFont(new Font("Helvetica", Font.BOLD, 100));
			
			bottomLabel.setText("How does music affect how you feel?");
			bottomLabel.setFont(new Font("Helvetica", Font.BOLD, 50));
			
			innerTop.add(topLabel, BorderLayout.NORTH);
			innerBottom.add(bottomLabel, BorderLayout.SOUTH);
	
	}
	
	private void setupFrames() {
		
		//add panes for layout
			this.setLayout(new BorderLayout());
			
			this.add(centerPane, BorderLayout.CENTER);
			centerPane.setBackground(Color.blue);
			centerPane.setPreferredSize(new Dimension(100,100));
			
			this.add(leftPane,BorderLayout.WEST);
			leftPane.setBackground(Color.green);
			leftPane.setPreferredSize(new Dimension(100,100));

			this.add(rightPane, BorderLayout.EAST);
			rightPane.setBackground(Color.yellow);
			rightPane.setPreferredSize(new Dimension(100,100));
			
			this.add(topPane,BorderLayout.NORTH);
			topPane.setBackground(Color.red);
			topPane.setPreferredSize(new Dimension(100,100));
			
			this.add(bottomPane, BorderLayout.SOUTH);
			bottomPane.setBackground(Color.blue);
			bottomPane.setPreferredSize(new Dimension(100,100));
			
		//add panes to taskPanel
			centerPane.setLayout(new BorderLayout());
			
			centerPane.add(innerTop, BorderLayout.NORTH);
			innerTop.setBackground(Color.white);
			innerTop.setPreferredSize(new Dimension(100,200));
			
			centerPane.add(innerBottom, BorderLayout.SOUTH);
			innerBottom.setBackground(Color.white);
			innerBottom.setPreferredSize(new Dimension(100,100));
			
			centerPane.add(innerCenter, BorderLayout.CENTER);
			innerCenter.setBackground(Color.white);
			innerCenter.setPreferredSize(new Dimension(100,100));
			
			innerCenter.add(startButton, BorderLayout.CENTER);
			startButton.setFont(new Font("Helvetica", Font.BOLD, 50));
			startButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton) {
			System.out.println("Starting...");	
			loadInstructs();
			Clock clock = new Clock();
		}else if(e.getSource()==testButton) {
			try {
				loadTest();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==testDoneButton) {
			clip.stop();
			loadReady();
		}else if(e.getSource()==task1Button) {
			topLabel.setText("Take a moment, and when ready press start for the next track");
			innerBottom.remove(task1Button);
			innerBottom.add(task2Button, BorderLayout.SOUTH);
			task2Button.setFont(new Font("Helvetica", Font.BOLD, 50));
			task2Button.addActionListener(this);
			repaint();
			doTask(1);
			Clock clock = new Clock();
		}else if(e.getSource()==task2Button) {
			topLabel.setText("Take a moment, and when ready press start for the next track");
			innerBottom.remove(task2Button);
			innerBottom.add(task3Button, BorderLayout.SOUTH);
			task3Button.setFont(new Font("Helvetica", Font.BOLD, 50));
			task3Button.addActionListener(this);
			repaint();
			doTask(2);
			Clock clock = new Clock();
		}else if(e.getSource()==task3Button) {
			topLabel.setText("Take a moment, and when ready press start for the next track");
			innerBottom.remove(task3Button);
			innerBottom.add(task4Button, BorderLayout.SOUTH);
			task4Button.setFont(new Font("Helvetica", Font.BOLD, 50));
			task4Button.addActionListener(this);
			repaint();
			doTask(3);
			Clock clock = new Clock();
		}else if(e.getSource()==task4Button) {
			topLabel.setText("Take a moment, and when ready press start for the next track");
			innerBottom.remove(task4Button);
			innerBottom.add(task5Button, BorderLayout.SOUTH);
			task5Button.setFont(new Font("Helvetica", Font.BOLD, 50));
			task5Button.addActionListener(this);
			repaint();
			doTask(4);
			Clock clock = new Clock();
		}else if(e.getSource()==task5Button) {
			topLabel.setText("Take a moment, and when ready press start for the next track");
			innerBottom.remove(task5Button);
			innerBottom.add(task6Button, BorderLayout.SOUTH);
			task6Button.setFont(new Font("Helvetica", Font.BOLD, 50));
			task6Button.addActionListener(this);
			repaint();
			doTask(5);
			Clock clock = new Clock();
		}else if(e.getSource()==task6Button) {
			topLabel.setText("Take a moment, and when ready press start for the next track");
			innerBottom.remove(task6Button);
			innerBottom.add(task7Button, BorderLayout.SOUTH);
			task7Button.setFont(new Font("Helvetica", Font.BOLD, 50));
			task7Button.addActionListener(this);
			repaint();
			doTask(6);
			Clock clock = new Clock();
		}else if(e.getSource()==task7Button) {
			topLabel.setText("Thanks for taking part.");
			innerBottom.remove(task7Button);
			innerBottom.add(endButton, BorderLayout.SOUTH);
			endButton.setFont(new Font("Helvetica", Font.BOLD, 50));
			endButton.addActionListener(this);
			repaint();
			Clock clock = new Clock();
		}else if(e.getSource()==endButton) {
			dispose();
		}
	}

	private void doTask(int track) {

		TaskFrame taskFrame = new TaskFrame(track);
			
		try {
			playTrack(track);	
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clipListener(track, taskFrame);
	}
	
	private void sortTracks() {
		
		track1 = getClass().getResource("Beyonce-Love_On_Top.wav");
		track2 = getClass().getResource("Ed_Sheeran-Shape_of_You.wav");
		track3 = getClass().getResource("Stevie_Wonder-You_Are_The_Sunshine_Of_My_Life.wav");
		track4 = getClass().getResource("The_Beach_Boys-God_Only_Knows.wav");
		track5 = getClass().getResource("The_Carpenters-We_ve_Only_Just_Begun.wav");
		track6 = getClass().getResource("Talking_Heads-This_Must_Be_The_Place_Naive_Melody.wav");

		tracks.add(track1);
		tracks.add(track2);
		tracks.add(track3);
		tracks.add(track4);
		tracks.add(track5);
		tracks.add(track6);
	
		System.out.println("Track list BEFORE Shuffle: "); 
		for(int i=0; i<tracks.size(); i++) {
			System.out.println("Track " + (i + 1) + ": " + tracks.get(i));
			System.out.println();
		};
		
		Collections.shuffle(tracks);
		System.out.println();
		System.out.println("Track list AFTER Shuffle: ");
		System.out.println();
		for(int i=0; i<tracks.size(); i++) {
			System.out.println("Track " + (i + 1) + ": " + tracks.get(i));
			System.out.println();
		};
		
		//DEBUG** 
		int listSize = tracks.size();
		System.out.println("Tracklist size = " + listSize);		
	}
	
	private void playTrack(int trackNum) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(tracks.get(trackNum-1));
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	
	private void clipListener(int track, TaskFrame taskFrame)  {
		
		
		clip.addLineListener(new LineListener(){
            @Override
            
            public void update(LineEvent e) {
                if (e.getType()==LineEvent.Type.STOP){
                    synchronized(clip){
                        clip.notifyAll();
                    }
                    System.err.println("\nSTOP!");
                    taskFrame.dispose();
                    try {
						dataDump(track);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
        });
	}
	
	private void dataDump(int track) throws IOException {
		
		File csvFile = new File("results_track0" + track + ".csv");
		FileWriter out = new FileWriter(csvFile,true);		
		System.out.println("DEBUG** Data Size is: " + data.size());
		
		for(int i=0;i<data.size();i++) {
			out.append(data.get(i));	
		}		
		out.close();
		data.removeAll(data);
	}

	private void loadReady() {
		
		innerBottom.remove(testDoneButton);
		topLabel.setText("The task is about to begin. When you are ready, press \"Start\"");
		
		innerBottom.add(task1Button, BorderLayout.SOUTH);
		task1Button.setFont(new Font("Helvetica", Font.BOLD, 50));
		task1Button.addActionListener(this);
		
		repaint();
	}

	private void loadTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
			
		testTrackURL = getClass().getResource("bobTest.wav");

		AudioInputStream audioStream = AudioSystem.getAudioInputStream(testTrackURL);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
		innerCenter.remove(textArea);
		
		topLabel.setText("Please turn up volume to comfortable level");
		innerBottom.remove(testButton);
		this.repaint();
		
		innerBottom.add(testDoneButton, BorderLayout.SOUTH);
		testDoneButton.setFont(new Font("Helvetica", Font.BOLD, 50));
		testDoneButton.addActionListener(this);
					
	}

	private void loadInstructs() {
		
		//load instructions onto home panel
			topLabel.setText("Thank you for agreeing to take part....");
			topLabel.setFont(new Font("Helvetica", Font.BOLD, 50));
			bottomLabel.setText("");
			innerCenter.remove(startButton);
						
			innerBottom.add(testButton);
			testButton.setFont(new Font("Helvetica", Font.BOLD, 50));
			testButton.addActionListener(this);
			
			innerCenter.add(textArea, BorderLayout.NORTH);
			textArea.setPreferredSize(new Dimension(1000,1000));
			
			textArea.setText("\n"
					+ "On the next screen you will be asked to set the headphones at a comfortable level.\n"
					+ "\nAfter that, you will be played 6 tracks.\n"
					+ "\nDuring each track please keep your eyes open and on the screen.\n"
					+ "\nPlace the mouse marker according to how you are feeling.\n"
					+ "\nAfter the track has finished, take a second before starting the next.");
					
			textArea.setFont(new Font("Helvetica", Font.BOLD, 20));
			textArea.setLineWrap(true);
			this.repaint();		
	}	
}
