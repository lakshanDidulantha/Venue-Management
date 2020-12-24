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

/**
 *
 * @author laksh
 */
public class FunctionReservation extends javax.swing.JFrame {

    /**
     * Creates new form FunctionReservation
     */
    public FunctionReservation() {
        initComponents();
        Connect();
        autoID();
        HallType();
        FuntionType();
        FeatureType();
        Capacity();
        Load_Function_Reservation();
       
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
            ResultSet rs =s.executeQuery("select MAX(rsid)from  functionreservation");
            rs.next();
            rs.getString("MAX(rsid)");
            if(rs.getString("MAX(rsid)")==null)
            {
                jLabel9.setText("RE001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(rsid)").substring(2,rs.getString("MAX(rsid)").length()));
                id++;
                jLabel9.setText("RE"+String.format("%03d",id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



public void HallType()
      {
        try {
            pst=con.prepareStatement("select Distinct htype from  function");  
            ResultSet rs = pst.executeQuery();
            txthtype.removeAllItems();
            
            while(rs.next())
            {
                txthtype.addItem(rs.getString("htype"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
}


 public void FuntionType()
      {
        try {
            pst=con.prepareStatement("select Distinct ftype from function");  
            ResultSet rs = pst.executeQuery();
            txtftype.removeAllItems();
            
            while(rs.next())
            {
                txtftype.addItem(rs.getString("ftype"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    public void FeatureType()
      {
        try {
            pst=con.prepareStatement("select Distinct hfeature from function");  
            ResultSet rs = pst.executeQuery();
            txtfeture.removeAllItems();
            
            while(rs.next())
            {
                txtfeture.addItem(rs.getString("hfeature"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void Capacity()
      {
        try {
            pst=con.prepareStatement("select Distinct capacity from function");  
            ResultSet rs = pst.executeQuery();
            txtcapacity.removeAllItems();
            
            while(rs.next())
            {
                txtcapacity.addItem(rs.getString("capacity"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




 public void Load_Function_Reservation()
      {
        int c;
        try {
            pst =con.prepareStatement("select * from   functionreservation");
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
                    v2.add(rs.getString("rsid"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("mobile"));
                    v2.add(rs.getString("idnum"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("time"));
                    v2.add(rs.getString("htype"));
                    v2.add(rs.getString("ftype"));
                    v2.add(rs.getString("hfeature"));
                    v2.add(rs.getString("capacity"));
                    v2.add(rs.getString("amount"));
                    
                }
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        txtidnum = new javax.swing.JTextField();
        txtdate = new com.toedter.calendar.JDateChooser();
        txthtype = new javax.swing.JComboBox<>();
        txtfeture = new javax.swing.JComboBox<>();
        txtcapacity = new javax.swing.JComboBox<>();
        txtamount = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txttime = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtftype = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(670, 620, 100, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 204));
        jLabel2.setText("Function Hall Reservation");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(420, 0, 400, 60);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Reservation Num");
        jLabel3.setAlignmentX(0.5F);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 80, 170, 20);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Customer Name");
        jLabel4.setAlignmentX(0.5F);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 130, 160, 20);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Num");
        jLabel5.setAlignmentX(0.5F);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 230, 110, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mobile");
        jLabel6.setAlignmentX(0.5F);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 180, 120, 24);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("reservied Date");
        jLabel7.setAlignmentX(0.5F);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 290, 140, 20);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Time");
        jLabel8.setAlignmentX(0.5F);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 350, 130, 20);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(230, 70, 160, 27);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hall Feature");
        jLabel10.setAlignmentX(0.5F);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(40, 520, 140, 20);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Venue Capacity");
        jLabel11.setAlignmentX(0.5F);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(40, 570, 160, 20);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Amount");
        jLabel12.setAlignmentX(0.5F);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(40, 630, 120, 20);

        txtname.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtname);
        txtname.setBounds(220, 120, 190, 30);

        txtmobile.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtmobile);
        txtmobile.setBounds(220, 180, 190, 30);

        txtidnum.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtidnum);
        txtidnum.setBounds(220, 230, 190, 30);

        txtdate.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtdate);
        txtdate.setBounds(220, 290, 190, 30);

        txthtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(txthtype);
        txthtype.setBounds(220, 400, 190, 30);

        jPanel1.add(txtfeture);
        txtfeture.setBounds(220, 510, 190, 30);

        txtcapacity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(txtcapacity);
        txtcapacity.setBounds(220, 570, 190, 30);

        txtamount.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtamount);
        txtamount.setBounds(220, 630, 190, 30);

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(800, 620, 90, 40);

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1060, 620, 100, 40);

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(1200, 620, 100, 40);

        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(1340, 620, 100, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rsid", "Name", "Mobile", "ID Num", "Day", "Time", "Hall Type", "Function Type", "Hall  Feature", "Capacity", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, false, true, true, true, true, false
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(450, 150, 1020, 402);

        txttime.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txttime);
        txttime.setBounds(220, 350, 190, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Hall Type");
        jLabel13.setAlignmentX(0.5F);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(40, 400, 130, 20);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Funvtion Type");
        jLabel14.setAlignmentX(0.5F);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(40, 460, 130, 20);

        txtftype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(txtftype);
        txtftype.setBounds(220, 460, 190, 30);

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(930, 620, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/wedding function2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -170, 1490, 1020);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1485, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          if(txtamount.getText().isEmpty())
       {
            JOptionPane.showMessageDialog(this,"Found Empty Filed." );
       }
       else { 
        String fno =jLabel9.getText();
        String name =txtname.getText();
        String mobile =txtmobile.getText();
        String idnum =txtidnum.getText();
        
        SimpleDateFormat df1 =new SimpleDateFormat("yyyy-MM-dd");
        String Date=df1.format(txtdate.getDate());
        
        String time =txttime.getText().toString();
        String htype =txthtype.getSelectedItem().toString();
        String ftype =txtftype.getSelectedItem().toString();
        String feature =txtfeture.getSelectedItem().toString();
        String capacity =txtcapacity.getSelectedItem().toString(); 
        String amount =txtamount.getText().toString();
        
        try {
            pst =con.prepareStatement("insert into functionreservation (rsid ,name,mobile,idnum,date,time,htype,ftype,hfeature,capacity,amount) values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, fno);
            pst.setString(2, name);
            pst.setString(3, mobile);
            pst.setString(4, idnum);
            pst.setString(5, Date);
            pst.setString(6, time);
            pst.setString(7, htype);
            pst.setString(8, ftype);
            pst.setString(9, feature);
            pst.setString(10, capacity);
            pst.setString(11, amount);
           
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Reservation Funtion Hall Added");
           
            
            txtname.setText("");
            txtmobile.setText("");
            txtidnum.setText("");
            txttime.setText("");
            txthtype.setSelectedIndex(-1);
            txtftype.setSelectedIndex(-1);
            txtfeture.setSelectedIndex(-1);
            txtcapacity.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_Function_Reservation();
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String fno =jLabel9.getText();
        String name =txtname.getText();
        String mobile =txtmobile.getText();
        String idnum =txtidnum.getText();
        
        SimpleDateFormat df1 =new SimpleDateFormat("yyyy-MM-dd");
        String Date=df1.format(txtdate.getDate());
        
        String time =txttime.getText().toString();
        String htype =txthtype.getSelectedItem().toString();
        String ftype =txtftype.getSelectedItem().toString();
        String feature =txtfeture.getSelectedItem().toString();
        String capacity =txtcapacity.getSelectedItem().toString(); 
        String amount =txtamount.getText().toString();
        try {
            pst =con.prepareStatement("update functionreservation set name = ?,mobile = ?,idnum = ?,date = ?,time = ?,htype = ? ,ftype = ?,hfeature=?, capacity=? ,amount= ? where rsid =?" );
            pst.setString(1, name);
            pst.setString(2, mobile);
            pst.setString(3, idnum);
            pst.setString(4, Date);
            pst.setString(5, time);
            pst.setString(6, htype);
            pst.setString(7, ftype);
            pst.setString(8, feature);
            pst.setString(9, capacity);
            pst.setString(10, amount);
            pst.setString(11, fno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this," function Reservation Edit");
           
               
            txtname.setText("");
            txtmobile.setText("");
            txtidnum.setText("");
            txttime.setText("");
            txthtype.setSelectedIndex(-1);
            txtftype.setSelectedIndex(-1);
            txtfeture.setSelectedIndex(-1);
            txtcapacity.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_Function_Reservation();
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int close =JOptionPane.showConfirmDialog(null,"Delete Item","Select",JOptionPane.YES_NO_OPTION);
        String function =jLabel9.getText();
 
        try {
            pst =con.prepareStatement("delete from functionreservation where rsid = ?");
            txtname.setText("");
            txtmobile.setText("");
            txtidnum.setText("");
            txttime.setText("");
            txthtype.setSelectedIndex(-1);
            txtftype.setSelectedIndex(-1);
            txtfeture.setSelectedIndex(-1);
            txtcapacity.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_Function_Reservation();
            jButton1.setEnabled(true);
             
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         d = (DefaultTableModel)jTable1.getModel();
        int selectIndex =jTable1.getSelectedRow();

        jLabel9.setText(d.getValueAt(selectIndex, 0).toString());
        txtname.setText(d.getValueAt(selectIndex, 1).toString());
        txtmobile.setText(d.getValueAt(selectIndex, 2).toString());
        txtidnum.setText(d.getValueAt(selectIndex, 3).toString());
       try {
            Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse((String)d.getValueAt(selectIndex,4));
            txtdate.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        txttime.setText(d.getValueAt(selectIndex, 5).toString());
        txthtype.setSelectedItem(d.getValueAt(selectIndex, 6).toString());
        txtftype.setSelectedItem(d.getValueAt(selectIndex, 7).toString());
        txtfeture.setSelectedItem(d.getValueAt(selectIndex, 8).toString());
        txtcapacity.setSelectedItem(d.getValueAt(selectIndex, 9).toString());
        txtamount.setText(d.getValueAt(selectIndex, 10).toString());
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            txtname.setText("");
            txtmobile.setText("");
            txtidnum.setText("");
            txttime.setText("");
            txthtype.setSelectedIndex(-1);
            txtftype.setSelectedIndex(-1);
            txtfeture.setSelectedIndex(-1);
            txtcapacity.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_Function_Reservation();
            jButton1.setEnabled(true);
             
        
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
               
        AdminMainManu min =new AdminMainManu();
        min.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        int close =JOptionPane.showConfirmDialog(null,"Close The Application","Select",JOptionPane.YES_NO_OPTION);
        if(close==0)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(FunctionReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FunctionReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FunctionReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FunctionReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FunctionReservation().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtcapacity;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JComboBox<String> txtfeture;
    private javax.swing.JComboBox<String> txtftype;
    private javax.swing.JComboBox<String> txthtype;
    private javax.swing.JTextField txtidnum;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txttime;
    // End of variables declaration//GEN-END:variables
}
