package ar.edu.unlam.pg2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testCuentasBancarias {

	@Test
	public void testCuentaSueldo() {
		
		CuentaSueldo cuenta=new CuentaSueldo();
		Double valorEsperado;
		
		cuenta.depositar(4000.00);
		valorEsperado=4000.00;
		Assert.assertEquals(valorEsperado,cuenta.getSaldo());
		
		//Extraer//////////
		cuenta.extraer(500.00);
		valorEsperado=3500.00;
		Assert.assertEquals(valorEsperado, cuenta.getSaldo());
		
		//Extraer con Exceso///////////////
		cuenta.extraer(4000.00);
		valorEsperado=3500.00;
		Assert.assertEquals(valorEsperado, cuenta.getSaldo());
		Assert.assertFalse(cuenta.getExtraccionExitosa());
	}
	//////////////////////////////////////////////////////////////
	
	
	
	@Test
	public void testCajaDeAhorros(){
		CajaDeAhorros caja=new CajaDeAhorros();
		Double valorEsperado;
		
		caja.depositar(5000.00);
		valorEsperado=5000.00;
		Assert.assertEquals(valorEsperado,caja.getSaldo());
		
		//Extraer Dinero////////
		caja.extraer(4000.00);
		valorEsperado=1000.00;
		Assert.assertEquals(valorEsperado,caja.getSaldo());
		
		//Extraer Dinero a partir de la quinta extraccion////////
		CajaDeAhorros caja2=new CajaDeAhorros();
		caja2.depositar(8000.00);
		
		caja2.setCostoAdicionalLuegoDeLaQuintaExtraccion(6.00);
		caja2.extraer(1000.00);//Extraccion 1
		caja2.extraer(1000.00);//  ""       2
		caja2.extraer(1000.00);//  ""       3
		caja2.extraer(8000.00);//  ""       4
		caja2.extraer(1000.00);//  ""       5
		caja2.extraer(1000.00);//  ""       6
		caja2.extraer(1000.00);//  ""       7
		valorEsperado=1994.00;
		Assert.assertEquals(valorEsperado, caja2.getSaldo());
		
			
		//Extraer con Exceso////////////////
		CajaDeAhorros caja3=new CajaDeAhorros();
		caja3.depositar(5000.00);
		caja3.extraer(6000.00);
		valorEsperado=5000.00;
		Assert.assertEquals(valorEsperado,caja3.getSaldo());
		Assert.assertFalse(caja3.getExtraccionExitosa());
	}
	//////////////////////////////////////////////////////////////////
	
	
	
	@Test
	public void testCuentaCorriente(){
		CuentaCorriente cuentaCorriente=new CuentaCorriente();
		
		Double valorEsperado;
		
		cuentaCorriente.depositar(5000.00);
		valorEsperado=5000.00;
		Assert.assertEquals(valorEsperado,cuentaCorriente.getSaldo());
		
		//Extraer/////////
		cuentaCorriente.extraer(4000.00);
		valorEsperado=1000.00;
		Assert.assertEquals(valorEsperado,cuentaCorriente.getSaldo());

		
		
		//Extraer con Exceso//////////
		CuentaCorriente cuentaCorriente2=new CuentaCorriente();
		cuentaCorriente2.depositar(1000.00);
		
		cuentaCorriente2.setLimiteAdicionalDescubierto(1500.00);
		cuentaCorriente2.extraer(2000.00);
		
		//Deuda lo que debo mas el 5%//
		valorEsperado=1050.00;
		Assert.assertEquals(valorEsperado, cuentaCorriente2.getDeuda());
		//Saldo Actual
		valorEsperado=0.0;
		Assert.assertEquals(valorEsperado, cuentaCorriente2.getSaldo());
		
	}
}