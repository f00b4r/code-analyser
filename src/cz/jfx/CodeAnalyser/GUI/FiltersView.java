package cz.jfx.CodeAnalyser.GUI;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.Control.FilterController;
import cz.jfx.CodeAnalyser.Filters.Filter;
import cz.jfx.CodeAnalyser.Filters.FilterList;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Felix
 */
public class FiltersView extends javax.swing.JFrame {
    
    private MainView parent;
    private static final Logger logger = Logger.getLogger(FiltersView.class.getName());
    private FilterController controller = AnalyserController.getInstance().getFilterController();
    private FilterList focusedList;
    private FilterListComboBoxModel filterListComboBoxModel = new FilterListComboBoxModel();
    private ExtensionListModel extensionListModel = new ExtensionListModel();

    /** Creates new form FiltersView */
    public FiltersView(MainView mainView) {
        parent = mainView;
        initMyComponents();
        initComponents();
    }
    
    private void initMyComponents() {
        setIconImage(parent.getIconImage());
        
        for (FilterList l : controller.getFilterLists().getFilters()) {
            filterListComboBoxModel.addElement(l);
        }
    }
    
    private class FilterListComboBoxModel extends DefaultComboBoxModel<FilterList> {
        
        @Override
        public FilterList getElementAt(int index) {
            FilterList fl = super.getElementAt(index);
            return fl;
        }
        
        @Override
        public Object getSelectedItem() {
            FilterList f = (FilterList) super.getSelectedItem();
            return f.getName();
        }
        
        public FilterList getSelectedList() {
            FilterList f = (FilterList) super.getSelectedItem();
            return f;
        }
    }
    
    private class ExtensionListModel extends DefaultListModel<Object> {
        
        @Override
        public Object get(int index) {
            Filter f = (Filter) super.get(index);
            return f;
        }
        
        @Override
        public Object getElementAt(int index) {
            Filter f = (Filter) super.getElementAt(index);
            return f.getExtension();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        extensionList = new javax.swing.JList();
        addExtensionButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        filterList = new javax.swing.JComboBox();
        removeExtensionButton = new javax.swing.JButton();
        extensionInput = new javax.swing.JFormattedTextField();
        newListButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filters");

        extensionList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        extensionList.setModel(extensionListModel);
        extensionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(extensionList);

        addExtensionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/add.png"))); // NOI18N
        addExtensionButton.setToolTipText("Add extension to list");
        addExtensionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addExtensionButton.setPreferredSize(new java.awt.Dimension(53, 21));
        addExtensionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExtensionButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Extensions list (*.ext)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Filter lists");

        filterList.setModel(filterListComboBoxModel);
        filterList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterListActionPerformed(evt);
            }
        });
        filterList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                filterListPropertyChange(evt);
            }
        });

        removeExtensionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/delete.png"))); // NOI18N
        removeExtensionButton.setToolTipText("Remove extension from list");
        removeExtensionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeExtensionButton.setPreferredSize(new java.awt.Dimension(53, 21));
        removeExtensionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeExtensionButtonActionPerformed(evt);
            }
        });

        extensionInput.setColumns(2);
        extensionInput.setFont(new java.awt.Font("Tahoma", 0, 12));

        newListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cz/jfx/CodeAnalyser/Resources/add.png"))); // NOI18N
        newListButton.setText("NEW LIST");
        newListButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newListButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("New extension");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(extensionInput, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addExtensionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeExtensionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterList, 0, 216, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newListButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newListButton))
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addExtensionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeExtensionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extensionInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void newListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newListButtonActionPerformed
        focusedList = controller.createList("custom1");
    }//GEN-LAST:event_newListButtonActionPerformed
    
    private void addExtensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExtensionButtonActionPerformed
        Filter f = new Filter(extensionInput.getText());
        focusedList.addFilter(f);
    }//GEN-LAST:event_addExtensionButtonActionPerformed
    
    private void removeExtensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeExtensionButtonActionPerformed
        Filter f = (Filter) extensionListModel.get(extensionList.getSelectedIndex());
        focusedList.removeFilter(f.getExtension());
        updateFocusedList();
    }//GEN-LAST:event_removeExtensionButtonActionPerformed
    
    private void filterListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_filterListPropertyChange
        updateFocusedList();
    }//GEN-LAST:event_filterListPropertyChange
    
    private void updateFocusedList() {
        focusedList = (FilterList) filterListComboBoxModel.getSelectedList();
        extensionListModel.clear();
        for (Filter f : focusedList.getFilters()) {
            extensionListModel.addElement(f);
        }
    }
    
    private void filterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterListActionPerformed
        updateFocusedList();
    }//GEN-LAST:event_filterListActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExtensionButton;
    private javax.swing.JFormattedTextField extensionInput;
    private javax.swing.JList extensionList;
    private javax.swing.JComboBox filterList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newListButton;
    private javax.swing.JButton removeExtensionButton;
    // End of variables declaration//GEN-END:variables
}
