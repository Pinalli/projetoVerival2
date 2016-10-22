package br.ages.crud.model;

public class FichaItem {

	private int idFichaItem;
	private int idUnidadeMedida;
	private int idMedidaCaseira;
	private int idIngrediente;
	private int idFicha;
	private int quantidadeUnidadeMedida;
	private int quantidadeMedidaCaseira;
	// Item da Ficha Completa
	private double perCapita;
	private double valorUnit;


	public FichaItem() {
		super();
	}

	public int getIdFichaItem() {
		return idFichaItem;
	}

	public void setIdFichaItem(int idFichaItem) {
		this.idFichaItem = idFichaItem;
	}

	public int getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(int idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public int getIdMedidaCaseira() {
		return idMedidaCaseira;
	}

	public void setIdMedidaCaseira(int idMedidaCaseira) {
		this.idMedidaCaseira = idMedidaCaseira;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public int getIdFicha() {
		return idFicha;
	}

	public void setIdFicha(int idFicha) {
		this.idFicha = idFicha;
	}

	public int getQuantidadeUnidadeMedida() {
		return quantidadeUnidadeMedida;
	}

	public void setQuantidadeUnidadeMedida(int quantidadeUnidadeMedida) {
		this.quantidadeUnidadeMedida = quantidadeUnidadeMedida;
	}

	public int getQuantidadeMedidaCaseira() {
		return quantidadeMedidaCaseira;
	}

	public void setQuantidadeMedidaCaseira(int quantidadeMedidaCaseira) {
		this.quantidadeMedidaCaseira = quantidadeMedidaCaseira;
	}

	public double getPerCapita() {
		return perCapita;
	}

	public void setPerCapita(double perCapita) {
		this.perCapita = perCapita;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

}
