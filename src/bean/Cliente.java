package bean;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefoneFixo;
	private String celular;
	private int id;
	
	
	public Cliente(String nome, String endereco, String telefoneFixo, String celular){
		this.nome = nome;
		this.endereco = endereco;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		
	}
	
	public Cliente(int id2, String nome2, String endereco2, String telefoneFixo2, String celular2) {
		this.id = id2;
		this.nome = nome2;
		this.endereco = endereco2;
		this.telefoneFixo = telefoneFixo2;
		this.celular = celular2;
	}
	
	public Cliente(int id3){
		this.id = id3;
	}

	
	public Cliente(){ }





	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCelular() {
		return celular;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
