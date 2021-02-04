import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// make a three by three bingo 
// use random to make the three by three
// maybe ask for name and make a congratulations panel if they win
// make the disabled if selected, maybe have a reset button to enable all buttons
// when button is pressed, show panel with the given word and the selected phrase
// give a cancel and an okay button on that panel ^
// when okay is pressed, another word is given.

public class bingo extends JFrame {   
	
	  // There are 33 sight words, increase
	
	 private String[] key = new String[] {"down", "saw", "they", "that", "this", "has", "did", "not", "where", "went", "be", "when",
			 							  "had", "who", "with", "get", "as", "his", "of", "her", "put", "out", "him", "ball", "wear",
			 							  "say", "come", "have", "look", "all", "will", "wait", "was", "were", "by"};
	 
	 private JButton[] q = new JButton[] {
			 new JButton("The dog fell ____."),             // down
			 new JButton("Hanson ___ Liam read."),          // saw
			 new JButton("I love animals, ____ are cool."), // they
			 
			 new JButton("What is ____ over there?"),       // that
			 new JButton("I have ____ in my hand."),        // this
			 new JButton("Liam ___ one brother."),          // has
			 
			 new JButton("Someone ___ something good."),    // did
			 new JButton("I do ___ like the dark."),        // not
			 new JButton("_____ is the cat, I can't find it?"), // where
			 
			 new JButton("Yesterday, he ____ to the park."), // went
			 new JButton("I want to __ a superhero."),       // be
			 new JButton("____ do you do your homework?"),   // when
			  
			 new JButton("Yesterday, I ___ a great time."),   // had
			 new JButton("___ are you?"),                    // who
			 new JButton("I go to school ____ my friends."),   // with
			 
			 new JButton("Can you ___ that for me?"),         // get
			 new JButton("__ I was running, I saw birds."), // as
			 new JButton("Bob likes ___ toy car."),          // his
			 
			 new JButton("The cup is full __ water."),       // of
			 new JButton("Sophia walks ___ dogs."),          // her
			 new JButton("Can you ___ that away?"),          // put
			 
			 new JButton("We took the toys ___ of the box."),       // out
			 new JButton("Jake fell down, so I gave ___ a band-aid."),   // him
			 new JButton("The ____ is round and bouncy."),   // ball
			 
			 new JButton("When it is cold, ____ a jacket."),   // wear
			 new JButton("Remember to ___ please!"),         // say
			 new JButton("Why can't they ____ over?"),       // come
			 
			 new JButton("I ____ lots of food right now."),   // have
			 new JButton("I see blue when I ____ at the sky. "),   // look
			 new JButton("I like to play ___ the time."),   // all
			  
			 new JButton("He ____ water the plants."),   // will
			 new JButton("Tom needs to ____ for his turn."),   // wait
			 new JButton("I thought she ___ here already."),   // was
			 
			 new JButton("They ____ outside last week."), // were
			 new JButton("This book was __ Liam") // by
			 };
	 
	
	  JPanel panel1 = new JPanel(); 
	  ClickListener cl = new ClickListener(); //clicking the phrase
	  CheckListener l = new CheckListener();  //clicking okay and cancel

	  Random rand = new Random();  
	  
	  //initializing lists
	  int[] nums = new int[9];
	  JButton[] chosen = new JButton[9];
	  String[] chosenKey = new String[9];
	  int[] used = new int[9];
	  JLabel word = new JLabel(newWord());
	  JButton okay = new JButton("Okay");
	  JButton cancel = new JButton("Cancel");
	  JButton start = new JButton("Start");
	  JButton restart = new JButton("Restart");
	  
