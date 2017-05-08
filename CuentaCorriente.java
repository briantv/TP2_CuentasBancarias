package ar.edu.unlam.pg2;

public class CuentaCorriente extends CuentaSueldo{
	
	private Double limiteAdicionalDescubierto;
	private Double deuda=0.0;
	
	public CuentaCorriente(){
		super();
	}
	
	public void extraer(Double dineroAExtraer){
		if(super.getSaldo()>=dineroAExtraer){
			super.extraer(dineroAExtraer);
		}
		else{
			Double saldoTotal=super.getSaldo()+this.limiteAdicionalDescubierto;
			if(saldoTotal>=dineroAExtraer){
				saldoTotal-=dineroAExtraer;
				this.deuda=(limiteAdicionalDescubierto-saldoTotal)+((limiteAdicionalDescubierto-saldoTotal)*0.05);
				super.depositar(00.00);
			}
			else{
				System.out.println("Saldo Descubierto insuficiente");
			}
		}
		
	}
	
	public void setLimiteAdicionalDescubierto(Double limiteAdicionalDescubierto){
		this.limiteAdicionalDescubierto=limiteAdicionalDescubierto;
	}
	public Double getDeuda(){
		return this.deuda;
	}
}
