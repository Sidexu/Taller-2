package Logica.valueObjects;

public class VOBusCant extends VOBus{
	private int cat_ex;

	public VOBusCant(String matricula, String marca, int capacidad, int cat_ex) {
		super(matricula, marca, capacidad);
		this.cat_ex = cat_ex;
	}

	public int getCat_ex() {
		return cat_ex;
	}
	
	
}
