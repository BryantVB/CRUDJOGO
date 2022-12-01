package CrudJOGOLIBRARY;


	import javafx.application.Application;
	import javafx.beans.binding.Bindings;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Control;
	import javafx.scene.control.Label;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;

	public class JogoBoundary extends Application{
		private Label lblId = new Label("Id: ");
		private Label lblNome = new Label("Nome: ");
		private Label lblGenero = new Label("Genero: ");
		private Label lblClassificacao = new Label("Classificacao: ");
		
		private TextField txtId = new TextField();
		private TextField txtNome = new TextField();
		private TextField txtGenero = new TextField();
		private TextField txtClassificacao = new TextField();
	
		private Button btnSalvar = new Button("Salvar");
		private Button btnListar = new Button("Listar");
		private Button btnExcluir = new Button("Excluir");
		private JogoControl control = new JogoControl();
		private TableView<Jogo> table = new TableView<>();
				

		
		@Override
		public void start(Stage stage) throws Exception {
			BorderPane principal = new BorderPane(); 
			GridPane grid = new GridPane(); 
			principal.setTop(grid); 
			principal.setCenter(table); 
			Scene scn = new Scene(principal, 500,400); 
			
			grid.add(lblId, 0, 0);
			grid.add(lblNome, 0, 1);
			grid.add(lblGenero, 0, 2);
			grid.add(lblClassificacao, 0, 3);
	
			
			grid.add(txtId, 1, 0);
			grid.add(txtNome, 1, 1);
			grid.add(txtGenero, 1, 2);
			grid.add(txtClassificacao, 1, 3);
		

			
			grid.add(btnSalvar, 0, 7);
			grid.add(btnListar, 1, 7);
			grid.add(btnExcluir, 2, 7);
			
			Bindings.bindBidirectional(control.idProperty(), txtId.textProperty());
			Bindings.bindBidirectional(control.nomeProperty(), txtNome.textProperty());
	        Bindings.bindBidirectional(control.generoProperty(), txtGenero.textProperty());
	        Bindings.bindBidirectional(control.classificacaoProperty(), txtClassificacao.textProperty());
	     
	      
	        
	        TableColumn<Jogo, String> col1 = new TableColumn<>("ID");
			col1.setCellValueFactory(new PropertyValueFactory<>("id"));
			
			TableColumn<Jogo, String> col2 = new TableColumn<>("Nome");
			col2.setCellValueFactory(new PropertyValueFactory<>("nome"));
					
			TableColumn<Jogo, String> col3 = new TableColumn<>("Genero");
			col3.setCellValueFactory(new PropertyValueFactory<>("genero"));
			
			TableColumn<Jogo , String> col4 = new TableColumn<>("Classificacao");
			col4.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
	
		
			
			table.getColumns().addAll(col1, col2, col3, col4);
			
			table.setItems(control.getJogo());
			btnSalvar.setOnAction((e) -> {
				control.salvar();
			});
			
			btnListar.setOnAction((e) -> {
				control.listar();
			});
			btnExcluir.setOnAction((e) -> {
				control.Excluir();
			});
			
			stage.setScene(scn); 
			stage.setTitle("Cadastrar Jogos"); 
			stage.show(); 
		}
		public static void main(String[] args) {
			Application.launch(JogoBoundary.class, args);
		}


	}
