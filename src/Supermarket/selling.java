/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Supermarket;

import java.awt.print.PrinterException;
import java.sql.*;  

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author kraji
 */
public class selling extends javax.swing.JFrame {

    /**
     * Creates new form selling
     */
    
     
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    public selling() {
        initComponents();
        selectproduct();
         Getcat();
    }
    
     
    public void selectproduct(){
        
        try{
         conn=  (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/SupermarketDB","user1","root");
         stmt= conn.createStatement();
         rs= stmt.executeQuery("select * from user1.PROD");
         Bill_Prod_table2.setModel(DbUtils.resultSetToTableModel(rs));
        Bill_Prod_table2.getColumn("PRODID").setHeaderValue("ProductID");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

      public void Getcat(){
         try{
         conn=  (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/SupermarketDB","user1","root");
         stmt= conn.createStatement();
         rs= stmt.executeQuery("select * from user1.CAT");
         while(rs.next()){
         String mycat=rs.getString("CATNAME");
         BillCat.addItem(mycat);
         }
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void update(){
          newqty= Availqty - Integer.valueOf(BillQty.getText());
       
    try{
    
        conn=  (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/SupermarketDB","user1","root");
        String query ="Update user1.PROD set PRDQTY="+newqty+" Where PRODID="+Prid;
        Statement add=conn.createStatement();
        add.executeUpdate(query);
          // JOptionPane.showMessageDialog(this,"Entry Updated");
       selectproduct();
           
        
    }catch(SQLException e){
        e.printStackTrace();
    }
   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        BillID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        BillName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        BillQty = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        BillCat = new javax.swing.JComboBox<>();
        Clear_button2 = new javax.swing.JButton();
        Add_button = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Bill_Prod_table2 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BillText = new javax.swing.JTextArea();
        Print_button = new javax.swing.JButton();
        GrdTotalLbl = new javax.swing.JLabel();
        Filter = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        jLabel6.setFont(new java.awt.Font("Russo One", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Billing Point");

        BillID.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        BillID.setForeground(new java.awt.Color(102, 102, 255));
        BillID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillIDActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Russo One", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 255));
        jLabel16.setText("Bill ID");

        jLabel17.setFont(new java.awt.Font("Russo One", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 255));
        jLabel17.setText("Name");

        BillName.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        BillName.setForeground(new java.awt.Color(102, 102, 255));
        BillName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillNameActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Russo One", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 255));
        jLabel18.setText("quantity");

        BillQty.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        BillQty.setForeground(new java.awt.Color(102, 102, 255));
        BillQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillQtyActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Russo One", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 255));
        jLabel19.setText("Filter by");

        BillCat.setForeground(new java.awt.Color(102, 102, 255));
        BillCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillCatMouseClicked(evt);
            }
        });
        BillCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillCatActionPerformed(evt);
            }
        });

        Clear_button2.setBackground(new java.awt.Color(102, 51, 255));
        Clear_button2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Clear_button2.setForeground(new java.awt.Color(255, 255, 255));
        Clear_button2.setText("Clear");
        Clear_button2.setBorder(null);
        Clear_button2.setBorderPainted(false);
        Clear_button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clear_button2MouseClicked(evt);
            }
        });
        Clear_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_button2ActionPerformed(evt);
            }
        });

        Add_button.setBackground(new java.awt.Color(102, 51, 255));
        Add_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add_button.setForeground(new java.awt.Color(255, 255, 255));
        Add_button.setText("Add to Bill");
        Add_button.setBorder(null);
        Add_button.setBorderPainted(false);
        Add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_buttonMouseClicked(evt);
            }
        });
        Add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_buttonActionPerformed(evt);
            }
        });

        Refresh.setBackground(new java.awt.Color(102, 51, 255));
        Refresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Refresh");
        Refresh.setBorder(null);
        Refresh.setBorderPainted(false);
        Refresh.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RefreshStateChanged(evt);
            }
        });
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshMouseClicked(evt);
            }
        });
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        Bill_Prod_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Name", "Price", "Category", "Quantity"
            }
        ));
        Bill_Prod_table2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        Bill_Prod_table2.setRowHeight(25);
        Bill_Prod_table2.setSelectionBackground(new java.awt.Color(102, 102, 255));
        Bill_Prod_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bill_Prod_table2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Bill_Prod_table2);

        jLabel21.setFont(new java.awt.Font("Russo One", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 255));
        jLabel21.setText("Products Table");

        BillText.setColumns(20);
        BillText.setRows(5);
        jScrollPane1.setViewportView(BillText);

        Print_button.setBackground(new java.awt.Color(102, 51, 255));
        Print_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Print_button.setForeground(new java.awt.Color(255, 255, 255));
        Print_button.setText("Print");
        Print_button.setBorder(null);
        Print_button.setBorderPainted(false);
        Print_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Print_buttonMouseClicked(evt);
            }
        });
        Print_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_buttonActionPerformed(evt);
            }
        });

        GrdTotalLbl.setFont(new java.awt.Font("Russo One", 0, 18)); // NOI18N
        GrdTotalLbl.setForeground(new java.awt.Color(255, 51, 51));
        GrdTotalLbl.setText("RS");

        Filter.setBackground(new java.awt.Color(102, 51, 255));
        Filter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Filter.setForeground(new java.awt.Color(255, 255, 255));
        Filter.setText("Filter");
        Filter.setBorder(null);
        Filter.setBorderPainted(false);
        Filter.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                FilterStateChanged(evt);
            }
        });
        Filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterMouseClicked(evt);
            }
        });
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BillQty, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(347, 347, 347)
                                .addComponent(jLabel6))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(Clear_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(27, 27, 27))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BillID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BillName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGap(35, 35, 35)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(212, 212, 212))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                        .addGap(52, 52, 52))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(BillCat, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(Print_button, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(GrdTotalLbl)
                        .addGap(208, 208, 208))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BillID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(jLabel21))
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BillName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BillCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(BillQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clear_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrdTotalLbl)
                .addGap(20, 20, 20)
                .addComponent(Print_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Russo One", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("X");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Russo One", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Logout");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel22)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BillIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillIDActionPerformed

    private void BillNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillNameActionPerformed

    private void BillQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillQtyActionPerformed

    private void BillCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillCatActionPerformed

    private void Clear_button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Clear_button2MouseClicked
        // TODO add your handling code here:
        BillID.setText("");
        BillName.setText("");
      
        BillQty.setText("");
        BillCat.setSelectedIndex(0);

    }//GEN-LAST:event_Clear_button2MouseClicked

    private void Clear_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Clear_button2ActionPerformed
