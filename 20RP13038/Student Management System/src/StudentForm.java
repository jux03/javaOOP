import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class StudentForm extends javax.swing.JFrame {
    

    public StudentForm() {
        initComponents();
        Connect();
        
//        start connection
    }
Connection con;
PreparedStatement pst;
ResultSet rs;

public void Connect() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cat", "root", "");
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(this, "Error: MySQL Driver not found!");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database connection error: " + ex.getMessage());
    }
}

    
//    exception handling
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtMath = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRegNo = new javax.swing.JTextField();
        txtPhp = new javax.swing.JTextField();
        txtJava = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STUDENTS MANAGEMENT SYSTEM");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel1.setText("Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 42, 120, -1));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel2.setText("Reg Number:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 71, 120, -1));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 41, 270, -1));
        getContentPane().add(txtMath, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 99, 270, -1));

        btnAdd.setBackground(new java.awt.Color(0, 255, 0));
        btnAdd.setFont(new java.awt.Font("Poppins SemiBold", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Student");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 280, -1));

        btnExit.setBackground(new java.awt.Color(255, 0, 0));
        btnExit.setFont(new java.awt.Font("Poppins SemiBold", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 280, -1));

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Math Marks:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 100, 120, -1));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Java Marks:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 129, 120, -1));

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel6.setText("PHP Marks:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 164, 120, -1));
        getContentPane().add(txtRegNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 70, 270, -1));
        getContentPane().add(txtPhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 163, 270, -1));
        getContentPane().add(txtJava, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 128, 270, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Reg Number", "Average Marks"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 282, 610, 229));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {                                       
            try {
               
                String Name = txtName.getText();
                String RegNo = txtRegNo.getText();
                String MathStr = txtMath.getText();
                String JavaStr = txtJava.getText();
                String PhpStr = txtPhp.getText();
                
                
                
                int Math = Integer.parseInt(MathStr);
                int Java = Integer.parseInt(JavaStr);
                int Php = Integer.parseInt(PhpStr);
                
                double average = (Math + Java + Php) / 3.0;
                
                
              if (Math < 0 || Math > 100 || Java < 0 || Java > 100 || Php < 0 || Php > 100) {
                JOptionPane.showMessageDialog(null, "Marks must be between 0 and 100");
                return;
              }
        
                    
                
                
                pst = con.prepareStatement("INSERT INTO students(Name,RegNo,Math,Java,Php,Average)VALUES(?,?,?,?,?,?)");
                pst.setString(1, Name);
                pst.setString(2, RegNo);
                pst.setInt(3, Math);
                pst.setInt(4, Java);
                pst.setInt(5, Php);
                pst.setDouble(6, average);
                
                
                
                
                int k = pst.executeUpdate();
                
                if(k==1){
                    JOptionPane.showMessageDialog(this,"Successfully Added");
                    txtName.setText("");
                    txtMath.setText("");
                    txtRegNo.setText("");
                    txtPhp.setText("");
                    txtJava.setText("");
                    
                } 
                    
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values of marks");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values of marks");
            return;
        }
            
            int q;            
            pst =con.prepareStatement("SELECT Name,RegNo,Average FROM students");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int a=1; a<=q; a++){
                    v2.add(rs.getString(a));  
                    


                }
                df.addRow(v2);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtJava;
    private javax.swing.JTextField txtMath;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhp;
    private javax.swing.JTextField txtRegNo;
    // End of variables declaration//GEN-END:variables
}