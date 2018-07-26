package dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DashboardviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    void doAboutUs(MouseEvent event) {
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("aboutUs/AboutUsView.fxml")); 
			Scene scene = new Scene(root);
			
			Stage stage=new Stage();

			stage.setScene(scene);
			
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }
    
    
    @FXML
    void doBillCollection(MouseEvent event) {

try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("billCollection/BillCollectionView.fxml")); 
			Scene scene = new Scene(root);
			
			Stage stage=new Stage();

			stage.setScene(scene);
			
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }


    @FXML
    void doBillHistory(MouseEvent event) {
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("billLog/BillLogView.fxml")); 
			Scene scene = new Scene(root);
			
			Stage stage=new Stage();

			stage.setScene(scene);
			
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void doCustomerFinder(MouseEvent event) {
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("customerFinder/CustomerFinderView.fxml")); 
			Scene scene = new Scene(root);
			
			Stage stage=new Stage();

			stage.setScene(scene);
			
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void doCustomerLogin(MouseEvent event) {
    	
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("customerRegisteration/CustomerForm.fxml")); 
			Scene scene = new Scene(root);
			
			Stage stage=new Stage();

			stage.setScene(scene);
			
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void doGenerateBill(MouseEvent event) {
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("generateBill/bill.fxml")); 
			Scene scene = new Scene(root);
			
			Stage stage=new Stage();

			stage.setScene(scene);
			
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void doRoutineLogin(MouseEvent event) {
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("routineLog/RoutineForm.fxml")); 
			Scene scene = new Scene(root);
			
			Stage stage=new Stage();

			stage.setScene(scene);
			
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void doRoutineManager(MouseEvent event) {
    	try{

    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("routineManager/RoutineManagerView.fxml")); 
		Scene scene = new Scene(root);
		
		Stage stage=new Stage();

		stage.setScene(scene);
		
		stage.show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

    }
    
    @FXML
    void initialize() {

    }
}
