package br.ages.crud.model;

/**
 * @author Homero Oliveira
 */

public class UnidadeMedida {
	private int idUnidadeMedida;
	private String descricaoOrigem;
	private String descricaoConversao;
	private String sigla;
	private double medidaConversao;

	public UnidadeMedida() {
	}

	public UnidadeMedida(int idUnidadeMedida, String descricaoOrigem, String descricaoConversao, String sigla,
			double medidaConversao) {
		this.idUnidadeMedida = idUnidadeMedida;
		this.descricaoOrigem = descricaoOrigem;
		this.descricaoConversao = descricaoConversao;
		this.sigla = sigla;
		this.medidaConversao = medidaConversao;
	}

	public int getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(int idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public String getDescricaoOrigem() {
		return descricaoOrigem;
	}

	public void setDescricaoOrigem(String descricaoOrigem) {
		this.descricaoOrigem = descricaoOrigem;
	}

	public String getDescricaoConversao() {
		return descricaoConversao;
	}

	public void setDescricaoConversao(String descricaoConversao) {
		this.descricaoConversao = descricaoConversao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public double getMedidaConversao() {
		return medidaConversao;
	}

	public void setMedidaConversao(double medidaConversao) {
		this.medidaConversao = medidaConversao;
	}

}
