package CrudJOGOLIBRARY;

import java.util.List;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JogoControl {
	private ObservableList<Jogo> jogos = FXCollections.observableArrayList();
	private JogoDAOImpl dao = new JogoDAOImpl();
private StringProperty id = new SimpleStringProperty();	
private StringProperty nome = new SimpleStringProperty();
private StringProperty genero = new SimpleStringProperty();	
private StringProperty classificacao = new SimpleStringProperty();





public StringProperty idProperty() {
	return id;
}
public StringProperty nomeProperty() {
	return nome;
}

public StringProperty generoProperty() {
	return genero;
}
public StringProperty classificacaoProperty() {
	return classificacao;
}



public void salvar() {
	System.out.println("Id: " + id.get());
	System.out.println("Nome: " + nome.get());
	System.out.println("Genero: " + genero.get());
	System.out.println("Classificacao: " + classificacao.get());
	
	
	Jogo j = new Jogo();
	j.setId(id.get());
	j.setNome(nome.get());
	j.setGenero(genero.get());
	j.setClassificacao(classificacao.get());
	

	dao.salvar(j);
	jogos.add(j);
}
public void listar() {
	List<Jogo> encontrados = dao.listar(nome.get());
	jogos.clear();
	jogos.addAll(encontrados);
}
public void Excluir() {
	
	Jogo j = new Jogo();
	j.setId(id.get());
	dao.excluir(j);
	
	}

public ObservableList<Jogo> getJogo(){
	return jogos;
}

}