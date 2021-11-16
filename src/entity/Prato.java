package entity;

public class Prato {
	
	private String nome;
	private String descricao;
	private float valor;
	private int cod_rest;
	private int cod_tipo_comida;
	private int cd_estilo_cozinha;
	
	public Prato(String nome, String descricao, float valor, int cod_rest, int cod_tipo_comida, int cd_estilo_cozinha) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.cod_rest = cod_rest;
		this.cod_tipo_comida = cod_tipo_comida;
		this.cd_estilo_cozinha = cd_estilo_cozinha;
	}
	
	public Prato() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getCod_rest() {
		return cod_rest;
	}
	public void setCod_rest(int cod_rest) {
		this.cod_rest = cod_rest;
	}
	public int getCod_tipo_comida() {
		return cod_tipo_comida;
	}
	public void setCod_tipo_comida(int cod_tipo_comida) {
		this.cod_tipo_comida = cod_tipo_comida;
	}
	public int getCd_estilo_cozinha() {
		return cd_estilo_cozinha;
	}
	public void setCd_estilo_cozinha(int cd_estilo_cozinha) {
		this.cd_estilo_cozinha = cd_estilo_cozinha;
	}

	@Override
	public String toString() {
		return "Prato [nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", cod_rest=" + cod_rest
				+ ", cod_tipo_comida=" + cod_tipo_comida + ", cd_estilo_cozinha=" + cd_estilo_cozinha + "]";
	}
	


}
