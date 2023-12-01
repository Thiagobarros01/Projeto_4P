package seminario;

public class FichaMedica {
	private int idFichaMedica;
	private Integer id_motorista;
	private String tipoSangue;
	private String alergias;
	private String doencasCronicas;
	private String medicamentos;

	public FichaMedica(Integer id_motorista, String tipoSangue, String alergias, String doencasCronicas,
			String medicamentos) {

		this.id_motorista = id_motorista;
		this.tipoSangue = tipoSangue;
		this.alergias = alergias;
		this.doencasCronicas = doencasCronicas;
		this.medicamentos = medicamentos;
	}

	public int getIdFichaMedica() {
		return idFichaMedica;
	}

	public void setIdFichaMedica(int idFichaMedica) {
		this.idFichaMedica = idFichaMedica;
	}

	public Integer getIdMotorista() {
		return id_motorista;
	}

	public void setIdMotorista(Integer motorista) {
		this.id_motorista = motorista;
	}

	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getDoencasCronicas() {
		return doencasCronicas;
	}

	public void setDoencasCronicas(String doencasCronicas) {
		this.doencasCronicas = doencasCronicas;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Override
	public String toString() {
		return String.format(
				"ID: %d\nID motorista: %s\nTipo de sangue: %s\nAlergias: %s\nDoenças crônicas: %s\nMedicamentos: %s\n",
				id_motorista, tipoSangue, alergias, doencasCronicas, medicamentos);
	}
}
