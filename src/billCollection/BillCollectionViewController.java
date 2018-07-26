package billCollection;

import sms.SendBill;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import connection.MySqlConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BillCollectionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> month;

    @FXML
    private ComboBox<Integer> year;

    @FXML
    private TextField txtmobile;

    @FXML
    private TextField txtBill;

    @FXML
    void doGetStatus(ActionEvent event) {
    	Alert alert =new Alert(AlertType.INFORMATION);
    			alert.setTitle("Bill Status");
    	if(month.getSelectionModel().isEmpty() || year.getSelectionModel().isEmpty() || txtmobile.getText().equals(""))
    	{
    		alert.setContentText("Please select year, month and mobile number");
    		alert.show();
    	}
    	else{
       try {
		pst=con.prepareStatement("select * from billhistory where mobile=? and month=? and year=?");
		pst.setString(1, txtmobile.getText());
		pst.setInt(2, month.getValue());
		pst.setInt(3, year.getValue());
		ResultSet rs =pst.executeQuery();
		rs.next();
		if(rs.getInt("Status")==0)
		{
			txtBill.setText(String.valueOf(rs.getFloat("Total")));
		}
		else
		{
			alert.setContentText("No pending Bill");
			alert.show();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    }

    @FXML
    void doUpdateStatus(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Updating Customer Status");
    	if(month.getSelectionModel().isEmpty() || year.getSelectionModel().isEmpty() || txtmobile.getText().equals(""))
    	{
    		alert.setContentText("Please select year, month and mobile number");
    		alert.show();
    	}
    	else{
       try {
		pst=con.prepareStatement("update billhistory set Status=? where mobile=? and month=? and year=?");
		pst.setInt(1, 1);
		pst.setString(2, txtmobile.getText());
		pst.setInt(3, month.getValue());
		pst.setInt(4, year.getValue());
		pst.executeUpdate();
		alert.setContentText("Status Updated");
		SendBill.sendMessage(txtmobile.getText(), "Payment of month :"+month.getValue()+" is received");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		alert.setContentText("Error Occured in Updating Status");
	}
       alert.show();
    }
    }
    Connection con;
    PreparedStatement pst;

    @FXML
    void initialize() {
    	con=MySqlConnection.doConnect();
        ArrayList<Integer> months = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        ArrayList<Integer> years = new ArrayList<Integer>(Arrays.asList(2017,2018,2019,2020,2021,2022));
        month.getItems().addAll(months);
        year.getItems().addAll(years);

    }
}
