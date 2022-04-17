package oopBD_SilviqDancheva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class dataBase {

	List<Adress> adresses = new ArrayList<>();
	List<User> users = new ArrayList<>();

	// conecting to the datebase
	Connection connect() {
		String url = "jdbc:sqlserver://DESKTOP-T260KV7;databaseName=bookShop;encrypt=true;trustServerCertificate=true";
		String user = "sisi";
		String pass = "sisi";
		
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Could not connect to the server. Try Again!");
			e.printStackTrace();
		}
		return connection;
	}

	void insert (String table, String columns, String[] values) {

		Connection connection = connect();

		String val = "(";
		for (int i = 0; i < values.length; i++) {
			val = val + "'" + values[i] + "'";
			if (i < values.length - 1)
				val = val + ",";
			else
				val = val + ")";
		}

		try {
			 
			String sql = "INSERT INTO [bookShop].[dbo].[" + table +"] " + columns + " VALUES " + val;
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate(sql);
			if (rows > 0) {
				JOptionPane.showMessageDialog(null, "Insered successfuly!");
			}
			connection.close();
		 } catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error! Try Again!");
		}
	}
	
	void updateRow(String Table, String[] column, String[] value, int id) {

		Connection connection = connect();
		if(Table!=null)
		try {
			String sql = "UPDATE " + Table + " SET ";
			
			for(int i=0; i<column.length; i ++) {
				if(i<column.length-1)
					sql = sql + column[i] + " = '" + value[i] + "', ";
				else 
					sql = sql + column[i] + " = '" + value[i] + "' ";
			}
			sql = sql + "WHERE id= " + id + ";";
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate(sql);

			if (rows > 0) {
				JOptionPane.showMessageDialog(null, "Updated Successfully!");
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid Data!");
			
			connection.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error!");
			e.printStackTrace();
		}
	}
	
	void deleteRow(String table, int id) {
		Connection connection = connect();
		if(table!=null)
		try {
			
			String sql = "DELETE FROM " + table + " WHERE id=" + id + ";";
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate(sql);
			if(rows > 0)
				JOptionPane.showMessageDialog(null, "Deleted successfuly!");
			else 
				JOptionPane.showMessageDialog(null, "Invalid Data!");
			connection.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error!");
			e.printStackTrace();
		}
	}
	
	
	List<String> getAll(String Table, String columns) {
		Connection connection = connect();
		Statement stetment = null;
		try {
			stetment = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> values = new ArrayList<>();
		if(stetment!=null)
		try {
			String sql = "SELECT TOP (100) " + columns + " FROM " + Table + ";";
			ResultSet rs = stetment.executeQuery(sql);
			int columnCount = rs.getMetaData().getColumnCount();
			while(rs.next()) {
				String [] row = new String [columnCount];
				for(int i=0; i< columnCount; i++) {
					row[i]= rs.getString(i+1) + " - " + rs.getString(i+2);
					values.add(row[i]);
					i++;
				}
			}
			
			connection.close();
			return values;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return values;
		}
		return values;

	}
	
	//GETING DATA FROM db TABLES
	public ArrayList<Adress> adressList(){
		ArrayList<Adress> adressList = new ArrayList<>();
		Connection connection = connect();
		String query="SELECT * FROM adress";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Adress adress;
			while(rs.next()) {
				adress = new Adress(rs.getInt("id"),rs.getString("country"),rs.getString("city"),rs.getString("street"));
				adresses.add(adress);
				adressList.add(adress);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return adressList;
		
	}
	public ArrayList<User> userList(){
		ArrayList<User> userList = new ArrayList<>();
		Connection connection = connect();
		String query="SELECT * FROM users";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			User user;
			while(rs.next()) {
			
				Adress adr = new Adress();
				int id = rs.getInt("adressId");
				adr = adresses
						  .stream()
						  .filter(c -> c.id == id)
						  .findFirst()
						  .get();
						 
				user = new User(rs.getInt("id"),rs.getString("username"),adr, rs.getString("gender"));
				users.add(user);
				userList.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	public ArrayList<Item> itemList(){
		ArrayList<Item> itemList = new ArrayList<>();
		Connection connection = connect();
		String query="SELECT * FROM item";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Item item;
			while(rs.next()) {
			
				User seller = new User();
				
				int idS = rs.getInt("sellerId");
				seller = users
						  .stream()
						  .filter(c -> c.id == idS)
						  .findFirst()
						  .get();
				
				User buyer = new User();
				
				int idB = rs.getInt("buyerId");
				buyer = users
						  .stream()
						  .filter(c -> c.id == idB)
						  .findFirst()
						  .orElse(null)
						  ;
				
				item = new Item(rs.getInt("id"),rs.getString("name"),rs.getString("description"),seller,buyer,rs.getFloat("price"));
				
				itemList.add(item);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemList;
	}
	
	public List<String> makeQuery(String fromItem1, String fromItem2, String fromUser, String fromAdress, String queryChoice){
		List<String> result = new ArrayList<>();
		Connection connection = connect();
		String query="SELECT item." + fromItem1 + ", item."+ fromItem2 + ", users." + fromUser + ", adress." + fromAdress 
				+ " FROM item "
				+ "INNER JOIN users ON item." + queryChoice + " = users.id "
				+ "INNER JOIN adress ON users.adressId = adress.id";
		System.out.println(query);
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				result.add(rs.getString(fromItem1));
				result.add(rs.getString(fromItem2));
				result.add(rs.getString(fromUser));
				result.add(rs.getString(fromAdress));
			}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
}
