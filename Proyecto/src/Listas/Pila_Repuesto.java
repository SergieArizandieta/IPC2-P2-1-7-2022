package Listas;

import java.io.FileWriter;

import javax.swing.JOptionPane;

import objetos.Empleado;
import objetos.Repuesto;

public class Pila_Repuesto {
	Nodo_Pila_Repuesto primero;
	int contador = 0;
	public Repuesto buscado;

	String ReporteInicio = "<!DOCTYPE html><!--Declarar el tipo de cumento -->\r\n" + "<html>\r\n" + "\r\n"
			+ "<!--Encabezado-->\r\n" + "<head>\r\n"
			+ "<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n"
			+ "<meta charset=\"UTF-8\"><!--codififcaion de caracteres ñ y á-->\r\n" + "\r\n" + "\r\n"
			+ "<meta name=\"name\" content=\"Reporte\"><!--nombre de la pagina-->\r\n"
			+ "<meta name=\"description\" content=\"name\"><!--autor de la pagina-->\r\n"
			+ "<meta name=\"keywods\" content=\"uno,dos,tres\"><!--Palabras claavez para, separadas por comas-->\r\n"
			+ "<meta name=\"robots\" content=\"Index, Follow\"><!--Mejora la busqueda-->\r\n"
			+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><!--visibilidaad en diferentes pantallas -->\r\n"
			+ "\r\n" + "\r\n"
			+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\"/><!--css /estilo/tipo/ruta relativa -->\r\n"
			+ "\r\n" + "<title>Reporte</title><!--Titulo visible de la pagina-->\r\n" + "</head>\r\n" + "\r\n"
			+ "<body>\r\n" + "\r\n" + "<center><!--centra todos lo que este dentro-->\r\n" + "\r\n"
			+ "<!----tabla 1-->\r\n" + "<h6 class=\"titulos\"><b> Reporte Alumnado </b></h6>\r\n" + "";

	String Scrip = "";

	String Scrip2 = " <script>\r\n" + "  const myChart = new Chart(\r\n" + "    document.getElementById('myChart'),\r\n"
			+ "    config\r\n" + "  );\r\n" + "</script>";

	String ReporteFinal = "\r\n" + "</center>\r\n" + "\r\n" + "</body>\r\n" + "</html> " + " ";

	public Pila_Repuesto() {
		this.primero = null;
	}

	public void insert(Repuesto repuesto) {
		Nodo_Pila_Repuesto new_node = new Nodo_Pila_Repuesto(contador + 1, repuesto);
		repuesto.identificador = contador + 1;

		if (isNone()) {
			contador++;
			this.primero = new_node;
		} else {
			contador++;
			new_node.next = this.primero;
			this.primero = new_node;
		}
	}

	public Repuesto Cima() {
		return this.primero.repuesto;
	}

	public void Desapilar() {
		if (isNone() == false) {
			JOptionPane.showMessageDialog(null, "Se elimino el repuesto!");
			this.primero = this.primero.next;

		}
	}

