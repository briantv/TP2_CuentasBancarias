package ar.edu.unlam.pg2;

public class CajaDeAhorros extends CuentaSueldo{
	
	private Double costoAdicionalLuegoDeLaQuintaExtraccion=6.00;
	private Integer cantidadDeExtracciones=0;
	
	public CajaDeAhorros(){}
		
	
	public void extraer(Double dineroAExtraer){
		this.cantidadDeExtracciones++;
		
		if(cantidadDeExtracciones<6){	
			super.extraer(dineroAExtraer);
		}
		else{
			Double montoTotal=dineroAExtraer+costoAdicionalLuegoDeLaQuintaExtraccion;
			super.extraer(montoTotal);
		}
		
		if(super.getExtraccionExitosa()==false){
			cantidadDeExtracciones--;
		}
	}
	
	public void setCostoAdicionalLuegoDeLaQuintaExtraccion(Double costoAdicional){
		this.costoAdicionalLuegoDeLaQuintaExtraccion=costoAdicional;
	}
}
