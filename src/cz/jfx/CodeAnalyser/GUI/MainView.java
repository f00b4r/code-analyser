package cz.jfx.CodeAnalyser.GUI;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Felix
 */
public class MainView extends javax.swing.JFrame {

    private File selectedFolder;

    public File getSelectedFolder() {
        return selectedFolder;
    }

    public void setSelectedFolder(File selectedFolder) {
        this.selectedFolder = selectedFolder;
    }

    /** Creates new form MainView */
    public MainView() {
        initBeforeComponents();
        initComponents();
        initAfterComponents();
    }

    private void initBeforeComponents() {
    }

    private void initAfterComponents() {
        scannButton.setEnabled(false);
        hideLoading();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scannButton = new javax.swing.JButton();
        scanFolder = new javax.swing.JTextField();
        selectFolder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        infoToolbar = new javax.swing.JToolBar();
        loadingBar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        menu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileMenuExit = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        optionsMenuPreferences = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CodeAnalyser");

        scannButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/inspect.png"))); // NOI18N
        scannButton.setBorderPainted(false);
        scannButton.setContentAreaFilled(false);
        scannButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scannButtonActionPerformed(evt);
            }
        });

        scanFolder.setText("Select your folder..");

        selectFolder.setText("SELECT");
        selectFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFolderActionPerformed(evt);
            }
        });

        jLabel1.setText("Scanned path");

        infoPanel.setAlignmentY(2.0F);
        infoPanel.setMinimumSize(new java.awt.Dimension(100, 20));

        infoToolbar.setFloatable(false);
        infoToolbar.setRollover(true);

        loadingBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/preloader3.gif"))); // NOI18N
        loadingBar.setToolTipText("Loading..");
        loadingBar.setDoubleBuffered(true);
        infoToolbar.add(loadingBar);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Extension", "Files", "Rows"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dataTable);

        fileMenu.setText("File");

        fileMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        fileMenuExit.setText("Exit");
        fileMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuExitActionPerformed(evt);
            }
        });
        fileMenu.add(fileMenuExit);

        menu.add(fileMenu);

        optionsMenu.setText("Options");

        optionsMenuPreferences.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        optionsMenuPreferences.setText("Preferences");
        optionsMenuPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsMenuPreferencesActionPerformed(evt);
            }
        });
        optionsMenu.add(optionsMenuPreferences);

        menu.add(optionsMenu);

        jMenu1.setText("jMenu1");
        menu.add(jMenu1);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scanFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectFolder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scannButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(scanFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFolder)
                    .addComponent(scannButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFolderActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int val = fileChooser.showOpenDialog(this);

        if (val == JFileChooser.APPROVE_OPTION) {
            setSelectedFolder(fileChooser.getSelectedFile());

            // let see user
            scanFolder.setText(getSelectedFolder().getAbsolutePath());
            // active scann button
            scannButton.setEnabled(true);
        }
    }//GEN-LAST:event_selectFolderActionPerformed

    private void scannButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scannButtonActionPerformed
        Thread t = new Thread() {

            public void run() {
                scannButton.setEnabled(false);
                showLoading();
                AnalyserController.getInstance().analyse();
                hideLoading();
                scannButton.setEnabled(true);
            }
        };
        t.start();
    }//GEN-LAST:event_scannButtonActionPerformed

    private void fileMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuExitActionPerformed
        dispose();
        AnalyserController.logger.exiting("MainView", "fileMenuExitActionPerformed");
        System.exit(0);
    }//GEN-LAST:event_fileMenuExitActionPerformed

    public void showLoading() {
        loadingBar.setVisible(true);
    }
    
    public void hideLoading() {
        loadingBar.setVisible(false);
    }
    
    private void optionsMenuPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsMenuPreferencesActionPerformed
    }//GEN-LAST:event_optionsMenuPreferencesActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fileMenuExit;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JToolBar infoToolbar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel loadingBar;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenuItem optionsMenuPreferences;
    private javax.swing.JTextField scanFolder;
    private javax.swing.JButton scannButton;
    private javax.swing.JButton selectFolder;
    // End of variables declaration//GEN-END:variables
}
