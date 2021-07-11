import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class BMI extends JFrame{

	private static final int Width=400;
	private static final int Height=300;

	private JLabel heightL,feetL,inchesL,weightL,poundL,bmiL,categoryL;
	private JTextField heightTF,feetTF,inchesTF,weighTF,poundTF,bmiTF,categoryTF;
	private JButton computeB,resetB;
	private ComputeButtonHandler cbHandler;
	private ResetButtonHandler rbHandler;
	private JLabel spaceH,spaceW,spaceC;

	public BMI()
	{
		heightL=new JLabel("Your Height",SwingConstants.LEFT);
		spaceH=new JLabel("");
		feetL=new JLabel("Feet:",SwingConstants.RIGHT);
		inchesL=new JLabel("Inches:",SwingConstants.RIGHT);
		spaceW=new JLabel("");
		weightL=new JLabel("Your weight",SwingConstants.LEFT);
		poundL=new JLabel("Pounds:",SwingConstants.RIGHT);
		bmiL=new JLabel ("Your BMI:",SwingConstants.RIGHT);
		categoryL=new JLabel("Your Category:",SwingConstants.RIGHT);

		heightTF=new JTextField(10);
		feetTF=new JTextField(10);
		inchesTF=new JTextField(10);
		weighTF=new JTextField(10);
		poundTF=new JTextField(10);
		bmiTF=new JTextField(10);
		categoryTF=new JTextField(10);

		computeB=new JButton("Compute BMI");
		resetB=new JButton("Reset");

		cbHandler=new ComputeButtonHandler();
		computeB.addActionListener(cbHandler);

		rbHandler=new ResetButtonHandler();
		resetB.addActionListener(rbHandler);

		Container box=getContentPane();
		box.setLayout(new GridLayout(8,2,5,5));

		box.add(heightL);
		box.add(spaceH);
		box.add(feetL);
		box.add(feetTF);
		box.add(inchesL);
		box.add(inchesTF);
		box.add(weightL);
		box.add(spaceW);
		box.add(poundL);
		box.add(poundTF);
		box.add(computeB);
		box.add(resetB);
		box.add(bmiL);
		box.add(bmiTF);
		box.add(categoryL);
		box.add(categoryTF);

		setTitle("Calculate your BMI");
		setBounds(50,50,Height,Width);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

		private class ComputeButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{

				double feet,inches,pound=0,bmi;
				DecimalFormat df=new DecimalFormat("#,##");

				feet=Double.parseDouble(feetTF.getText());
				inches=Double.parseDouble(inchesTF.getText());
				pound=Double.parseDouble(poundTF.getText());
				inches=(feet*12)+inches;
				bmi=pound/(inches*inches)*703;
				bmiTF.setText(""+df.format(bmi));

				if (bmi<18.5)
				{categoryTF.setText("Underweight");
				}
				else if (bmi>=18.5&&bmi<29.9)
				{
					categoryTF.setText("Normal");

				}
				else if(bmi>=25&&bmi<29.9)
				{
					categoryTF.setText("Overweight");

				}
				else if(bmi>29.9)
				{
					categoryTF.setText("Obesity");
				}
			}
		
			
		}
		
		private class ResetButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				feetTF.setText("");
				inchesTF.setText("");
				poundTF.setText("");
				bmiTF.setText("");
				categoryTF.setText("");
			}
		}

}

	


