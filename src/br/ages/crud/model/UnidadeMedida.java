package br.ages.crud.model;

/**
 * @author Homero Oliveira
 */

public class UnidadeMedida {
	private int idUnidadeMedida;
	private String unidadeMedida;
	private String medidaConversao;
	private String siglaUnidadeMedida;
	private double fatorConversao;

	public UnidadeMedida() {
	}

	public UnidadeMedida(int idUnidadeMedida, String unidadeMedida, String medidaConversao, String siglaUnidadeMedida,
						 double fatorConversao) {
		this.idUnidadeMedida = idUnidadeMedida;
		this.unidadeMedida = unidadeMedida;
		this.medidaConversao = medidaConversao;
		this.siglaUnidadeMedida = siglaUnidadeMedida;
		this.fatorConversao = fatorConversao;
	}

	public int getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(int idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getMedidaConversao() {
		return medidaConversao;
	}

	public void setMedidaConversao(String medidaConversao) {
		this.medidaConversao = medidaConversao;
	}

	public String getSiglaUnidadeMedida() {
		return siglaUnidadeMedida;
	}

	public void setSiglaUnidadeMedida(String siglaUnidadeMedida) {
		this.siglaUnidadeMedida = siglaUnidadeMedida;
	}

	public double getFatorConversao() {
		return fatorConversao;
	}

	public void setFatorConversao(double fatorConversao) {
		this.fatorConversao = fatorConversao;
	}

}
