package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Cal extends JFrame
{
	Container c;
	JLabel lblNumber,lblAnswer;
	JButton btnAnswer;
	JTextField txtNumber;

	Cal()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		lblNumber= new JLabel("Enter a Number");
		lblAnswer= new JLabel("");
		btnAnswer= new JButton("Answer");
		txtNumber= new JTextField(5);

		c.add(lblNumber);
		c.add(txtNumber);
		c.add(btnAnswer);
		c.add(lblAnswer);

		btnAnswer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					double num= Double.parseDouble(txtNumber.getText());
					double res=num*num;
					lblAnswer.setText("Square="+res);
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(c,"Wrong Input.Enter a Number");
					txtNumber.setText("");
					lblAnswer.setText("");
					txtNumber.requestFocus();		
				}
			}
		});


	}

	public static void main(String args[])
	{
		Cal c = new Cal();
		c.setSize(250,150);
		c.setTitle("Calculator");
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLocationRelativeTo(null);
		c.setVisible(true);
	}
}