int i;
    private void Add_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_buttonMouseClicked
        // TODO add your handling code here:
 if(BillQty.getText().isEmpty() || BillName.getText().isEmpty() ){
     JOptionPane.showMessageDialog(this, "Missing Field Values");
 }
 else if(Availqty<= Integer.valueOf(BillQty.getText())){
     
  JOptionPane.showMessageDialog(this, "Sorry no Stock Available!!!");
 }
 else{
 i++;
   ProdTot= Uprice * Integer.valueOf(BillQty.getText());
   Grdtot+=ProdTot;
 if(i==1){
 BillText.setText(BillText.getText()+"###############  Welcome  ##############\n"+"NUM        PRODUCT        PRICE        QUANTITY        TOTAL\n"+i+"               "+BillName.getText()+"                  "+(ProdTot/Integer.valueOf(BillQty.getText()))+"                    "+BillQty.getText()+"                    "+ProdTot+"\n");
 
 }
 else{
     BillText.setText(BillText.getText()+i+"               "+BillName.getText()+"                  "+(ProdTot/Integer.valueOf(BillQty.getText()))+"                    "+BillQty.getText()+"                    "+ProdTot+"\n");
 }
 GrdTotalLbl.setText("RS "+Grdtot);
 update();
 
 }
 
    }//GEN-LAST:event_Add_buttonMouseClicked

    private void Add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Add_buttonActionPerformed

    private void RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseClicked
        // TODO add your handling code here:
       selectproduct();
    }//GEN-LAST:event_RefreshMouseClicked

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshActionPerformed

    Double Uprice,ProdTot=0.0,Grdtot=0.0;
    int Availqty,Prid,newqty;
    private void Bill_Prod_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bill_Prod_table2MouseClicked
        // TODO add your handling code here:
     DefaultTableModel model=(DefaultTableModel) Bill_Prod_table2.getModel();
        int myindex=Bill_Prod_table2.getSelectedRow();
          BillName.setText(model.getValueAt(myindex, 1).toString());
          BillQty.setText(model.getValueAt(myindex, 2).toString());
      Availqty=Integer.valueOf(model.getValueAt(myindex,2).toString());
      
      Uprice= Double.valueOf(model.getValueAt(myindex, 3).toString());
     
   Prid= Integer.valueOf(model.getValueAt(myindex,0).toString());
 
    
       // PrdPrice.setText(model.getValueAt(myindex, 3).toString());
        selectproduct();

    }//GEN-LAST:event_Bill_Prod_table2MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void Print_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Print_buttonMouseClicked
        try {
            // TODO add your handling code here:
            BillText.print();
        } catch (PrinterException ex) {
            Logger.getLogger(selling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Print_buttonMouseClicked

    private void Print_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Print_buttonActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void BillCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillCatMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_BillCatMouseClicked

    private void RefreshStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RefreshStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshStateChanged

    private void FilterStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_FilterStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterStateChanged

    private void FilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterMouseClicked
        // TODO add your handling code here:
          try{
         conn=  (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/SupermarketDB","user1","root");
         stmt= conn.createStatement();
         rs= stmt.executeQuery("select * from user1.PROD where PRDCAT='"+BillCat.getSelectedItem().toString()+"'");
         Bill_Prod_table2.setModel(DbUtils.resultSetToTableModel(rs));
       
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_FilterMouseClicked

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterActionPerformed

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
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_button;
    private javax.swing.JComboBox<String> BillCat;
    private javax.swing.JTextField BillID;
    private javax.swing.JTextField BillName;
    private javax.swing.JTextField BillQty;
    private javax.swing.JTextArea BillText;
    private javax.swing.JTable Bill_Prod_table2;
    private javax.swing.JButton Clear_button2;
    private javax.swing.JButton Filter;
    private javax.swing.JLabel GrdTotalLbl;
    private javax.swing.JButton Print_button;
    private javax.swing.JButton Refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
