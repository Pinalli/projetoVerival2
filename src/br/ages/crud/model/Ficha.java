package br.ages.crud.model;

import java.util.ArrayList;
import java.util.List;

public class Ficha {
	private int idFicha;
	private int idEmpresa;
	private String nome;
	private String rendimento;
	private String foto;
	private String modoPreparo;
	private String montagem;
	private String orientacoesArmazenamento;
	private String tipoFicha;
	// Ficha Completa
	private String textura;
	private String sabor;
	private String apresentacao;

	private List<FichaItem> itens;

	public Ficha() {
		super();
		this.itens = new ArrayList<>();
	}

	public int getIdFicha() {
		return idFicha;
	}

	public void setIdFicha(int idFicha) {
		this.idFicha = idFicha;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

	public String getTipoFicha() {
		return tipoFicha;
	}

	public void setTipoFicha(String tipoFicha) {
		this.tipoFicha = tipoFicha;
	}

	public String getTextura() {
		return textura;
	}

	public void setTextura(String textura) {
		this.textura = textura;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public List<FichaItem> getItens() {
		return itens;
	}

	public void setItens(List<FichaItem> itens) {
		this.itens = itens;
	}

}