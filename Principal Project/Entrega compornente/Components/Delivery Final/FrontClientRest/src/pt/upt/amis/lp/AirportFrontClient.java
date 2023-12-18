package pt.upt.amis.lp;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.upt.amis.lp.db.Airport;


public class AirportFrontClient extends Application {  
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RESTServer/airport/").build();
	}

	private static ClientConfig config = new ClientConfig();
	private static Client client = ClientBuilder.newClient(config);
	private static WebTarget service = client.target(getBaseURI());
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		//FlowPane root = new FlowPane();
		GridPane root = new GridPane();
		
		/* We will use the TableView component to list the books */
		
		TableView tableView = new TableView();

		/* Each of the columns must be linked to a colum in your model class (Book) - 
		 * Pay attention to the type
		 */		
        TableColumn<Airport, String> column1 = new TableColumn<>("Name Airport");
        column1.setMinWidth(250);
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Airport, String> column2 = new TableColumn<>("City");
        column1.setMinWidth(200);
        column2.setCellValueFactory(new PropertyValueFactory<>("city"));
        
        TableColumn<Airport, String> column3 = new TableColumn<>("Country");
        column1.setMinWidth(200);
        column3.setCellValueFactory(new PropertyValueFactory<>("country"));
        
        TableColumn<Airport, String> column4 = new TableColumn<>("ID Airport");
        column1.setMinWidth(200);
        column4.setCellValueFactory(new PropertyValueFactory<>("idAirport"));
        
        TableColumn<Airport, String> column5 = new TableColumn<>("N Companys");
        column1.setMinWidth(200);
        column5.setCellValueFactory(new PropertyValueFactory<>("numCompany"));

        /* Add the columns to the table view */
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        
        // Load objects into table calling the REST service
        fillTableView(tableView);

        /*This command line gets the selected row and the corresponding Model Instance (Book)*/
        TableView.TableViewSelectionModel<Airport> selectionModel = tableView.getSelectionModel();

        /* You can choose between single and multiple selection*/
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        //selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        /* Here is a list for the selected items in the table view */
        ObservableList<Airport> selectedItems = selectionModel.getSelectedItems();

        /* In case you need to check the selected item when it is changed */
        selectedItems.addListener(new ListChangeListener<Airport>() {
            @Override
            public void onChanged(Change<? extends Airport> change) {
                System.out.println("Selection changed: " + change.getList());
            }
        });

        /* Select the first item of the table view */
        selectionModel.select(0);

        /* In case if you need to get the index of the table view */
        ObservableList<Integer> selectedIndices = selectionModel.getSelectedIndices();
        
        //tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        //root.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        
        // We bind the prefHeight- and prefWidthProperty to the height and width of the stage.
        tableView.prefHeightProperty().bind(primaryStage.heightProperty());
        tableView.prefWidthProperty().bind(primaryStage.widthProperty());
        
        /* 
         * or we can use the scroll pane
         * 
        ScrollPane sp = new ScrollPane(tableView);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        
        */
        
        //root.getChildren().add(tableView);  
        root.add(tableView, 0, 0, 4, 1);
		
        Button btnNew = new Button("New");
		Button btnEdit = new Button("Edit");	
		Button btnDelete = new Button("Delete");
		Button btnCancel = new Button("Cancel");
		
		btnNew.setOnAction(ae -> { 
			System.out.println("New airport data... ");
			showAddUpdateAirportStage(primaryStage, new Airport()); 
			fillTableView(tableView);
        });
						
		btnEdit.setOnAction(ae -> {
			System.out.println("Editing data... ");			
			showAddUpdateAirportStage(primaryStage, selectedItems.get(0));
			fillTableView(tableView);
		});
		
		btnDelete.setOnAction(ae -> {
			System.out.println("Deleting data... ");				

			if (showConfirmationDialog("Are you sure you want to delete the Airport? ")) {
				deleteAirport(selectedItems.get(0).getIdAirport());
				fillTableView(tableView);
			}			
			
		});
		
		btnCancel.setOnAction(ae -> {
			System.out.println("Cancelling...");
			fillTableView(tableView);
		});
		
				
		//root.getChildren().addAll(new Button[] { btnNew, btnEdit, btnDelete, btnCancel});
		root.add(btnNew, 0, 1, 1, 1);
		root.add(btnEdit, 1, 1, 1, 1);
		root.add(btnDelete, 2, 1, 1, 1);
		root.add(btnCancel, 3, 1, 1, 1);
		
		root.setHgap(5);
		root.setVgap(5);
						
		Scene scene = new Scene(root);
		primaryStage.setTitle("CRUD AIRPORTS");
		primaryStage.setScene(scene);
		
		primaryStage.setX(700);//300
		primaryStage.setY(300);//300
		primaryStage.setWidth(580);//500
		primaryStage.setHeight(500);//500
		
		primaryStage.show();
	}
	
	private void fillTableView(TableView tableView) {
        tableView.getItems().clear();
        List<Airport> airports = getAirports();
        for (Airport a : airports) {
        	tableView.getItems().add(a);
		}
	}

	private List<Airport> getAirports() {

		// Get the Books
		Gson gson = new Gson();

		String responseAirportsList = service.path("getAirports")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);

		List<Airport> airports = Arrays.asList(gson.fromJson(responseAirportsList, Airport[].class));
				
		return airports;

	}
	
	private boolean deleteAirport(int idAirport) {

		// Delete Book with id 1
		Response response = service.path("deleteAirport")
				.path(Integer.toString(idAirport)).request().delete();

		if (response.getStatus() < 200 || response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} 
		
		return response.getStatus() == 200;

	}
	
    private void showAddUpdateAirportStage(Stage primaryStage, Airport airport) {
    	    	   	
    	Stage stage = new Stage();
        
    	stage.setTitle("Add or Update Airports - in Modal Mode");
        stage.setX(300);
        stage.setY(300);
        stage.setWidth(300);
        stage.setHeight(300);
        
		//FlowPane root = new FlowPane();
		GridPane root = new GridPane();

		
		
		Label lblIdAirport = new Label("ID Airport");
		root.add(lblIdAirport, 0, 0, 1, 1);
		
		Label txtIdAirport = new Label();
		lblIdAirport.setId("lblIdAirport");
		root.add(txtIdAirport, 1, 0, 1, 1);
		
		
		
		//TextField txtIdAirport = new TextField();
		//lblIdAirport.setId("lblIdAirport");
		//root.add(txtIdAirport, 1, 0, 1, 1);
		
		
		///////////////////////////////////////////////////////
		
		Label lblNameAirport = new Label("Name Airport");
		root.add(lblNameAirport, 0, 1, 1, 1);
		
		TextField txtNameAirport = new TextField();
		lblNameAirport.setId("lblNameAirport");
		root.add(txtNameAirport, 1, 1, 1, 1);
		
		///////////////////////////////////////////////////////

		Label lblCity = new Label("City");
		root.add(lblCity, 0, 2, 1, 1);

		TextField txtCity = new TextField();
		txtCity.setId("txtCity");
		root.add(txtCity, 1, 2, 1, 1);
		
        ///////////////////////////////////////////////////////
		
		Label lblIsCountry = new Label("Country");
		root.add(lblIsCountry, 0, 3, 1, 1);
		
		TextField txtCountry = new TextField();
		txtCountry.setId("txtCountry");
		root.add(txtCountry, 1, 3, 1, 1);
		
        ///////////////////////////////////////////////////////
		
		Label lblIsNumC = new Label("N Companys");
		root.add(lblIsNumC, 0, 4, 1, 1);
		
		Label txtNumC = new Label();
		txtNumC.setId("txtNumC");
		root.add(txtNumC, 1, 4, 1, 1);
		
		
		
		
		//CheckBox ckIsAvailable = new CheckBox();
		//ckIsAvailable.setId("ckIsAvailable");
		//root.add(ckIsAvailable, 1, 2, 1, 1);
		//root.getChildren().add(ckIsAvailable);

		Button btnSave = new Button("Save");
		Button btnCancel = new Button("Cancel");
		root.add(btnSave, 0, 5, 1, 1);
		root.add(btnCancel, 1, 5, 1, 1);
		
		root.setHgap(5);
		root.setVgap(5);
		
		if (airport.getIdAirport() != 0) {
			txtIdAirport.setText(String.valueOf(airport.getIdAirport()));
			txtNameAirport.setText(airport.getName());
			txtCity.setText(airport.getCity());
			txtCountry.setText(airport.getCountry());
			txtNumC.setText(String.valueOf(airport.getNumCompany()));
			//ckIsAvailable.setSelected();
		}

		btnSave.setOnAction(ae -> {
			System.out.println("Saving data... " + airport);
			
			
			//int idAirportValue = Integer.parseInt(txtIdAirport.getText());
			//airport.setIdAirport(idAirportValue);
				
			airport.setName(txtNameAirport.getText());
			airport.setCity(txtCity.getText());
			airport.setCountry(txtCountry.getText());
			//airport.setNumCompany(txtNumC.getText());
			/*book.setTitle(txtTitle.getText());
			book.setAuthor(txtAuthor.getText());
			book.setAvailable(ckIsAvailable.isSelected());
			*/
			saveData(airport);
			stage.close();
		});

		btnCancel.setOnAction(ae -> {
			System.out.println("Cancelling...");
			cleanFields(root);
			stage.close();
		});

		//root.getChildren().addAll(new Button[] { btnSave, btnCancel });
		
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root);
		stage.setTitle("Create or Update Airport");
		stage.setScene(scene);
		      
        
        stage.initOwner(primaryStage);
        //stage.initModality(Modality.NONE);
        stage.initModality(Modality.WINDOW_MODAL);
        //stage.initModality(Modality.APPLICATION_MODAL);


        stage.showAndWait();
    }
    
    private void saveData(Airport airport) {		
		try {
			
			Response response;
			String message = "Airport added successfully.";
			
			if (airport.getIdAirport() != 0) {
				
				message = "Airport updated successfully.";				
				response = service.path("updateAirport").request(MediaType.APPLICATION_JSON)
						.put(Entity.entity(airport, MediaType.APPLICATION_JSON), Response.class);
			} else {
				
				message = "Airport added successfully.";
				response = service.path("addAirport").request(MediaType.APPLICATION_JSON)
						.post(Entity.entity(airport, MediaType.APPLICATION_JSON), Response.class);
			}		
			
			if (response.getStatus() < 200 || response.getStatus() > 299) {			
				showMessage("Failed : HTTP error code : " + response.getStatus(), AlertType.ERROR);
				//throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}else {
				showMessage(message, AlertType.INFORMATION);
			}
		} catch (Exception e) {
			showMessage("Error while saving the Airport.", AlertType.ERROR);
			//throw new RuntimeException("Failed to save the book.");
		}
	}
	
	private void cleanFields(GridPane root) {
		
		for (Node node : root.getChildren()) {
		    System.out.println("Id: " + node.getId());
		    if (node instanceof TextField) {
		        // clear
		        ((TextField)node).setText("");
		    } else if (node instanceof CheckBox) {
		        // clear
		        ((CheckBox)node).setSelected(false);
		    }
		}
		
	}
	
	private void showMessage(String message, AlertType alertType) {
		Alert alert = new Alert(alertType);
        alert.setTitle("Airports Application");
        alert.setHeaderText(message);
        //alert.setContentText(message);
        alert.showAndWait();
	}
	
	private boolean showConfirmationDialog(String confirmationMessage) {
		ButtonType okBtn = new ButtonType("Yes", ButtonData.OK_DONE);
		ButtonType closeBtn = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
		Alert alert = new Alert(AlertType.WARNING,
		        confirmationMessage,
		        okBtn,
		        closeBtn);

		alert.setTitle("Delete airport warning");
		Optional<ButtonType> result = alert.showAndWait();

		return (result.orElse(closeBtn) == okBtn);
	}

	

	}