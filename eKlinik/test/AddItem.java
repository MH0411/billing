

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import main.RMIConnector;

/**
 *
 * @author Ho Zhen Hong
 */
public class AddItem extends javax.swing.JFrame {
// call library

    RMIConnector rc = new RMIConnector();
    private ServerDetail sd = new ServerDetail();
    // declaration host and port
    private String host = sd.getHost();
    private int port = sd.getPort();
    
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    private Date date = new Date();        

    private String custId;
    private String billNo;

    /**
     * Creates new form addItem
     */
    public AddItem() {
        initComponents();
        fillcombo();
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the billNo
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * @param billNo the billNo to set
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtf_desc = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        jcb_itemCd = new javax.swing.JComboBox<>();
        jtf_unitPrice = new javax.swing.JTextField();
        jtf_quantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jtf_desc.setEditable(false);
        jtf_desc.setEnabled(false);

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jcb_itemCd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb_itemCd.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcb_itemCdPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jtf_unitPrice.setEditable(false);
        jtf_unitPrice.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Add Item");

        jLabel2.setText("Item");

        jLabel3.setText("Description");

        jLabel4.setText("Unit Price");

        jLabel5.setText("Quantity");

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addComponent(jtf_desc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcb_itemCd, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_unitPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtf_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(159, 159, 159)))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcb_itemCd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_quantity)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * cancel current action
     * @param evt 
     */
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        dispose(); // for hide current window
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void jcb_itemCdPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcb_itemCdPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String selectedItem = (String) jcb_itemCd.getSelectedItem();
        String sql = "Select * from miscellaneous_item where item_code='" + selectedItem + "'";
        ArrayList<ArrayList<String>> data = rc.getQuerySQL(host, port, sql);

        if (selectedItem != "-Please Select-") {
            jtf_desc.setText(data.get(0).get(2));
            jtf_unitPrice.setText(data.get(0).get(4));
        } else {
            jtf_desc.setText("");
            jtf_unitPrice.setText("");
            jtf_quantity.setText("");
        }
    }//GEN-LAST:event_jcb_itemCdPopupMenuWillBecomeInvisible

    /**
     * Add selected item to customer dtl
     * @param evt 
     */
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        String strDate = dateFormat.format(date);
        
        String itemCode = (String) jcb_itemCd.getSelectedItem();
        String desc = (String) jtf_desc.getText();
        String unitPrice = (String) jtf_unitPrice.getText();
        String quantity = (String) jtf_quantity.getText();

        if (quantity == null) {
            String infoMessage = "Please insert data in Quantity text field.";
            JOptionPane.showMessageDialog(null, infoMessage, "Warning",
                    JOptionPane.WARNING_MESSAGE);

        } else if (itemCode == null) {
            String infoMessage = "Please select the Item Code.";
            JOptionPane.showMessageDialog(null, infoMessage, "Warning",
                    JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                System.out.println(strDate);
                String month = new Month().getCreditMonth();
                double totalPrice = Integer.parseInt(quantity) * Double.parseDouble(unitPrice);
                
                //Get current month credit and add the item price
                String sql1 = "SELECT "+ month +" "
                        + "FROM customer_ledger "
                        + "WHERE customer_id = '"+ custId +"' ";
                ArrayList<ArrayList<String>> data1 = rc.getQuerySQL(host, port, sql1);
                String currentCredit = data1.get(0).get(0);
                
                currentCredit = String.valueOf(Double.parseDouble(currentCredit) + totalPrice);
                
                //Update customer ledger
                String sql2 = "UPDATE customer_ledger "
                        + "SET "+ month +" = '"+ currentCredit +"' "
                        + "WHERE customer_id = '"+ custId +"' ";
                rc.setQuerySQL(host, port, sql2);
                
                //Update customer dtl
                String sql3 = "INSERT into customer_dtl (txn_date, item_cd, item_desc, item_amt, quantity, bill_no) "
                        + "VALUES('"+ strDate +"', '"+ itemCode +"','"+ desc +"','"+ unitPrice +"','"+ quantity +"','"+ billNo +"')";
                rc.setQuerySQL(host, port, sql3);
                
                //Get current bill_amt and add item price;
                String sql4 = "SELECT item_amt, quantity "
                        + "FROM customer_hdr "
                        + "WHERE customer_id = '"+ custId +"' "
                        + "AND bill_no = '"+ billNo +"'";
                ArrayList<ArrayList<String>> data2 = rc.getQuerySQL(host, port, sql4);
                String itemAmt = data2.get(0).get(0);
                String qty = data2.get(0).get(1);
                
                itemAmt = String.valueOf(Double.parseDouble(itemAmt) + totalPrice);
                qty = String.valueOf(Integer.parseInt(qty) + quantity);
                
                //Update customer hdr
                String sql5 = "UPDATE customer_hdr "
                        + "SET txn_date = '"+ strDate +"', item_amt = '"+ itemAmt +"', quantity = '"+ qty +"' "
                        + "WHERE bill_no = '"+ billNo +"' "
                        + "AND customer_id = '"+ custId +"'";
                
                String infoMessage = "Success add data";
                JOptionPane.showMessageDialog(null, infoMessage, "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
           
            dispose(); 
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_formWindowClosed

    /**
     * get item from miscellaneous item table
     */
    private void fillcombo() {
        jcb_itemCd.removeAllItems();
        jcb_itemCd.addItem("-Please Select-");

        String sql = "Select * from miscellaneous_item";

        ArrayList<ArrayList<String>> data = rc.getQuerySQL(host, port, sql);// execute query

        for (int i = 0; i < data.size(); i++) {
            jcb_itemCd.addItem(data.get(i).get(1));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcb_itemCd;
    private javax.swing.JTextField jtf_desc;
    private javax.swing.JTextField jtf_quantity;
    private javax.swing.JTextField jtf_unitPrice;
    // End of variables declaration//GEN-END:variables
}
