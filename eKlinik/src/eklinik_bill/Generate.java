/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eklinik_bill;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.RMIConnector;
import static jdk.nashorn.internal.objects.NativeString.substring;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 *
 * @author Amalina
 * @author Ho Zhen Hong
 */
public class Generate extends javax.swing.JFrame {

    //Connect to RMI
    RMIConnector rc = new RMIConnector();
    private ServerDetail sd = new ServerDetail();
    //Declaration host and port
    private String host = sd.getHost();
    private int port = sd.getPort();
    
    JDatePicker datePicker = new JDatePicker() {
        @Override
        public void setTextEditable(boolean bln) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isTextEditable() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setButtonFocusable(boolean bln) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean getButtonFocusable() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setShowYearButtons(boolean bln) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isShowYearButtons() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setDoubleClickAction(boolean bln) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isDoubleClickAction() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DateModel<?> getModel() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addActionListener(ActionListener al) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeActionListener(ActionListener al) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    public final String selectedPatient = Billing.getSelectedPatient();
    public static String billNo;
    public static String custId;
    public static String tableClick2;
    public static String orderNo;
    private double totalPrice;
    
    /**
     * Creates new form generate
     */
    public Generate() {
        initComponents();
        billDetails();
        super.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    /**
     * @return the tableClick1
     */
    public String getSelectedPatientPMINo() {
        return selectedPatient;
    }

    /**
     * @return the billNo
     */
    public static String getBillNo() {
        return billNo;
    }

    /**
     * @param aBillNo the billNo to set
     */
    public static void setBillNo(String aBillNo) {
        billNo = aBillNo;
    }

    /**
     * @return the custId
     */
    public static String getCustId() {
        return custId;
    }

    /**
     * @param aCustId the custId to set
     */
    public static void setCustId(String aCustId) {
        custId = aCustId;
    }

    /**
     * @return the tableClick2
     */
    public static String getTableClick2() {
        return tableClick2;
    }

    /**
     * @param aTableClick2 the tableClick2 to set
     */
    public static void setTableClick2(String aTableClick2) {
        tableClick2 = aTableClick2;
    }

    /**
     * @return the orderNo
     */
    public static String getOrderNo() {
        return orderNo;
    }

    /**
     * @param aOrderNo the orderNo to set
     */
    public static void setOrderNo(String aOrderNo) {
        orderNo = aOrderNo;
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
        btn_Modify = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        btn_Payment = new javax.swing.JButton();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bill Details"));
        jPanel1.setToolTipText("");

        jtf_name.setEditable(false);

        jtf_address.setEditable(false);

        jtf_ic.setEditable(false);

        jtf_id.setEditable(false);

        jtf_telNo.setEditable(false);

        jtf_billNo.setEditable(false);

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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_BillDetails.getTableHeader().setReorderingAllowed(false);
        jt_BillDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_BillDetailsMouseClicked(evt);
            }
        });
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

        btn_Modify.setText("Modify");
        btn_Modify.setEnabled(false);
        btn_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModifyActionPerformed(evt);
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

        dateChooserCombo1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserCombo1OnSelectionChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
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
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtf_billNo, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                        .addComponent(jtf_date))))
                            .addComponent(jtf_name)
                            .addComponent(jtf_address)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Modify, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jtf_ic)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_billNo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_telNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Payment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Modify, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
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
        pdf();
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Receipt.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
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
    private void btn_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifyActionPerformed
