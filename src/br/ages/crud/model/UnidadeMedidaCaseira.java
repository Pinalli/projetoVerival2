package br.ages.crud.model;

/**
 * @author Homero Oliveira
 */

public class UnidadeMedidaCaseira {
	private int idUnidadeMedidaCaseira;
	private String nome;
	private String sigla;

	public UnidadeMedidaCaseira() {
	}

	public UnidadeMedidaCaseira(int idUnidadeMedidaCaseira, String nome, String sigla) {
		this.idUnidadeMedidaCaseira = idUnidadeMedidaCaseira;
		this.nome = nome;
		this.sigla = sigla;
	}

	public int getIdUnidadeMedidaCaseira() {
		return idUnidadeMedidaCaseira;
	}

	public void setIdUnidadeMedidaCaseira(int idUnidadeMedidaCaseira) {
		this.idUnidadeMedidaCaseira = idUnidadeMedidaCaseira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
