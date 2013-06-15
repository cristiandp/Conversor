package conversion.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



@SuppressWarnings("serial")
public class GuiNoHilo extends JFrame implements ActionListener{
	
	
	
	int width = 700;  //Ancho
	int height = 300; //Alto
	Dimension d= new Dimension(width,height);	//Para el minimunSize
	
	JPanel optionGroup,			//|--------------------------|
		optionGroup2;			//|                          |
	JButton button;				//|							 |
	JTextField input,output1,	//|							 |	
		output2,output3,		//|							 |
		output4;				//|Componentes de la ventana |
	JRadioButton option1,		//|							 |
		option2,option3,		//|							 |
		option4;				//|							 |
								//|							 |
	JLabel text,convers;		//|--------------------------|
	
	GridBagConstraints g = new GridBagConstraints();	//Constantes del layout
	static String titulo ="Conversor"; //Titulo de la ventana
	
	ButtonGroup bg = new ButtonGroup();
	
	int estado;	//Estado de los Radiobuttons para los hilos

	
	double aux; //Para calculos de divisas
	
	protected static final int EUR =0;		//
	protected static final int USD =1;		//Retorna un numero dependiendo de los diferentes cambios
	protected static final int YEN =2;		//de la moneda
	protected static final int GBM =3; 		//
	
	protected static final double ETD=1.3159;
	protected static final double ETY=130.029644;
	protected static final double ETP=0.846619057;
	protected static final double DTY=98.8142292;
	protected static final double DTP=0.64337644;
	protected static final double YTP=0.00651096957;
	
	protected static final double ASD4=0;
	protected static final double ASD5=0;
	
	
	DecimalFormat formato = new DecimalFormat("##########################.##");
	
