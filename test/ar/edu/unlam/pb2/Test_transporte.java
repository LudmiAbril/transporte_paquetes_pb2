package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_transporte {

	@Test
	public void QueLosParametrosDelPaqueteSeanCorrectos() {
		Double alto = 8.0;
		Double ancho = 4.0;
		Double profundidad = 16.0;
		Double peso = 15.0;
		Double volumen = 512.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);

		assertEquals(alto, paquete.getAlto());
		assertEquals(ancho, paquete.getAncho());
		assertEquals(profundidad, paquete.getProfundidad());
		assertEquals(peso, paquete.getPeso());
		assertEquals(volumen, paquete.calcularVolumen());
		assertEquals(destino, paquete.getDestino());
	}

	@Test
	public void QueSePuedaAgregarUnPaqueteAlLaBicicleta() {
		Double alto = 0.5;
		Double ancho = 0.5;
		Double profundidad = 0.5;
		Double peso = 15.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Bicicleta bici = new Bicicleta();

		assertTrue(bici.agregarPaquete(paquete));
	}
	
	@Test
	public void QueSePuedaAgregarMasDeDosPaquetesAlLaBicicleta() {
		Double alto = 0.1;
		Double ancho = 0.1;
		Double profundidad = 0.1;
		Double peso = 2.0;	
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p3 = new Paquete(alto, ancho, profundidad, peso, destino);
		Bicicleta bici = new Bicicleta();

		assertTrue(bici.agregarPaquete(p1));
		assertTrue(bici.agregarPaquete(p2));
		assertFalse(bici.agregarPaquete(p3));
	}
	
	@Test
	public void QueNoSePuedanAgregarDosPaquetesAlLaBicicletaConDestinoDistinto() {
		Double alto = 0.1;
		Double ancho = 0.1;
		Double profundidad = 0.1;
		Double peso = 2.0;	
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(alto, ancho, profundidad, peso, "San Justo");
		Bicicleta bici = new Bicicleta();

		assertTrue(bici.agregarPaquete(p1));
		assertFalse(bici.agregarPaquete(p2));
	}

	@Test
	public void QueNoSePuedaAgregarUnPaqueteAlLaBicicletaConVolumenExcedido() {
		Double alto = 6.0;
		Double ancho = 8.0;
		Double profundidad = 16.0;
		Double peso = 15.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Bicicleta bici = new Bicicleta();

		assertFalse(bici.agregarPaquete(paquete));
	}

	@Test
	public void QueNoSePuedaAgregarUnPaqueteAlLaBicicletaConPesoExcedido() {
		Double alto = 0.5;
		Double ancho = 0.5;
		Double profundidad = 0.5;
		Double peso = 26.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Bicicleta bici = new Bicicleta();

		assertFalse(bici.agregarPaquete(paquete));
	}
	
	@Test
	public void QueNoSePuedanAgregarVariosPaqueteAlLaBicicletaCuyoPesoTotalExcedaElLimite() {
		Double alto = 0.5;
		Double ancho = 0.5;
		Double profundidad = 0.5;
		Double peso = 10.0;
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(alto, ancho, profundidad, 6.0, destino);
		Bicicleta bici = new Bicicleta();

		assertTrue(bici.agregarPaquete(p1));
		assertFalse(bici.agregarPaquete(p2));
	}
	
	@Test
	public void QueNoSePuedanAgregarVariosPaqueteAlLaBicicletaCuyoVolumenTotalExcedaElLimite() {
		Double alto = 0.5;
		Double ancho = 0.5;
		Double profundidad = 0.1;
		Double peso = 10.0;
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(3.9, 3.9, 3.9, 3.0, destino);
		Bicicleta bici = new Bicicleta();

		assertTrue(bici.agregarPaquete(p1));
		assertFalse(bici.agregarPaquete(p2));
	}

	@Test
	public void QueSePuedaAgregarUnPaqueteAlAuto() {
		Double alto = 1.25;
		Double ancho = 1.25;
		Double profundidad = 1.25;
		Double peso = 300.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Auto auto = new Auto();

		assertTrue(auto.agregarPaquete(paquete));
	}

	@Test
	public void QueSeNoPuedaAgregarUnPaqueteAlAutoExcedidoDePeso() {
		Double alto = 1.26;
		Double ancho = 1.26;
		Double profundidad = 1.26;
		Double peso = 500.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Auto auto = new Auto();

		assertFalse(auto.agregarPaquete(paquete));
	}

	@Test
	public void QueSeNoPuedaAgregarUnPaqueteAlAutoExcedidoDeVolumen() {
		Double alto = 1.26;
		Double ancho = 1.26;
		Double profundidad = 1.30;
		Double peso = 300.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Auto auto = new Auto();

		assertFalse(auto.agregarPaquete(paquete));
	}

	@Test
	public void QueSeNoPuedaAgregarUnPaqueteAlAutoConDestinoRepetido() {
		Double alto = 1.15;
		Double ancho = 1.15;
		Double profundidad = 1.5;
		Double peso = 100.0;
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(alto, ancho, profundidad, peso, destino);
		Auto auto = new Auto();

		assertTrue(auto.agregarPaquete(p1));
		assertFalse(auto.agregarPaquete(p2));
	}

	@Test
	public void QueSeNoPuedaAgregarUnPaqueteAlAutoQueYaTieneMasDeTresDestinos() {
		Double alto = 1.0;
		Double ancho = 1.0;
		Double profundidad = 1.0;
		Double peso = 100.0;
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, peso, "Ramos Mejia");
		Paquete p3 = new Paquete(0.1, 0.1, 0.1, peso, "San Justo");
		Paquete p4 = new Paquete(0.1, 0.1, 0.1, peso, "Isidro Casanova");
		Auto auto = new Auto();

		assertTrue(auto.agregarPaquete(p1));
		assertTrue(auto.agregarPaquete(p2));
		assertTrue(auto.agregarPaquete(p3));
		assertFalse(auto.agregarPaquete(p4));
	}
	
	@Test
	public void QueSeNoPuedanAgregarVariosPaquetesAlAutoQueCuyoPesoTotalExcedaElLimite() {
		Double alto = 1.0;
		Double ancho = 1.0;
		Double profundidad = 1.0;
		Double peso = 200.0;
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, peso, "Ramos Mejia");
		Paquete p3 = new Paquete(0.1, 0.1, 0.1, peso, "San Justo");
		Auto auto = new Auto();

		assertTrue(auto.agregarPaquete(p1));
		assertTrue(auto.agregarPaquete(p2));
		assertFalse(auto.agregarPaquete(p3));

	}
	
	@Test
	public void QueSeNoPuedanAgregarVariosPaquetesAlAutoQueCuyoVolumenTotalExcedaElLimite() {
		Double alto = 1.0;
		Double ancho = 1.0;
		Double profundidad = 1.0;
		Double peso = 200.0;
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, peso, "Ramos Mejia");
		Paquete p3 = new Paquete(0.1, 0.1, 0.1, 100.0, "San Justo");
		Auto auto = new Auto();

		assertTrue(auto.agregarPaquete(p1));
		assertTrue(auto.agregarPaquete(p2));
		assertFalse(auto.agregarPaquete(p3));

	}
	
	@Test
	public void QueSePuedaAgregarUnPaqueteAlCamion() {
		Double alto = 1.25;
		Double ancho = 1.25;
		Double profundidad = 1.25;
		Double peso = 300.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Camion camion = new Camion();

		assertTrue(camion.agregarPaquete(paquete));
	}
	
	@Test
	public void QueNoSePuedaAgregarUnPaqueteAlCamionQueExcedaElPeso() {
		Double alto = 1.25;
		Double ancho = 1.25;
		Double profundidad = 1.25;
		Double peso = 16100.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Camion camion = new Camion();

		assertFalse(camion.agregarPaquete(paquete));
	}
	
	@Test
	public void QueNoSePuedaAgregarUnPaqueteAlCamionQueExcedaElVolumen() {
		Double alto = 2.71;
		Double ancho = 2.71;
		Double profundidad = 2.74;
		Double peso = 2000.0;
		String destino = "Moron";

		Paquete paquete = new Paquete(alto, ancho, profundidad, peso, destino);
		Camion camion = new Camion();

		assertFalse(camion.agregarPaquete(paquete));
	}
	
	@Test
	public void QueNoSePuedanAgregarPaquetesAlCamionCuyoPesoTotalExcedaElLimite() {
		Double alto = 0.1;
		Double ancho = 0.1;
		Double profundidad = 0.1;
		Double peso = 10000.0;
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(alto, ancho, profundidad, 7000.0, destino);
		Camion camion = new Camion();
		
		assertTrue(camion.agregarPaquete(p1));
		assertFalse(camion.agregarPaquete(p2));
	}
	
	@Test
	public void QueNoSePuedanAgregarPaquetesAlCamionCuyoVolumenTotalExcedaElLimite() {
		Double alto = 2.16;
		Double ancho = 2.16;
		Double profundidad = 2.16;
		Double peso = 10000.0;
		String destino = "Moron";

		Paquete p1 = new Paquete(alto, ancho, profundidad, peso, destino);
		Paquete p2 = new Paquete(2.28, 2.28, 2.28, 7000.0, destino);
		Camion camion = new Camion();
		assertTrue(camion.agregarPaquete(p1));
		assertFalse(camion.agregarPaquete(p2));
	}
}
