import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Tokenization extends javax.swing.JFrame {
	
	
       private void tokenize(String verse){
	String[] tokens = verse.split("[\\s.,!?]+");
		for (int i = 0; i < tokens.length; ++i) 
		{
			tokensList.addItem(tokens[i]);
		}

	}
	public Tokenization() {
		initComponents();
		addRoots();
		rootsList.removeAll();
		tokensList.removeAll();
		textArea.setText("Root   -->>   Token\n");
	}

	private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tokenizeBtn = new javax.swing.JButton();
        addRootsBtn = new javax.swing.JButton();
        tokensList = new javax.swing.JComboBox<>();
        misra1TxtField = new javax.swing.JTextField();
        rootsList = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tokenizeBtn.setText("Tokenize");
        tokenizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokenizeBtnActionPerformed(evt);
            }
        });

        addRootsBtn.setText("Roots");
        addRootsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRootsBtnActionPerformed(evt);
            }
        });

        tokensList.setModel(new javax.swing.DefaultComboBoxModel<>());

        rootsList.setModel(new javax.swing.DefaultComboBoxModel<>());

        jLabel2.setText("Verse");

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(misra1TxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addRootsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tokenizeBtn))
                                .addGap(114, 114, 114))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(tokensList, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                                .addComponent(rootsList, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(80, 80, 80))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(misra1TxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(tokenizeBtn)
                .addGap(22, 22, 22)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rootsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tokensList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(addRootsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

	private void addRoots() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream("Roots.txt"), StandardCharsets.UTF_8));
			String line;
			while ((line = br.readLine()) != null) {
				String[] roots = line.split("[\\s.,!?]+");
				for(int i = 0; i < roots.length; ++i) {
					rootsList.addItem(roots[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void addPoem(String verse) {
		tokenize(verse);
	}

	private void addRootsBtnActionPerformed(java.awt.event.ActionEvent evt) {
		String roots = (String) rootsList.getSelectedItem();
		String tokens = (String) tokensList.getSelectedItem();
		textArea.append(roots + "  -->>  " + tokens + "\n");
	}

	private void tokenizeBtnActionPerformed(java.awt.event.ActionEvent evt) {
		addPoem(misra1TxtField.getText());
	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Tokenization().setVisible(true);
			}
		});
	}

	private javax.swing.JButton addRootsBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField misra1TxtField;
    private javax.swing.JComboBox<String> rootsList;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton tokenizeBtn;
    private javax.swing.JComboBox<String> tokensList;              
}
