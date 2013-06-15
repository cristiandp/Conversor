package conversion.hilos;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import conversion.gui.GuiConHilos;


public class calculo extends Thread {
	int estado;
	String text;
	DecimalFormat formato = new DecimalFormat("##########################.##");
	
	public void run(){
		try{
		while(true){
			
		
		text = GuiConHilos.input.getText();
		estado = GuiConHilos.getEstado();
		switch (estado){
		
		case 0:
			GuiConHilos.output1.setText(formato.format(Double.parseDouble(GuiConHilos.input.getText())) + "€");
			
//			aux = Double.parseDouble(input.getText())*ETD; Estas dos 
//			output2.setText(String.valueOf(aux) + "$") ;   lineas y la siguiente son lo mismo
			
			GuiConHilos.output2.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())*GuiConHilos.ETD) + "$") ;
			GuiConHilos.output3.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())*GuiConHilos.ETY) + "¥") ;
			GuiConHilos.output4.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())*GuiConHilos.ETP) + "£") ;
		
			break;
			
		case 1:
			GuiConHilos.output1.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())/GuiConHilos.ETD) + "€") ;
			GuiConHilos.output2.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())) + "$");
			GuiConHilos.output3.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())*GuiConHilos.DTY) + "¥") ;
			GuiConHilos.output4.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())*GuiConHilos.DTP) + "£") ;
			
			
			break;
		case 2:
			GuiConHilos.output1.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())/GuiConHilos.ETY) + "€") ;
			GuiConHilos.output2.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())/GuiConHilos.DTY) + "$") ;
			GuiConHilos.output3.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())) + "¥");
			GuiConHilos.output4.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())*GuiConHilos.YTP) + "£") ;
			
			break;
		
		case 3:
			GuiConHilos.output1.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())/GuiConHilos.ETP) + "€") ;
			GuiConHilos.output2.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())/GuiConHilos.DTP) + "$") ;
			GuiConHilos.output3.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())/GuiConHilos.YTP) + "¥") ;
			GuiConHilos.output4.setText(formato.format(Double.parseDouble(	GuiConHilos.input.getText())) + "£");
			
			break;
			
		
			}
		
		}
		}finally{
			try{
//				GuiConHilos.output1.setText("0");
//				GuiConHilos.output2.setText("0" );
//				GuiConHilos.output3.setText("0");
//				GuiConHilos.output4.setText("0");
				GuiConHilos.input.setText("0");
				Thread.sleep(10);
				run();
			} catch (InterruptedException e) {
				
			}
			
			
		}
	}
	}
	




