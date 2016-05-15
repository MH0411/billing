/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eklinik_bill;

import java.awt.Desktop;
import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.RMIConnector;
import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 *
 * @author Amalina
 * @author Ho Zhen Hong
 */
public final class Generate extends javax.swing.JFrame {

    //Connect to RMI
    RMIConnector rc = new RMIConnector();
    private ServerDetail sd = new ServerDetail();
    //Declaration host and port
    private String host = sd.getHost();
    private int port = sd.getPort();
    
    
    private DateFormat dateFormat1 = new SimpleDateFormat("MMyyyy");
    private DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
    private Date date = new Date();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    private String txnDate = dateFormat.format(date);
    private String date1 = dateFormat1.format(date);
    private String date2 = dateFormat2.format(date);

    DecimalFormat df = new DecimalFormat("0.00");
   
    private String pmiNo;
    private String billNo;
    private String orderNo;
    private double totalPrice;
    
    /**
     * Creates new form generate
     */
    public Generate() {
        initComponents();
        
        super.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    /**
     * @return the pmiNo
     */
    public String getPmiNo() {
        return pmiNo;
    }

    /**
     * @param pmiNo the pmiNo to set
     */
    public void setPmiNo(String pmiNo) {
        this.pmiNo = pmiNo;
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
     * @return the orderNo
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jtf_name = new javax.swing.JTextField();
        jtf_address = new javax.swing.JTextField();
        jtf_ic = new javax.swing.JTextField();
        jtf_id = new javax.swing.JTextField();
        jtf_telNo = new javax.swing.JTextField();
        jtf_billNo = new javax.swing.JTextField();
        jtf_date = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_BillDetails = new javax.swing.JTable();
        btn_Print = new javax.swing.JButton();
        btn_Confirm = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        btn_Payment = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bill Details"));
        jPanel1.setToolTipText("");

        jtf_name.setEditable(false);
        jtf_name.setToolTipText("");

        jtf_address.setEditable(false);

        jtf_ic.setEditable(false);
        jtf_ic.setToolTipText("");

        jtf_id.setEditable(false);

        jtf_telNo.setEditable(false);

        jtf_billNo.setEditable(false);
        jtf_billNo.setToolTipText("");

        jtf_date.setEditable(false);

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        jLabel3.setText("IC Number");

        jLabel4.setText("Other ID");

        jLabel5.setText("Phone No.");

        jLabel6.setText("Bill No.");

        jLabel7.setText("Date");

        jt_BillDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Description", "Quantity", "Unit Price", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_BillDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jt_BillDetails);

        btn_Print.setText("Print Receipt");
        btn_Print.setEnabled(false);
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });

