package conversion.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModeSelector extends JFrame implements ActionListener{
	
	ImageIcon question = new ImageIcon(this.getClass().getResource("/conversion/images/question.png"));
	JLabel label;
	JPanel panel;
	JButton button;
	
	static String nombre="Selector";
	int modo;
	
	public ModeSelector() {
		super(nombre);
		GridBagConstraints g = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setResizable(false);
		
		
		label = new JLabel();
		label.setIcon(question);
		
		g.gridx=0;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=2;
		g.fill = GridBagConstraints.HORIZONTAL;
		
		add(label,g);
		
		
		label = new JLabel("Selecciona el tipo de ejecucion");
		
		g.gridx=1;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.fill = GridBagConstraints.HORIZONTAL;
		
		add(label,g);
		
		
		
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
			
			button = new JButton("Con hilos");
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					modo = 1;
					
					
				}
			});
			panel.add(button);
			
			button = new JButton("Sin hilos");
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					modo = 2;
					
				}
			});
			panel.add(button);
		
		g.gridx=1;
		g.gridy=1;
		g.gridwidth=2;
		g.gridheight=1;
		g.fill = GridBagConstraints.HORIZONTAL;
		
		add(panel,g);
		
		pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getModo(){
		return modo;
	}

}
