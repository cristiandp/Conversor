package conversion.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import conversion.hilos.calculo;

public class GuiConHilos extends JFrame implements ActionListener {
	
	JPanel type,outputG;
	public  static JTextField input;
	
	public static int estado=0;
	public static JTextField output1;
	public static JTextField output2;
	public static JTextField output3;
	public static JTextField output4;
	JLabel text;
	JRadioButton rb;
	
	
	static String titulo="Conversor";
	ButtonGroup bg = new ButtonGroup();
	public static final double ETD=1.3159;
	public static final double ETY=130.029644;
	public static final double ETP=0.846619057;
	public static final double DTY=98.8142292;
	public static final double DTP=0.64337644;
	public static final double YTP=0.00651096957;
	
	calculo h1 = new calculo();
	

	public GuiConHilos() {
		super(titulo);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		this.setMinimumSize(new Dimension(500,250));
		
		text = new JLabel();
		text.setText("introduce un numero");
			g.gridx = 1;
			g.gridy = 0;
			g.gridheight = 1;
			g.gridwidth = 1;
			g.fill = GridBagConstraints.CENTER;
		
		add(text,g);
		
		input = new JTextField();
		input.setEditable(false);
		input.setText("0");
		input.setColumns(9);
			g.gridx = 1;
			g.gridy = 2;
			g.gridheight = 1;
			g.gridwidth = 2;
			g.fill = GridBagConstraints.HORIZONTAL;
		add(input,g);
		
		
		//****************************Type Panel*****************************
		type = new JPanel();
		type.setBorder(new TitledBorder("Input"));
		type.setLayout(new GridBagLayout());
		
			rb = new JRadioButton("Euros(€)");
			rb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					estado = 0;
					input.setEditable(true);
					
				}
			});
				g.gridx = 0;
				g.gridy = 0;
				g.gridheight = 1;
				g.gridwidth = 1;
				g.fill = GridBagConstraints.HORIZONTAL;
				bg.add(rb);
			type.add(rb,g);
		
			rb = new JRadioButton("Dolares($)");
			rb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					estado = 1;
					input.setEditable(true);
				}
			});
				g.gridx = 1;
				g.gridy = 0;
				g.gridheight = 1;
				g.gridwidth = 1;
				g.fill = GridBagConstraints.HORIZONTAL;
				bg.add(rb);
			type.add(rb,g);
		
			rb = new JRadioButton("Yens(¥)");
			rb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					estado = 2;
					input.setEditable(true);
				}
			});
				g.gridx = 0;
				g.gridy = 1;
				g.gridheight = 1;
				g.gridwidth = 1;
				g.fill = GridBagConstraints.HORIZONTAL;
				bg.add(rb);
			type.add(rb,g);
			
			rb = new JRadioButton("Libras(£)");
			rb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					estado = 3;
					input.setEditable(true);
				}
			});
				g.gridx = 1;
				g.gridy = 1;
				g.gridheight = 1;
				g.gridwidth = 1;
				g.fill = GridBagConstraints.HORIZONTAL;
				bg.add(rb);
			type.add(rb,g);
		
			
			
			
			
			g.gridx = 0;
			g.gridy = 1;
			g.gridheight = 2;
			g.gridwidth = 1;
			g.fill = GridBagConstraints.HORIZONTAL;
		add(type,g);
			
		//****************************Fin Type Panel*************************
		
		
		
		
		
		
		//****************************Type Panel*****************************
				outputG= new JPanel();
				outputG.setLayout(new GridBagLayout());
				outputG.setBorder(new TitledBorder("Resultado"));
				
					output1 = new JTextField();
					output1.setEditable(false);
					output1.setColumns(7);
						g.gridx = 0;
						g.gridy = 0;
						g.gridheight = 1;
						g.gridwidth = 1;
						g.fill = GridBagConstraints.HORIZONTAL;
						
					outputG.add(output1,g);
				
					output2 = new JTextField();
					output2.setEditable(false);
					output2.setColumns(7);
						g.gridx = 1;
						g.gridy = 0;
						g.gridheight = 1;
						g.gridwidth = 1;
						g.fill = GridBagConstraints.HORIZONTAL;
						
					outputG.add(output2,g);
			
					output3 = new JTextField();
					output3.setEditable(false);
					output3.setColumns(7);
						g.gridx = 0;
						g.gridy = 1;
						g.gridheight = 1;
						g.gridwidth = 1;
						g.fill = GridBagConstraints.HORIZONTAL;
						
					outputG.add(output3,g);
					
					output4 = new JTextField();
					output4.setEditable(false);
					output4.setColumns(7);
						g.gridx = 1;
						g.gridy = 1;
						g.gridheight = 1;
						g.gridwidth = 1;
						g.fill = GridBagConstraints.HORIZONTAL;
					
					outputG.add(output4,g);
			
					
					
					
					
					g.gridx = 3;
					g.gridy = 1;
					g.gridheight = 2;
					g.gridwidth = 1;
					g.fill = GridBagConstraints.HORIZONTAL;
				add(outputG,g);
					
				//****************************Fin Type Panel*************************
		
		
		
		
		
		
		h1.start();
		pack();
	}
	
	public static int getEstado(){
		return estado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
