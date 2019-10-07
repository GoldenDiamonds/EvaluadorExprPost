package FileReader;

public class Infija {
	String Qexpresion;
	int indice;
	
	public Infija(String expre)	{
		this.indice=0;
		Qexpresion = new String();
		Qexpresion=expre;
	}
	
	public String retornar()	{
		String Aux=Qexpresion.substring(indice, indice+1);
		indice++;
		return(Aux);
	}
	
	public void entrarCaracterFinal(String car)	{
		Qexpresion=Qexpresion.concat(car);
	}
	public int Caracteres()	{
		return(Qexpresion.length());
	}
}
