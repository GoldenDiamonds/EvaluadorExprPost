package FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

//Para Daniela Pineda con love tu Papi <3
public class Postfijo {
	public String leer()	{
		//Cambiar ruta por donde se encuentre el proyecto
		String rutaFichero = "c:\\Users\\Diamond\\Google Drive\\Eclipse\\Tests\\src\\FileReader/infijas.txt";
		ArrayList array = new ArrayList();
		String linea = "";
		String retornar = "";
		File archivo = new File(rutaFichero);
		try	{
			FileReader leer = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(leer);
			while((linea = buffer.readLine()) !=null)	{
				retornar +=linea + "\n";
			}
			buffer.close();
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return retornar;
	}
	
	public static void main(String[] args) {
		Postfijo post = new Postfijo();
		String operadores = "+-*/+!";
		String Posfija = new String();
		Pila MiPila = new Pila(100);
		
		//Las dos lineas comentadas de abajo son pruebas antes de procesar el archivo de texto
		//Descomentar una y comentar la 3er infija para hacer pruebas
		
		//Infija expresion = new Infija("(X!2+3*X+5)*(2+X)");
		//Infija expresion = new Infija("(3+4*5)");
		Infija expresion = new Infija(post.leer());
		MiPila.entraElemento("(");
		expresion.entrarCaracterFinal(")");
		
		for(int i=0;i<expresion.Caracteres();i++)	{
			String cadena=expresion.retornar();
			System.out.println(cadena);
			//Parentesis izquierdo a Pila
			if(cadena.contentEquals("("))	{
				MiPila.entraElemento(cadena);
			}else if(operadores.indexOf(cadena)<0 && !cadena.endsWith(")"))
			{
				Posfija=Posfija.concat(cadena);
			}
			if(operadores.indexOf(cadena)>=0)	{
				if(cadena.equals("!"))	{

				}else {
					String Aux=MiPila.Vercima();
					int precedenciaQ=operadores.indexOf(cadena);
					int precedenciaP=operadores.indexOf(Aux);
					while(precedenciaP>=precedenciaQ && !Aux.contentEquals("("))	{
						Posfija=Posfija.concat(MiPila.SacarElemento());
						Aux=MiPila.Vercima();
						precedenciaP=operadores.indexOf(Aux);
					}
				}
				MiPila.entraElemento(cadena);
			}
			if(cadena.contentEquals(")"))	{
				String Aux=MiPila.Vercima();
				while(!Aux.equals("("))
				{
					Posfija=Posfija.concat(MiPila.SacarElemento());
					Aux=MiPila.Vercima(); 
				}
				MiPila.SacarElemento();
			}
		}
		//Salida por consola
		System.out.println("POSTFIJA->"+Posfija);
		
		System.out.println(post.leer());
		//Salida por cuadro de dialogo
		JOptionPane.showMessageDialog(null, "POSTFIJA->"+Posfija);
		
		
	}
}

