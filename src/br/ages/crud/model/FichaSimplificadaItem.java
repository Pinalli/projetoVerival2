package br.ages.crud.model;

import java.util.Date;

public class FichaSimplificadaItem {

	private int idFichaSimplificadaItem;
	private int idUnidadeMedida;
	private int idMedidaCaseira;
	private int idIngredientes;
	private int idFichaSimplicada;
	private int quantidadeUnidadeMedida;
	private int quantidadeMedidaCaseira;
	private Date dataInclusao;

	public FichaSimplificadaItem() {
		super();
		this.dataInclusao = new Date();
	}

	public int getIdFichaSimplificadaItem() {
		return idFichaSimplificadaItem;
	}

	public void setIdFichaSimplificadaItem(int idFichaSimplificadaItem) {
		this.idFichaSimplificadaItem = idFichaSimplificadaItem;
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

	public int getIdIngredientes() {
		return idIngredientes;
	}

	public void setIdIngredientes(int idIngredientes) {
		this.idIngredientes = idIngredientes;
	}

	public int getIdFichaSimplicada() {
		return idFichaSimplicada;
	}

	public void setIdFichaSimplicada(int idFichaSimplicada) {
		this.idFichaSimplicada = idFichaSimplicada;
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

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}
