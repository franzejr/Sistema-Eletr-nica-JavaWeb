package bean;

public class Aparelho {
	private int id;
	private String nome;
	private String modelo;
	private String marca;
	private String defeito;
	private String observacoes;
	private String serie;
	
	public Aparelho(String nome, String modelo, String marca, String defeito, String observacoes, String serie){
		this.nome = nome;
		this.modelo = modelo;
		this.marca = marca;
		this.defeito = defeito;
		this.observacoes = observacoes;
		this.serie = serie;
	}
	public Aparelho(int id2, String nome2, String modelo2, String marca2, String defeito2, String observacoes2, String serie2) {
		this.setId(id2);
		this.nome = nome2;
		this.modelo = modelo2;
		this.marca = marca2;
		this.defeito = defeito2;
		this.observacoes = observacoes2;
		this.serie = serie2;
	}
	public Aparelho(int id2) {
		this.id = id2;
	}
	
	public Aparelho() { }
	
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDefeito() {
		return defeito;
	}
	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getSerie() {
		return serie;
	}
	

	

}
