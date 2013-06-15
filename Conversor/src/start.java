import javax.swing.JFrame;

import conversion.gui.*;

public class start {

	private static int modo=0;
	
	public static void main(String[] args) {
		
		
		ModeSelector  ms = new ModeSelector();
		ms.setVisible(true);
		ms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (modo == 0){
			try {
				modo=ms.getModo();
				Thread.sleep(100);
			} catch (Exception e) {
				
			}
		}
		ms.setVisible(false);
		
		if(modo == 2){
		GuiNoHilo g1 = new GuiNoHilo();
		
		g1.setVisible(true);
		g1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		else{
			GuiConHilos g2 = new GuiConHilos();
			
			g2.setVisible(true);
			g2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
	
	public void setModo(int modo){
		this.modo = modo;
	}
}
