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
public class UserRoomReservation extends javax.swing.JFrame {

    public UserRoomReservation() {
        initComponents();
        Connect();
        autoID();
        BedType();
        RoomTypeL();
        RoomNo();
        amount();
        
    }
    
    Connection con;
    PreparedStatement pst;

    
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
                jLabel12.setText("RE001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(reid)").substring(2,rs.getString("MAX(reid)").length()));
                id++;
                jLabel12.setText("RE"+String.format("%03d",id));
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
     
      
     public void amount()
      {
        try {
            pst=con.prepareStatement("select Distinct amount from room");  
            ResultSet rs = pst.executeQuery();
            txtamount.removeAllItems();
            
            while(rs.next())
            {
                txtamount.addItem(rs.getString("amount"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

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
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        txtchekin = new com.toedter.calendar.JDateChooser();
        txtcheckout = new com.toedter.calendar.JDateChooser();
        txtrtype = new javax.swing.JComboBox<>();
        txtro = new javax.swing.JComboBox<>();
        txtbtype = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtamount = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("Mobile");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 340, 170, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setText("Room Type");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(120, 530, 200, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setText("Address");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(120, 270, 220, 40);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setText("Reservation No");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(120, 140, 230, 40);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setText("Name");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(120, 210, 190, 40);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setText("CheckIn");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(120, 400, 150, 40);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel8.setText("CheckOut");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(120, 460, 160, 40);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("Room Booking");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 10, 340, 50);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel11.setText("Room No");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(120, 600, 150, 40);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setText("Bed Type");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(120, 650, 170, 40);

        txtname.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtname);
        txtname.setBounds(320, 210, 260, 30);

        txtaddress.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtaddress);
        txtaddress.setBounds(320, 280, 260, 30);

        txtmobile.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtmobile);
        txtmobile.setBounds(320, 340, 260, 30);

        txtchekin.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtchekin);
        txtchekin.setBounds(320, 400, 260, 30);

        txtcheckout.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtcheckout);
        txtcheckout.setBounds(320, 460, 260, 30);

        txtrtype.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtrtype);
        txtrtype.setBounds(320, 540, 260, 30);

        txtro.setBackground(new java.awt.Color(191, 191, 191));
        txtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(txtro);
        txtro.setBounds(320, 610, 260, 30);

        txtbtype.setBackground(new java.awt.Color(191, 191, 191));
        jPanel1.add(txtbtype);
        txtbtype.setBounds(320, 670, 260, 30);

        jButton1.setBackground(new java.awt.Color(34, 167, 240));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(820, 320, 70, 30);

        jButton6.setBackground(new java.awt.Color(51, 255, 0));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(830, 570, 63, 30);

        jButton5.setBackground(new java.awt.Color(153, 255, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(820, 490, 67, 30);

        jButton4.setBackground(new java.awt.Color(255, 255, 153));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(820, 410, 70, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(330, 150, 60, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Amount(One Day)");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(120, 730, 170, 30);

        jPanel1.add(txtamount);
        txtamount.setBounds(320, 740, 260, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bedroom.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-1310, -530, 2850, 1590);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String reno =jLabel12.getText();
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
        String amount =txtamount.getSelectedItem().toString();

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
            txtamount.setSelectedIndex(-1);
          
            autoID();

        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

       UserMainManu min =new UserMainManu();
        min.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int close =JOptionPane.showConfirmDialog(null,"Close The Application","Select",JOptionPane.YES_NO_OPTION);
        if(close==0)
        {
            System.exit(0);
        }
        //this.setVisible(false);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        txtname.setText("");
        txtaddress.setText("");
        txtmobile.setText("");
        txtrtype.setSelectedIndex(-1);
        txtro.setSelectedIndex(-1);
        txtbtype.setSelectedIndex(-1);
      
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(UserRoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRoomReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRoomReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JComboBox<String> txtamount;
    private javax.swing.JComboBox<String> txtbtype;
    private com.toedter.calendar.JDateChooser txtcheckout;
    private com.toedter.calendar.JDateChooser txtchekin;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JComboBox<String> txtro;
    private javax.swing.JComboBox<String> txtrtype;
    // End of variables declaration//GEN-END:variables
}
