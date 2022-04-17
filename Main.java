package oopBD_SilviqDancheva;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			     myFrame frame = new myFrame();
			    
			}
		});
		
   /* String s[]= {"country", "city", "street", "number"};
     String s1[]= {"Bulgaria", "Sofia", "Cherni Vruh", "57"};
     db.insert("adress", s, s1);
     
     db.updateCol("adress", "city", "Vratsa", 10);
     db.delete("adress", 2);
     */
	}

}
