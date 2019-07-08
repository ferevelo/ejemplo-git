package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JMenuBar;
import java.awt.Choice;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;

public class proy {

	private JFrame frmMariaFernandaR;
	private JTextField txtResolucionDeFunciones;
	private JTextField numero1;
	private JTextField numero2;
	private JTextField numero3;
	private JTextField numero4;
	private JTextField raiz1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JLabel lblX_2;
	private JLabel lblValorInicial;
	private JTable table;
	private JList list;
	private JScrollPane scrollPane_1;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proy window = new proy();
					window.frmMariaFernandaR.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public proy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMariaFernandaR = new JFrame();
		frmMariaFernandaR.setForeground(new Color(139, 0, 139));
		frmMariaFernandaR.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		frmMariaFernandaR.setTitle("MARIA FERNANDA REVELO BAUTISTA");
		frmMariaFernandaR.getContentPane().setBackground(new Color(216, 191, 216));
		frmMariaFernandaR.setBounds(100, 100, 763, 334);
		frmMariaFernandaR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtResolucionDeFunciones = new JTextField();
		txtResolucionDeFunciones.setBackground(Color.PINK);
		txtResolucionDeFunciones.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		txtResolucionDeFunciones.setHorizontalAlignment(SwingConstants.CENTER);
		txtResolucionDeFunciones.setText("RESOLUCION DE FUNCIONES NO LINEALES");
		txtResolucionDeFunciones.setColumns(10);
		
		JLabel label = new JLabel("");
		
		numero1 = new JTextField();
		numero1.setColumns(10);
		
		JLabel lblX = new JLabel("X^3");
		lblX.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		numero2 = new JTextField();
		numero2.setColumns(10);
		
		JLabel lblX_1 = new JLabel("X^2");
		lblX_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		numero3 = new JTextField();
		numero3.setColumns(10);
		
		numero4 = new JTextField();
		numero4.setColumns(10);
		
		JButton btnMetodoPruebaY = new JButton("METODO PRUEBA Y ERROR");
		btnMetodoPruebaY.setForeground(Color.GREEN);
		btnMetodoPruebaY.setBackground(Color.WHITE);
		btnMetodoPruebaY.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		JButton btnMetodoPuntoFijo = new JButton("METODO PUNTO FIJO");
		btnMetodoPuntoFijo.setForeground(Color.GREEN);
		btnMetodoPuntoFijo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		JButton btnMetodoNewton = new JButton("METODO NEWTON");
		btnMetodoNewton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		btnMetodoNewton.setForeground(Color.GREEN);
		
		JLabel label_1 = new JLabel("");
		
		JButton resolver1 = new JButton("RESOLVER");
		resolver1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n1,n2,n3,n4;
				n1=Integer.parseInt(numero1.getText());
				n2=Integer.parseInt(numero2.getText());
				n3=Integer.parseInt(numero3.getText());
				n4=Integer.parseInt(numero4.getText());
				
				int suma;
				suma=n1+n2;
				raiz1.setText(" "+suma);
				
			
			}
		});
		resolver1.setForeground(new Color(148, 0, 211));
		resolver1.setBackground(Color.WHITE);
		resolver1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		JButton resolver2 = new JButton("RESOLVER");
		resolver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int numCols = table_1.getModel().getColumnCount();

				Object [] fila = new Object[numCols]; 
				        
				 fila[0] = "unal";
				 fila[1] = "420";
				 fila[2] = "mundo";
			
				 ((DefaultTableModel)table_1.getModel()).addRow(fila);
				
				
			}
		});
		resolver2.setForeground(new Color(148, 0, 211));
		resolver2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		resolver2.setBackground(Color.WHITE);
		
		JButton resolver3 = new JButton("RESOLVER");
		resolver3.setForeground(new Color(148, 0, 211));
		resolver3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		resolver3.setBackground(Color.WHITE);
		
		raiz1 = new JTextField();
		raiz1.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		JLabel lblRaiz = new JLabel("RAIZ");
		lblRaiz.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblFx = new JLabel("F(X)");
		lblFx.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblError = new JLabel("ERROR");
		lblError.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		lblX_2 = new JLabel("X");
		lblX_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		
		lblValorInicial = new JLabel("VALOR INICIAL");
		lblValorInicial.setBackground(new Color(0, 0, 205));
		lblValorInicial.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		table = new JTable();
		
		list = new JList();
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frmMariaFernandaR.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(txtResolucionDeFunciones, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(label)
							.addGap(23)
							.addComponent(numero1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblX)
							.addGap(18)
							.addComponent(numero2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblX_1)
							.addGap(4)
							.addComponent(numero3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblX_2)
							.addGap(39)
							.addComponent(numero4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(110)
							.addComponent(lblRaiz)
							.addGap(18)
							.addComponent(lblFx)
							.addGap(18)
							.addComponent(lblError))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnMetodoPruebaY)
							.addGap(16)
							.addComponent(lblValorInicial)
							.addGap(10)
							.addComponent(resolver1)
							.addGap(6)
							.addComponent(raiz1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(20)
											.addComponent(btnMetodoPuntoFijo))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(30)
											.addComponent(btnMetodoNewton)))
									.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
									.addGap(72)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(37)
									.addComponent(resolver2)
									.addGap(6)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(37)
									.addComponent(resolver3)
									.addGap(6)
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(289)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))))
					.addGap(204)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(txtResolucionDeFunciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(numero1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblX))
						.addComponent(numero2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblX_1))
						.addComponent(numero3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblX_2))
						.addComponent(numero4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(lblRaiz))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(lblFx))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(lblError)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMetodoPruebaY)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblValorInicial))
						.addComponent(resolver1)
						.addComponent(raiz1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(btnMetodoPuntoFijo))
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(resolver2)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(btnMetodoNewton))
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(resolver3)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table_1 = new JTable(modelo);
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"X", "F(X)","FER"
			}
		));
		scrollPane_1.setViewportView(table_1);
		frmMariaFernandaR.getContentPane().setLayout(groupLayout);
	}
}
