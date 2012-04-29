package cz.jfx.CodeAnalyser.GUI;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FileListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

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
        Counter c1 = new Counter(filesPending, filesScanned);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        threadsPanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        folderPanel = new javax.swing.JPanel();
        scanFolder = new javax.swing.JTextField();
        selectFolder = new javax.swing.JButton();
        progressPanel = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        statsPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        foldersScanned = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        foldersPending = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        filesScanned = new javax.swing.JLabel();
        filesPending = new javax.swing.JLabel();
        scannButton = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileMenuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        threadsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Threads settings"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        jLabel3.setText("Loaders");

        jLabel4.setText("Readers");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        javax.swing.GroupLayout threadsPanelLayout = new javax.swing.GroupLayout(threadsPanel);
        threadsPanel.setLayout(threadsPanelLayout);
        threadsPanelLayout.setHorizontalGroup(
            threadsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(threadsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(threadsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(threadsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(threadsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        threadsPanelLayout.setVerticalGroup(
            threadsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(threadsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(threadsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(threadsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2))
                .addContainerGap())
        );

        folderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Folder to scan"));

        scanFolder.setText("Select your folder..");

        selectFolder.setText("SELECT");
        selectFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout folderPanelLayout = new javax.swing.GroupLayout(folderPanel);
        folderPanel.setLayout(folderPanelLayout);
        folderPanelLayout.setHorizontalGroup(
            folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(folderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scanFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectFolder)
                .addContainerGap())
        );
        folderPanelLayout.setVerticalGroup(
            folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(folderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFolder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        progressPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Progress"));

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        statsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Stats"));

        jLabel5.setText("Folders:");

        foldersScanned.setText("0");

        jLabel7.setText("/");

        foldersPending.setText("0");

        jLabel9.setText("/");

        jLabel10.setText("Files");

        filesScanned.setText("0");

        filesPending.setText("0");

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(foldersScanned)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(foldersPending))
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(filesScanned)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filesPending)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(foldersScanned)
                    .addComponent(jLabel7)
                    .addComponent(foldersPending))
                .addGap(18, 18, 18)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(filesScanned)
                    .addComponent(jLabel9)
                    .addComponent(filesPending))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        scannButton.setText("SCAN");
        scannButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scannButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("File");

        fileMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        fileMenuExit.setText("Exit");
        fileMenu.add(fileMenuExit);

        menu.add(fileMenu);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(threadsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(statsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(progressPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(folderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scannButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scannButton, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(folderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(threadsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        }
    }//GEN-LAST:event_selectFolderActionPerformed

    private void scannButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scannButtonActionPerformed
        Thread t = new Thread() {

            public void run() {
                AnalyserController.getInstance().analyse();
            }
        };

        t.setDaemon(false);
        t.start();
        //SwingUtilities.invokeLater(t);
    }//GEN-LAST:event_scannButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fileMenuExit;
    private javax.swing.JLabel filesPending;
    private javax.swing.JLabel filesScanned;
    private javax.swing.JPanel folderPanel;
    private javax.swing.JLabel foldersPending;
    private javax.swing.JLabel foldersScanned;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar menu;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JTextField scanFolder;
    private javax.swing.JButton scannButton;
    private javax.swing.JButton selectFolder;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JPanel threadsPanel;
    // End of variables declaration//GEN-END:variables
    private int x = 0;

    public void increase() {
        filesPending.setText(++x+"");
    }
}
