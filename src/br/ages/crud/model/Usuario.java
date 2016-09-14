package br.ages.crud.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity Usuario - Data Transfer Objeto
 * 
 * @author 3- Victor Diehl, Daniele de Souza.
 *
 */
public class Usuario implements Serializable, Comparable<Usuario> {

	private static final long serialVersionUID = 2717027327683138959L;
	private int idUsuario;
	private String usuario;
	private String senha;
	private TipoUsuario tipoUsuario;
	private PerfilAcesso perfilAcesso;
	private StatusUsuario statusUsuario;
	private String nome;
	private String email;
	private Date dataInclusao;
	private String cpf;
	private String endereco;
	private String telefone;
	

	public Usuario() {
		// TODO Auto-generated constructor stub
		this.dataInclusao = new Date();
	}

	public Usuario(int idUsuario) {
		this.idUsuario = idUsuario;
		this.dataInclusao = new Date();
	}

	public Usuario(String usuario, String senha, String cpf, String nome, String email, String telefone, String endereco, StatusUsuario statusUsuario, TipoUsuario tipoUsuario, PerfilAcesso perfilAcesso) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.statusUsuario = statusUsuario;
		this.perfilAcesso = perfilAcesso;
		this.tipoUsuario = tipoUsuario;
		this.dataInclusao = new Date();
	}

	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int value) {
		idUsuario = value;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String value) {
		usuario = value;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String value) {
		senha = value;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public StatusUsuario getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(StatusUsuario statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String value) {
		nome = value;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String value) {
		email = value;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public PerfilAcesso getPerfilAcesso() {
		return perfilAcesso;
	}

	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	@Override
	public int compareTo(Usuario usuario) {
		return this.getNome().compareToIgnoreCase(usuario.getNome());
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", senha=" + senha + ", tipoUsuario=" + tipoUsuario + ", perfilAcesso=" + perfilAcesso + ", statusUsuario=" + statusUsuario
				+ ", cpf=" + cpf + "endereco=" + endereco + "telefone" + ", nome=" + nome + ", email=" + email + ", dataInclusao=" + dataInclusao + "]";
	}

	
}
