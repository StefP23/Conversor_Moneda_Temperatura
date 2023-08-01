package conversormoneda;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Label;

public class Miconversormoneda {

	private JFrame frame;
	private JButton btn;
	private JComboBox<Moneda> cmb;
	private JTextField txt;
	private JLabel lbl;
	
	public enum Moneda {
		Dolar_Euro,
		Dolar_Libra,
		Dolar_Yen,
		Dolar_Won,
		Euro_Dolar,
		Libra_Dolar,
		Yen_Dolar,
		Won_Dolar,
	}
	
	public double Euro = 0.91;
	public double Libra = 0.78;
	public double Yen = 0.91;
	public double Won = 1280.29;
	private double valorInput;
	private Label lbl2;
	private Label label_1;
	private Label label;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Miconversormoneda window = new Miconversormoneda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Miconversormoneda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(128, 128, 128));
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 427, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CONVERSOR DE MONEDAS");
		frame.setResizable(false);
		
		txt = new JTextField();
		txt.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt.setBounds(108, 161, 212, 30);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		cmb = new JComboBox<Moneda>();
		cmb.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(108, 81, 212, 30);
		frame.getContentPane().add(cmb);
		
		//Funcion de Boton1
		btn = new JButton("Convertir");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.setBounds(177, 216, 89, 23);
		frame.getContentPane().add(btn);
		
		lbl = new JLabel("       00.00");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(177, 250, 89, 30);
		frame.getContentPane().add(lbl);
		
		lbl2 = new Label(" Resultado de la Conversión");
		lbl2.setAlignment(Label.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl2.setBounds(108, 280, 206, 22);
		frame.getContentPane().add(lbl2);
		
		Label lbl3 = new Label("\t\t\t\t            Conversor de Monedas  ");
		lbl3.setAlignment(Label.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl3.setBounds(45, 22, 348, 30);
		frame.getContentPane().add(lbl3);
		
		label = new Label("Seleccione una Opción de Conversión");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(108, 58, 224, 22);
		frame.getContentPane().add(label);
		
		label_1 = new Label("Ingrese el Monto que desea Convertir");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(108, 133, 224, 22);
		frame.getContentPane().add(label_1);
	}
	
	public void Convertir() {
		if(Validar(txt.getText())) {
			Moneda moneda = (Moneda) cmb.getSelectedItem();
			
			switch (moneda) {
			
			case Dolar_Euro:
				DolarAMoneda(Euro);
				break;
			case Dolar_Libra:
				DolarAMoneda(Libra);
				break;
			case Dolar_Yen:
				DolarAMoneda(Yen);
				break;
			case Dolar_Won:
				DolarAMoneda(Won);
				break;
			case Euro_Dolar:
				MonedaADolar(Euro);
				break;
			case Libra_Dolar:
				MonedaADolar(Euro);
				break;
			case Yen_Dolar:
				MonedaADolar(Euro);
				break;
			case Won_Dolar:
				MonedaADolar(Euro);
				break;
			default: 
				throw new IllegalArgumentException("Unexpected value: " + moneda);
				
		}
		
		}
	}
	
	public void DolarAMoneda(double moneda) {
		double res = valorInput / moneda;
		lbl.setText(Redondear(res));
	}
	
	public void MonedaADolar(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(Redondear(res));
	}
	
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("  0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	public boolean Validar(String texto)  {
		try  {
			double x = Double.parseDouble(texto);
			if(x > 0);
			valorInput = x;
			return true;
		}catch(NumberFormatException e)  {
			lbl.setText("Valor Inválido!!");
			return false;
		}
	}
}	



