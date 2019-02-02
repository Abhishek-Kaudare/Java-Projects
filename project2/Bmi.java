	package p2;

	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.text.*;

	class Bmi extends JFrame
	{

		Container c;
		JLabel lblWeight,lblHeight, lblAnswer;
		JButton btnSubmit;
		JTextField txtWeight,txtFeet,txtInch;
		JPanel p1,p2,p3,p4;

		Bmi()
		{
			c=getContentPane();
			c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));


			p1= new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblWeight = new JLabel("Enter Weight In Kgs");
			txtWeight=new JTextField(6);
			p1.add(lblWeight);
			p1.add(txtWeight);
			c.add(p1);


			p2= new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblHeight = new JLabel("Enter Height In Feet And Inches");
			txtFeet=new JTextField(2);
			txtInch=new JTextField(4);
			p2.add(lblHeight);
			p2.add(txtFeet);
			p2.add(txtInch);
			c.add(p2);

			p3= new JPanel();
			btnSubmit = new JButton("Submit");
			p3.add(btnSubmit);
			c.add(p3);

			p4= new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblAnswer = new JLabel("");
			p4.add(lblAnswer);
			c.add(p4);

			btnSubmit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					try
					{
						double weight= Double.parseDouble(txtWeight.getText());
						int feet= Integer.parseInt(txtFeet.getText());
						int inch= Integer.parseInt(txtInch.getText());
						while(feet>0)
						{
							inch=inch+12;
							feet--;
						}
						double height = inch *0.0254;
						double bmi = weight/(height*height);
						NumberFormat nf = NumberFormat.getInstance();
						nf.setMaximumFractionDigits(2);
						String bmis= nf.format(bmi);
						String msg="";
						if(bmi<18.5)msg="Underweight";
						if(bmi>=18.5 && bmi<25 )msg="Normal";
						if(bmi>=25 && bmi<30)msg="Overweight";
						if(bmi>=30)msg="Obese";
						JOptionPane.showMessageDialog(c,"BMI="+ bmis +"\nYou are "+msg);
						lblAnswer.setText("BMI="+ bmis +"\nYou are "+msg);
					}
					catch(NumberFormatException e)
					{

					}
				}
			});
		}

		public static void main(String args[])
		{
			Bmi c = new Bmi();
			c.setSize(300,200);
			c.setTitle("Bmi Calculator");
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			c.setLocationRelativeTo(null);
			c.setVisible(true);
		}

	}