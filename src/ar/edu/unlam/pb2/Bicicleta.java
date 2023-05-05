package ar.edu.unlam.pb2;

public class Bicicleta extends Vehiculo {
	private String destino;

	@Override
	public boolean agregarPaquete(Paquete paquete) {

		if (paquetes.size() < 2 && paquete.calcularVolumen() <= 0.125 && paquete.getPeso() <= 15.0
				&& paquete.getPeso() + getPesoTotal() <= 15.0 && paquete.calcularVolumen() + getVolTotal() <= 0.125) {

			if (this.destino == null) {
				this.destino = paquete.getDestino();
				return paquetes.add(paquete);
			} else if (this.destino.equals(paquete.getDestino())) {
				return paquetes.add(paquete);
			}

		}

		return false;

	}


}
