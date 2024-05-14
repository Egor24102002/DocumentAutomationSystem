/*
 * To change this license header, choose License Headers in Project Properties.
 * To chaimport java.util.UUID;nge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.BreakNode;

public class NewDocument extends javax.swing.JFrame {
private String docNumber;
    private Date docDate;
    private String docType;
    private String field1Value;
    private String field2Value;
 private int id;
   private String saveNumber;
    public NewDocument(String docNumber, Date docDate, String docType, String field1Value, String field2Value,int id) {
        initComponents();
        this.id=id;
      this.saveNumber=docNumber;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.docType = docType;
        this.field1Value = field1Value;
        this.field2Value = field2Value;
        
       
        number.setText(docNumber);
        data.setText(new SimpleDateFormat("dd/MM/yyyy").format(docDate));
        type.setSelectedItem(docType);
        field1.setText(field1Value);
        field2.setText(field2Value);
        type.setVisible(false);
        jLabel3.setVisible(false);
    }
    /**
     * Creates new form NewDocument
     */
    public NewDocument() {
        saveNumber="";
        initComponents();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        number = new javax.swing.JTextField();
        data = new javax.swing.JTextField();
        field1 = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        field2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Statement_type_m = new javax.swing.JLabel();
        amount_m = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });

        field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field1ActionPerformed(evt);
            }
        });

        save.setText("Сохранить");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel1.setText("number");

        jLabel2.setText("data (dd/MM/yyyy)");

        jLabel3.setText("type");

        Statement_type_m.setText("employee_name");

        amount_m.setText("position");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EmployeeRecord", "LegalContract", "FinancialStatement" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(number)
                    .addComponent(data)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 108, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Statement_type_m)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(amount_m)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Statement_type_m)
                    .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount_m)
                    .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String docNumber = number.getText();
    String docDate = data.getText();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
Date date = null;
    try {
    date = dateFormat.parse(docDate);
} catch (ParseException e) {
    JOptionPane.showMessageDialog(this, "Пожалуйста, введите дату в правильном формате (dd/MM/yyyy)", "Ошибка", JOptionPane.ERROR_MESSAGE);
       
        return;
}
    String docType = type.getSelectedItem().toString();
 Connection connection = DatabaseManager.getConnection();
   String checkDocumentQuery = "SELECT COUNT(*) FROM documents WHERE number = ?";
boolean documentExists = false;
try (PreparedStatement checkStatement = connection.prepareStatement(checkDocumentQuery)) {
    checkStatement.setString(1, docNumber);
    try (ResultSet resultSet = checkStatement.executeQuery()) {
        if (resultSet.next()) {
           
            int count = resultSet.getInt(1);
            documentExists = (count > 0);
            
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
}

  if (documentExists&&!saveNumber.equals(docNumber)){
    javax.swing.JOptionPane.showMessageDialog(this, "Данный документ уже существует");
 return;
    }
    
 
    if (id!=0) {
       
        switch (docType) {
            case "EmployeeRecord":
                String employeeName=field1.getText();
                String position=field2.getText();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                 
    
                EmployeeRecord employeeRecord = new EmployeeRecord(docNumber, sqlDate, employeeName, position);
                employeeRecord.update(connection,id);
                break;
            case "LegalContract":
                String counterParty=field1.getText();
                String purpose=field2.getText();
                java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());
                LegalContract legalContract = new LegalContract(docNumber, sqlDate2, counterParty, purpose);
                legalContract.update(connection,id);
                break;
            case "FinancialStatement":
                String statementType=field1.getText();
                double amount=Double.parseDouble(field2.getText());
                java.sql.Date sqlDate3 = new java.sql.Date(date.getTime());
                FinancialStatement financialStatement = new FinancialStatement(docNumber, sqlDate3, statementType, amount);
                financialStatement.update(connection,id);
                break;
          
        }
    } else { 
        switch (docType) {
            case "EmployeeRecord":
                String employeeName=field1.getText();
                String position=field2.getText();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                EmployeeRecord employeeRecord = new EmployeeRecord(docNumber, sqlDate, employeeName, position);
                employeeRecord.addDocument(connection);
                break;
            case "LegalContract":
                String counterParty=field1.getText();
                String purpose=field2.getText();
                java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());
                LegalContract legalContract = new LegalContract(docNumber, sqlDate2, counterParty, purpose);
                legalContract.addDocument(connection);
                break;
            case "FinancialStatement":
                String statementType=field1.getText();
                try {
        double amount = Double.parseDouble(field2.getText());
   
        java.sql.Date sqlDate3 = new java.sql.Date(date.getTime());
        FinancialStatement financialStatement = new FinancialStatement(docNumber, sqlDate3, statementType, amount);
        financialStatement.addDocument(connection);
    } catch (NumberFormatException e) {
    
        JOptionPane.showMessageDialog(this, "Пожалуйста, введите числовое значение в поле", "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
                break;
           
        }
    }
      
    }//GEN-LAST:event_saveActionPerformed

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberActionPerformed

    private void field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field1ActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
         String selectedItem = (String) type.getSelectedItem(); 
            switch (selectedItem) {
                case "EmployeeRecord":
                    Statement_type_m.setText("Employee Name:");
                    amount_m.setText("Position:");
                    break;
                case "LegalContract":
                    Statement_type_m.setText("Counterparty:");
                    amount_m.setText("Purpose:");
                    break;
                case "FinancialStatement":
                    Statement_type_m.setText("Statement Type:");
                    amount_m.setText("Amount:");
                    break;
              
            }
    }//GEN-LAST:event_typeActionPerformed

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
            java.util.logging.Logger.getLogger(NewDocument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewDocument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewDocument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewDocument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewDocument().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Statement_type_m;
    private javax.swing.JLabel amount_m;
    private javax.swing.JTextField data;
    private javax.swing.JTextField field1;
    private javax.swing.JTextField field2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField number;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
