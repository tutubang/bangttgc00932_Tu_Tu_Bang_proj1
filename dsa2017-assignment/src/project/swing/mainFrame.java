package project.swing;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import project.controller.Module_Customer;
import project.controller.Module_Order;
import project.controller.Module_Product;
import project.entity.Customer;
import project.entity.Order;
import project.entity.Product;
import project.my_list.MyList;
import project.my_list.MyNode;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class mainFrame extends JFrame {

	private JPanel pnMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	CardLayout card;
	private static JTable tableCustomer;
	private JTextField txtCCode;
	private JTextField txtCName;
	private JTextField txtCPhone;
	Module_Customer module_customer;
	Module_Product module_Product;
	Module_Order module_Order;
	private JTextField txtCSearch;
	private JTextField txtPCode;
	private JTextField txtPQuantity;
	private JTextField txtPName;
	private JTextField txtPSearch;
	private JTable tableProduct;
	private JTextField txtPSale;
	private JTextField txtPPrice;
	private JTable tableOrder;

	public mainFrame() {
		module_customer = new Module_Customer();
		module_Product = new Module_Product();
		module_Order = new Module_Order();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 412);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnProduct = new JMenu("Product");
		menuBar.add(mnProduct);

		JMenuItem mntmLoad_1 = new JMenuItem("Load");
		mntmLoad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showDataProduct();
				card.show(pnMain, "cardProduct");
			}
		});
		mnProduct.add(mntmLoad_1);

		JMenuItem mntmSortByPcode = new JMenuItem("Sort By Pcode");
		mntmSortByPcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyList<Product> myList = module_Product.readData();
				module_Product.sortByPcode(myList);
				int stt = 0;
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("STT");
				model.addColumn("ID");
				model.addColumn("Pro_name");
				model.addColumn("Quantity");
				model.addColumn("Sale");
				model.addColumn("Price");
				for (Product c : myList) {
					model.addRow(new Object[] { stt += 1, c.getPcode(), c.getPro_name(), c.getQuantity(), c.getSale(),
							c.getPrice() });
				}
				tableProduct.getTableHeader().setReorderingAllowed(false);
				tableProduct.setEnabled(false);
				tableProduct.setModel(model);
			}
		});
		mnProduct.add(mntmSortByPcode);

		JMenu mnCustomer = new JMenu("Customer");
		menuBar.add(mnCustomer);

		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDataCustomer();
				card.show(pnMain, "cardCustomer");

			}
		});
		mnCustomer.add(mntmLoad);

		JMenu mnOrder = new JMenu("Order");
		menuBar.add(mnOrder);

		JMenuItem mntmLoad_2 = new JMenuItem("Load");
		mntmLoad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showDataOrder();
				card.show(pnMain, "cardOrder");
			}
		});
		mnOrder.add(mntmLoad_2);

		JMenuItem mntmSortByPcode_1 = new JMenuItem("Sort by Pcode");
		mntmSortByPcode_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyList<Order> myList = module_Order.readData();
				module_Order.sortByPcode(myList);
				int stt = 0;
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("STT");
				model.addColumn("Pcode");
				model.addColumn("ccode");
				model.addColumn("Quantity");
				for (Order c : myList) {
					model.addRow(new Object[] { stt += 1, c.getPcode(), c.getCcode(), c.getQuantity() });
				}
				tableOrder.getTableHeader().setReorderingAllowed(false);
				tableOrder.setEnabled(false);
				tableOrder.setModel(model);
			}
		});
		mnOrder.add(mntmSortByPcode_1);

		JMenuItem mntmSortByCcode = new JMenuItem("Sort by Ccode");
		mntmSortByCcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyList<Order> myList = module_Order.readData();
				module_Order.sortByCcode(myList);
				int stt = 0;
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("STT");
				model.addColumn("Pcode");
				model.addColumn("ccode");
				model.addColumn("Quantity");
				for (Order c : myList) {
					model.addRow(new Object[] { stt += 1, c.getPcode(), c.getCcode(), c.getQuantity() });
				}
				tableOrder.getTableHeader().setReorderingAllowed(false);
				tableOrder.setEnabled(false);
				tableOrder.setModel(model);
			}
		});
		mnOrder.add(mntmSortByCcode);
		pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnMain);
		pnMain.setLayout(new CardLayout(0, 0));
		card = (CardLayout) pnMain.getLayout();

		Panel panel = new Panel();
		pnMain.add(panel, "name_5740879615778");

		JPanel pnCustomer = new JPanel();
		pnMain.add(pnCustomer, "cardCustomer");
		pnCustomer.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 180, 486, 151);
		pnCustomer.add(scrollPane);

		tableCustomer = new JTable();
		scrollPane.setViewportView(tableCustomer);
		tableCustomer.setBackground(new Color(255, 255, 255));

		JPanel panelAddnew = new JPanel();
		panelAddnew.setBounds(37, 23, 233, 146);
		pnCustomer.add(panelAddnew);

		JLabel lblCode = new JLabel("Code:");

		JLabel lblName = new JLabel("Name:");

		JLabel lblPhone = new JLabel("phone:");

		txtCCode = new JTextField();
		txtCCode.setColumns(10);

		txtCName = new JTextField();
		txtCName.setColumns(10);

		txtCPhone = new JTextField();
		txtCPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char character = arg0.getKeyChar();
				if ((character < '0' || character > '9') && character != '\b') {
					arg0.consume();
				}
			}
		});
		txtCPhone.setColumns(10);

		JLabel lblAddNew = new JLabel("Add new");

		JButton btnAddNewCus = new JButton("Add new");
		btnAddNewCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtCCode.getText().equals("") || txtCName.getText().equals("") || txtCPhone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Input the information!");
				} else {
					Customer customer = new Customer(txtCCode.getText(), txtCName.getText(), txtCPhone.getText());
					MyList<Customer> list = module_customer.readData();
					boolean check = true;
					for (Customer customer2 : list) {
						if (customer2.ccode.equals(txtCCode.getText())) {
							check = false;
							JOptionPane.showMessageDialog(null, "Code has to be unique for the product!");
						}
					}
					if (check) {
						list.add(customer);
						module_customer.writeData(list);
						JOptionPane.showMessageDialog(null, "Add new success!");
						showDataCustomer();
					}
				}
			}
		});
		GroupLayout gl_panelAddnew = new GroupLayout(panelAddnew);
		gl_panelAddnew.setHorizontalGroup(gl_panelAddnew.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAddnew
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelAddnew.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddnew.createSequentialGroup().addComponent(lblCode)
								.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
								.addComponent(txtCCode, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_panelAddnew.createSequentialGroup()
										.addGroup(gl_panelAddnew.createParallelGroup(Alignment.LEADING)
												.addComponent(lblName).addComponent(lblPhone))
										.addGap(28)
										.addGroup(gl_panelAddnew.createParallelGroup(Alignment.LEADING)
												.addComponent(txtCPhone, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
												.addComponent(txtCName, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
												.addComponent(btnAddNewCus))))
				.addGap(30))
				.addGroup(gl_panelAddnew.createSequentialGroup().addGap(22).addComponent(lblAddNew).addContainerGap(165,
						Short.MAX_VALUE)));
		gl_panelAddnew.setVerticalGroup(gl_panelAddnew.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAddnew
				.createSequentialGroup().addContainerGap().addComponent(lblAddNew).addGap(11)
				.addGroup(gl_panelAddnew.createParallelGroup(Alignment.BASELINE).addComponent(lblCode).addComponent(
						txtCCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelAddnew.createParallelGroup(Alignment.BASELINE).addComponent(lblName).addComponent(
						txtCName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelAddnew.createParallelGroup(Alignment.BASELINE).addComponent(lblPhone).addComponent(
						txtCPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAddNewCus)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelAddnew.setLayout(gl_panelAddnew);

		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(298, 23, 202, 73);
		pnCustomer.add(panelSearch);
		panelSearch.setLayout(null);

		txtCSearch = new JTextField();
		txtCSearch.setBounds(66, 11, 127, 20);
		panelSearch.add(txtCSearch);
		txtCSearch.setColumns(10);

		JButton btnSearchCus = new JButton("Search");
		btnSearchCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int stt = 0;
				if (txtCSearch.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insert information search please!");
					showDataCustomer();
				} else {
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("STT");
					model.addColumn("ID");
					model.addColumn("cus_name");
					model.addColumn("cus_phone");
					MyNode<Customer> c = module_customer.searchByCode(txtCSearch.getText());
					if (c != null) {
						model.addRow(new Object[] { stt++, c.t.getCcode(), c.t.getCus_name(), c.t.getPhone() });
						tableCustomer.setModel(model);
					} else {
						JOptionPane.showMessageDialog(null, "Code you input do not exist!");
						showDataCustomer();
					}
				}
			}
		});
		btnSearchCus.setBounds(20, 39, 77, 23);
		panelSearch.add(btnSearchCus);

		JLabel lblEnterCode = new JLabel("Code");
		lblEnterCode.setBounds(20, 14, 42, 14);
		panelSearch.add(lblEnterCode);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtCSearch.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insert information delete please!");
					showDataCustomer();
				} else {
					if (module_customer.deleteByCode(txtCSearch.getText())) {
						JOptionPane.showMessageDialog(null, "Delete success!");
						showDataCustomer();
					} else {
						JOptionPane.showMessageDialog(null, "Code you input do not exist!");
						showDataCustomer();
					}
				}
			}
		});
		btnDelete.setBounds(107, 39, 89, 23);
		panelSearch.add(btnDelete);

		JPanel pnProduct = new JPanel();
		pnMain.add(pnProduct, "cardProduct");
		pnProduct.setLayout(null);

		JPanel panelAddnewProduct = new JPanel();
		panelAddnewProduct.setBounds(25, 11, 264, 139);
		pnProduct.add(panelAddnewProduct);

		JLabel label = new JLabel("Code:");

		txtPCode = new JTextField();
		txtPCode.setColumns(10);

		JLabel label_1 = new JLabel("Name:");

		JLabel lblQuantity = new JLabel("Quantity:");

		txtPQuantity = new JTextField();
		txtPQuantity.setColumns(10);

		txtPName = new JTextField();
		txtPName.setColumns(10);

		JButton btnPAddNew = new JButton("Add new");
		btnPAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Integer.valueOf(txtPSale.getText()) > Integer.valueOf(txtPQuantity.getText())) {
						JOptionPane.showMessageDialog(null, "Saled has to <= Quantity!");
					} else {
						Product product = new Product(txtPCode.getText(), txtPName.getText(),
								Integer.valueOf(txtPQuantity.getText()), Integer.valueOf(txtPSale.getText()),
								Double.valueOf(txtPPrice.getText()), "");
						MyList<Product> list = module_Product.readData();
						boolean check = true;
						for (Product product2 : list) {
							if (product2.pcode.equals(txtPCode.getText())) {
								check = false;
								JOptionPane.showMessageDialog(null, "Code has to be unique for the product!");
							}
						}
						if (check) {
							list.add(product);
							module_Product.writeData(list);
							JOptionPane.showMessageDialog(null, "Add new success!");
							showDataProduct();
						}
					}
				} catch (NumberFormatException numberFormatException) {
					JOptionPane.showMessageDialog(null, "Format input error!");
				}
			}
		});

		JLabel label_3 = new JLabel("Add new");

		JLabel lblSale = new JLabel("Sale:");

		txtPSale = new JTextField();
		txtPSale.setColumns(10);

		JLabel lblPrice = new JLabel("Price:");

		txtPPrice = new JTextField();
		txtPPrice.setColumns(10);
		GroupLayout gl_panelAddnewProduct = new GroupLayout(panelAddnewProduct);
		gl_panelAddnewProduct
				.setHorizontalGroup(
						gl_panelAddnewProduct.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelAddnewProduct.createSequentialGroup().addGroup(gl_panelAddnewProduct
										.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAddnewProduct
												.createSequentialGroup().addContainerGap().addGroup(
														gl_panelAddnewProduct
																.createParallelGroup(Alignment.LEADING).addGroup(
																		gl_panelAddnewProduct
																				.createSequentialGroup()
																				.addGroup(gl_panelAddnewProduct
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(label)
																						.addComponent(label_1))
																				.addGap(26)
																				.addGroup(gl_panelAddnewProduct
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(txtPName)
																						.addComponent(txtPCode))
																				.addGroup(gl_panelAddnewProduct
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(gl_panelAddnewProduct
																								.createSequentialGroup()
																								.addGap(9)
																								.addComponent(lblSale))
																						.addGroup(gl_panelAddnewProduct
																								.createSequentialGroup()
																								.addGap(10)
																								.addComponent(
																										lblPrice)))
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addGroup(gl_panelAddnewProduct
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(txtPPrice,
																								GroupLayout.PREFERRED_SIZE,
																								61,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(txtPSale,
																								GroupLayout.PREFERRED_SIZE,
																								61,
																								GroupLayout.PREFERRED_SIZE)))
																.addGroup(gl_panelAddnewProduct.createSequentialGroup()
																		.addComponent(lblQuantity)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(txtPQuantity,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
												.addGap(14))
										.addGroup(gl_panelAddnewProduct.createSequentialGroup().addGap(24)
												.addComponent(label_3))
										.addGroup(gl_panelAddnewProduct.createSequentialGroup().addGap(33)
												.addComponent(btnPAddNew)))
										.addContainerGap(15, Short.MAX_VALUE)));
		gl_panelAddnewProduct.setVerticalGroup(gl_panelAddnewProduct.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAddnewProduct.createSequentialGroup().addGap(4).addComponent(label_3)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelAddnewProduct.createParallelGroup(Alignment.BASELINE).addComponent(label)
								.addComponent(txtPCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSale).addComponent(txtPSale, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelAddnewProduct.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(txtPName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrice).addComponent(txtPPrice, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelAddnewProduct.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuantity).addComponent(txtPQuantity, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPAddNew).addGap(14)));
		panelAddnewProduct.setLayout(gl_panelAddnewProduct);

		JPanel panelSearchProduct = new JPanel();
		panelSearchProduct.setLayout(null);
		panelSearchProduct.setBounds(315, 11, 202, 73);
		pnProduct.add(panelSearchProduct);

		txtPSearch = new JTextField();
		txtPSearch.setColumns(10);
		txtPSearch.setBounds(66, 11, 127, 20);
		panelSearchProduct.add(txtPSearch);

		JButton btnPSearch = new JButton("Search");
		btnPSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stt = 0;
				if (txtPSearch.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insert information search please!");
					showDataCustomer();
				} else {
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("STT");
					model.addColumn("ID");
					model.addColumn("Pro_name");
					model.addColumn("Quantity");
					model.addColumn("Sale");
					model.addColumn("Price");
					MyNode<Product> p = module_Product.searchByCode(txtPSearch.getText());
					if (p != null) {
						model.addRow(new Object[] { stt += 1, p.t.getPcode(), p.t.getPro_name(), p.t.getQuantity(),
								p.t.getSale(), p.t.getPrice() });
						tableProduct.setModel(model);
					} else {
						JOptionPane.showMessageDialog(null, "Code you input do not exist!");
						showDataProduct();
					}
				}
			}
		});
		btnPSearch.setBounds(20, 39, 77, 23);
		panelSearchProduct.add(btnPSearch);

		JLabel label_4 = new JLabel("Code");
		label_4.setBounds(20, 14, 42, 14);
		panelSearchProduct.add(label_4);

		JButton btnPDelete = new JButton("Delete");
		btnPDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtPSearch.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insert information delete please!");
					showDataProduct();
				} else {
					if (module_Product.deleteByCode(txtPSearch.getText())) {
						JOptionPane.showMessageDialog(null, "Delete success!");
						showDataProduct();
					} else {
						JOptionPane.showMessageDialog(null, "Code you input do not exist!");
						showDataProduct();
					}
				}
			}
		});
		btnPDelete.setBounds(107, 39, 89, 23);
		panelSearchProduct.add(btnPDelete);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 161, 530, 170);
		pnProduct.add(scrollPane_1);

		tableProduct = new JTable();
		scrollPane_1.setViewportView(tableProduct);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (module_Product.deleleAfterCode(txtPSearch.getText())) {
					JOptionPane.showMessageDialog(null, "Delete success!");
					showDataProduct();
				} else {
					JOptionPane.showMessageDialog(null, "Code you input do not exist!");
					showDataProduct();
				}
			}
		});
		btnNewButton.setBounds(343, 109, 89, 23);
		pnProduct.add(btnNewButton);

		JPanel pnOrder = new JPanel();
		pnMain.add(pnOrder, "cardOrder");
		pnOrder.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 160, 530, 171);
		pnOrder.add(scrollPane_2);

		tableOrder = new JTable();
		scrollPane_2.setViewportView(tableOrder);
	}

	public void showDataCustomer() {
		int stt = 0;
		DefaultTableModel model = new DefaultTableModel();
		MyList<Customer> kq = module_customer.readData();
		model.addColumn("STT");
		model.addColumn("ID");
		model.addColumn("cus_name");
		model.addColumn("cus_phone");
		for (Customer c : kq) {
			model.addRow(new Object[] { stt += 1, c.getCcode(), c.getCus_name(), c.getPhone() });
		}
		tableCustomer.getTableHeader().setReorderingAllowed(false);
		tableCustomer.setEnabled(false);
		tableCustomer.setModel(model);
	}

	public void showDataProduct() {
		int stt = 0;
		DefaultTableModel model = new DefaultTableModel();
		MyList<Product> kq = module_Product.readData();
		model.addColumn("STT");
		model.addColumn("ID");
		model.addColumn("Pro_name");
		model.addColumn("Quantity");
		model.addColumn("Sale");
		model.addColumn("Price");
		for (Product c : kq) {
			model.addRow(new Object[] { stt += 1, c.getPcode(), c.getPro_name(), c.getQuantity(), c.getSale(),
					c.getPrice() });
		}
		tableProduct.getTableHeader().setReorderingAllowed(false);
		//tableProduct.setEnabled(false);
		tableProduct.setModel(model);
	}

	public void showDataOrder() {
		int stt = 0;
		DefaultTableModel model = new DefaultTableModel();
		MyList<Order> kq = module_Order.readData();
		model.addColumn("STT");
		model.addColumn("Pcode");
		model.addColumn("Pcode");
		model.addColumn("Quantity");
		for (Order o : kq) {
			model.addRow(new Object[] { stt += 1, o.getPcode(), o.getCcode(), o.getQuantity() });
		}
		tableOrder.getTableHeader().setReorderingAllowed(false);
//		tableOrder.setEnabled(false);
		tableOrder.setModel(model);
	}
}
