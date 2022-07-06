package Listas;

import java.io.FileWriter;

import objetos.Automovil;
import objetos.Cliente;

public class Circular_Doble {
	Nodo_Circular_doble primero;
	int normales,oro;

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

	String Scrip2 = " <script>\r\n"
			+ "  const myChart = new Chart(\r\n"
			+ "    document.getElementById('myChart'),\r\n"
			+ "    config\r\n"
			+ "  );\r\n"
			+ "</script>";
	
	String ReporteFinal = "\r\n" + "</center>\r\n" + "\r\n" + "</body>\r\n" + "</html> " + " ";
	
	
	public Circular_Doble() {
		this.primero = null;
		this.ultimo = null;
	}

	public void insert(Cliente cliente) {
		Nodo_Circular_doble new_node = new Nodo_Circular_doble(cliente.DPI, cliente);

		if (isNone()) {
			this.primero = new_node;
			this.ultimo = new_node;
			if (!new_node.cliente.tipo.toLowerCase().equals("oro")) {
				normales++;
			}else {
				oro++;
			}
			
		} else {
			new_node.next = this.primero.next;
			this.primero.next = new_node;

			this.ultimo.next = new_node;
			new_node.next = this.primero;
			new_node.previous = this.ultimo;
			this.ultimo = new_node;
			this.primero.previous = ultimo;
			
			if (!new_node.cliente.tipo.toLowerCase().equals("oro")) {
				normales++;
			}else {
				oro++;
			}
		}
	}

	public void showList() {
		Nodo_Circular_doble actual = this.primero;

		if (isNone() == false) {
			do {
				System.out.println(actual.info);
				actual = actual.next;
			} while (actual != this.primero);

		}

	}

	Nodo_Circular_doble ultimo;

	public Cliente Search(String data) {

		if (isNone() == false) {
			Nodo_Circular_doble actual = this.primero;
			Boolean Encontrado = true;
			do {
				if (actual.cliente.usuario.equals(data)) {
					System.out.println("Dato encontrado: " + data);
					Encontrado = false;
					return actual.cliente;

				} else {
					actual = actual.next;
				}
			} while (actual != this.primero);

			if (Encontrado) {
				System.out.println("No se encontro el dato: " + data);
				return null;
			}

		}
		return null;
	}

	public void Delete(Long data) {

		if (isNone() == false) {
			Nodo_Circular_doble actual = this.primero;
			Nodo_Circular_doble anterior = null;
			Boolean Encontrado = true;

			do {
				if (actual.info.equals(data)) {
					System.out.println("Se elimino el dato: " + data);

					if (anterior == null) {
						this.primero = this.primero.next;
						do {
							anterior = actual.next;
						} while (anterior != this.primero);
					}

					anterior.next = actual.next;
					actual.next = null;
					Encontrado = false;
					break;

				} else {
					anterior = actual;
					actual = actual.next;
				}
			} while (actual != this.primero);

			if (Encontrado) {
				System.out.println("No se encontro el dato a eliminar: " + data);
			}

		}
	}

	public Boolean isNone() {
		return this.primero == null;
	}

	String ReporteAsignacion = "", Reporte2 = "", junto = "";

	public void reporte() {

		ReporteAsignacion = "<h1>Clientes normales</h1> <!----tabla 2-->\r\n" + "<table class=\"steelBlueCols\">\r\n" + "<thead>\r\n"
				+ "   <tr> <th>DPI</th> <th>Nombre</th> <th> Usuario</th> <th> Contraseña</th> </tr>\r\n" + "</thead>\r\n"
				+ "<tbody>\r\n" + "\r\n" + "<tr>";

		Reporte2 = "<h1>Clientes Oro</h1> <!----tabla 2-->\r\n" + "<table class=\"steelBlueCols\">\r\n" + "<thead>\r\n"
				+ "   <tr> <th>DPI</th> <th>Nombre</th> <th> Usuario</th> <th> Contraseña</th> </tr>\r\n" + "</thead>\r\n"
				+ "<tbody>\r\n" + "\r\n" + "<tr>";

		Nodo_Circular_doble actual = this.primero;

		if (isNone() == false) {
			do {

				if (!actual.cliente.tipo.toLowerCase().equals("oro")) {
					
					ReporteAsignacion += "<td>" + String.valueOf(actual.cliente.DPI) + "</td>";
					ReporteAsignacion += "<td>" + String.valueOf(actual.cliente.nombre) + "</td>";
					ReporteAsignacion += "<td>" + String.valueOf(actual.cliente.usuario) + "</td>";
					ReporteAsignacion += "<td>" + String.valueOf(actual.cliente.password) + "</td>";
					ReporteAsignacion += "</tr> \n <tr>";
				} else {
					Reporte2 += "<td>" + String.valueOf(actual.cliente.DPI) + "</td>";
					Reporte2 += "<td>" + String.valueOf(actual.cliente.nombre) + "</td>";
					Reporte2 += "<td>" + String.valueOf(actual.cliente.usuario) + "</td>";
					Reporte2 += "<td>" + String.valueOf(actual.cliente.password) + "</td>";
					Reporte2 += "</tr> \n <tr>";
					
				}

				actual = actual.next;
			} while (actual != this.primero);

		}

		ReporteAsignacion += "</tr></tbody></table> <br><br>";
		Reporte2 += "</tr></tbody></table> <br><br>";

		junto += ReporteAsignacion + Reporte2 + "\n <br> <div>\r\n"
				+ "  <canvas id=\"myChart\"></canvas>\r\n"
				+ "</div>";
		
		Scrip = " <script>\r\n"
			+ "  const labels = [\r\n"
			+ "    'Oro',\r\n"
			+ "    'Normales',\r\n"
			+ "  ];\r\n"
			+ "\r\n"
			+ "  const data = {\r\n"
			+ "    labels: labels,\r\n"
			+ "    datasets: [{\r\n"
			+ "      label: 'Grafico',\r\n"
			+ "      backgroundColor: 'rgb(255, 99, 132)',\r\n"
			+ "      borderColor: 'rgb(255, 99, 132)',\r\n"
			+ "      data: [" + normales + " , " + oro + "],\r\n"
			+ "    }]\r\n"
			+ "  };\r\n"
			+ "\r\n"
			+ "  const config = {\r\n"
			+ "    type: 'pie',\r\n"
			+ "    data: data,\r\n"
			+ "    options: {}\r\n"
			+ "  };\r\n"
			+ "</script>";
	}

	public void ReporteMostrar() {

		try {

			FileWriter archivo = new FileWriter("Reportes/Clientes.html");
			archivo.write(ReporteInicio + junto + Scrip + Scrip2 + ReporteFinal);
			archivo.close();

		} catch (Exception e) {

		}

		

	}
}

class Nodo_Circular_doble {

	Nodo_Circular_doble next,previous;
	Long info;
	Cliente cliente;
	
	public Nodo_Circular_doble(Long dPI,Cliente cliente) {
		this.info = dPI;
		this.next = this;
		this.previous = this;
		this.cliente = cliente;

	}
}
