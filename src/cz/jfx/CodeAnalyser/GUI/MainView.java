package cz.jfx.CodeAnalyser.GUI;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import java.awt.Toolkit;
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
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/logo1.png")));
    }

    private void initAfterComponents() {
        scannButton.setEnabled(false);
        hideLoading();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        scanFolder = new javax.swing.JTextField();
        selectFolder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        infoToolbar = new javax.swing.JToolBar();
        loadingBar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        menuToolbar = new javax.swing.JToolBar();
        scannButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        settingsButton = new javax.swing.JButton();
        filtersButton = new javax.swing.JButton();
        graphButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CodeAnalyser");

        scanFolder.setText("Select your folder..");

        selectFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/search.png"))); // NOI18N
        selectFolder.setToolTipText("Browse local computer");
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
                .addComponent(infoToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
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

        menuToolbar.setBackground(new java.awt.Color(153, 180, 209));
        menuToolbar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menuToolbar.setFloatable(false);
        menuToolbar.setRollover(true);

        scannButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/inspect.png"))); // NOI18N
        scannButton.setToolTipText("Analyse code");
        scannButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scannButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scannButtonActionPerformed(evt);
            }
        });
        menuToolbar.add(scannButton);

        jSeparator3.setPreferredSize(new java.awt.Dimension(30, 30));
        jSeparator3.setRequestFocusEnabled(false);
        menuToolbar.add(jSeparator3);

        settingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/settings.png"))); // NOI18N
        settingsButton.setToolTipText("Settings and options");
        settingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsButton.setFocusable(false);
        settingsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        settingsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        menuToolbar.add(settingsButton);

        filtersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/filters.png"))); // NOI18N
        filtersButton.setToolTipText("Code filters");
        filtersButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filtersButton.setFocusable(false);
        filtersButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        filtersButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        filtersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtersButtonActionPerformed(evt);
            }
        });
        menuToolbar.add(filtersButton);

        graphButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/graph.png"))); // NOI18N
        graphButton.setToolTipText("Generate graph");
        graphButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        graphButton.setFocusable(false);
        graphButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        graphButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });
        menuToolbar.add(graphButton);
        menuToolbar.add(jSeparator2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/info.png"))); // NOI18N
        jButton1.setToolTipText("About analyser");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        menuToolbar.add(jButton1);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/exit.png"))); // NOI18N
        exitButton.setToolTipText("Exit program");
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.setFocusable(false);
        exitButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        menuToolbar.add(exitButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scanFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectFolder))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menuToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(menuToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-426)/2, (screenSize.height-406)/2, 426, 406);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AboutDialog about = new AboutDialog(this, false);
        about.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
        AnalyserController.logger.exiting("MainView", "close program");
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        PreferencesView view = new PreferencesView(this);
        view.setVisible(true);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void filtersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtersButtonActionPerformed
        FiltersView view = new FiltersView(this);
        view.setVisible(true);
    }//GEN-LAST:event_filtersButtonActionPerformed

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graphButtonActionPerformed

    public void showLoading() {
        loadingBar.setVisible(true);
    }

    public void hideLoading() {
        loadingBar.setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton filtersButton;
    private javax.swing.JButton graphButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JToolBar infoToolbar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JLabel loadingBar;
    private javax.swing.JToolBar menuToolbar;
    private javax.swing.JTextField scanFolder;
    private javax.swing.JButton scannButton;
    private javax.swing.JButton selectFolder;
    private javax.swing.JButton settingsButton;
    // End of variables declaration//GEN-END:variables
}
