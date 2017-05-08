package ar.edu.unlam.pg2;

public class CuentaSueldo {
	private Double saldo;
	private Boolean extraccionExitosa;

	public CuentaSueldo(){}
	
	
	//Metodos///////////////
	public void depositar(Double dineroDepositado){
		this.saldo=dineroDepositado;
	}
	public Double getSaldo(){
		return this.saldo;
	}
	public void extraer(Double dineroAExtraer){
		if(this.saldo>=dineroAExtraer){
			this.saldo-=dineroAExtraer;
			extraccionExitosa=true;
		}
		else{
			System.out.println("Saldo insuficiente");
			extraccionExitosa=false;
			//throw new RuntimeException("");
		}
	}
	public Boolean getExtraccionExitosa(){
		return this.extraccionExitosa;
	}
	
	
}
