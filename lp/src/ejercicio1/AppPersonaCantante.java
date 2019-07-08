package ejercicio1;

public class AppPersonaCantante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		persona p=new persona();//instanciar implementacion
		
		//p.cantar();//llama el metodo
		hacerCantar(p);
		

	}

	public static void hacerCantar(cantante c) {//llama la interfaz
		
		c.cantar();
		
	}
}
