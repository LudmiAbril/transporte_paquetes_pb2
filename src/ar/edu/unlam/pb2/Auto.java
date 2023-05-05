package ar.edu.unlam.pb2;

import java.util.HashSet;

public class Auto extends Vehiculo {
	private HashSet<String> destinos = new HashSet<String>();

	@Override
	public boolean agregarPaquete(Paquete paquete) {
		if (paquete.getPeso() < 500.0 && paquete.calcularVolumen() <= 2.0 && destinos.size() < 3
				&& paquete.getPeso() + getPesoTotal() < 500.0 && paquete.calcularVolumen() + getVolTotal() < 2.0) {
			if (destinos.add(paquete.getDestino())) {
				return paquetes.add(paquete);
			}

		}
		return false;
	}

	

}
