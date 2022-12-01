package CrudJOGOLIBRARY;

import java.util.List;
public interface JogoDAO {
		void salvar(Jogo j);
		List<Jogo> listar(String nome);
	}