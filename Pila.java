package FileReader;

public class Pila {
	String [] PilaV;
	int elementos;
	int cima;
	
	public Pila(int cantidad)	{
		elementos=cantidad;
		PilaV = new String [elementos];
		cima=-1;
	}
	
	public boolean pilallena()	{
		if(cima==elementos-1)	{
			return(true);
		}
		return false;
	}
	
	public boolean pilaVacia()	{
		if(cima==1) {
			return(true);
		}
		return(false);
	}
	
	public void entraElemento(String elem)	{
		if(!pilallena())	{
			cima++;
			PilaV[cima]=elem;
			elementos++;
		}
	}
	
	public String Vercima()	{
		return(PilaV[cima]);
	}
	
	public String SacarElemento()	{
		String aux="";
		if(!pilaVacia()) {
			aux=PilaV[cima];
			cima--;
			elementos--;
		}
		return(aux);
	}
}
