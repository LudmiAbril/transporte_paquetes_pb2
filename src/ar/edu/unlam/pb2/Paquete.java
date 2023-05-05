package ar.edu.unlam.pb2;

public class Paquete {
	private Double alto;
	private Double ancho;
	private Double profundidad;
	private Double peso;
	private String destino;

	public Paquete(Double alto, Double ancho, Double profundidad, Double peso, String destino) {
		this.alto = alto;
		this.ancho = ancho;
		this.destino = destino;
		this.peso = peso;
		this.profundidad = profundidad;
	}

	public Double getAlto() {
		return alto;
	}

	public void setAlto(Double alto) {
		this.alto = alto;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Double calcularVolumen() {
		Double volumen = this.alto * this.ancho * this.profundidad;
		return volumen;
	}

}
