package customerFinder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import connection.MySqlConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

public class CustomerFinderViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboArea;

    @FXML
    private TextField txtName;

    @FXML
    private TableView<CustomerFinderBean> tblCustomers;
    
    ObservableList<CustomerFinderBean> list;
    
    @FXML
    void doFetch(ActionEvent event) {
    	TableColumn<CustomerFinderBean,String> mobile = new TableColumn<CustomerFinderBean,String>("Mobile");
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        
        TableColumn<CustomerFinderBean,String> name = new TableColumn<CustomerFinderBean,String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("CName"));
        
        TableColumn<CustomerFinderBean,String> address = new TableColumn<CustomerFinderBean,String>("Address");
        address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        
        TableColumn<CustomerFinderBean,String> area = new TableColumn<CustomerFinderBean,String>("Area");
        area.setCellValueFactory(new PropertyValueFactory<>("Area"));
        
        TableColumn<CustomerFinderBean,String> city = new TableColumn<CustomerFinderBean,String>("City");
        city.setCellValueFactory(new PropertyValueFactory<>("City"));
        
        TableColumn<CustomerFinderBean,String> cq = new TableColumn<CustomerFinderBean,String>("Cow Quantity");
        cq.setCellValueFactory(new PropertyValueFactory<>("cq"));
        
        TableColumn<CustomerFinderBean,String> cp = new TableColumn<CustomerFinderBean,String>("Cow Milk Price");
        cp.setCellValueFactory(new PropertyValueFactory<>("cp"));
        
        TableColumn<CustomerFinderBean,String> bq = new TableColumn<CustomerFinderBean,String>("Buffallo Quantity");
        bq.setCellValueFactory(new PropertyValueFactory<>("bq"));
        
        TableColumn<CustomerFinderBean,String> bp = new TableColumn<CustomerFinderBean,String>("Buffallo Milk Price");
        bp.setCellValueFactory(new PropertyValueFactory<>("bp"));
        
        TableColumn<CustomerFinderBean,String> date = new TableColumn<CustomerFinderBean,String>("Date of start");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        tblCustomers.getColumns().clear();
        tblCustomers.getColumns().addAll(mobile,name,address,area,city,cq,cp,bq,bp,date);
        
         list=FXCollections.observableArrayList();
		try {
			pst=con.prepareStatement("select * from customers where Area=?");
			pst.setString(1, comboArea.getValue());
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String mobile1=rs.getString("mobile");								
				String CName1=rs.getString("CName");							
				String Address1=rs.getString("Address");								
				String Area1=rs.getString("Area");							
				String City1=rs.getString("City");						
			    float cq1=rs.getFloat("cq");			
				float cp1=rs.getFloat("cp");			
				float bq1=rs.getFloat("bq");			
				float bp1=rs.getFloat("bp");							
				Date date2 = rs.getDate("dos");
				String date1 = date2.toString();
				
				CustomerFinderBean customer = new CustomerFinderBean(mobile1,CName1,Address1,Area1,City1,cq1,cp1,bq1,bp1,date1);
				list.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tblCustomers.setItems(list);
    }

    @FXML
    void doFetchAllRecords(ActionEvent event) {
     TableColumn<CustomerFinderBean,String> mobile = new TableColumn<CustomerFinderBean,String>("Mobile");
     mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
     
     TableColumn<CustomerFinderBean,String> name = new TableColumn<CustomerFinderBean,String>("Name");
     name.setCellValueFactory(new PropertyValueFactory<>("CName"));
     
     TableColumn<CustomerFinderBean,String> address = new TableColumn<CustomerFinderBean,String>("Address");
     address.setCellValueFactory(new PropertyValueFactory<>("Address"));
     
     TableColumn<CustomerFinderBean,String> area = new TableColumn<CustomerFinderBean,String>("Area");
     area.setCellValueFactory(new PropertyValueFactory<>("Area"));
     
     TableColumn<CustomerFinderBean,String> city = new TableColumn<CustomerFinderBean,String>("City");
     city.setCellValueFactory(new PropertyValueFactory<>("City"));
     
     TableColumn<CustomerFinderBean,String> cq = new TableColumn<CustomerFinderBean,String>("Cow Quantity");
     cq.setCellValueFactory(new PropertyValueFactory<>("cq"));
     
     TableColumn<CustomerFinderBean,String> cp = new TableColumn<CustomerFinderBean,String>("Cow Milk Price");
     cp.setCellValueFactory(new PropertyValueFactory<>("cp"));
     
     TableColumn<CustomerFinderBean,String> bq = new TableColumn<CustomerFinderBean,String>("Buffallo Quantity");
     bq.setCellValueFactory(new PropertyValueFactory<>("bq"));
     
     TableColumn<CustomerFinderBean,String> bp = new TableColumn<CustomerFinderBean,String>("Buffallo Milk Price");
     bp.setCellValueFactory(new PropertyValueFactory<>("bp"));
     
     TableColumn<CustomerFinderBean,String> date = new TableColumn<CustomerFinderBean,String>("Date of start");
     date.setCellValueFactory(new PropertyValueFactory<>("date"));
     
     tblCustomers.getColumns().clear();
     tblCustomers.getColumns().addAll(mobile,name,address,area,city,cq,cp,bq,bp,date);
     
      list=FXCollections.observableArrayList();
		try {
			pst=con.prepareStatement("select * from customers");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String mobile1=rs.getString("mobile");								
				String CName1=rs.getString("CName");							
				String Address1=rs.getString("Address");								
				String Area1=rs.getString("Area");							
				String City1=rs.getString("City");						
			    float cq1=rs.getFloat("cq");			
				float cp1=rs.getFloat("cp");			
				float bq1=rs.getFloat("bq");			
				float bp1=rs.getFloat("bp");							
				Date date2 = rs.getDate("dos");
				String date1 = date2.toString();
				
				CustomerFinderBean customer = new CustomerFinderBean(mobile1,CName1,Address1,Area1,City1,cq1,cp1,bq1,bp1,date1);
				list.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
     tblCustomers.setItems(list);
    }

    @FXML
    void doSearch(ActionEvent event) {
    	TableColumn<CustomerFinderBean,String> mobile = new TableColumn<CustomerFinderBean,String>("Mobile");
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        
        TableColumn<CustomerFinderBean,String> name = new TableColumn<CustomerFinderBean,String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("CName"));
        
        TableColumn<CustomerFinderBean,String> address = new TableColumn<CustomerFinderBean,String>("Address");
        address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        
        TableColumn<CustomerFinderBean,String> area = new TableColumn<CustomerFinderBean,String>("Area");
        area.setCellValueFactory(new PropertyValueFactory<>("Area"));
        
        TableColumn<CustomerFinderBean,String> city = new TableColumn<CustomerFinderBean,String>("City");
        city.setCellValueFactory(new PropertyValueFactory<>("City"));
        
        TableColumn<CustomerFinderBean,String> cq = new TableColumn<CustomerFinderBean,String>("Cow Quantity");
        cq.setCellValueFactory(new PropertyValueFactory<>("cq"));
        
        TableColumn<CustomerFinderBean,String> cp = new TableColumn<CustomerFinderBean,String>("Cow Milk Price");
        cp.setCellValueFactory(new PropertyValueFactory<>("cp"));
        
        TableColumn<CustomerFinderBean,String> bq = new TableColumn<CustomerFinderBean,String>("Buffallo Quantity");
        bq.setCellValueFactory(new PropertyValueFactory<>("bq"));
        
        TableColumn<CustomerFinderBean,String> bp = new TableColumn<CustomerFinderBean,String>("Buffallo Milk Price");
        bp.setCellValueFactory(new PropertyValueFactory<>("bp"));
        
        TableColumn<CustomerFinderBean,String> date = new TableColumn<CustomerFinderBean,String>("Date of start");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        tblCustomers.getColumns().clear();
        tblCustomers.getColumns().addAll(mobile,name,address,area,city,cq,cp,bq,bp,date);
        list=FXCollections.observableArrayList();
		try {
			pst=con.prepareStatement("select * from customers where CName like ?");
			pst.setString(1, "%"+txtName.getText()+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String mobile1=rs.getString("mobile");								
				String CName1=rs.getString("CName");							
				String Address1=rs.getString("Address");								
				String Area1=rs.getString("Area");							
				String City1=rs.getString("City");						
			    float cq1=rs.getFloat("cq");			
				float cp1=rs.getFloat("cp");			
				float bq1=rs.getFloat("bq");			
				float bp1=rs.getFloat("bp");							
				Date date2 = rs.getDate("dos");
				String date1 = date2.toString();
				
				CustomerFinderBean customer = new CustomerFinderBean(mobile1,CName1,Address1,Area1,City1,cq1,cp1,bq1,bp1,date1);
				list.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tblCustomers.setItems(list);
    }
    
    ObservableList<CustomerFinderBean> getRecords1(String name)
    {
		ObservableList<CustomerFinderBean> list=FXCollections.observableArrayList();
		try {
			pst=con.prepareStatement("select * from customers where CName like ?");
			pst.setString(1, "%"+name+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String mobile=rs.getString("mobile");								
				String CName=rs.getString("CName");							
				String Address=rs.getString("Address");								
				String Area=rs.getString("Area");							
				String City=rs.getString("City");						
			    float cq=rs.getFloat("cq");			
				float cp=rs.getFloat("cp");			
				float bq=rs.getFloat("bq");			
				float bp=rs.getFloat("bp");							
				Date date1 = rs.getDate("dos");
				String date = date1.toString();
				
				CustomerFinderBean customer = new CustomerFinderBean(mobile,CName,Address,Area,City,cq,cp,bq,bp,date);
				list.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    }

    @FXML
    void doExportToExcel(ActionEvent event) {
    	try {
			writeExcel();
			System.out.println("Exported to excel");
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
            String text="Mobile Number,Customer Name,Address,Area,City,Cow Quantity,Cow Milk Price,Buffallo Quantity,Buffallo Milk Price,Date Of Start\n";
            writer.write(text);
            for (CustomerFinderBean p : list)
            {
				text = p.getMobile()+ "," + p.getCName()+ "," + p.getAddress()+ "," + p.getArea()+","+p.getCity()+","+p.getCq()+","+p.getCp()+","+p.getBq()+","+p.getBp()+","+p.getDate()+"\n";
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
    
    void doFill()
    {
    	comboArea.getItems().clear();
    	try {
			pst=con.prepareStatement("select distinct Area from customers");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				comboArea.getItems().add(rs.getString("Area"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void initialize() {
        con=MySqlConnection.doConnect();
        doFill();
    }
}
