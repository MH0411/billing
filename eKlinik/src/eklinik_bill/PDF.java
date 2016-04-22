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
import static eklinik_bill.Generate.billNo;
import static eklinik_bill.Generate.custId;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import main.RMIConnector;

/**
 * This class help print pdf file
 * @author user
 */
public class PDF {
    
    //Call library
    private RMIConnector rc = new RMIConnector();
    private ServerDetail sd = new ServerDetail();
    private String host = sd.getHost();
    private int port = sd.getPort();
    
    private DateFormat dateFormat = new SimpleDateFormat("MMyyyy");
    private Date date = new Date();
    private String date1 = dateFormat.format(date);
    
    public String receiptNo;
    private String custId;
    private String billNo;
    
    public PDF(String custId, String billNo){
        this.custId = custId;
        this.billNo = billNo;
    }
    
     /**
     * Display in PDF format
     */
    public void print() {
        //create new document
        Document document = new Document(PageSize.A4, 36, 36, 64, 36); 
        document.setMargins(40, 30, 50, 50); 

        int num = 0;
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
            document.open(); //open document
            
            //Get patient data from database
            String sql1 = "SELECT "
                    + "pb.patient_name, "
                    + "pb.home_address, "
                    + "pb.new_ic_no, "
                    + "pb.id_no, "
                    + "pb.mobile_phone, "
                    + "ch.bill_no, "
                    + "ch.txn_date, "
                    + "cd.item_cd, "
                    + "cd.item_desc, "
                    + "cd.quantity, "
                    + "cd.item_amt, "
                    + "(cd.quantity * cd.item_amt), "
                    + "ch.item_amt, "
                    + "ch.bill_no "
                    + "FROM customer_hdr ch "
                    + "INNER JOIN customer_dtl cd "
                    + "ON ch.bill_no = cd.bill_no "
                    + "INNER JOIN pms_patient_biodata pb "
                    + "ON cd.customer_id = pb.pmi_no "
                    + "WHERE ch.customer_id = '"+ custId +"'  "
                    + "AND ch.bill_no = '"+ billNo +"' ";
            ArrayList<ArrayList<String>> data1 = rc.getQuerySQL(host, port, sql1);

            //Get the last sequence no of receipt
            String sql2 = "SELECT last_seq_no "
                    + "FROM last_seq_no "
                    + "WHERE module_name = 'R' "
                    + "FOR UPDATE";
            ArrayList<ArrayList<String>> data2 = rc.getQuerySQL(host, port, sql2);
            
            String seqNo = data2.get(0).get(0);
            int seq = Integer.parseInt(seqNo);
            int currSeq = seq + 1;
            String currentSeq = Integer.toString(currSeq);
            
            //Update last sequance number of receipt
            String sql3 = "UPDATE last_seq_no "
                    + "SET last_seq_no = '"+ currentSeq +"' "
                    + "WHERE module_name = 'R'";
            rc.setQuerySQL(host, port, sql3);
            
            //Generate receipt no
            int length = (int) Math.log10(currSeq) + 1;
            String zero = "0";
            String tmpNum = currentSeq;
            
            int count;
            for (count = length; count < 10; count++) {
                tmpNum = zero + tmpNum;
            }
            
            receiptNo = tmpNum + date1;

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
            
            PdfPCell cellAddress = new PdfPCell(new Phrase("Hang Tuah Jaya, 76100 Durian Tunggal, Melaka, Malaysia", rectemja));
            header_table.addCell(cellAddress);
            
            //-----------------------------Title--------------------------------------->
            PdfPCell cell200 = new PdfPCell(new Phrase(" ", recti));
            cell200.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell200.setBorder(Rectangle.NO_BORDER);
            cell200.setColspan(4);
            header_table.addCell(cell200);
            
            PdfPCell cell2 = new PdfPCell(new Phrase(receiptNo, recti));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.setColspan(4);
            header_table.addCell(cell2);

            PdfPCell cell001 = new PdfPCell(new Phrase(" ", recti));
            cell001.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell001.setBorder(Rectangle.NO_BORDER);
            cell001.setColspan(4);
            header_table.addCell(cell001);

            String nama = data1.get(0).get(0);
            String address = data1.get(0).get(1);
            String ic = data1.get(0).get(2);
            String id = data1.get(0).get(3);
            String phone = data1.get(0).get(4);
            String bill_no = data1.get(0).get(5);
            String date = data1.get(0).get(6);

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

            double tmpGrandTotal = 0;
            for (int i = 0; i < data1.size() ; i++) {

                String no = Integer.toString(num);

                String item = data1.get(i).get(7);
                String description = data1.get(i).get(8);
                String quantity = data1.get(i).get(9);
                String price = data1.get(i).get(10);
                String total = data1.get(i).get(11);
                
                tmpGrandTotal += Double.parseDouble(total);

                PdfPCell cell71 = new PdfPCell(new Phrase(no, rectemja));
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

                num++;
            }
            //--------------------------table bill------------------------------------------>
            PdfPTable total = new PdfPTable(6);
            total.setWidths(new float[]{0.5f, 1.5f, 4f, 1.5f, 1.5f, 1.5f});
            total.setLockedWidth(true);
            total.setTotalWidth(document.right() - document.left());
            //--------------------------table bill------------------------------------------>

            String gt2 = data1.get(0).get(12);
            PdfPCell cell81 = new PdfPCell(new Phrase("Grand Total : RM  ", rectem));
            cell81.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell81.setColspan(5);
            PdfPCell cell86 = new PdfPCell(new Phrase(String.valueOf(tmpGrandTotal), rectemjabold));
            cell86.setHorizontalAlignment(Element.ALIGN_CENTER);

            total.addCell(cell81);
            total.addCell(cell86);
            //-------------------------------------------------------------------->

            document.add(header_table);
            document.add(table);
            document.add(total);
            
            document.close();//close document
            writer.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
}
