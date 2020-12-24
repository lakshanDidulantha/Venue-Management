/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RoomReservation extends javax.swing.JFrame {

    /**
     * Creates new form reservation
     */
    public RoomReservation() {
        initComponents();
        Connect();
        autoID();
        RoomTypeL();
        RoomNo();
        BedType();
        Load_reservation();
    }
    Connection con;
    PreparedStatement pst;
    DefaultTableModel d;
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagement","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void autoID()
    {
        try {
            Statement s =con.createStatement();
            ResultSet rs =s.executeQuery("select MAX(reid)from reservation");
            rs.next();
            rs.getString("MAX(reid)");
            if(rs.getString("MAX(reid)")==null)
            {
                jLabel14.setText("RE001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(reid)").substring(2,rs.getString("MAX(reid)").length()));
                id++;
                jLabel14.setText("RE"+String.format("%03d",id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public void RoomTypeL()
      {
        try {
            pst=con.prepareStatement("select Distinct rtype from room");  
            ResultSet rs = pst.executeQuery();
            txtrtype.removeAllItems();
            
            while(rs.next())
            {
                txtrtype.addItem(rs.getString("rtype"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      public void Load_reservation()
      {
        int c;
        try {
            pst =con.prepareStatement("select * from reservation");
            ResultSet rs =pst.executeQuery();
            
            ResultSetMetaData rsd =rs.getMetaData();
            c = rsd.getColumnCount();
            
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 =new Vector();
                for(int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("reid"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("mobile"));
                    v2.add(rs.getString("checkin"));
                    v2.add(rs.getString("checkout"));
                    v2.add(rs.getString("bedtype"));
                    v2.add(rs.getString("roomno"));
                    v2.add(rs.getString("rtype"));
                    v2.add(rs.getString("amount"));
                 
                }
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void RoomNo()
      {
        try {
            pst=con.prepareStatement("select Distinct rid from room");  
            ResultSet rs = pst.executeQuery();
            txtro.removeAllItems();
            
            while(rs.next())
            {
                txtro.addItem(rs.getString("rid"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    public void BedType()
      {
        try {
            pst=con.prepareStatement("select Distinct btype from room");  
            ResultSet rs = pst.executeQuery();
            txtbtype.removeAllItems();
            
            while(rs.next())
            {
                txtbtype.addItem(rs.getString("btype"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtchekin = new com.toedter.calendar.JDateChooser();
        txtcheckout = new com.toedter.calendar.JDateChooser();
        txtmobile = new javax.swing.JTextField();
        txtro = new javax.swing.JComboBox<>();
        txtbtype = new javax.swing.JComboBox<>();
        txtrtype = new javax.swing.JComboBox<>();
        txtamount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtamount1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("RESERVATION");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(720, 50, 230, 70);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setText("Reservation No");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 110, 160, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 190, 70, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setText("Address");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 260, 90, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setText("Mobile");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 320, 80, 40);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("CheckIn");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 400, 90, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("CheckOut");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(70, 460, 110, 40);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Room Type");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(70, 530, 150, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Room No");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(70, 590, 120, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("Bed Type");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(70, 670, 130, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setText("Amount");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(70, 750, 100, 30);

        txtaddress.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtaddress);
        txtaddress.setBounds(200, 260, 220, 30);

        txtname.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtname);
        txtname.setBounds(200, 190, 220, 30);

        txtchekin.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtchekin);
        txtchekin.setBounds(200, 400, 220, 30);

        txtcheckout.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtcheckout);
        txtcheckout.setBounds(200, 470, 220, 30);

        txtmobile.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtmobile);
        txtmobile.setBounds(200, 330, 220, 30);

        txtro.setBackground(new java.awt.Color(191, 191, 191));
        txtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(txtro);
        txtro.setBounds(200, 600, 220, 30);

        txtbtype.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtbtype);
        txtbtype.setBounds(200, 670, 220, 30);

        txtrtype.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtrtype);
        txtrtype.setBounds(200, 530, 220, 30);

        txtamount.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtamount);
        txtamount.setBounds(200, 760, 220, 30);

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RID", "Name", "Adress", "Mobile", "CheckIn", "CheckOut", "Room Type", "Room No", "Bed Type", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(550, 160, 960, 550);

        jButton1.setBackground(new java.awt.Color(34, 167, 240));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(610, 790, 70, 30);

        jButton2.setBackground(new java.awt.Color(153, 51, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(740, 790, 80, 30);

        jButton3.setBackground(new java.awt.Color(192, 57, 43));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(900, 790, 80, 30);

        jButton4.setBackground(new java.awt.Color(255, 255, 153));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(1040, 790, 70, 30);

        jButton5.setBackground(new java.awt.Color(153, 255, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(1190, 790, 67, 30);

        jButton6.setBackground(new java.awt.Color(51, 255, 0));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(1350, 790, 63, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 255, 51));
        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(240, 110, 100, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bedroom.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-970, -80, 2500, 960);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(236, 240, 241));
        jLabel15.setText("Amount");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(70, 750, 100, 30);

        txtamount1.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtamount1);
        txtamount1.setBounds(200, 760, 220, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1551, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String reno =jLabel14.getText();
        String name =txtname.getText();
        String address =txtaddress.getText();
        String mobile =txtmobile.getText();
        
        SimpleDateFormat df1 =new SimpleDateFormat("yyyy-MM-dd");
        String StartDate=df1.format(txtchekin.getDate());
        
        SimpleDateFormat df2 =new SimpleDateFormat("yyyy-MM-dd");
        String EndDate=df2.format(txtcheckout.getDate());
        
        String rtype =txtrtype.getSelectedItem().toString();
        String roomno=txtro.getSelectedItem().toString();
        String bedtype =txtbtype.getSelectedItem().toString();
        String amount =txtamount.getText();
          
        try {
            pst =con.prepareStatement("insert into reservation(reid ,name,address,mobile,checkin,checkout,bedtype,roomno,rtype,amount) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, reno);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, mobile);
            pst.setString(5, StartDate);
            pst.setString(6, EndDate);
            pst.setString(7, rtype);
            pst.setString(8, roomno);
            pst.setString(9, bedtype);
            pst.setString(10, amount);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"reservation Added");
           
            
            txtname.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtrtype.setSelectedIndex(-1);
            txtro.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_reservation();
          
             
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String reno =jLabel14.getText();
        String name =txtname.getText();
        String address =txtaddress.getText();
        String mobile =txtmobile.getText();
        
        SimpleDateFormat df1 =new SimpleDateFormat("yyyy-MM-dd");
        String StartDate=df1.format(txtchekin.getDate());
        
        
        SimpleDateFormat df2 =new SimpleDateFormat("yyyy-MM-dd");
        String EndDate=df2.format(txtcheckout.getDate());
        
        String rtype =txtrtype.getSelectedItem().toString();
        String roomno=txtro.getSelectedItem().toString();
        String bedtype =txtbtype.getSelectedItem().toString();
        String amount =txtamount.getText();
          
        try {
            pst =con.prepareStatement("update reservation set name = ?,address = ?,mobile = ?,checkin = ?,checkout = ?,bedtype = ?,roomno = ? ,rtype = ?, amount= ? where reid =?" );
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, mobile);
            pst.setString(4, StartDate);
            pst.setString(5, EndDate);
            pst.setString(6, rtype);
            pst.setString(7, roomno);
            pst.setString(8, bedtype);
            pst.setString(9, amount);
            pst.setString(10, reno);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"reservation Edit");
           
            
            txtname.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtrtype.setSelectedIndex(-1);
            txtro.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_reservation();
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          
        d = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
            
         jLabel14.setText(d.getValueAt(selectIndex,0).toString());
         txtname.setText(d.getValueAt(selectIndex,1).toString());
         txtaddress.setText(d.getValueAt(selectIndex, 2).toString());
         txtmobile.setText(d.getValueAt(selectIndex, 3).toString());
         
        try {
            Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse((String)d.getValueAt(selectIndex,4));
            txtchekin.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Date date2 =new SimpleDateFormat("yyyy-MM-dd").parse((String)d.getValueAt(selectIndex,5));
            txtcheckout.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
         txtrtype.setSelectedItem(d.getValueAt(selectIndex, 6).toString());
         txtro.setSelectedItem(d.getValueAt(selectIndex, 7).toString());
         txtbtype.setSelectedItem(d.getValueAt(selectIndex, 8).toString());
         txtamount.setText(d.getValueAt(selectIndex, 9).toString());
         
         jButton1.setEnabled(false);//save button desable
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
 
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
     
    }//GEN-LAST:event_jButton2KeyPressed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here: d = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
            
         jLabel14.setText(d.getValueAt(selectIndex,0).toString());
         txtname.setText(d.getValueAt(selectIndex,1).toString());
         txtaddress.setText(d.getValueAt(selectIndex, 2).toString());
         txtmobile.setText(d.getValueAt(selectIndex, 3).toString());
         
        try {
            Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse((String)d.getValueAt(selectIndex,4));
            txtchekin.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Date date2 =new SimpleDateFormat("yyyy-MM-dd").parse((String)d.getValueAt(selectIndex,5));
            txtcheckout.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
         txtrtype.setSelectedItem(d.getValueAt(selectIndex, 6).toString());
         txtro.setSelectedItem(d.getValueAt(selectIndex, 7).toString());
         txtbtype.setSelectedItem(d.getValueAt(selectIndex, 8).toString());
         txtamount.setText(d.getValueAt(selectIndex, 9).toString());
         
         jButton1.setEnabled(false);//save button desable
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
            txtname.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtrtype.setSelectedIndex(-1);
            txtro.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText(""); 
            Load_reservation();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String reno =jLabel14.getText();

        try {
            pst =con.prepareStatement("delete from reservation where reid =?" );
           
            pst.setString(1, reno);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Delete Succes");
           
            txtname.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtrtype.setSelectedIndex(-1);
            txtro.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_reservation();
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
        int close =JOptionPane.showConfirmDialog(null,"Close The Application","Select",JOptionPane.YES_NO_OPTION);
        if(close==0)
        {
            System.exit(0);
        }
        //this.setVisible(false);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
             
        AdminMainManu min =new AdminMainManu();
        min.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    
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
            java.util.logging.Logger.getLogger(RoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtamount1;
    private javax.swing.JComboBox<String> txtbtype;
    private com.toedter.calendar.JDateChooser txtcheckout;
    private com.toedter.calendar.JDateChooser txtchekin;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JComboBox<String> txtro;
    private javax.swing.JComboBox<String> txtrtype;
    // End of variables declaration//GEN-END:variables
}
