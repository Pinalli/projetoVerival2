package br.ages.crud.model;

public class FichaItem {

	private int idFichaItem;
	private int idUnidadeMedida;
	private int idMedidaCaseira;
	private int idIngrediente;
	private int idFicha;
	private double quantidadeUnidadeMedida;
	private double quantidadeMedidaCaseira;

	private String ingrediente;
	private String unidadeMedida;
	private String unidadeMedidaCaseira;

	private double fatorCorrecao;
	private double indiceCoccao;

	
	// Item da Ficha Completa
	private double perCapita;
	private double valorUnit;

	private String operacao;

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

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getUnidadeMedidaCaseira() {
		return unidadeMedidaCaseira;
	}

	public void setUnidadeMedidaCaseira(String unidadeMedidaCaseira) {
		this.unidadeMedidaCaseira = unidadeMedidaCaseira;
	}

	public double getQuantidadeUnidadeMedida() {
		return quantidadeUnidadeMedida;
	}

	public void setQuantidadeUnidadeMedida(double quantidadeUnidadeMedida) {
		this.quantidadeUnidadeMedida = quantidadeUnidadeMedida;
	}

	public double getQuantidadeMedidaCaseira() {
		return quantidadeMedidaCaseira;
	}

	public void setQuantidadeMedidaCaseira(double quantidadeMedidaCaseira) {
		this.quantidadeMedidaCaseira = quantidadeMedidaCaseira;
	}
	
	public double getFatorCorrecao() {
		return fatorCorrecao;
	}

	public void setFatorCorrecao(double fatorCorrecao) {
		this.fatorCorrecao = fatorCorrecao;
	}

	public double getIndiceCoccao() {
		return indiceCoccao;
	}

	public void setIndiceCoccao(double indiceCoccao) {
		this.indiceCoccao = indiceCoccao;
	}
}
