package ar.edu.unlam.pb2;

import java.util.ArrayList;

public abstract class Vehiculo {
	protected ArrayList<Paquete> paquetes = new ArrayList<Paquete>();

	public abstract boolean agregarPaquete(Paquete paquete);
	
	protected Double getPesoTotal() {
		Double peso = 0.0;
		for (Paquete p : paquetes) {
			peso += p.getPeso();
		}
		return peso;
	}

	protected Double getVolTotal() {
		Double vol = 0.0;
		for (Paquete p : paquetes) {
			vol += p.calcularVolumen();
		}
		return vol;
	}
}
