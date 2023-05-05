package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Camion extends Vehiculo {
	private ArrayList<String> destinos = new ArrayList<String>();
	
    @Override
	public boolean agregarPaquete(Paquete paquete) {
		if (paquete.getPeso() < 16000.0 && paquete.calcularVolumen() < 20.0
				&& paquete.getPeso() + getPesoTotal() <= 16000.0 && paquete.calcularVolumen() + getVolTotal() <= 20.0) {
			destinos.add(paquete.getDestino());
			return paquetes.add(paquete);
		}
		return false;

	}

	

}
