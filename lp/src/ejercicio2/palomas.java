package ejercicio2;

public class palomas implements volador {//impementado de volador

	@Override
	public void despegar() {
		
		System.out.println("paloma despegando");
	}

	@Override
	public void aterrizar() {
		System.out.println("paloma aterrizada");
		
	}

	@Override//sobrecarga de metodos
	public void volar() {
		System.out.println("paloma volando");
		
	}
	
	
	public void comer() {
		System.out.println("paloma comiendo");
		
	}

}