	public void showList() {
		if (isNone() == false) {
			Nodo_Pila_Repuesto actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual.repuesto.print();
				actual = actual.next;
			}
		}
	}

	public Double Search(int data) {

		if (isNone() == false) {
			Nodo_Pila_Repuesto actual = this.primero;
			while (actual != null && actual.info != data) {
				actual = actual.next;
				if (actual == null) {

					System.out.println("No se encontro el dato: " + data);
					// JOptionPane.showMessageDialog(null, "No se encontro el repuesto!");
					return 0.0;
				}
			}
			if (actual != null && actual.info == data) {

				System.out.println("Dato encontrado: " + data);
				// JOptionPane.showMessageDialog(null, "Se encontro el repuesto!");
				actual.repuesto.print();
				actual.repuesto.existencia--;
				actual.repuesto.usado++;
				return actual.repuesto.precio;

			}
		}

		return 0.0;
	}

	public void Terminado() {
		buscado = null;

	}

	public Boolean isNone() {
		return this.primero == null;
	}

	String ReporteAsignacion = "", junto = "";

	Pila_Repuesto temporal;

	public void reporte() {

		ReporteAsignacion = "<h1>Clientes normales</h1> <!----tabla 2-->\r\n" + "<table class=\"steelBlueCols\">\r\n"
				+ "<thead>\r\n"
				+ "   <tr> <th>Nombre</th> <th>Marca</th> <th> Modelo</th> <th> Existencia</th> <th> precio</th></tr>\r\n"
				+ "</thead>\r\n" + "<tbody>\r\n" + "\r\n" + "<tr>";
		temporal = new Pila_Repuesto();
		
		if (isNone() == false) {
			Nodo_Pila_Repuesto actual = this.primero;
			while (actual != null) {
				temporal.insert(actual.repuesto);
				actual = actual.next;
			}
		}

		BubbleSort(temporal);
		System.out.println("NUEVO--------------------------");
		temporal.showList();
		

		if (isNone() == false) {
			Nodo_Pila_Repuesto actual = temporal.primero;
			while (actual != null) {
				ReporteAsignacion += "<td>" + String.valueOf(actual.repuesto.nombre) + "</td>";
				ReporteAsignacion += "<td>" + String.valueOf(actual.repuesto.marca) + "</td>";
				ReporteAsignacion += "<td>" + String.valueOf(actual.repuesto.modelo) + "</td>";
				ReporteAsignacion += "<td>" + String.valueOf(actual.repuesto.existencia) + "</td>";
				ReporteAsignacion += "<td>" + String.valueOf(actual.repuesto.precio) + "</td>";
				ReporteAsignacion += "</tr> \n <tr>";
				actual = actual.next;
			}
		}

		ReporteAsignacion += "</tr></tbody></table> <br><br>";

		junto += ReporteAsignacion + "\n <br> <div>\r\n" + "  <canvas id=\"myChart\"></canvas>\r\n" + "</div>";

		Scrip = " <script>\r\n" + "  const labels = [\r\n";

		


		Nodo_Pila_Repuesto actual = temporal.primero;

		for (int i = 0; i < 10; i++) {
			if (actual != null) {
				Scrip += "\"" + actual.repuesto.nombre + "\"" + ",\n";

				actual = actual.next;
			}

		}

		Scrip += "  ];\r\n" + "\r\n" + "  const data = {\r\n" + "    labels: labels,\r\n" + "    datasets: [{\r\n"
				+ "      label: 'Grafico',\r\n" + "      backgroundColor: 'rgb(255, 99, 132)',\r\n"
				+ "      borderColor: 'rgb(255, 99, 132)',\r\n";

		actual = temporal.primero;
		Scrip += "      data: [";
		for (int i = 0; i < 10; i++) {
			if (actual != null) {
				if (i == 9) {
					Scrip += String.valueOf(actual.repuesto.precio);
				} else {
					Scrip += String.valueOf(actual.repuesto.precio) + ",";
				}

				actual = actual.next;
			}

		}

		Scrip += "],\r\n";

		Scrip += "    }]\r\n" + "  };\r\n" + "\r\n" + "  const config = {\r\n" + "    type: 'bar',\r\n"
				+ "    data: data,\r\n" + "    options: {}\r\n" + "  };\r\n" + "</script>";
	}

	public void BubbleSort(Pila_Repuesto temporal2) {

		while (true) {
			Nodo_Pila_Repuesto actual = temporal2.primero;
			Nodo_Pila_Repuesto i = null; // anterior
			Nodo_Pila_Repuesto j = temporal2.primero.next; // siguiente
			boolean cambio = false;
			while (j != null) {
				if (actual.repuesto.precio < j.repuesto.precio) {
					cambio = true;
					if (i != null) {
						Nodo_Pila_Repuesto tmp = j.next;
						i.next = j;
						j.next = actual;
						actual.next = tmp;
					} else {
						Nodo_Pila_Repuesto tmp2 = j.next;
						temporal2.primero = j;
						j.next = actual;
						actual.next = tmp2;
					}

					i = j;
					j = actual.next;
				} else {
					i = actual;
					actual = j;
					j = j.next;
				}
			}
			if (!cambio) {
				break;
			}

		}

	}

	public void ReporteMostrar() {

		try {

			FileWriter archivo = new FileWriter("Reportes/Repuestos.html");
			archivo.write(ReporteInicio + junto + Scrip + Scrip2 + ReporteFinal);
			archivo.close();

		} catch (Exception e) {

		}

	}

}

class Nodo_Pila_Repuesto {

	Nodo_Pila_Repuesto next;
	int info;
	public Repuesto repuesto;

	public Nodo_Pila_Repuesto(int info, Repuesto repuesto) {
		this.next = null;
		this.info = info;
		this.repuesto = repuesto;
	}
}
