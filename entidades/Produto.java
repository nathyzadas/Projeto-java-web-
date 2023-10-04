package br.com.ProjetoCRUD.entidades;

public class Produto {

	private int idProduto;
	public String nomeProduto;
	public String descricao;
	public String image;

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Produto(String nomeProduto, String descricao, String image) {
		super();

		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.image = image;
	}

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

}