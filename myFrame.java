package oopBD_SilviqDancheva;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class myFrame {

	dataBase db = new dataBase();
	
	String[] values;
	String Table;
	String colums;

	JFrame jf = new JFrame();

	// PANELS
	JPanel panel = new JPanel();
	JPanel wellcomePanel = new JPanel();
	JPanel addUserPanel = new JPanel();
	JPanel addAdressPanel = new JPanel();
	JPanel addItemPanel = new JPanel();

	JPanel allTables = new JPanel();
	JPanel queryPanel = new JPanel();
	
	CardLayout cardLayout = new CardLayout();

	JLabel wellcome = new JLabel("Wellcome!");
	JLabel getStarted = new JLabel("Get started...");

	// FOR ADD ADRESS
	JLabel addAdress = new JLabel("Add new Adress");
	JLabel CountryL = new JLabel("Country: ");
	JTextField CountryTF = new JTextField();
	JLabel CityL = new JLabel("City: ");
	JTextField CityTF = new JTextField();
	JLabel StreetL = new JLabel("Street: ");
	JTextField StreetTF = new JTextField();

	// FOR USER
	JLabel addUser = new JLabel("Add new User..");
	JLabel usernameL = new JLabel("Username:");
	JTextField usernameTF = new JTextField();
	String[] gender = { "female", "male", "other" };
	JLabel genderL = new JLabel("Gender:");
	JComboBox<String> genderCB = new JComboBox<String>(gender);
	List<String> adr = db.getAll("adress", "[id],[Country]");
	String[] adresses = adr.toArray(new String[0]);
	JLabel adressL = new JLabel("Adress:");
	JComboBox<String> adressCB = new JComboBox<String>(adresses);

	// FOR ITEM

	JLabel addItem = new JLabel("Add new Item..");
	JLabel nameL = new JLabel("Item Name:");
	JTextField nameTF = new JTextField();
	JLabel descriptionL = new JLabel("Description:");
	JTextField descriptionTF = new JTextField();
	JLabel priceL = new JLabel("Price (BGN):");
	JTextField priceTF = new JTextField();
	List<String> usrs = db.getAll("users", "[id],[username]");
	String[] users = usrs.toArray(new String[0]);
	JLabel sellerL = new JLabel("Choose seller:");
	JComboBox<String> sellerCB = new JComboBox<String>(users);
	JLabel buyerL = new JLabel("Choose buyer:");
	JComboBox<String> buyerCB = new JComboBox<String>(users);

	JButton addAdressBt = new JButton("NEW ADRESS");
	JButton addUserBt = new JButton("NEW USER");
	JButton addItemBt = new JButton("NEW ITEM");

	// --------------FOR TABLES-------------
	// -Adress Table
	ArrayList<Adress> adressDataFromDb = db.adressList();
	String[] ColumnNamesForAdressTable = { "id", "country", "city", "street" };
	DefaultTableModel tableModelA = new DefaultTableModel(ColumnNamesForAdressTable, 0);
	JTable adressTable = new JTable(tableModelA);
	JPanel adressFields = new JPanel();
	JLabel adressId = new JLabel();
	JTextField adressCountry = new JTextField();
	JTextField adressCity = new JTextField();
	JTextField adressStreet = new JTextField();
	JButton adressUpdateBt = new JButton("Edit");
	JButton adressDeleteBt = new JButton("Delete");
	JPanel adressButtons = new JPanel();
	JPanel adressPanel = new JPanel();
	JScrollPane sp1 = new JScrollPane(adressTable);

	// -User Table
	ArrayList<User> userDataFromDb = db.userList();
	String[] ColumnNamesForUserTable = { "id", "username", "gender", "adress Id", "country" };
	DefaultTableModel tableModelU = new DefaultTableModel(ColumnNamesForUserTable, 0);
	JTable userTable = new JTable(tableModelU);
	JPanel userFields = new JPanel();
	JLabel userId = new JLabel();
	JTextField userUsername = new JTextField();
	JTextField userGender = new JTextField();
	JComboBox<String> userAdress = new JComboBox<String>(adresses);
	JButton userUpdateBt = new JButton("Edit");
	JButton userDeleteBt = new JButton("Delete");
	JPanel userButtons = new JPanel();
	JPanel userPanel = new JPanel();
	JScrollPane sp2 = new JScrollPane(userTable);

	// -Item Table
	ArrayList<Item> itemDataFromDb = db.itemList();
	String[] ColumnNamesForItemTable = { "id", "name", "description", "seller", "buyer", "price" };
	DefaultTableModel tableModelI = new DefaultTableModel(ColumnNamesForItemTable, 0);
	JTable itemTable = new JTable(tableModelI);
	JPanel itemFields = new JPanel();
	JLabel itemId = new JLabel();
	JTextField itemName = new JTextField();
	JTextField itemDescription = new JTextField();
	JComboBox<String> itemSellerCB = new JComboBox<String>(users);
	JComboBox<String> itemBuyerCB = new JComboBox<String>(users);
	JTextField itemPrice = new JTextField();
	JButton itemUpdateBt = new JButton("Edit");
	JButton itemDeleteBt = new JButton("Delete");
	JPanel itemButtons = new JPanel();
	JPanel itemPanel = new JPanel();
	JScrollPane sp3 = new JScrollPane(itemTable);
	
	//Query Table
	JPanel choicesPanel = new JPanel();
	JLabel titleQueryPanel = new JLabel("Make a Query");
	JPanel chPanel = new JPanel();
	String[] CBitems = {"id","name","description","sellerId", "buyerId","price"};
	JComboBox<String> chooseFromItem1 = new JComboBox<String>(CBitems);
	JComboBox<String> chooseFromItem2 = new JComboBox<String>(CBitems);
	JPanel SearchPanel = new JPanel();
	JTextField typeForItem = new JTextField();
	JTextField typeForUser = new JTextField();
	JTextField typeForAdress = new JTextField();
	JButton makeSearch = new JButton("Make Search");
	String[] CBusers = {"id","username","gender","adressId"};
	JComboBox<String> chooseFromUser = new JComboBox<String>(CBusers);
	String[] CBadress= {"id","country","city","street"};
	JComboBox<String> chooseFromAdress= new JComboBox<String>(CBadress);
	JPanel radioBoxPanel = new JPanel();
	JRadioButton sellerId = new JRadioButton("Make the query for Seller");
	JRadioButton buyerId = new JRadioButton("Make the query for Buyer");
	ButtonGroup groupBt = new ButtonGroup();
	JButton makeQuery = new JButton("Make a Query");
	String[] ColumnNamesForQueryTable = {"-", "-","-", "-"}; 
	DefaultTableModel tableModelQ = new DefaultTableModel(ColumnNamesForQueryTable,0);
	JTable queryTable = new JTable(tableModelQ);
	JScrollPane querySP = new JScrollPane(queryTable);
	
	
	

	public myFrame() {
		// CREATE FRAME
		jf.setSize(500, 500);
		jf.setTitle("SALES");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(cardLayout);
		menu();

		wellcomePanel.add(wellcome);
		wellcomePanel.add(getStarted);
		panel.add(wellcomePanel, "wp");
		panel.add(addAdressPanel, "addAdress");
		panel.add(addUserPanel, "addUser");
		panel.add(addItemPanel, "addItem");

		panel.add(allTables, "allTables");
		panel.add(queryPanel,"queryPanel");

		cardLayout.show(panel, "wp");

		buildPanels();

		jf.add(panel);
		jf.setVisible(true);
	}

	void menu() {
		// CREATE MENU
		JMenuBar jmb = new JMenuBar();

		jf.setJMenuBar(jmb);

		// SET BLOCKS IN THE MENU
		JMenu add = new JMenu("Add New");
		jmb.add(add);

		JMenu Tables = new JMenu("Tables");
		jmb.add(Tables);

		JMenuItem user = new JMenuItem("User");
		JMenuItem adress = new JMenuItem("Adress");
		JMenuItem item = new JMenuItem("Item");

		JMenuItem all = new JMenuItem("All");
		JMenuItem query = new JMenuItem("Query");

		add.add(adress);
		add.addSeparator();
		add.add(user);
		add.addSeparator();
		add.add(item);

		Tables.add(all);
		add.addSeparator();
		Tables.add(query);

		// ACTION LISTENERS

		adress.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.show(panel, "addAdress");
			}
		});

		user.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(panel, "addUser");
			}
		});

		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(panel, "addItem");

			}
		});

		all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "allTables");
			}
		});
		
		query.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "queryPanel");
			}
		});
	}

	// CLASS TO ADD
	class AddAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "NEW ADRESS") {
				Table = "adress";
				colums = "(country, city, street)";
				String[] val = { CountryTF.getText(), CityTF.getText(), StreetTF.getText() };
				values = val;
			}
			if (e.getActionCommand() == "NEW USER") {
				Table = "users";
				colums = "(username, gender, adressId)";
				String adress = adressCB.getSelectedItem().toString();
				adress = adress.substring(0, adress.indexOf(" "));
				String[] val = { usernameTF.getText(), genderCB.getSelectedItem().toString(), adress };
				values = val;
			}
			if (e.getActionCommand() == "NEW ITEM") {
				Table = "item";
				colums = "(name, description, price, sellerId, buyerId)";
				String seller = sellerCB.getSelectedItem().toString();
				seller = seller.substring(0, seller.indexOf(" "));
				String buyer = buyerCB.getSelectedItem().toString();
				buyer = buyer.substring(0, buyer.indexOf(" "));
				String[] val = { nameTF.getText(), descriptionTF.getText(), priceTF.getText(), seller, buyer };
				values = val;

			}

			db.insert(Table, colums, values);

		}
	}

	// UPDATE CLASS
	class UpdateAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String Table = null;
			String[] col = null;
			String[] val = null;
			int id = 0;
			if (e.getSource().equals(adressUpdateBt) && adressId.getText() != null && adressId.getText() != "") {
				Table = "adress";
				String[] bufferC = new String[3];
				bufferC[0] = "country";
				bufferC[1] = "city";
				bufferC[2] = "street";
				col = bufferC;
				String[] bufferV = new String[3];
				bufferV[0] = adressCountry.getText();
				bufferV[1] = adressCity.getText();
				bufferV[2] = adressStreet.getText();
				val = bufferV;
				id = Integer.parseInt(adressId.getText());
			}
			if (e.getSource().equals(userUpdateBt) && userId.getText() != null && userId.getText() != "") {
				Table = "users";
				String[] BufferC = { "username", "gender", "adressId" };
				col = BufferC;
				String[] BufferV = new String[3];
				String adress = userAdress.getSelectedItem().toString();
				adress = adress.substring(0, adress.indexOf(" "));
				BufferV[0] = userUsername.getText();
				BufferV[1] = userGender.getText();
				BufferV[2] = adress;
				val = BufferV;
				id = Integer.parseInt(userId.getText());
			}
			if (e.getSource().equals(itemUpdateBt) && itemId.getText() != null && itemId.getText() != "") {
				Table = "item";
				String[] BufferC = { "name", "description", "sellerId", "buyerId", "price" };
				col = BufferC;
				String[] BufferV = new String[5];
				BufferV[0] = itemName.getText();
				BufferV[1] = itemDescription.getText();
				BufferV[2] = itemSellerCB.getSelectedItem().toString();
				BufferV[2] = BufferV[2].substring(0, BufferV[2].indexOf(" "));
				BufferV[3] = itemBuyerCB.getSelectedItem().toString();
				BufferV[3] = BufferV[3].substring(0, BufferV[3].indexOf(" "));
				BufferV[4] = itemPrice.getText();
				val = BufferV;
				id = Integer.parseInt(itemId.getText());
			}

			db.updateRow(Table, col, val, id);
		}

	}

	// DELETE CLASS
	class DeleteAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String Table = null;
			int id = 0;
			if (e.getSource().equals(adressDeleteBt) && adressId.getText() != null && adressId.getText() != "") {
				Table = "adress";
				id = Integer.parseInt(adressId.getText());
			}
			if (e.getSource().equals(userDeleteBt) && userId.getText() != null && userId.getText() != "")
			{
				Table = "users";
				id = Integer.parseInt(userId.getText());
			}

			if (e.getSource().equals(itemDeleteBt) && itemId.getText() != null && itemId.getText() != "") {
				Table = "item";
				id = Integer.parseInt(itemId.getText());
			}
			db.deleteRow(Table, id);
		}

	}

	//MAKE QUERY 
	class makeQueryAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String fromItem= chooseFromItem1.getSelectedItem().toString();
			String fromItem2 = chooseFromItem2.getSelectedItem().toString();
			String fromUser = chooseFromUser.getSelectedItem().toString();
			String fromAdress = chooseFromAdress.getSelectedItem().toString();
			String queryChoice=null;
			if(groupBt.getSelection()!=null)
			queryChoice = groupBt.getSelection().getActionCommand().toString();
			
			List<String> queryDataFromDb = new ArrayList<String>();
			if(queryChoice!=null)
			queryDataFromDb = db.makeQuery(fromItem,fromItem2, fromUser, fromAdress, queryChoice);
			
			
			ColumnNamesForQueryTable[0] = fromItem;
			ColumnNamesForQueryTable[1] = fromItem2;
			ColumnNamesForQueryTable[2] = fromUser;
			ColumnNamesForQueryTable[3] = fromAdress;
			tableModelQ = new DefaultTableModel(ColumnNamesForQueryTable,0);
			Object[] rowQ = new Object[4];
			for (int i = 0; i <= queryDataFromDb.size()-4; i=i+4) {
				rowQ[0] = queryDataFromDb.get(i);
				rowQ[1] = queryDataFromDb.get(i+1);
				rowQ[2] = queryDataFromDb.get(i+2);
				rowQ[3] = queryDataFromDb.get(i+3);
				tableModelQ.addRow(rowQ);
			}
			queryTable = new JTable(tableModelQ);
			querySP = new JScrollPane(queryTable);
			queryPanel.removeAll();
			queryPanel.add(choicesPanel);
			queryPanel.add(querySP);

			
		}
		
	}
	// BUILD UP PANELS
	void buildPanels() {
		// ------------------PANELS--------------------------
		// add new address
		addAdressPanel.setLayout(new GridLayout(5, 2));
		addAdressPanel.add(new JLabel(" "));
		addAdressPanel.add(addAdress);
		addAdressPanel.add(CountryL);
		addAdressPanel.add(CountryTF);
		addAdressPanel.add(CityL);
		addAdressPanel.add(CityTF);
		addAdressPanel.add(StreetL);
		addAdressPanel.add(StreetTF);
		addAdressPanel.add(new JLabel(" "));
		addAdressPanel.add(addAdressBt);
		addAdressBt.addActionListener(new AddAction());

		// add new User
		addUserPanel.setLayout(new GridLayout(5, 2));
		addUserPanel.add(addUser);
		addUserPanel.add(new JLabel(" "));
		addUserPanel.add(usernameL);
		addUserPanel.add(usernameTF);
		addUserPanel.add(genderL);
		addUserPanel.add(genderCB);
		addUserPanel.add(adressL);
		addUserPanel.add(adressCB);
		addUserPanel.add(new JLabel(" "));
		addUserPanel.add(addUserBt);
		addUserBt.addActionListener(new AddAction());

		// add new Item
		addItemPanel.setLayout(new GridLayout(7, 2));
		addItemPanel.add(addItem);
		addItemPanel.add(new JLabel(" "));
		addItemPanel.add(nameL);
		addItemPanel.add(nameTF);
		addItemPanel.add(descriptionL);
		addItemPanel.add(descriptionTF);
		addItemPanel.add(priceL);
		addItemPanel.add(priceTF);
		addItemPanel.add(sellerL);
		addItemPanel.add(sellerCB);
		addItemPanel.add(buyerL);
		addItemPanel.add(buyerCB);
		addItemPanel.add(new JLabel(" "));
		addItemPanel.add(addItemBt);
		addItemBt.addActionListener(new AddAction());

		createTables();

	}

	
	void createTables() {
		// All TABLES WITHOUT FILTERS
		// Adress Table
		
		Object[] rowA = new Object[4];
		for (int i = 0; i < adressDataFromDb.size(); i++) {
			rowA[0] = adressDataFromDb.get(i).getId();
			rowA[1] = adressDataFromDb.get(i).getCoutry();
			rowA[2] = adressDataFromDb.get(i).getCity();
			rowA[3] = adressDataFromDb.get(i).getStreet();
			tableModelA.addRow(rowA);
		}

		adressFields.setLayout(new GridLayout(1, 6));
		adressFields.add(adressId);
		adressFields.add(adressCountry);
		adressFields.add(adressCity);
		adressFields.add(adressStreet);
		adressUpdateBt.addActionListener(new UpdateAction());
		adressButtons.add(adressUpdateBt);
		adressDeleteBt.addActionListener(new DeleteAction());
		adressButtons.add(adressDeleteBt);
		adressPanel.setLayout(new GridLayout(2, 1));
		adressPanel.add(adressFields);
		adressPanel.add(adressButtons); 

		updateTFAdress();

		// User Table
		Object[] rowU = new Object[5];
		for (int i = 0; i < userDataFromDb.size(); i++) {
			rowU[0] = userDataFromDb.get(i).getId();
			rowU[1] = userDataFromDb.get(i).getUsername();
			rowU[2] = userDataFromDb.get(i).getGender();
			rowU[3] = userDataFromDb.get(i).getAdress().id;
			rowU[4] = userDataFromDb.get(i).getAdress().country;
			tableModelU.addRow(rowU);
		}

		userFields.setLayout(new GridLayout(1, 3));
		userFields.add(userId);
		userFields.add(userUsername);
		userFields.add(userGender);
		userFields.add(userAdress);
		userUpdateBt.addActionListener(new UpdateAction());
		userDeleteBt.addActionListener(new DeleteAction());
		userButtons.add(userUpdateBt);
		userButtons.add(userDeleteBt);
		userPanel.setLayout(new GridLayout(2, 1));
		userPanel.add(userFields);
		userPanel.add(userButtons);

		updateTFUser();

		Object[] rowI = new Object[6];
		for (int i = 0; i < itemDataFromDb.size(); i++) {
			rowI[0] = itemDataFromDb.get(i).getId();
			rowI[1] = itemDataFromDb.get(i).getName();
			rowI[2] = itemDataFromDb.get(i).getDescription();
			rowI[3] = itemDataFromDb.get(i).getSeller().getUsername();
			if (itemDataFromDb.get(i).getBuyer() != null)
				rowI[4] = itemDataFromDb.get(i).getBuyer().getUsername();
			else
				rowI[4] = "-";
			rowI[5] = itemDataFromDb.get(i).getPrice();
			tableModelI.addRow(rowI);
		}

		itemFields.setLayout(new GridLayout(1, 6));
		itemFields.add(itemId);
		itemFields.add(itemName);
		itemFields.add(itemDescription);
		itemFields.add(itemSellerCB);
		itemFields.add(itemBuyerCB);
		itemFields.add(itemPrice);
		itemUpdateBt.addActionListener(new UpdateAction());
		itemDeleteBt.addActionListener(new DeleteAction());
		itemButtons.add(itemUpdateBt);
		itemButtons.add(itemDeleteBt);
		itemPanel.setLayout(new GridLayout(2, 1));
		itemPanel.add(itemFields);
		itemPanel.add(itemButtons);

		updateTfItem();

		// ALL TABLES
		allTables.setLayout(new GridLayout(6, 1));
		allTables.add(sp1);
		allTables.add(adressPanel);
		allTables.add(sp2);
		allTables.add(userPanel);
		allTables.add(sp3);
		allTables.add(itemPanel);
		
		//QUERY TABLE

		choicesPanel.setLayout(new GridLayout(6,1));
		choicesPanel.add(titleQueryPanel);
		chPanel.add(chooseFromItem1);
		chPanel.add(chooseFromItem2);
		chPanel.add(chooseFromUser);
		chPanel.add(chooseFromAdress);
		choicesPanel.add(chPanel);
		sellerId.setActionCommand("sellerId");
		buyerId.setActionCommand("buyerId");
		groupBt.add(sellerId);
		groupBt.add(buyerId);
		radioBoxPanel.add(sellerId);
		radioBoxPanel.add(buyerId);
		choicesPanel.add(radioBoxPanel);
		
		makeQuery.addActionListener(new makeQueryAction());
		
		choicesPanel.add(makeQuery);
		
		SearchPanel.setLayout(new GridLayout(1,4));
		SearchPanel.add(typeForItem);
		SearchPanel.add(typeForUser);
		SearchPanel.add(typeForAdress);
	
		SearchPanel.add(makeSearch);
		choicesPanel.add(SearchPanel);
		
		queryPanel.setLayout(new GridLayout(2,1));
		queryPanel.add(choicesPanel);
		queryPanel.add(querySP);
	
		
		
	}

	// Display selected Row in Fields under the table
	void updateTFAdress() {
		adressTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int a = adressTable.getSelectedRow();
				adressId.setText(adressTable.getModel().getValueAt(a, 0).toString());
				adressCountry.setText(adressTable.getModel().getValueAt(a, 1).toString());
				adressCity.setText(adressTable.getModel().getValueAt(a, 2).toString());
				adressStreet.setText(adressTable.getModel().getValueAt(a, 3).toString());
			}
		});
	}

	// Display selected Row in Fields under the table
	void updateTFUser() {
		userTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int u = userTable.getSelectedRow();
				userId.setText(userTable.getModel().getValueAt(u, 0).toString());
				userUsername.setText(userTable.getModel().getValueAt(u, 1).toString());
				userGender.setText(userTable.getModel().getValueAt(u, 2).toString());
				String stringForCB = userTable.getModel().getValueAt(u, 3).toString() + " - "
						+ userTable.getModel().getValueAt(u, 4).toString();
				int indexForCB = Arrays.asList(adresses).indexOf(stringForCB);
				userAdress.setSelectedIndex(indexForCB);
			}
		});
	}

	// Display selected Row in Fields under the table
	void updateTfItem() {
		itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int u = itemTable.getSelectedRow();
				itemId.setText(itemTable.getModel().getValueAt(u, 0).toString());
				itemName.setText(itemTable.getModel().getValueAt(u, 1).toString());
				itemDescription.setText(itemTable.getModel().getValueAt(u, 2).toString());

				String stringForSellerCB = itemTable.getModel().getValueAt(u, 3).toString();
				int indexForSellerCb = 1;
				for (int i = 0; i < users.length; i++) {
					if (users[i].contains(stringForSellerCB)) {
						indexForSellerCb = i;
						break;
					}
				}
				itemSellerCB.setSelectedIndex(indexForSellerCb);

				String stringForBuyerCb = itemTable.getModel().getValueAt(u, 4).toString();
				int indexForBuyerCb = 1;
				for (int i = 0; i < users.length; i++) {
					if (users[i].contains(stringForBuyerCb)) {
						indexForBuyerCb = i;
						break;
					}
				}
				itemBuyerCB.setSelectedIndex(indexForBuyerCb);

				itemPrice.setText(itemTable.getModel().getValueAt(u, 5).toString());
			}
		});
	}

	
}