	  //constructor
	  public bingo() {
	    this.setSize(1000, 1000); // size of the frame
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("Sight Words Bingo");  
		    
  
	    panel1.setLayout(null);

	    // default numUsed
	    
	    for(int i = 0; i < 9; i++) {
	    	used[i] = -1;
	    }
	    
	    // choosing the phrases
	    for (int i = 0; i < 9; i++) {
	    	int x = rand.nextInt(35);
	    	if(q[x] == null)
	    		i--;
	    	else {
	    		chosen[i] = q[x];
	    		q[x] = null;
	    		nums[i] = x;
	    	}
	    }
	    
	    // making the key
	    for(int i = 0; i < 9; i++) {
	    	chosenKey[i] = key[nums[i]]; 
	    }
	       
	    // new word shown
	    word.setFont(new Font("times new roman", Font.PLAIN, 56));
	    word.setBounds(445,50,150,150);
	    
	    // check text
	    
	    check.setFont(new Font("times new roman", Font.PLAIN, 30));
	    check.setBounds(980,50,850,450);
	    
	    // start button
	    start.setFont(new Font("SansSerif Bold", Font.PLAIN, 40));
	    
	    
	    // setup bingo format buttons
	    for(int i = 0; i < 9; i++) {
	    	chosen[i].addActionListener(cl);
	    }
	    
	    int w = 300, h = 200;
	    for(int i = 0, x = 40, y = 230; i < 9; i++) {
	    	if(i%3 == 0 && i != 0) {
	    		y += 200;
	    		x = 40;
	    	}
	    	chosen[i].setBounds(x, y, w, h);
	    	x += 300;
	    }

	    for(int i = 0; i < 9; i++) {
	    	panel1.add(chosen[i]);
	    }
	    
		okay.setBounds(1100, 700, 100, 100);
		cancel.setBounds(1300, 700, 100, 100);
	    start.setBounds(445,50,150,100);
	    restart.setBounds(80, 100, 200, 50);
		okay.setVisible(false);
		cancel.setVisible(false);
		
		restart.addActionListener(l);
		okay.addActionListener(l);
		cancel.addActionListener(l);
	    start.addActionListener(l);
	    
		//adding button to the panel
	    panel1.add(restart);
		panel1.add(start);
		panel1.add(check);
	    panel1.add(word);
	    panel1.add(okay);
	    panel1.add(cancel);
	    this.add(panel1); //add panel to Frame
	    this.setVisible(true); //make JFrame visible
	    
	  }
	  
	  
	  public String newWord() {
		  	
		  	int x = rand.nextInt(9);
		  	
		  	for (int i = 0; i < 9; i ++) {
		  		if (x == used[i])
		  			return newWord();
		  	}
	    	
		  	for (int j = 0; j < 9; j++) {
		  		if(-1 == used[j]) {
		  			used[j] = x;
		  			break;
		  		}
		  	}
		  	
	    	return chosenKey[x];
	    }
	  
	  public static void main(String[] args) {
			new bingo();
		 
		}

	  
	  // check if confirmed
	  
	  boolean confirmed = false, reset = false;
	  JLabel check = new JLabel();
	  // for the phrases and check
	  private class ClickListener implements ActionListener { 

		    public void actionPerformed(ActionEvent e) {
		    	String button = (String)((AbstractButton)e.getSource()).getText();
		    	if(button.indexOf("_") == 0)
		    		check.setText(word.getText() + button.substring(button.indexOf("_ ") + 1) );
		    	else if(button.substring(button.length()-2).equals("_."))
		    		check.setText(button.substring(0, button.indexOf(" _")) + " " + word.getText() + ".");
		    	else
		    		check.setText(button.substring(0, button.indexOf(" _")) + " " + word.getText() + button.substring(button.indexOf("_ ") + 1) );
		    	okay.setVisible(true);
				cancel.setVisible(true);
				
				if(confirmed) {
					((Component) e.getSource()).setEnabled(false);
					confirmed = false;
				}
				if(reset) {
					((Component) e.getSource()).setEnabled(true);
					reset = false;
				}
		    	
		    }
	    
	  }
	  
      // to confirm the answer
	  private class CheckListener implements ActionListener {
		  
		  public void actionPerformed(ActionEvent e) {
			  
			  	if(e.getSource() == restart) {
			  		dispose();
			  		new bingo();
			  	}
			  	if(e.getSource() == start) {
			  		start.setVisible(false);
			  		word.setText(newWord());
			  	}
		    	if (e.getSource() == okay) {
		    		confirmed = true;
		    		word.setText(newWord());
		    		okay.setVisible(false);
					cancel.setVisible(false);
		    	}
		    	if (e.getSource() == cancel) {
		    		reset = true;
		    		okay.setVisible(false);
					cancel.setVisible(false);
		    	}
		    	
		  }
	  }

	  
	  
}

