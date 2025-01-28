
package View;

import Controller.LoginController;
import Model.User;
import Model.Admin;
import Model.Member;
import javax.swing.JOptionPane;


public class Loginn extends javax.swing.JFrame {

   LoginController l1=new LoginController();
    public Loginn() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        cmBox = new javax.swing.JComboBox<>();
        lblPw = new javax.swing.JLabel();
        txtUn = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        btnLog = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblUn = new javax.swing.JLabel();
        lblCnum = new javax.swing.JLabel();
        txtCnum = new javax.swing.JTextField();
        lblEdate = new javax.swing.JLabel();
        txtEdate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("Login");

        cmBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Member", "Admin" }));
        cmBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblLogin)
                .addGap(27, 27, 27)
                .addComponent(cmBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(708, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(cmBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 50));

        lblPw.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lock.png"))); // NOI18N
        lblPw.setText("Password");
        jPanel1.add(lblPw, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));
        jPanel1.add(txtUn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 260, -1));
        jPanel1.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, -1));

        btnLog.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLog.setText("Login");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 100, -1));

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 100, -1));

        lblUn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clay.png"))); // NOI18N
        lblUn.setText("Username");
        jPanel1.add(lblUn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        lblCnum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCnum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/card.png"))); // NOI18N
        lblCnum.setText("Card number");
        jPanel1.add(lblCnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        txtCnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnumActionPerformed(evt);
            }
        });
        jPanel1.add(txtCnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 260, -1));

        lblEdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/calender.png"))); // NOI18N
        lblEdate.setText("Exp date");
        jPanel1.add(lblEdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));
        jPanel1.add(txtEdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed

      
      String username=txtUn.getText();
      String password=passField.getText();
      String role=String.valueOf(cmBox.getSelectedItem());
      User user=l1.login(username, password);
      if(user!=null){
          if(role.equalsIgnoreCase("Member")&&user instanceof Member){
            
              
              MemberMainmenu m=new MemberMainmenu();
              m.setVisible(true);
              this.setVisible(false);
              
          }else if(role.equalsIgnoreCase("Admin")&&user instanceof Admin){
             
             AdminMainmenu m1=new AdminMainmenu();
             m1.setVisible(true);
             this.setVisible(false);
          }else{
              JOptionPane.showMessageDialog(null, "Invalid role selection");
          }
      }else{
          JOptionPane.showMessageDialog(null,"Invalid credentials");
          
      }
     
    }//GEN-LAST:event_btnLogActionPerformed

    private void cmBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmBoxActionPerformed
        String role=String.valueOf(cmBox.getSelectedItem());
        if("Member".equals(role)){
            txtCnum.setVisible(true);
            txtEdate.setVisible(true);
            lblCnum.setVisible(true);
            lblEdate.setVisible(true);
        }else{
            txtCnum.setVisible(false);
            txtEdate.setVisible(false);
            lblCnum.setVisible(false);
            lblEdate.setVisible(false);
        }
    }//GEN-LAST:event_cmBoxActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtCnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnumActionPerformed
        
    }//GEN-LAST:event_txtCnumActionPerformed

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
            java.util.logging.Logger.getLogger(Loginn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLog;
    private javax.swing.JComboBox<String> cmBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCnum;
    private javax.swing.JLabel lblEdate;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPw;
    private javax.swing.JLabel lblUn;
    private javax.swing.JPasswordField passField;
    private javax.swing.JTextField txtCnum;
    private javax.swing.JTextField txtEdate;
    private javax.swing.JTextField txtUn;
    // End of variables declaration//GEN-END:variables
}