	public GuiNoHilo(){
		super(titulo);
		

		this.setLayout(new GridBagLayout());
//		this.setMinimumSize(d);
		this.setResizable(false);
		
		text = new JLabel();
		text.setText("Introduce: ");
		
		g.gridx = 0;		//posicion X
		g.gridy = 0;		//Posicion Y
		g.gridwidth = 1;	//Extension Horizontal
		g.gridheight = 1;	//Extension Vertical
		g.fill = GridBagConstraints.HORIZONTAL; //Como se rellenan las celdas
		
		add(text,g);		//Añadimos al JFrame el objeto y sus constantes
		
		input = new JTextField();
		input.setEditable(false);
		g.gridx = 1;
		g.gridy = 0;
		g.gridwidth = 2;
		g.gridheight = 1;
		g.fill =GridBagConstraints.HORIZONTAL;
		
		add(input,g);
		
		button = new JButton("Convertir");
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				
			switch (estado){
				
			case 0:
				output1.setText(formato.format(Double.parseDouble(input.getText())) + "€");
				
//				aux = Double.parseDouble(input.getText())*ETD; Estas dos 
//				output2.setText(String.valueOf(aux) + "$") ;   lineas y la siguiente son lo mismo
				
				output2.setText(formato.format(Double.parseDouble(input.getText())*ETD) + "$") ;
				output3.setText(formato.format(Double.parseDouble(input.getText())*ETY) + "¥") ;
				output4.setText(formato.format(Double.parseDouble(input.getText())*ETP) + "£") ;
				break;
				
			case 1:
				
				output1.setText(formato.format(Double.parseDouble(input.getText())/ETD) + "€") ;
				output2.setText(formato.format(Double.parseDouble(input.getText())) + "$");
				output3.setText(formato.format(Double.parseDouble(input.getText())*DTY) + "¥") ;
				output4.setText(formato.format(Double.parseDouble(input.getText())*DTP) + "£") ;
				break;
				
			case 2:
				output1.setText(formato.format(Double.parseDouble(input.getText())/ETY) + "€") ;
				output2.setText(formato.format(Double.parseDouble(input.getText())/DTY) + "$") ;
				output3.setText(formato.format(Double.parseDouble(input.getText())) + "¥");
				output4.setText(formato.format(Double.parseDouble(input.getText())*YTP) + "£") ;
				break;
			
			case 3:
				output1.setText(formato.format(Double.parseDouble(input.getText())/ETP) + "€") ;
				output2.setText(formato.format(Double.parseDouble(input.getText())/DTP) + "$") ;
				output3.setText(formato.format(Double.parseDouble(input.getText())/YTP) + "¥") ;
				output4.setText(formato.format(Double.parseDouble(input.getText())) + "£");
				break;
				
			
				}
			}
		});
		
		
		
		
		g.gridx = 2;
		g.gridy = 1;
		g.gridwidth = 1;
		g.gridheight= 1;
		g.fill = GridBagConstraints.EAST;
		
		add(button,g);
		
		
		
		//***************************Pane******************************//
		optionGroup = new JPanel();
		optionGroup.setLayout(new BorderLayout());
		optionGroup.setBorder(new TitledBorder("Input type"));
		
				option1 = new JRadioButton("Euros(€)");
				option1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						estado = EUR;
						input.setEditable(true);
						button.setEnabled(true);
					}
				});
				optionGroup.add(option1,BorderLayout.NORTH);
				
				option2 = new JRadioButton("Dolares($)");
				option2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						estado = USD;
						input.setEditable(true);
						button.setEnabled(true);
					}
				});
				optionGroup.add(option2,BorderLayout.EAST);
				
				option3 = new JRadioButton("Yens(¥)");
				option3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						estado = YEN;
						input.setEditable(true);
						button.setEnabled(true);
					}
				});
				optionGroup.add(option3,BorderLayout.WEST);
				
				option4 = new JRadioButton("Libras(£)");
				option4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						estado = GBM;
						input.setEditable(true);
						button.setEnabled(true);
					}
				});
				optionGroup.add(option4,BorderLayout.SOUTH);
				
				bg.add(option1);
				bg.add(option2);
				bg.add(option3);
				bg.add(option4);
				
		g.gridx=0;
		g.gridy=1;
		g.gridheight=3;
		g.gridwidth=2;
		g.fill=GridBagConstraints.HORIZONTAL;
		add(optionGroup,g);
				
		
		//***************************Fin Pane**************************//
		
		//***************************Pane resultado ******************************//
		optionGroup2 = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		optionGroup2.setLayout(new GridBagLayout());
		optionGroup2.setBorder(new TitledBorder("Resultado"));
		optionGroup2.setMinimumSize(new Dimension(500,500));
		
			output1 = new JTextField("0€");
			output1.setEditable(false);
			output1.setColumns(9);
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.fill= GridBagConstraints.HORIZONTAL;
			optionGroup2.add(output1,gbc);
			
			output2 = new JTextField("0$");
			output2.setEditable(false);
			output2.setColumns(9);
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.fill= GridBagConstraints.HORIZONTAL;
			optionGroup2.add(output2,gbc);
			
			
			output3 = new JTextField("0¥");
			output3.setEditable(false);
			output3.setColumns(9);
				gbc.gridx = 0;
				gbc.gridy = 1;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.fill= GridBagConstraints.HORIZONTAL;
			optionGroup2.add(output3,gbc);
				
			
			output4 = new JTextField("0£");
			output4.setEditable(false);
			output4.setColumns(9);
				gbc.gridx = 1;
				gbc.gridy = 1;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.fill= GridBagConstraints.HORIZONTAL;
			optionGroup2.add(output4,gbc);
		
			
		g.gridx = 3;
		g.gridy = 1;
		g.gridwidth = 3;
		g.gridheight = 1;
		
		add(optionGroup2,g);
		
		//***************************Fin Pane resultado**************************//
			
			
		pack(); //Compila el JFrame con todos los elementos
		
		}
	
	
		
	
	public String getInput(){
		return input.getText();
	}
	

	
	
@Override											//|---------------------------------------------------------------!
public void actionPerformed(ActionEvent e) {		//|                                                               |
	// TODO Auto-generated method stub				//|Este metodo no se utiliza ya que se usan todo clases anonimas  !
}													//|---------------------------------------------------------------!

}
