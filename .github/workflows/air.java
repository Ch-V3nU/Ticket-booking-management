import javax.swing.*;  
import java.awt.event.*;  

public class air extends JFrame implements ActionListener{  
    JLabel l;               
								//static declaration of label,tickets,textfield,progressbar,button.
     static int total=45;
     static int tickets=45;
     static JTextField tf;
     static JLabel l1,l2;
     static JProgressBar jp;
    JButton b; 
    air(){  			//constructor

        l=new JLabel("Enter no.of tickets you'd like to purchase(1-6):",SwingConstants.CENTER);    //Setting Label
        l.setBounds(30,20,375,20);  

        tf= new JTextField();
        tf.setBounds(50,60,200,30);



        b=new JButton("purchase");    //Creating Button and adding action listener to it
        b.setBounds(280,60,100,30); 
        l1=new JLabel("45 Tickets remaining.",SwingConstants.CENTER);
        l1.setBounds(90,90,210,30);
        jp=new JProgressBar();			
        jp.setValue(100);			//setting intial value to pgrogess bar.
        jp.setStringPainted(true);
        jp.setBounds(50,115,300,50);
        
        
        l2=new JLabel(" ",SwingConstants.CENTER);
        l2.setBounds(80,190,150,30);
        b.addActionListener(this); 
		
        add(l);add(tf);add(l1);add(l2);add(jp);add(b);  //adding all components to frame
        
        setSize(400,300);  //Setting Frame size and its configuration
        setLayout(null);  
        setVisible(true);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //setting close operation
    }  
    public void actionPerformed(ActionEvent e){    //This will be invoked after the button is pressed
		String s1=tf.getText();			// getting input from the text feild
		int a=Integer.parseInt(s1);		// converting string to int
		if(e.getSource()==b)
		{
			if(a>=7 || a<1 || tickets-a<0) 
			{
				JOptionPane.showMessageDialog(this,"invalid input");		//printing error
			}
			else
			{
				tickets -= a;	//decrementing remaining tickets
			}
			if(tickets==0)
			l2.setText("event sold out");		// if all tickets are sold
		}
		String r=String.valueOf(tickets);
		l1.setText(r+" Tickets remaining.");
		System.out.println(tickets+"\t"+total);
		int value = (int)(((float)tickets/(float)total)*100);	//changing the progress bar
        jp.setValue(value);
        tf.setText("");
        
    } 

    public static void main(String[] args) {  
        new air();    //Calling class
    }  
} 
