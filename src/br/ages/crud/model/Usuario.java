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
	private String cpf;
	private int telefone;
	private String usuario;
	private String senha;
	private String confirmarSenha;
	private TipoUsuario tipoUsuario;
	private PerfilAcesso perfilAcesso;
	private StatusUsuario statusUsuario;
	private String matricula;
	private String nome;
	private String email;
	private String endereco;
	private Date dataInclusao;

	public Usuario() {
		// TODO Auto-generated constructor stub
		this.dataInclusao = new Date();
	}

	public Usuario(int idUsuario) {
		this.idUsuario = idUsuario;
		this.dataInclusao = new Date();
	}

	public Usuario(String usuario, String senha, String confirmarSenha, String matricula, String nome, String email, String endereco, String cpf, int telefone, StatusUsuario statusUsuario, TipoUsuario tipoUsuario, PerfilAcesso perfilAcesso) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.confirmarSenha = confirmarSenha;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
		this.statusUsuario = statusUsuario;
		this.perfilAcesso = perfilAcesso;
		this.tipoUsuario = tipoUsuario;
		this.dataInclusao = new Date();
	}

	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public PerfilAcesso getPerfilAcesso() {
		return perfilAcesso;
	}

	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", senha=" + senha +  ", confirmarSenha=" + confirmarSenha + ", endereco=" + endereco 
				+", cpf=" + cpf +", telefone=" + telefone +", tipoUsuario=" + tipoUsuario + ", perfilAcesso=" + perfilAcesso + ", statusUsuario=" + statusUsuario
				+  ", nome=" + nome + ", email=" + email + ", dataInclusao=" + dataInclusao + "]";
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
