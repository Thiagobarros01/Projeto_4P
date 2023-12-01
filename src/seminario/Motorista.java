package seminario;

import java.time.LocalDate;

public class Motorista {

	private int idMotorista;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private LocalDate dataNascimento;
	private String cpf;
	private String telefone;

	public Motorista(String nome, String sobrenome, String email, String senha, LocalDate dataNascimento, String cpf,
			String telefone) {

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.telefone = telefone;
		
	}
	
	public Motorista(String nome, String sobrenome, String email, String senha, LocalDate dataNascimento, String cpf,
			String telefone,int id) {
	
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idMotorista = id;
		
	}
	

	public int getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	@Override
	public String toString() {
	    return String.format(
	            "ID: %d\nNome: %s\nSobrenome: %s\nEmail: %s\nSenha: %s\nData de Nascimento: %s\nCPF: %s\nTelefone: %s",
	            idMotorista, nome, sobrenome, email, senha, dataNascimento, cpf, telefone
	    );
	}


}
