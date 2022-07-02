package Generales;

import javax.swing.JOptionPane;

public class Generales {
    public static boolean Caracteres(String cadena) {
    	
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
            	JOptionPane.showMessageDialog(null, "Introducir solo caracteres en los nombres");
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean Numeros(String cadena) {
    	try {
			int numero = Integer.valueOf(cadena);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introducir solo numeros en los campos especificados");
			return false;
		}
    }
    
    public static boolean Numeros_Dobles(String cadena) {
    	try {
			Double numero = Double.valueOf(cadena);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introducir solo numeros en los campos especificados");
			return false;
		}
    }
}
