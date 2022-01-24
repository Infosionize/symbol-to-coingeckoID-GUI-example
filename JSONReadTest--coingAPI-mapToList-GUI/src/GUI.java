import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI {

	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Portf to List (Map: Symbol TO CoingeckoID)");
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 647, 514);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JTextArea txtareaIn = new JTextArea();
		txtareaIn.setRows(25);
		txtareaIn.setColumns(25);
		txtareaIn.setWrapStyleWord(true);
		JScrollPane scrollIn = new JScrollPane(txtareaIn);
		JPanel panelIn = new JPanel();
		panelIn.add(scrollIn); // Object of Jpanel
		mainFrame.getContentPane().add(panelIn);

		JTextArea txtareaOut = new JTextArea();
		txtareaOut.setRows(25);
		txtareaOut.setColumns(25);
		txtareaOut.setWrapStyleWord(true);
		JScrollPane scrollOut = new JScrollPane(txtareaOut);
		JPanel panelOut = new JPanel();
		panelOut.add(scrollOut);
		mainFrame.getContentPane().add(panelOut);

		JButton btnNewButton = new JButton(">>>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Other o = new Other();

				String[] txtSplitted = txtareaIn.getText().split("\\n");

				// TO EDIT PART start

				String tempTextZeile;
				ArrayList<String> outputText = new ArrayList<String>();
				for (int i = 0; i < txtSplitted.length; i++) {

					tempTextZeile = "" + txtSplitted[i];

					// EDIT HERE
					// EDIT HERE
					// EDIT HERE

					outputText.add(tempTextZeile);

				}
				// Collections.shuffle(outputText);

				MapListOfTokenSymbolsToCoingeckoId motstci = new MapListOfTokenSymbolsToCoingeckoId();
				outputText = motstci.doit(outputText);

				// TO EDIT PART end

				String tempOutTxt = "";
				for (int i = 0; i < outputText.size(); i++) {
					if (i == 0) {
						tempOutTxt = outputText.get(i);
					} else {

						tempOutTxt = tempOutTxt + "\n" + outputText.get(i);
					}

				}
				txtareaOut.setText(tempOutTxt);

				// txtareaOut.setText(o.ersterBuchstabeGross(txtareaIn.getText()));
				System.out.println("DONE");
			}
		});
		mainFrame.getContentPane().add(btnNewButton);

	}

}
