/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryingM.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 123456789
 */
public class Results extends javax.swing.JFrame {

    /**
     * Creates new form Results
     */
    public Results() {
        initComponents();
        CreatConnection();
    } 
    String tablename ; 
Map<Character, Integer> newmap = new HashMap<>(); 
    public Results(int wpm, int errors, Map<Character, Integer> chars) {
          initComponents();
          CreatConnection();
          String str= ""; 
          speedlabel.setText(wpm+"");
         errorslabel.setText(errors+"");
         for (Map.Entry<Character,Integer> entry : chars.entrySet()) 
         {              //  try to write space in errorarea 
             if(entry.getValue()>1){
            str = entry.getKey()+": "+ entry.getValue()+" times\n"+str ; 
            newmap.put(entry.getKey(), entry.getValue()); 
             }
             else 
             {
                  str = entry.getKey()+": "+ entry.getValue()+" time\n"+str ; 
                   newmap.put(entry.getKey(), entry.getValue()); 
             }
             errorarea.setText(str);
         }
            //System.out.println("Key = " + entry.getKey() + 
                           //  ", Value = " + entry.getValue());
         if(usernamelabel.getText()!="jLabel6")
          {
              HistroryCreation();
          }
         
          
    } 
     Connection con ;
     void CreatConnection()
     {
        
             
        try { 
            Class.forName("com.mysql.jdbc.Driver");            
            con=DriverManager.getConnection("jdbc:mysql:// localhost:3306/tryingio","root","1234");
            System.out.println("Database connection sucees ");
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
    
    public Results(int wpm, int errors, Map<Character, Integer> chars,String user) {
          initComponents();
          CreatConnection();
          String str= ""; 
          JOptionPane.showMessageDialog(this, user);
          speedlabel.setText(wpm+"");
         errorslabel.setText(errors+"");
         for (Map.Entry<Character,Integer> entry : chars.entrySet()) 
         {              //  try to write space in errorarea 
             if(entry.getValue()>1){
            str = entry.getKey()+": "+ entry.getValue()+" times\n"+str ; 
            newmap.put(entry.getKey(), entry.getValue()); 
             }
             else 
             {
                  str = entry.getKey()+": "+ entry.getValue()+" time\n"+str ; 
                  newmap.put(entry.getKey(), entry.getValue()); 
             }
             errorarea.setText(str);
         }
            //System.out.println("Key = " + entry.getKey() + 
                           //  ", Value = " + entry.getValue());
                          
         
          usernamelabel.setText(user);
          if(usernamelabel.getText()!="jLabel6")
          {
              HistroryCreation();
          }
    } 
    public void history(){
        
        
        if (usernamelabel.getText()=="")
        {
            JOptionPane.showMessageDialog(null, " You should register to show your history ):");
        }
        else
        {
         new Result_History().setVisible(true);
        }
    } 
    public void HistroryCreation()
    { 
        try {
            // but the  history  happen when usernamelabel!= jlabel6
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");
            //System.out.println(formatter.format(date));
            String user = usernamelabel.getText();
             tablename = user + formatter.format(date) ;
            System.out.println(formatter.format(date));
         // String table = "CREATE TABLE "+tablename+"(user varchar(100),typingspeed int, errors int,value varchar(100), key int);";
//         String CREATE_TABLE_SQL="CREATE TABLE `boraji.users ("
//                    + "UID INT NOT NULL,"
//                    + "NAME VARCHAR(45) NOT NULL,"
//                    + "DOB DATE NOT NULL,"
//                    + "EMAIL VARCHAR(45) NOT NULL,"
//                    + "PRIMARY KEY (UID))";

//       String sql =  "CREATE TABLE "+tablename
//                   +"(user varchar(100) , "
//                   +"typingspeed int,"
//                   +"errors int, "
//                   +"value varchar(100),"
//                   +"key int "
//                  
//                   +" );" ;
 String sql =  "CREATE TABLE " +tablename+" ("
   +" user varchar(255),"
    +" typingspeed int,"
   + "errors int,"
   + "ckey varchar(255),"
  +" value int" 
+"); " ;      
            
            System.out.println(tablename);
   //   PreparedStatement stmt  =  con.prepareStatement("CREATE TABLE db( user VARCHAR(100),typingspeed INT, errors NT,value VARCHAR(100), key INT );");

            Statement stmt = con.createStatement();
            stmt.execute(sql);
            
            System.out.println("creating table done succesfully");
            stmt.close();
            Insertion();
        } catch (SQLException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public void Insertion()
    { 
        try {
            String username =  usernamelabel.getText() ;
            int typingspeed = Integer.parseInt(speedlabel.getText());
            int errors = Integer.parseInt(errorslabel.getText());
            System.out.println(newmap.size());
               for (Map.Entry<Character,Integer> entry : newmap.entrySet()) 
         {              //  try to write space in errorarea 
             System.out.println("hellowman");
             PreparedStatement stmt  =  con.prepareStatement("INSERT INTO "+tablename+" VALUES(?,?,?,?,?)");
            stmt.setString(1, username);
            stmt.setInt(2, typingspeed) ; 
             stmt.setInt(3, errors);
           stmt.setString(4, entry.getKey().toString());
               stmt.setInt(5, entry.getValue());
               
           stmt.execute();
             System.out.println("inserted mm");
             stmt.close();
            
           
         }
             
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        speedlabel = new javax.swing.JLabel();
        errorslabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        errorarea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Your Result ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Typing Speed : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Number of Errors :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("List of Errors :");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Finish ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        speedlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        speedlabel.setText("jLabel5");

        errorslabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errorslabel.setText("jLabel6");

        errorarea.setColumns(20);
        errorarea.setRows(5);
        jScrollPane1.setViewportView(errorarea);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("UserName");

        usernamelabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernamelabel.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addGap(68, 68, 68)
                        .addComponent(usernamelabel)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(speedlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(errorslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(usernamelabel)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(speedlabel))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(errorslabel))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Results().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea errorarea;
    private javax.swing.JLabel errorslabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel speedlabel;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