        btn_Confirm.setText("Confirm");
        btn_Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConfirmActionPerformed(evt);
            }
        });

        btnAddItem.setText("Add Item");
        btnAddItem.setToolTipText("");
        btnAddItem.setEnabled(false);
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btn_Cancel.setText("Cancel");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        btn_Payment.setText("Payment");
        btn_Payment.setEnabled(false);
        btn_Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtf_ic)
                                    .addComponent(jtf_id)
                                    .addComponent(jtf_telNo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_billNo, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                    .addComponent(jtf_date)))
                            .addComponent(jtf_name)
                            .addComponent(jtf_address)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_name, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_address, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_ic, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtf_billNo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_telNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Payment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Print receipt and display receipt
     * @param evt 
     */
    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed
        // TODO add your handling code here:
        try {
            PDF pdf = new PDF(pmiNo, getBillNo());
            pdf.print();
            //Open the generated receipt
            Desktop.getDesktop().open(new File("Receipt.pdf"));
            dispose();
            Billing billing = new Billing();
            billing.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Generate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_PrintActionPerformed

    /**
     * Cancel confirmation of bill
     * @param evt 
     */
    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // TODO add your handling code here:
        Billing billing = new Billing(); //set new window
        billing.setVisible(true);//set new window visible
        dispose(); // for hide current window
    }//GEN-LAST:event_btn_CancelActionPerformed

    /**
     * Allow modification of bill
     * @param evt 
     */
    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:
        AddBillItem addBillItem = new AddBillItem();
        addBillItem.setCustId(pmiNo);
        addBillItem.setBillNo(billNo);
        addBillItem.setVisible(true);
    }//GEN-LAST:event_btnAddItemActionPerformed

    /**
     * Confirm to add bill to customer hdr and dtl
     * @param evt 
     */
    private void btn_ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConfirmActionPerformed
        // TODO add your handling code here:
        
        btn_Payment.setEnabled(true);
        btn_Print.setEnabled(true);
        btn_Confirm.setEnabled(false);
        btnAddItem.setEnabled(true);
        btn_Cancel.setEnabled(false);
        
        try {
            String name = (String) jtf_name.getText();
            String billNo = (String) jtf_billNo.getText();
            String stringDate = (String) jtf_date.getText();

            DefaultTableModel model = (DefaultTableModel) jt_BillDetails.getModel();
            
            //Loop to insert to cus dtl
            int rowCount = model.getRowCount();
            setTotalPrice(0);
            int itemQuantity = 0;
            for (int i = 0; i < rowCount; i++) {
                String itemCode = (jt_BillDetails.getModel().getValueAt(i, 0).toString());
                String itemDesc = (jt_BillDetails.getModel().getValueAt(i, 1).toString());
                String quantity = (jt_BillDetails.getModel().getValueAt(i, 2).toString());
                String unitPrice = (jt_BillDetails.getModel().getValueAt(i, 3).toString());
                String subTotal = (jt_BillDetails.getModel().getValueAt(i, 4).toString());
   
                String sql1 = "INSERT into far_customer_dtl(bill_no, txn_date, item_cd, item_desc, item_amt, quantity, customer_id) "
                        + "VALUES('"+ billNo +"','"+ stringDate +"','"+ itemCode +"','"+ itemDesc +"','"+ unitPrice +"','"+ quantity +"','"+ pmiNo +"' )";
                rc.setQuerySQL(host, port, sql1);
                
                //Calculate total items and total price of items
                double subtol = Double.parseDouble(String.valueOf(subTotal));
                itemQuantity += Integer.parseInt(quantity);
                setTotalPrice(getTotalPrice() + subtol);
            } 
           
            String sql2 = "INSERT into far_customer_hdr(customer_id, bill_no, txn_date, item_desc, item_amt, quantity, order_no, payment)"
                    + "VALUES('"+ pmiNo +"','"+ billNo +"','"+ stringDate +"','"+ name +"','"+ totalPrice +"','"+ itemQuantity +"' , '"+ orderNo +"', 'Unpaid')";
            rc.setQuerySQL(host, port, sql2);
                
            //Get customer_ledger current month credit add to current bill total
            String creditMonth = new Month().getCreditMonth();
            String sql3 = "SELECT "+ creditMonth +" "
                    + "FROM far_customer_ledger "
                    + "WHERE customer_id  = '"+ pmiNo +"'";
            ArrayList<ArrayList<String>> data = rc.getQuerySQL(host, port, sql3);
            
            if (data.isEmpty()) {
                //When no current month credit exist insert
                String sql4 = "INSERT into far_customer_ledger(customer_id, bill_no, txn_date, bill_desc, bill_amt, "+ creditMonth +" )"
                        + "VALUES('"+ pmiNo +"', '"+ billNo +"', '"+ stringDate +"', '"+ name +"', '"+ totalPrice +"', '"+ totalPrice +"' )";
                rc.setQuerySQL(host, port, sql4);
            
            } else {
                //When current month credit exist update
                setTotalPrice(Double.parseDouble(data.get(0).get(0)) + totalPrice);
                String sql5 = "UPDATE far_customer_ledger "
                        + "SET "+ creditMonth +" = '"+ totalPrice +"', bill_amt = '"+ totalPrice +"', txn_date = '"+ stringDate +"' "
                        + "WHERE customer_id = '"+ pmiNo +"' ";
                rc.setQuerySQL(host, port, sql5);
            }

            String infoMessage = "Success add data";
            JOptionPane.showMessageDialog(null, infoMessage, "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_ConfirmActionPerformed

    private void btn_PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PaymentActionPerformed
        // TODO add your handling code here:
        Payment payment = new Payment();
        payment.setCustId(pmiNo);
        payment.setBillNo(billNo);
        payment.setTotalPrice(totalPrice);
//        payment.displayCurrentCredit();
        payment.setVisible(true);
    }//GEN-LAST:event_btn_PaymentActionPerformed

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
            java.util.logging.Logger.getLogger(Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Generate().setVisible(true);
            }
        });
    }

    /**
     * Display selected patient bill details
     */
    public void billDetails() {
        //module name - > 
        //B = Billing
        //R = Receipt
        //I = Invoice
        try {
            String sql1 = "SELECT last_seq_no "
                    + "FROM far_last_seq_no "
                    + "WHERE module_name = 'B' "
                    + "FOR UPDATE";
            ArrayList<ArrayList<String>> dataSeq = rc.getQuerySQL(host, port, sql1);
            
            //Get last sequance number
            String seqNo = dataSeq.get(0).get(0);
            int seq = Integer.parseInt(seqNo);
            int currSeq = seq + 1;
            String currentSeq = Integer.toString(currSeq);
            
            //Update last sequance number
            String sql2 = "UPDATE far_last_seq_no "
                    + "SET last_seq_no = '"+ currentSeq +"' "
                    + "WHERE module_name = 'B'";
            rc.setQuerySQL(host, port, sql2);
            
            //Generate bill no
            int length = (int) Math.log10(currSeq) + 1;
            String zero = "0";
            String num = currentSeq;
            int count;
            for (count = length; count < 10; count++) {
                num = zero + num;
            }
            setBillNo(num + date1);
            
            //Display selected patient bill info
            String sql3 = "SELECT DISTINCT "
                    + "pb.PATIENT_NAME, "
                    + "pb.HOME_ADDRESS, "
                    + "pb.NEW_IC_NO, "
                    + "pb.ID_NO, "
                    + "pb.MOBILE_PHONE, "
                    + "NOW(), "
                    + "pdd.DRUG_ITEM_CODE, "
                    + "mdc.D_TRADE_NAME, "
                    + "pdd.DISPENSED_QTY, "
                    + "mdc.D_PRICE_PPACK, "
                    + "(pdd.DISPENSED_QTY * mdc.D_PRICE_PPACK) AS TOTAL, "
                    + "pb.PATIENT_TYPE "
                    + "FROM pms_episode pe "
                    + "INNER JOIN pms_patient_biodata pb "
                    + "ON pe.PMI_NO = pb.PMI_NO "
                    + "INNER JOIN pis_order_master pom "
                    + "ON pe.PMI_NO = pom.PMI_NO "
                    + "INNER JOIN pis_dispense_master pdm "
                    + "ON pom.ORDER_NO = pdm.ORDER_NO "
                    + "INNER JOIN pis_dispense_detail pdd "
                    + "ON pdm.ORDER_NO = pdd.ORDER_NO "  
                    + "INNER JOIN pis_mdc2 mdc "
                    + "ON pdd.DRUG_ITEM_CODE = mdc.UD_MDC_CODE "
                    + "WHERE pe.PMI_NO = '"+ pmiNo +"' "
                    + "AND pom.order_no = '"+ orderNo +"' ";
            ArrayList<ArrayList<String>> data = rc.getQuerySQL(host, port, sql3);
            
            jtf_name.setText(data.get(0).get(0));
            jtf_address.setText(data.get(0).get(1));
            jtf_ic.setText(data.get(0).get(2));
            jtf_id.setText(data.get(0).get(3));
            jtf_telNo.setText(data.get(0).get(4));
            jtf_billNo.setText(billNo);
            jtf_date.setText(data.get(0).get(5));

            DefaultTableModel model = (DefaultTableModel) jt_BillDetails.getModel();
            //Remove all previous row
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            //Add row and show value
            for (int i = 0; i < data.size(); i++) {
                model.addRow(new Object[]{"", "", "", "", ""});
                jt_BillDetails.setValueAt(data.get(i).get(6), i, 0);
                jt_BillDetails.setValueAt(data.get(i).get(7), i, 1);
                jt_BillDetails.setValueAt((int) Double.parseDouble(data.get(i).get(8)), i, 2);
                jt_BillDetails.setValueAt(df.format(Double.parseDouble(data.get(i).get(9))), i, 3);
                jt_BillDetails.setValueAt(df.format(Double.parseDouble(data.get(i).get(10))), i, 4);
            }

            //Search and add miscellaneous item to table.
            String type = data.get(0).get(11);
            if (type.equals("2")) {
                type = "RG00001";
            } else if (type.equals("1")) {
                type = "RG00002";
            } else if (type.equals("3")) {
                type = "RG00003";
            }
            String sqlItem = "SELECT * "
                    + "FROM far_miscellaneous_item "
                    + "where item_code = '"+ type +"'";
            ArrayList<ArrayList<String>> dataItem = rc.getQuerySQL(host, port, sqlItem);
            String code = dataItem.get(0).get(1);
            String desc = dataItem.get(0).get(2);
            String price = dataItem.get(0).get(4);
            String total = dataItem.get(0).get(4);
            Object[] row = {code, desc, 1, df.format(Double.parseDouble(price)), df.format(Double.parseDouble(total))};
            model.addRow(row);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Confirm;
    private javax.swing.JButton btn_Payment;
    private javax.swing.JButton btn_Print;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_BillDetails;
    private javax.swing.JTextField jtf_address;
    private javax.swing.JTextField jtf_billNo;
    private javax.swing.JTextField jtf_date;
    private javax.swing.JTextField jtf_ic;
    private javax.swing.JTextField jtf_id;
    private javax.swing.JTextField jtf_name;
    private javax.swing.JTextField jtf_telNo;
    // End of variables declaration//GEN-END:variables
}
