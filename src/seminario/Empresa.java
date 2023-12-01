package seminario;

public class Empresa {
	private Integer idEmpresa;
	private String nomeEmpresa;
	private String cnpj;
	private String endereco;
	private String contatoNome;
	private String contatoTelefone;

	public Empresa(String nomeEmpresa, String cnpj, String endereco, String contatoNome, String contatoTelefone) {

		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.contatoNome = contatoNome;
		this.contatoTelefone = contatoTelefone;
	}

	public Empresa(String nomeEmpresa, String cnpj, String endereco, String contatoNome, String contatoTelefone,
			int id) {

		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.contatoNome = contatoNome;
		this.contatoTelefone = contatoTelefone;
		this.idEmpresa = id;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContatoNome() {
		return contatoNome;
	}

	public void setContatoNome(String contatoNome) {
		this.contatoNome = contatoNome;
	}

	public String getContatoTelefone() {
		return contatoTelefone;
	}

	public void setContatoTelefone(String contatoTelefone) {
		this.contatoTelefone = contatoTelefone;
	}

	@Override
	public String toString() {
		return String.format(
				"ID: %d\nEmpresa: %s\nCnpj: %s\nEndereço: %s\nNome do contato: %s\nTelefone: %s ",
				idEmpresa, nomeEmpresa, cnpj, endereco, contatoNome, contatoTelefone);
	}

}
