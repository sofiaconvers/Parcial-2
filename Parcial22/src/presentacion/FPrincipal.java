package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.Parcial;
import excepciones.EcuacionException;

public class FPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtA;
    private JTextField txtB;
    private JTextField txtC;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FPrincipal frame = new FPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FPrincipal() {
        setTitle("Examen Sofia Convers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 240);
        setResizable(false);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblA = new JLabel("a:");
        lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblA.setHorizontalAlignment(SwingConstants.RIGHT);
        lblA.setBounds(180, 25, 20, 25);
        contentPane.add(lblA);

        txtA = new JTextField();
        txtA.setBounds(210, 25, 170, 25);
        contentPane.add(txtA);
        txtA.setColumns(10);


        JLabel lblB = new JLabel("b:");
        lblB.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblB.setHorizontalAlignment(SwingConstants.RIGHT);
        lblB.setBounds(180, 65, 20, 25);
        contentPane.add(lblB);

        txtB = new JTextField();
        txtB.setBounds(210, 65, 170, 25);
        contentPane.add(txtB);
        txtB.setColumns(10);

        
        JLabel lblC = new JLabel("c:");
        lblC.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblC.setHorizontalAlignment(SwingConstants.RIGHT);
        lblC.setBounds(180, 105, 20, 25);
        contentPane.add(lblC);

        txtC = new JTextField();
        txtC.setBounds(210, 105, 170, 25);
        contentPane.add(txtC);
        txtC.setColumns(10);


        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCalcular.setBounds(30, 150, 130, 30);
        contentPane.add(btnCalcular);


        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblResultado.setBounds(180, 150, 200, 30);
        contentPane.add(lblResultado);


        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutarCalculo();
            }
        });
    }

    private void ejecutarCalculo() {
        try {
            double a = Double.parseDouble(txtA.getText().trim());
            double b = Double.parseDouble(txtB.getText().trim());
            double c = Double.parseDouble(txtC.getText().trim());

            Parcial parcial = new Parcial();
            String resultado = parcial.resolver(a, b, c);
            
            lblResultado.setText(resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                    "Por favor ingrese valores numéricos válidos.", 
                    "Error de formato", 
                    JOptionPane.ERROR_MESSAGE);
        } catch (EcuacionException e) {
            lblResultado.setText("");
            JOptionPane.showMessageDialog(this, 
                    e.getMessage(), 
                    "Error en la ecuación", 
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "Ocurrió un error inesperado: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}