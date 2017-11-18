package br.ages.crud.model;

import java.util.Date;

/**
 * @author Luis Santana
 *
 */
public class Ingrediente {
	private int id;
	private int codigo;
	private int id_empresa;
	private String descricao;
	private double carboidratos;
	private double kcalCarboidratos;
	private double proteinas;
	private double kcalProteinas;
	private double lipidios;
	private double kcalLipidios;
	private double gorduraSaturada;
	private double fibrasAlimentares;
	private double sodio;
	private double custo;
	private String unidadeMedida;
	private Date dataAlteracao;

	public Ingrediente() {
		this.dataAlteracao = new Date();
	}

	public Ingrediente(int id, int codigo, String descricao, double carboidratos, double kcalCarboidratos,
			double proteinas, double kcalProteinas, double lipidios, double kcalLipidios, double gorduraSaturada,
			double fibrasAlimentares, double sodio, double fatorCorrecao, double indiceCoccao, double custo,
			String unidadeMedida) {
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.carboidratos = carboidratos;
		this.kcalCarboidratos = kcalCarboidratos;
		this.proteinas = proteinas;
		this.kcalProteinas = kcalProteinas;
		this.lipidios = lipidios;
		this.kcalLipidios = kcalLipidios;
		this.gorduraSaturada = gorduraSaturada;
		this.fibrasAlimentares = fibrasAlimentares;
		this.sodio = sodio;
		this.custo = custo;
		this.unidadeMedida = unidadeMedida;
		this.dataAlteracao = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getCarboidratos() {
		return carboidratos;
	}

	public void setCarboidratos(double carboidratos) {
		this.carboidratos = carboidratos;
	}

	public double getKcalCarboidratos() {
		return kcalCarboidratos;
	}

	public void setKcalCarboidratos(double kcalCarboidratos) {
		this.kcalCarboidratos = kcalCarboidratos;
	}

	public double getProteinas() {
		return proteinas;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public double getKcalProteinas() {
		return kcalProteinas;
	}

	public void setKcalProteinas(double kcalProteinas) {
		this.kcalProteinas = kcalProteinas;
	}

	public double getLipidios() {
		return lipidios;
	}

	public void setLipidios(double lipidios) {
		this.lipidios = lipidios;
	}

	public double getKcalLipidios() {
		return kcalLipidios;
	}

	public void setKcalLipidios(double kcalLipidios) {
		this.kcalLipidios = kcalLipidios;
	}

	public double getGorduraSaturada() {
		return gorduraSaturada;
	}

	public void setGorduraSaturada(double gorduraSaturada) {
		this.gorduraSaturada = gorduraSaturada;
	}

	public double getFibrasAlimentares() {
		return fibrasAlimentares;
	}

	public void setFibrasAlimentares(double fibrasAlimentares) {
		this.fibrasAlimentares = fibrasAlimentares;
	}

	public double getSodio() {
		return sodio;
	}

	public void setSodio(double sodio) {
		this.sodio = sodio;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", codigo=" + codigo + ", id_empresa=" + id_empresa + ", descricao="
				+ descricao + ", carboidratos=" + carboidratos + ", kcalCarboidratos=" + kcalCarboidratos
				+ ", proteinas=" + proteinas + ", kcalProteinas=" + kcalProteinas + ", lipidios=" + lipidios
				+ ", kcalLipidios=" + kcalLipidios + ", gorduraSaturada=" + gorduraSaturada + ", fibrasAlimentares="
				+ fibrasAlimentares + ", sodio=" + sodio + "fatorCorrecao=" + ", indiceCoccao=" + ", custo=" + custo
				+ ", unidadeMedida=" + unidadeMedida + ", dataAlteracao=" + dataAlteracao + "]";
	}

}