//        jButton1.setEnabled(false);
//        jButton2.setEnabled(true);
//        jButton3.setEnabled(false);
//        jButton4.setEnabled(true);
//        jButton5.setEnabled(true);   
//        try {
//                String sql = "SELECT DISTINCT "
//                + "pb.PATIENT_NAME, "
//                + "pb.HOME_ADDRESS, "
//                + "pb.NEW_IC_NO, "
//                + "pb.ID_NO, "
//                + "pb.MOBILE_PHONE, "
//                + "ch.bill_no, "
//                + "ch.txn_date, "
//                + "cd.item_cd, "
//                + "cd.item_desc, "
//                + "cd.quantity, "
//                + "cd.item_amt, "
//                + "cd.quantity * cd.item_amt AS total "
//                + "FROM customer_hdr ch "
//                + "INNER JOIN customer_dtl cd "
//                + "ON ch.bill_no = cd.bill_no "
//                + "INNER JOIN pms_patient_biodata pb "
//                + "ON ch.customer_id = pb.ID_NO "
//                + "WHERE ch.customer_id = '"+cust_id+"'";
//                ArrayList<ArrayList<String>> data = rc.getQuerySQL(host, port, sql);// execute query
//
//                jTextField1.setText(data.get(0).get(0));
//                jTextField2.setText(data.get(0).get(1));
//                jTextField3.setText(data.get(0).get(2));
//                jTextField4.setText(data.get(0).get(3));
//                jTextField5.setText(data.get(0).get(4));
//                jTextField6.setText(data.get(0).get(5));
//                jTextField7.setText(data.get(0).get(6));
//                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
//
//                //remove all row
//                int rowCount1 = model1.getRowCount();
//                for (int i = rowCount1 - 1; i >= 0; i--) {
//                    model1.removeRow(i);
////                System.out.println("i " + i);
//                }
//
//                //add row and show value
//                for (int i = 0; i < data.size(); i++) {
//                    model1.addRow(new Object[]{"", "", "", "", ""});
//
//                    //jTable1.setValueAt((Object)i, 1, 1);
//                    jTable1.setValueAt(data.get(i).get(7), i, 0);
//                    jTable1.setValueAt(data.get(i).get(8), i, 1);
//                    jTable1.setValueAt(data.get(i).get(9), i, 2);
//                    jTable1.setValueAt(data.get(i).get(10), i, 3);
//                    jTable1.setValueAt(data.get(i).get(11), i, 4);
//
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            AfterModify afterModify = new AfterModify(); //set new window
            afterModify.setVisible(true);//set new window visible
            dispose(); // for hide current window
    }//GEN-LAST:event_btn_ModifyActionPerformed

    /**
     * Confirm to add bill to customer hdr and dtl
     * @param evt 
     */
    private void btn_ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConfirmActionPerformed
        // TODO add your handling code here:
        
        btn_Payment.setEnabled(true);
        btn_Print.setEnabled(true);
        btn_Confirm.setEnabled(false);
        btn_Modify.setEnabled(true);
        btn_Cancel.setEnabled(false);
        
        try {
            String name = (String) jtf_name.getText();
            String address = (String) jtf_address.getText();
            String ic = (String) jtf_ic.getText();
            String id = (String) jtf_id.getText();
            String telNo = (String) jtf_telNo.getText();
            String billNo = (String) jtf_billNo.getText();
            String stringDate = (String) jtf_date.getText();
            String last_seq = substring(billNo, 1, 10);

            DefaultTableModel model = (DefaultTableModel) jt_BillDetails.getModel();
            
            //Loop to insert to cus dtl
            int rowCount = model.getRowCount();
            totalPrice = 0;
            int datasize = 0;
            for (int i = 0; i < rowCount; i++) {
                String itemCode = (jt_BillDetails.getModel().getValueAt(i, 0).toString());
                String itemDesc = (jt_BillDetails.getModel().getValueAt(i, 1).toString());
                String quantity = (jt_BillDetails.getModel().getValueAt(i, 2).toString());
                String unitPrice = (jt_BillDetails.getModel().getValueAt(i, 3).toString());
                String subTotal = (jt_BillDetails.getModel().getValueAt(i, 4).toString());

                String sql1 = "insert into customer_dtl(bill_no, txn_date, item_cd, item_desc, item_amt, quantity, customer_id )"
                        + "values('" + billNo + "','" + stringDate + "','" + itemCode + "','" + itemDesc + "','" + unitPrice + "','" + quantity + "','" + getCustId() + "' )";
                rc.setQuerySQL(host, port, sql1);

                String sql2 = "insert into last_seq_no(last_seq_no )" + "values('" + last_seq + "' )";
                rc.setQuerySQL(host, port, sql2);
                
                //Calculate total items and total price of items
                double subtol = Double.parseDouble(String.valueOf(subTotal));
                datasize = datasize + 1;
                totalPrice = totalPrice + subtol;
            }
            
            DateFormat dateFormat;
            dateFormat = new SimpleDateFormat("MM");
            Date date = new Date();

            String creditMonth = null;
            String month = dateFormat.format(date);
            
            //Check current month
            if (null != month) {
                switch (month) {
                    case "01":
                        creditMonth = "cr_amt_1";
                        break;
                    case "02":
                        creditMonth = "cr_amt_2";
                        break;
                    case "03":
                        creditMonth = "cr_amt_3";
                        break;
                    case "04":
                        creditMonth = "cr_amt_4";
                        break;
                    case "05":
                        creditMonth = "cr_amt_5";
                        break;
                    case "06":
                        creditMonth = "cr_amt_6";
                        break;
                    case "07":
                        creditMonth = "cr_amt_7";
                        break;
                    case "08":
                        creditMonth = "cr_amt_8";
                        break;
                    case "09":
                        creditMonth = "cr_amt_9";
                        break;
                    case "10":
                        creditMonth = "cr_amt_10";
                        break;
                    case "11":
                        creditMonth = "cr_amt_11";
                        break;
                    case "12":
                        creditMonth = "cr_amt_12";
                        break;
                    default:
                        break;
                }
            }
            
            /**
             * haven complete
             * get last month credit and debit to calculate this month credit
             * get this month credit add to current bill
             */
            String sql3 = "insert into customer_hdr(customer_id, bill_no, txn_date, item_desc, item_amt, quantity)"
                    + "values('" + getCustId() + "','" + billNo + "','" + stringDate + "','" + name + "','" + totalPrice + "','" + datasize + "' )";
            rc.setQuerySQL(host, port, sql3);
                
            String sql4 = "insert into customer_ledger(customer_id, txn_date, bill_no, bill_desc, bill_amt, " + creditMonth + " )"
                    + "values('" + getCustId() + "', '" + stringDate + "', '" + billNo + "', '" + name + "', '" + totalPrice + "', '" + totalPrice + "' )";
            rc.setQuerySQL(host, port, sql4);

            String infoMessage = "Success add data";
            JOptionPane.showMessageDialog(null, infoMessage, "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_ConfirmActionPerformed

    /**
     * ??
     * @param evt 
     */
    private void jt_BillDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_BillDetailsMouseClicked
        // TODO add your handling code here:
//        int row = jTable1.getSelectedRow();
//        Table_click2 = (jTable1.getModel().getValueAt(row, 0).toString());
//        edit m = new edit(); //set new window
//        m.setVisible(true);//set new window visible
//        dispose(); // for hide current window
//
//        String sql = "SELECT DISTINCT pdm.ORDER_NO "
//                + "FROM ehr_central ec "
//                + "INNER JOIN pms_patient_biodata pb "
//                + "ON ec.PMI_NO = pb.PMI_NO "
//                + "INNER JOIN pis_order_master pom "
//                + "ON ec.PMI_NO = pom.PMI_NO "
//                + "INNER JOIN pis_dispense_master pdm "
//                + "ON pom.ORDER_NO = pdm.ORDER_NO "
//                + "INNER JOIN pis_dispense_detail pdd "
//                + "ON pdm.ORDER_NO = pdd.ORDER_NO "
//                + "INNER JOIN pis_mdc2 mdc "
//                + "ON pdd.DRUG_ITEM_CODE = mdc.UD_MDC_CODE "
//                + "WHERE (ec.status = 1 OR ec.status = 3) "
//                + "AND ec.PMI_NO = '" + Table_click1 + "' "
//                + "AND  pdd.DRUG_ITEM_CODE = '" + Table_click2 + "' ";
//        //+ "AND substring(pom.EPISODE_CODE,1,10)='2015-12-21' "
//        //+ "AND substring(pdm.ORDER_DATE,1,10)='2015-12-21'";
////                    + "AND substring(pom.EPISODE_CODE,1,10)='" + dateFormat.format(date) + "' "
////                    + "AND substring(pdm.ORDER_DATE,1,10)='" + dateFormat.format(date) + "'";
//        ArrayList<ArrayList<String>> data = rc.getQuerySQL(host, port, sql);// execute query
//        orderno = data.get(0).get(0);
//        System.out.println("test order no: " + orderno);

    }//GEN-LAST:event_jt_BillDetailsMouseClicked

    private void btn_PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PaymentActionPerformed
        // TODO add your handling code here:
        Payment payment = new Payment();
        payment.setVisible(true);
    }//GEN-LAST:event_btn_PaymentActionPerformed

    private void dateChooserCombo1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnSelectionChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserCombo1OnSelectionChange

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
        try {
            DateFormat dateFormat1;
            DateFormat dateFormat2;
            dateFormat1 = new SimpleDateFormat("MMyyyy");
            dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String date1 = dateFormat1.format(date);
            String date2 = dateFormat2.format(date);
            
            DecimalFormat df = new DecimalFormat("0.00"); 
            
            String sqlSearch = "SELECT bill_no FROM customer_ledger WHERE customer_id = '"+getCustId()+"' ";
            ArrayList<ArrayList<String>> dataSearch = rc.getQuerySQL(host, port, sqlSearch);
            
            //if customer ledger no selected patient record create new bill
            //else get bill no in customer ledger
            if (dataSearch.isEmpty()){
                //Check count of bills
                String sqlSeqNo = "SELECT MAX(last_seq_no) AS no FROM last_seq_no";
                ArrayList<ArrayList<String>> dataSeq = rc.getQuerySQL(host, port, sqlSeqNo);

                //Generate bill no
                String checkSeq = dataSeq.get(0).get(0);
                int seq = Integer.parseInt(checkSeq);
                int currSeq = seq + 1;
                String currentSeq = Integer.toString(currSeq);

                int length = (int) Math.log10(currSeq) + 1;
                String zero = "0";
                String num = currentSeq;

                int count;
                for (count = length; count < 10; count++) {
                    num = zero + num;
                }
                setBillNo(num + date1);
            } else {
                setBillNo(dataSearch.get(0).get(0));
            }
            
            String sql = "SELECT DISTINCT "
                    + "pb.PATIENT_NAME,  pb.HOME_ADDRESS, pb.NEW_IC_NO, pb.ID_NO, pb.MOBILE_PHONE, NOW(), "
                    + "pdd.DRUG_ITEM_CODE, mdc.D_TRADE_NAME, pdd.DISPENSED_QTY, "
                    + "mdc.D_PRICE_PPACK, pdd.DISPENSED_QTY * mdc.D_PRICE_PPACK AS TOTAL, "
                    + "pb.PMI_NO "
                    + "FROM ehr_central ec "
                    + "INNER JOIN pms_patient_biodata pb "
                    + "ON ec.PMI_NO = pb.PMI_NO "
                    + "INNER JOIN pis_order_master pom "
                    + "ON ec.PMI_NO = pom.PMI_NO "
                    + "INNER JOIN pis_dispense_master pdm "
                    + "ON pom.ORDER_NO = pdm.ORDER_NO "
                    + "INNER JOIN pis_dispense_detail pdd "
                    + "ON pdm.ORDER_NO = pdd.ORDER_NO "  
                    + "INNER JOIN pis_mdc2 mdc "
                    + "ON pdd.DRUG_ITEM_CODE = mdc.UD_MDC_CODE "
                    + "WHERE (ec.status = 1 OR ec.status = 3) "
                    + "AND ec.PMI_NO = '" + getSelectedPatientPMINo() + "' "
                    + "AND pdm.dispensed_date like '2016-03-25%' ";
            
            ArrayList<ArrayList<String>> data = rc.getQuerySQL(host, port, sql);
            
            System.out.println(data.get(0).get(0));

            jtf_name.setText(data.get(0).get(0));
            jtf_address.setText(data.get(0).get(1));
            jtf_ic.setText(data.get(0).get(2));
            jtf_id.setText(data.get(0).get(3));
            jtf_telNo.setText(data.get(0).get(4));
            jtf_billNo.setText(getBillNo());
            jtf_date.setText(data.get(0).get(5));

            setCustId(data.get(0).get(11));
            System.out.println(getCustId());
            
            
//            System.out.println("cust id no : " + custId);
//            System.out.println("bill no : " + billNo);
//            System.out.println("cust pmi no : " + billNo);
            
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

            String id = data.get(0).get(3);
            int lengthId = id.length();
            
            //Search and add miscellaneous item to table.
            if (lengthId == 10) {
                String sqlItem = "SELECT * FROM miscellaneous_item where item_desc = 'Student'";
                ArrayList<ArrayList<String>> dataItem = rc.getQuerySQL(host, port, sqlItem);
                String code = dataItem.get(0).get(1);
                String desc = dataItem.get(0).get(2);
                String price = dataItem.get(0).get(4);
                String total = dataItem.get(0).get(4);
                Object[] row = {code, desc, 1, df.format(Double.parseDouble(price)), df.format(Double.parseDouble(total))};
                model.addRow(row);
                
            } else if (lengthId == 5) {
                String sqlItem = "SELECT * FROM miscellaneous_item where item_desc = 'Staff'";
                ArrayList<ArrayList<String>> dataItem = rc.getQuerySQL(host, port, sqlItem);
                String code = dataItem.get(0).get(1);
                String desc = dataItem.get(0).get(2);
                String price = dataItem.get(0).get(4);
                String total = dataItem.get(0).get(4);
                Object[] row = {code, desc, 1, df.format(Double.parseDouble(price)), df.format(Double.parseDouble(total))};
                model.addRow(row);
                
            } else {
                String sqlItem = "SELECT * FROM miscellaneous_item where item_desc = 'Other'";
                ArrayList<ArrayList<String>> dataItem = rc.getQuerySQL(host, port, sqlItem);
                String code = dataItem.get(0).get(1);
                String desc = dataItem.get(0).get(2);
                String price = dataItem.get(0).get(4);
                String total = dataItem.get(0).get(4);
                Object[] row = {code, desc, 1, df.format(Double.parseDouble(price)), df.format(Double.parseDouble(total))};
                model.addRow(row);
            }
            
            //Get temporary item add to table
            dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String getDate1 = dateFormat1.format(new Date());
            String sql2 = "SELECT * FROM temp_item WHERE customer_id ='" + getSelectedPatientPMINo() + "' AND date = '" + getDate1 + "' ";

            ArrayList<ArrayList<String>> data2 = rc.getQuerySQL(host, port, sql2);
            
            for (int i = 0; i < data2.size(); i++) {
                String code = data2.get(i).get(3);
                String desc = data2.get(i).get(4);
                String qt = data2.get(i).get(5);
                String price = data2.get(i).get(6);
                double subTotal = Double.parseDouble(qt) * Double.parseDouble(price);

                int subTot = (int) subTotal;
                String tot = Integer.toString(subTot);

                Object[] row = {code, desc, qt, df.format(Double.parseDouble(price)), df.format(Double.parseDouble(tot))};
                model.addRow(row);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Display in PDF format
     */
    public void pdf() {
        Document document = new Document(PageSize.A4, 36, 36, 64, 36); //create new document
        document.setMargins(40, 30, 50, 50); //set document margin

        int num = 0;
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
            document.open(); //open document
            //database query

            String sql = "SELECT DISTINCT "
                    + "pb.PATIENT_NAME, "
                    + "pb.HOME_ADDRESS, "
                    + "pb.NEW_IC_NO, "
                    + "pb.ID_NO, "
                    + "pb.MOBILE_PHONE, "
                    + "ch.bill_no, "
                    + "ch.txn_date, "
                    + "cd.item_cd, "
                    + "cd.item_desc, "
                    + "cd.quantity, "
                    + "cd.item_amt, "
                    + "(cd.quantity * cd.item_amt), "
                    + "ch.item_amt "
                    + "FROM customer_hdr ch "
                    + "INNER JOIN customer_dtl cd "
                    + "ON ch.customer_id = cd.customer_id "
                    + "INNER JOIN pms_patient_biodata pb "
                    + "ON cd.customer_id = pb.ID_NO "
                    + "WHERE ch.customer_id = '" + getCustId() + "'  and ch.bill_no = '" + getBillNo() + "' ";
            //+ "AND ch.txn_date = '2016-02-01'";
            ArrayList<ArrayList<String>> data = rc.getQuerySQL(host, port, sql);// execute query

            //initialize pdf
            Font recno = new Font(Font.TIMES_ROMAN, 10);
            Font recti = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font rectem = new Font(Font.HELVETICA, 12, Font.BOLD);
            Font rectemja = new Font(Font.COURIER, 12);
            Font rectemjabold = new Font(Font.COURIER, 12, Font.BOLD);
            //--------------------------table bill------------------------------------------>
            PdfPTable table = new PdfPTable(6);
            table.setWidths(new float[]{0.5f, 1.5f, 4f, 1.5f, 1.5f, 1.5f});
            table.setLockedWidth(true);
            table.setTotalWidth(document.right() - document.left());
            //--------------------------receipt no------------------------------------------>
            PdfPTable header_table = new PdfPTable(4);
            header_table.setWidths(new float[]{2f, 7f, 1.5f, 4f});
            header_table.setLockedWidth(true);
            header_table.setTotalWidth(document.right() - document.left());

            //--------------------------table header------------------------------------------>
            Image logo = Image.getInstance("pic/logo.png");
            logo.scaleAbsolute(115, 50);

            PdfPCell cell1 = new PdfPCell(logo);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setBorder(Rectangle.NO_BORDER);
            cell1.setColspan(4);
            cell1.setLeading(15f, 0.3f);
            header_table.addCell(cell1);
            //-----------------------------Title--------------------------------------->
            PdfPCell cell200 = new PdfPCell(new Phrase(" ", recti));
            cell200.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell200.setBorder(Rectangle.NO_BORDER);
            cell200.setColspan(4);
            header_table.addCell(cell200);
            PdfPCell cell2 = new PdfPCell(new Phrase("RECEIPT", recti));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.setColspan(4);
            header_table.addCell(cell2);

            PdfPCell cell001 = new PdfPCell(new Phrase(" ", recti));
            cell001.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell001.setBorder(Rectangle.NO_BORDER);
            cell001.setColspan(4);
            header_table.addCell(cell001);

            String nama = data.get(0).get(0);
            String address = data.get(0).get(1);
            String ic = data.get(0).get(2);
            String id = data.get(0).get(3);
            String phone = data.get(0).get(4);
            String bill_no = data.get(0).get(5);
            String date = data.get(0).get(6);

            // String grandtotal = data.get(i).get(10);
            //System.out.println(name);
            //--------------------------Receipt item------------------------------------------>
            PdfPCell cell11 = new PdfPCell(new Phrase("Name", rectem));
            cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell11.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell12 = new PdfPCell(new Phrase(": " + nama, rectemja));
            cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell12.setBorder(Rectangle.NO_BORDER);
            cell12.setColspan(3);

            header_table.addCell(cell11);
            header_table.addCell(cell12);

            PdfPCell cell21 = new PdfPCell(new Phrase("Address", rectem));
            cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell21.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell22 = new PdfPCell(new Phrase(": " + address, rectemja));
            cell22.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell22.setBorder(Rectangle.NO_BORDER);
            cell22.setColspan(3);

            header_table.addCell(cell21);
            header_table.addCell(cell22);

            PdfPCell cell31 = new PdfPCell(new Phrase("IC Number", rectem));
            cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell31.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell32 = new PdfPCell(new Phrase(": " + ic, rectemja));
            cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell32.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell33 = new PdfPCell(new Phrase(" ", rectem));
            cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell33.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell34 = new PdfPCell(new Phrase(" ", rectemja));
            cell34.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell34.setBorder(Rectangle.NO_BORDER);

            header_table.addCell(cell31);
            header_table.addCell(cell32);
            header_table.addCell(cell33);
            header_table.addCell(cell34);

            PdfPCell cell41 = new PdfPCell(new Phrase("Other ID", rectem));
            cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell41.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell42 = new PdfPCell(new Phrase(": " + id, rectemja));
            cell42.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell42.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell43 = new PdfPCell(new Phrase("Bill No", rectem));
            cell43.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell43.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell44 = new PdfPCell(new Phrase(": " + bill_no, rectemja));
            cell44.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell44.setBorder(Rectangle.NO_BORDER);

            header_table.addCell(cell41);
            header_table.addCell(cell42);
            header_table.addCell(cell43);
            header_table.addCell(cell44);

            PdfPCell cell51 = new PdfPCell(new Phrase("No. Tel", rectem));
            cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell51.setBorder(Rectangle.NO_BORDER);
            PdfPCell cell52 = new PdfPCell(new Phrase(": " + phone, rectemja));
            cell52.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell52.setBorder(Rectangle.NO_BORDER);

            DateFormat dateFormat;
            dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //2015-01-06 
            Date date1 = new Date();
            String getdate = dateFormat.format(date1);

            PdfPCell cell53 = new PdfPCell(new Phrase("Date", rectem));
            cell53.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell53.setBorder(Rectangle.NO_BORDER);

            PdfPCell cell54 = new PdfPCell(new Phrase(": " + getdate, rectemja));
            cell54.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell54.setBorder(Rectangle.NO_BORDER);

            header_table.addCell(cell51);
            header_table.addCell(cell52);
            header_table.addCell(cell53);
            header_table.addCell(cell54);

            PdfPCell cell002 = new PdfPCell(new Phrase(" ", recti));
            cell002.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell002.setBorder(Rectangle.NO_BORDER);
            cell002.setColspan(4);
            header_table.addCell(cell002);

            //-------------------------------------------------------------------->
            PdfPCell cell61 = new PdfPCell(new Phrase("No.", rectem));
            cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell62 = new PdfPCell(new Phrase("Item", rectem));
            cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell63 = new PdfPCell(new Phrase("Description", rectem));
            cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell64 = new PdfPCell(new Phrase("Quantity", rectem));
            cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell65 = new PdfPCell(new Phrase("Unit Price", rectem));
            cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell66 = new PdfPCell(new Phrase("Total Price", rectem));
            cell66.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell61);
            table.addCell(cell62);
            table.addCell(cell63);
            table.addCell(cell64);
            table.addCell(cell65);
            table.addCell(cell66);

           
            for (int i = 0; i < data.size(); i++) {

                String NO = Integer.toString(num);

                String item = data.get(i).get(7);
                String description = data.get(i).get(8);
                String quantity = data.get(i).get(9);
                String price = data.get(i).get(10);
                String total = data.get(i).get(11);
                

                PdfPCell cell71 = new PdfPCell(new Phrase(NO, rectemja));
                cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell cell72 = new PdfPCell(new Phrase(item, rectemja));
                cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell cell73 = new PdfPCell(new Phrase(description, rectemja));
                cell73.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell cell74 = new PdfPCell(new Phrase(quantity, rectemja));
                cell74.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell cell75 = new PdfPCell(new Phrase(price, rectemja));
                cell75.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell cell76 = new PdfPCell(new Phrase(total, rectemja));
                cell76.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell71);
                table.addCell(cell72);
                table.addCell(cell73);
                table.addCell(cell74);
                table.addCell(cell75);
                table.addCell(cell76);

                num = num + 1;
            }
            //--------------------------table bill------------------------------------------>
            PdfPTable total = new PdfPTable(6);
            total.setWidths(new float[]{0.5f, 1.5f, 4f, 1.5f, 1.5f, 1.5f});
            total.setLockedWidth(true);
            total.setTotalWidth(document.right() - document.left());
            //--------------------------table bill------------------------------------------>

            String gt2 = data.get(0).get(12);
            PdfPCell cell81 = new PdfPCell(new Phrase("Grand Total : RM  ", rectem));
            cell81.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell81.setColspan(5);
            PdfPCell cell86 = new PdfPCell(new Phrase(String.valueOf(totalPrice), rectemjabold));
            cell86.setHorizontalAlignment(Element.ALIGN_CENTER);

            total.addCell(cell81);
            total.addCell(cell86);
            //-------------------------------------------------------------------->

            document.add(header_table);
            document.add(table);
            document.add(total);
            document.close();//close document

            writer.close();
            Billing billing = new Billing(); //set new window
            billing.setVisible(true);//set new window visible
            dispose(); // for hide current window
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Confirm;
    private javax.swing.JButton btn_Modify;
    private javax.swing.JButton btn_Payment;
    private javax.swing.JButton btn_Print;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
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
