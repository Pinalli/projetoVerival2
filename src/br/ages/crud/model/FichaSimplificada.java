package br.ages.crud.model;

import java.util.Date;

public class FichaSimplificada {
	private int idFichaSimplificada;
	private String nome;
	private String rendimento;
	private String modoPreparo;
	private String montagem;
	private String orientacoesArmazenamento;
	private Date dataInclusao;

	public FichaSimplificada() {
		super();
		this.dataInclusao = new Date();
	}

	public int getIdFichaSimplificada() {
		return idFichaSimplificada;
	}

	public void setIdFichaSimplificada(int idFichaSimplificada) {
		this.idFichaSimplificada = idFichaSimplificada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRendimento() {
		return rendimento;
	}

	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public String getMontagem() {
		return montagem;
	}

	public void setMontagem(String montagem) {
		this.montagem = montagem;
	}

	public String getOrientacoesArmazenamento() {
		return orientacoesArmazenamento;
	}

	public void setOrientacoesArmazenamento(String orientacoesArmazenamento) {
		this.orientacoesArmazenamento = orientacoesArmazenamento;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}