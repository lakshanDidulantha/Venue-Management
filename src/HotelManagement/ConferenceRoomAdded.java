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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laksh
 */
public class ConferenceRoomAdded extends javax.swing.JFrame {

    /**
     * Creates new form Conference
     */
    public ConferenceRoomAdded() {
        initComponents();
        Connect();
        autoID();
        Load_conference();
    }

    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel d;
    
//conect database  
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
    
//auto connect room number
    public void autoID()
    {
        try {
            Statement s =con.createStatement();
            ResultSet rs =s.executeQuery("select MAX(cid)from conference");
            rs.next();
            rs.getString("MAX(cid)");
            if(rs.getString("MAX(cid)")==null)
            {
                jLabel7.setText("R0001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(cid)").substring(2,rs.getString("MAX(cid)").length()));
                id++;
                jLabel7.setText("R0"+String.format("%03d",id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//load the table   
    public void Load_conference()
    {
        int c;
        try {
            pst =con.prepareStatement("select * from conference");
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
                    v2.add(rs.getString("cid"));
                    v2.add(rs.getString("crtype"));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtrtype = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtcapacity = new javax.swing.JComboBox<>();
        txtamount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Conference Room");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(320, 20, 340, 100);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 204));
        jLabel3.setText("Conference Room No");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 210, 230, 22);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 204));
        jLabel4.setText("Room Type");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 280, 91, 22);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 204));
        jLabel5.setText("Capacity");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 350, 90, 16);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 204));
        jLabel6.setText("Amount");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(100, 410, 70, 22);

        txtrtype.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtrtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bоаrdrооm Style", "Hоllоw Sԛuаrе Style", "U-Shape Style", "Auditorium Stуlе", "Classroom Style", "Banquet Style" }));
        jPanel1.add(txtrtype);
        txtrtype.setBounds(310, 280, 180, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(320, 210, 130, 30);

        txtcapacity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-25", "1-50", "1-100", "100-500", "More Than 500" }));
        jPanel1.add(txtcapacity);
        txtcapacity.setBounds(310, 350, 180, 30);
        jPanel1.add(txtamount);
        txtamount.setBounds(310, 410, 180, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Con Room No", "Room Type", "Capacity", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(550, 140, 452, 310);

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 570, 61, 25);

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(360, 570, 69, 30);

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(500, 570, 70, 30);

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setForeground(new java.awt.Color(51, 51, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(630, 570, 70, 30);

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setForeground(new java.awt.Color(51, 51, 255));
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(770, 570, 63, 30);

        jButton6.setBackground(new java.awt.Color(255, 204, 204));
        jButton6.setForeground(new java.awt.Color(51, 51, 255));
        jButton6.setText("Edit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(220, 570, 70, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/confrenece1.jpg"))); // NOI18N
        jLabel1.setText("C");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-150, -140, 1350, 830);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // New Data Add to the table
       if(txtamount.getText().isEmpty())
       {
            JOptionPane.showMessageDialog(this,"Found Empty Filed." );
       }
       else 
       {
        String conroomno =jLabel7.getText();
        String roomtype =txtrtype.getSelectedItem().toString();
        String capacity =txtcapacity.getSelectedItem().toString();
        String amount =txtamount.getText();
          
        try {
            pst =con.prepareStatement("insert into conference(cid , crtype ,capacity, amount) values(?,?,?,?)");
            pst.setString(1, conroomno);
            pst.setString(2, roomtype);
            pst.setString(3, capacity);
            pst.setString(4, amount);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Conference Room Added");
            
            txtrtype.setSelectedIndex(-1);
            txtcapacity.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_conference();
             
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // arrow keys visible data 
        d = (DefaultTableModel)jTable1.getModel();
        int selectIndex =jTable1.getSelectedRow();

        jLabel7.setText(d.getValueAt(selectIndex, 0).toString());
        txtrtype.setSelectedItem(d.getValueAt(selectIndex, 1).toString());
        txtcapacity.setSelectedItem(d.getValueAt(selectIndex, 2).toString());
        txtamount.setText(d.getValueAt(selectIndex, 3).toString());
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // mouse click visible data
        d = (DefaultTableModel)jTable1.getModel();
        int selectIndex =jTable1.getSelectedRow();

        jLabel7.setText(d.getValueAt(selectIndex, 0).toString());
        txtrtype.setSelectedItem(d.getValueAt(selectIndex, 1).toString());
        txtcapacity.setSelectedItem(d.getValueAt(selectIndex, 2).toString());
        txtamount.setText(d.getValueAt(selectIndex, 3).toString());
        jButton1.setEnabled(false);
        
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Edit data from table
        
         if(txtrtype.getSelectedItem().toString().isEmpty()||txtcapacity.getSelectedItem().toString().isEmpty()|| txtamount.getText().isEmpty())
        {
              JOptionPane.showMessageDialog(this, "You Don't  Edit Any Item " );
        }
        else
        {
        String conroomno =jLabel7.getText();
        String roomtype =txtrtype.getSelectedItem().toString();
        String capacity =txtcapacity.getSelectedItem().toString();
        String amount =txtamount.getText();
          
        try {
            pst =con.prepareStatement("update conference set crtype = ?, capacity = ? ,amount =? where cid = ?");
            pst.setString(1, roomtype);
            pst.setString(2, capacity);
            pst.setString(3, amount);
            pst.setString(4, conroomno); 
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Conference Room Edit");
            
            txtrtype.setSelectedIndex(-1);
            txtcapacity.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_conference();
            jButton1.setEnabled(true);
             
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // clear data from table
           txtrtype.setSelectedIndex(-1);
           txtcapacity.setSelectedIndex(-1);
           txtamount.setText("");
           autoID();
           Load_conference();
           jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // delete data from table
        int close =JOptionPane.showConfirmDialog(null,"Delete Item","Select",JOptionPane.YES_NO_OPTION);
        String roomno =jLabel7.getText();
 
        try {
            pst =con.prepareStatement("delete from conference where cid = ?");
            pst.setString(1, roomno); 
            pst.executeUpdate();
           
            
            txtrtype.setSelectedIndex(-1);
            txtcapacity.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
            Load_conference();
            jButton1.setEnabled(true);
             
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // back to home tab
        AdminMainManu min =new AdminMainManu();
        min.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     //close tab
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
            java.util.logging.Logger.getLogger(ConferenceRoomAdded.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConferenceRoomAdded.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConferenceRoomAdded.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConferenceRoomAdded.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConferenceRoomAdded().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtcapacity;
    private javax.swing.JComboBox<String> txtrtype;
    // End of variables declaration//GEN-END:variables
}
