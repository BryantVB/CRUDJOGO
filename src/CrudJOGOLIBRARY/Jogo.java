package CrudJOGOLIBRARY;

public class Jogo {
	private String Id;
	private String nome;
	private String genero;
	private String classificacao;
	

	
	public String getId() {
	return Id;
	}
	public void setId(String id) {
	this.Id = id;
	}
	public String getNome() {
	return nome;
	}
	public void setNome(String nome) {
	this.nome = nome;
	}
	
	public String getgenero() {
	return genero;
	}
    public void setGenero(String genero) {
	this.classificacao = genero;
}
    public String getclassificacao() {
  	return classificacao;
}
    public void setClassificacao(String classificacao) {
	this.classificacao = classificacao;
}



}