package customerRegisteration;

import connection.MySqlConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CustomerFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtArea;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCq;

    @FXML
    private TextField txtBq;

    @FXML
    private TextField txtCr;

    @FXML
    private TextField txtBr;
    
    @FXML
    private DatePicker date;
    
    @FXML
    private Label lblres;


    @FXML
    void doClose(ActionEvent event) {
       Alert confirm = new Alert(AlertType.CONFIRMATION);
       confirm.setTitle("Exit");
       confirm.setContentText("Do you want to close the page?");
       Optional<ButtonType> res = confirm.showAndWait();
       if(res.get()==ButtonType.OK)
       {
    	  /* Alert alert = new Alert(AlertType.CONFIRMATION);
    	   confirm.setTitle("Save");
    	   confirm.setContentText("Do you want to save the document?");
    	   Optional<ButtonType> save = alert.showAndWait();
    	   if(save.get()==ButtonType.OK)
    	   {
    		   doSave();
    	   }*/
    	   System.exit(1);
       }
    }
    
    @FXML
    void doNew(ActionEvent event) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	confirm.setTitle("New");
    	confirm.setContentText("Do you want to enter the information of New Customer?");
    	Optional<ButtonType> res=confirm.showAndWait();
    	if(res.get()==ButtonType.OK)
    	{
         txtMobile.setText("");
         txtName.setText("");
         txtAddress.setText("");
         txtArea.setText("");
         txtCity.setText("");
         txtCq.setText("0");
         txtCr.setText("0");
         txtBq.setText("0");
         txtBr.setText("0");
         date.setValue(null);
         lblres.setText("New Customer");
    	}
    }

    @FXML
    void doDelete(ActionEvent event) {
    	try {
			pst=con.prepareStatement("delete from customers where mobile=?");
			pst.setString(1, txtMobile.getText());
			int count = pst.executeUpdate();
			if(count==0)
				lblres.setText("Invalid Mobile Number");
			else
				lblres.setText("Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    @FXML
    void doSave(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("Saving new entry");
    	if(txtMobile.getText().matches("[0-9]*")==false || txtMobile.getText().length()!=10 || txtName.getText().equals("") || txtAddress.getText().equals("") || txtArea.getText().equals("") || txtCity.getText().equals("") || txtCq.getText().matches("[0-9]*")==false || txtCr.getText().matches("[0-9]*")==false || txtBq.getText().matches("[0-9]*")==false || txtBr.getText().matches("[0-9]*")==false || date.getValue().equals(""))
    	{
    		alert.setContentText("Please fill the correct details");
    		alert.show();
    	}
    	else{
    	try {
    		pst=con.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?,?,?,?)");
    		pst.setString(1, txtMobile.getText());
    		pst.setString(2, txtName.getText());
    		pst.setString(3, txtAddress.getText());
    		pst.setString(4, txtArea.getText());
    		pst.setString(5, txtCity.getText());
    		pst.setFloat(6, Float.parseFloat(txtCq.getText()));
    		pst.setFloat(7, Float.parseFloat(txtCr.getText()));
    		pst.setFloat(8, Float.parseFloat(txtBq.getText()));
    		pst.setFloat(9, Float.parseFloat(txtBr.getText()));
    		pst.setDate(10,java.sql.Date.valueOf(date.getValue()));
    		pst.setInt(11, 1);
    		try{
    		pst.executeUpdate();
    		lblres.setText("Saved");
    		alert.setContentText("Data Saved");
    		alert.show();
    		}
    		catch(Exception ex)
    		{
    			lblres.setText("Duplicate Mobile Number ");
    			alert.setContentText("Duplicate entry");
    			alert.show();
    		}
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		//alert.setContentText("Please fill the correct details");
    		//alert.show();
    	}
    	}
    }

    @FXML
    void doSearch(ActionEvent event) {
          try {
			pst=con.prepareStatement("select * from customers where mobile=?");
			pst.setString(1,txtMobile.getText());
			ResultSet rs = pst.executeQuery();
			boolean flag=false;
			while(rs.next())
			{
				flag=true;
				txtName.setText(rs.getString("CName"));
				txtAddress.setText(rs.getString("Address"));
				txtArea.setText(rs.getString("Area"));
				txtCity.setText(rs.getString("City"));
				txtCq.setText(String.valueOf(rs.getFloat("cq")));
				txtCr.setText(String.valueOf(rs.getFloat("cp")));
				txtBq.setText(String.valueOf(rs.getFloat("bq")));
				txtBr.setText(String.valueOf(rs.getFloat("bp")));
				date.setValue(rs.getDate("dos").toLocalDate());
			}
			if(flag==false)
			{
				lblres.setText("Invalid Mobile");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doUpdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Updating the entry");
if(txtMobile.getText().matches("[0-9]*")==false || txtMobile.getText().length()!=10 || txtName.getText().equals("") || txtAddress.getText().equals("") || txtArea.getText().equals("") || txtCity.getText().equals("") || txtCq.getText().matches("[0-9]*")==false || txtCr.getText().matches("[0-9]*")==false || txtBq.getText().matches("[0-9]*")==false || txtBr.getText().matches("[0-9]*")==false || date.getValue().equals(""))
{
	alert.setContentText("Please fill the correct details");
	alert.show();
}
else{
    	 try {
    			pst=con.prepareStatement("update customers set CName=?,Address=?,Area=?,City=?,cq=?,cp=?,bq=?,bp=? where mobile=?");
    			pst.setString(9, txtMobile.getText());
    			pst.setString(1, txtName.getText());
    			pst.setString(2, txtAddress.getText());
    			pst.setString(3, txtArea.getText());
    			pst.setString(4, txtCity.getText());
    			pst.setFloat(5, Float.parseFloat(txtCq.getText()));
    			pst.setFloat(6, Float.parseFloat(txtCr.getText()));
    			pst.setFloat(7, Float.parseFloat(txtBq.getText()));
    			pst.setFloat(8, Float.parseFloat(txtBr.getText()));
    			try{
    			pst.executeUpdate();
    			lblres.setText("Updated");
    			alert.setContentText("Record Updated");
    			alert.show();
    			}
    			catch(Exception ex)
    			{
    				lblres.setText("Invalid Mobile Number ");
    				alert.setContentText("Invalid Mobile Number");
        			alert.show();
    			}
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
}
    }

    Connection con;
    PreparedStatement pst;
    
    @FXML
    void initialize() {
        con=MySqlConnection.doConnect();
        txtCq.setText("0");
        txtCr.setText("0");
        txtBq.setText("0");
        txtBr.setText("0");
    }
}
