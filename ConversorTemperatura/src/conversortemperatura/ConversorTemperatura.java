		package conversortemperatura;
		
		import javax.swing.JFrame;
		import javax.swing.JPanel;
		import javax.swing.border.EmptyBorder;
		
		
		import javax.swing.JButton;
		import javax.swing.JTextField;
		import java.awt.Label;
		import java.awt.EventQueue;
		import java.awt.Font;
		import java.awt.event.MouseAdapter;
		import java.awt.event.MouseEvent;
		import java.math.RoundingMode;
		import java.text.DecimalFormat;
		
		import javax.swing.JComboBox;
		import javax.swing.DefaultComboBoxModel;
		
		public class ConversorTemperatura extends JFrame {
		
			/*Componentes con variables locales*/
			private static final long serialVersionUID = 7277988888352239075L;
			private JPanel contentPane;
			private JTextField txtResult;
			private JButton btnConvertir;
			private JComboBox<Grados> cmbSelect;
			private Label lblleyenda;
			private Label lblTexto;
			private Label lbltema;
			private JTextField txtDatos;
			
			public double Celsius = 32;
			public double Fahrenheit = -17.22;
		
			public double valorInput = 0;
			
			public enum Grados {
				Celsius_Fahrenheit,
				Fahrenheit_Celsius,
			}
			/*Contenido de la pantalla*/
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ConversorTemperatura frame = new ConversorTemperatura();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			

			/*Muestra los componentes creados son Swing*/
			public ConversorTemperatura() {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 436, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				/*Creamos una */
				btnConvertir = new JButton("Convertir");
				btnConvertir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Convertir();
					}
				});
				
				btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnConvertir.setBounds(99, 208, 89, 30);
				contentPane.add(btnConvertir);
				
				txtResult = new JTextField();
				txtResult.setColumns(10);
				txtResult.setBounds(275, 114, 114, 30);
				contentPane.add(txtResult);
				
				lbltema = new Label("\t\t\t\t            Conversor de Temperatura");
				lbltema.setFont(new Font("Tahoma", Font.BOLD, 15));
				lbltema.setAlignment(Label.CENTER);
				lbltema.setBounds(53, 25, 309, 30);
				contentPane.add(lbltema);
				
				cmbSelect = new JComboBox<Grados>();
				cmbSelect.setModel(new DefaultComboBoxModel<>(Grados.values()));
				cmbSelect.setBounds(32, 114, 215, 30);
				contentPane.add(cmbSelect);
				
				lblTexto = new Label("Seleccione una Opción de Conversión");
				lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblTexto.setBounds(32, 86, 224, 22);
				contentPane.add(lblTexto);
				
				lblleyenda = new Label("Resultado");
				lblleyenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblleyenda.setAlignment(Label.CENTER);
				lblleyenda.setBounds(275, 163, 114, 22);
				contentPane.add(lblleyenda);
				
				txtDatos = new JTextField();
				txtDatos.setColumns(10);
				txtDatos.setBounds(32, 155, 215, 30);
				contentPane.add(txtDatos);
			}
			
			public void Convertir() {
					double valor = Validar(txtDatos.getText());
					Grados grados = (Grados) cmbSelect.getSelectedItem();
					
					switch (grados) {
						
					case Celsius_Fahrenheit:
						GradosCAGradosF(valor);
						break;
					case Fahrenheit_Celsius:
						GradosFAGradosC(valor);
						break;	
					default: 
						throw new IllegalArgumentException("Unexpected value: " + grados);
					
					
			    }
				
			}
			
			public void GradosCAGradosF(double grados) {
				double res = (grados * 9)/5 + 32;
				txtResult.setText(Redondear(res));
			}
			
			public void GradosFAGradosC(double grados) {
				double res = (grados - 32) * 9/5;
				txtResult.setText(Redondear(res));
			}
			
			public String Redondear(double valor) {
				DecimalFormat df = new DecimalFormat("  0.0");
				df.setRoundingMode(RoundingMode.HALF_UP);
				return df.format(valor);
			}
			
			public double Validar(String texto)  {
				try  {
					double x = Double.valueOf(texto);
					if(x > 0);
					valorInput = x;
					return x;
				}catch(NumberFormatException e)  {
					txtResult.setText(" Valor Inválido!!");
					return 0;
				}
				
			}
		}
		
