package billLog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import connection.MySqlConnection;
import customerFinder.CustomerFinderBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

public class BillLogViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> combomonth;

    @FXML
    private ComboBox<Integer> comboyear;

    @FXML
    private RadioButton chkpaid;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton chkpending;

    @FXML
    private TextField txtmobile;

    @FXML
    private TableView<BillHistoryBean> tblHistory;

    private ObservableList<BillHistoryBean> list;
    
    @FXML
    void doBillHistory(ActionEvent event) {
    	TableColumn<BillHistoryBean,String> mobile = new TableColumn<BillHistoryBean,String>("Mobile");
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        
        TableColumn<BillHistoryBean,Float> cq = new TableColumn<BillHistoryBean,Float>("Cow Quantity");
        cq.setCellValueFactory(new PropertyValueFactory<>("cqT"));
        
        TableColumn<BillHistoryBean,Float> bq = new TableColumn<BillHistoryBean,Float>("Buffallo Quantity");
        bq.setCellValueFactory(new PropertyValueFactory<>("bqT"));
        
        TableColumn<BillHistoryBean,Float> CBill = new TableColumn<BillHistoryBean,Float>("Cow Milk Price");
        CBill.setCellValueFactory(new PropertyValueFactory<>("CBill"));
        
        TableColumn<BillHistoryBean,Float> BBill = new TableColumn<BillHistoryBean,Float>("Buffallo Milk Price");
        BBill.setCellValueFactory(new PropertyValueFactory<>("BBill"));
        
        TableColumn<BillHistoryBean,Float> Total = new TableColumn<BillHistoryBean,Float>("Total Bill");
        Total.setCellValueFactory(new PropertyValueFactory<>("Total"));
        
        TableColumn<BillHistoryBean,Integer> Status = new TableColumn<BillHistoryBean,Integer>("Status");
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        
        TableColumn<BillHistoryBean,Integer> month = new TableColumn<BillHistoryBean,Integer>("Month");
        month.setCellValueFactory(new PropertyValueFactory<>("month"));
        
        TableColumn<BillHistoryBean,Integer> year = new TableColumn<BillHistoryBean,Integer>("Year");
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        
        tblHistory.getColumns().clear();
        tblHistory.getColumns().addAll(mobile,cq,bq,CBill,BBill,Total,Status,month,year);
        
         list = FXCollections.observableArrayList();
    	try {
			pst=con.prepareStatement("select * from billhistory where mobile=? order by month,year");
			pst.setString(1, txtmobile.getText());
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String mobile1=rs.getString("mobile");	
				float cqT1=rs.getFloat("cqT");
				float bqT1=rs.getFloat("bqT");
				float CBill1=rs.getFloat("CBill");	
				float BBill1=rs.getFloat("BBill");
				float Total1=rs.getFloat("Total");
				int	Status1=rs.getInt("Status");	
				int	month1=rs.getInt("month");	
				int	year1=rs.getInt("year");
				BillHistoryBean record = new BillHistoryBean(mobile1,cqT1,bqT1,CBill1,BBill1,Total1,Status1,month1,year1);
				list.add(record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        tblHistory.setItems(list);
    }
    
    @FXML
    void doFetch(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Fetching data");
    	
    	TableColumn<BillHistoryBean,String> mobile = new TableColumn<BillHistoryBean,String>("Mobile");
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        
        TableColumn<BillHistoryBean,Float> cq = new TableColumn<BillHistoryBean,Float>("Cow Quantity");
        cq.setCellValueFactory(new PropertyValueFactory<>("cqT"));
        
        TableColumn<BillHistoryBean,Float> bq = new TableColumn<BillHistoryBean,Float>("Buffallo Quantity");
        bq.setCellValueFactory(new PropertyValueFactory<>("bqT"));
        
        TableColumn<BillHistoryBean,Float> CBill = new TableColumn<BillHistoryBean,Float>("Cow Milk Price");
        CBill.setCellValueFactory(new PropertyValueFactory<>("CBill"));
        
        TableColumn<BillHistoryBean,Float> BBill = new TableColumn<BillHistoryBean,Float>("Buffallo Milk Price");
        BBill.setCellValueFactory(new PropertyValueFactory<>("BBill"));
        
        TableColumn<BillHistoryBean,Float> Total = new TableColumn<BillHistoryBean,Float>("Total Bill");
        Total.setCellValueFactory(new PropertyValueFactory<>("Total"));
        
        TableColumn<BillHistoryBean,Integer> Status = new TableColumn<BillHistoryBean,Integer>("Status");
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        
        TableColumn<BillHistoryBean,Integer> month = new TableColumn<BillHistoryBean,Integer>("Month");
        month.setCellValueFactory(new PropertyValueFactory<>("month"));
        
        TableColumn<BillHistoryBean,Integer> year = new TableColumn<BillHistoryBean,Integer>("Year");
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        
        tblHistory.getColumns().clear();
        tblHistory.getColumns().addAll(mobile,cq,bq,CBill,BBill,Total,Status,month,year);
        int s=0;
        if(chkpending.isSelected()==true)
        	s=0;
        else if(chkpaid.isSelected()==true)
        	s=1;
        
        list = FXCollections.observableArrayList();
       
        if(combomonth.getSelectionModel().isEmpty() || comboyear.getSelectionModel().isEmpty())
        {
        	alert.setContentText("Please select month and year");
        	alert.show();
        }
        else{
    	try {
			pst=con.prepareStatement("select * from billhistory where month=? and year=? and Status=?");
			pst.setInt(1, combomonth.getValue());
			pst.setInt(2, comboyear.getValue());
			pst.setInt(3, s);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String mobile1=rs.getString("mobile");	
				float cqT1=rs.getFloat("cqT");
				float bqT1=rs.getFloat("bqT");
				float CBill1=rs.getFloat("CBill");	
				float BBill1=rs.getFloat("BBill");
				float Total1=rs.getFloat("Total");
				int	Status1=rs.getInt("Status");	
				int	month1=rs.getInt("month");	
				int	year1=rs.getInt("year");
				BillHistoryBean record = new BillHistoryBean(mobile1,cqT1,bqT1,CBill1,BBill1,Total1,Status1,month1,year1);
				list.add(record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tblHistory.setItems(list);
        
        }
    }
    
    @FXML
    void doExportToExcel(ActionEvent event) {
    	try {
			writeExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void writeExcel() throws Exception {
        Writer writer = null;
        try {
        	FileChooser chooser=new FileChooser();
	    	
        	chooser.setTitle("Select Path:");
        	
        	chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Files", "*.*")
                    
                );
        	 File file=chooser.showSaveDialog(null);
        	String filePath=file.getAbsolutePath();
        	if(!(filePath.endsWith(".csv")||filePath.endsWith(".CSV")))
        	{
        		System.out.println("file name should have .csv extension");
        		return;
        	}
        	 file = new File(filePath); 
            writer = new BufferedWriter(new FileWriter(file));
            String text="Mobile Number,Total Cow Quantity,Total Buffallo Quantity,Total Cow Bill,Total Buffallo Bill,Total Bill,Status,Month,Year\n";
            writer.write(text);
            for (BillHistoryBean p : list)
            {
				text = p.getMobile()+ "," + p.getCqT()+ "," + p.getBqT()+ "," + p.getCBill()+","+p.getBBill()+","+p.getTotal()+","+p.getStatus()+","+p.getMonth()+","+p.getYear()+"\n";
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
           
            writer.flush();
             writer.close();
        }
    }

    Connection con;
    PreparedStatement pst;

    @FXML
    void initialize() {
    	con=MySqlConnection.doConnect();
    	ArrayList<Integer> months = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        ArrayList<Integer> years = new ArrayList<Integer>(Arrays.asList(2017,2018,2019,2020,2021,2022));
        combomonth.getItems().addAll(months);
        comboyear.getItems().addAll(years);
    }
}
