package br.ages.crud.model;

import java.util.Date;

/**
 * @author Luis Santana
 *
 */
public class Empresa {
	private int idEmpresa;
	private String cnpj;
	private String telefone;
	private String nome;
	private String endereco;
	private String cidade;
	private String uf;
	private String razaoSocial;
	private String responsavel;
	private String logo; //caminho da imagem
	
	private Date dataAlteracao;
	
	public Empresa(){
		this.dataAlteracao = new Date();
	}

	public Empresa(int idEmpresa, String cnpj, String telefone, String nome, String endereco, String cidade, String uf,
			String razaoSocial, String responsavel, String logo) {
		super();
		this.idEmpresa = idEmpresa;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.razaoSocial = razaoSocial;
		this.responsavel = responsavel;
		this.logo = logo;
		this.dataAlteracao = new Date();
	}



	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf(){
		return uf;
	}
	
	public void setUf(String uf){
		this.uf = uf;
	}
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Empresa" + " CNPJ=" + cnpj + ", Nome=" + nome + ", Cidade="+ cidade + ", UF=" + uf +  
				", Razao Social=" + razaoSocial + ", Telefone=" + telefone
				+ ", Endereco=" + endereco + "]";
	}
	
}
