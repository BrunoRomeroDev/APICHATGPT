package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.ConnectionChatGpt;

public class TelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton jbt;
	private JTextArea jta;
	JTextField jtf;
	
	public void createTela() throws ParseException, IOException {


		Container janela = getContentPane();
		setLayout(null);

		JLabel labelP = new JLabel("Pergunta: ");
		labelP.setBounds(50, 40, 100, 20);
		janela.add(labelP);

		jtf = new JTextField();
		jtf.setBounds(50, 60, 660, 25);
		janela.add(jtf);

		JLabel labelR = new JLabel("Resposta: ");
		labelR.setBounds(50, 80, 100, 20);
		janela.add(labelR);

		jta = new JTextArea();
		jta.setBounds(50, 100, 700, 300);
		jta.setLineWrap(true);
		janela.add(jta);

		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		jbt = new JButton();
		JButton jbt = new JButton();		
		jbt.setBounds(710, 60, 40, 25);
		jbt.setText("...");
		janela.add(jbt);
		jbt.addActionListener((ActionListener) this);

	
	}

	
	public void actionPerformed(ActionEvent evento) {
		
		String resposta = null;
		try {
			resposta = ConnectionChatGpt.QuestionChatGPT(jtf.getText());
		} catch (IOException | InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		jta.setText(resposta);
	}
	
}
