/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryingM.io;

import java.io.BufferedReader;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 123456789
 */

public class PracticeInterface extends javax.swing.JFrame {

    /**
     * Creates new form PracticeInterface
     */
    public PracticeInterface() throws IOException {
        initComponents();
    }
    
     public PracticeInterface(String user) throws IOException {
        initComponents();
        usernamelabel.setText(user);
        
    }
    
    // Priacte Members
    private int seconds;
    private String originalcode;
    private int index = 0;
    private int wpm = 0;
      int errors = 0; 
     int corret_chars = 0; 
    
    Map<Character, Integer> chars = new HashMap();
//    char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
         
    public void Timing ()
    {
        seconds = 60; 
        Timer timer = new Timer();  
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(seconds == 1) {
                   timer.cancel();
                    timer.purge();
                }   
                seconds--;
                timerlabel.setText(seconds+"");
            }
            
          
        }; 
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    
    public void getCode() throws FileNotFoundException
    {
        String filename= languagecombobox.getSelectedItem().toString()+".txt"; 
        System.out.println(filename);
  
        BufferedReader br = new BufferedReader(new FileReader(filename));       
        String st;
        originalcode  = original.getText(); 
        try {
            while ((st = br.readLine()) != null)
            {
                originalcode = originalcode + st + "\n" ;
                 
            }
        } catch (IOException ex) {
            Logger.getLogger(PracticeInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        original.setText(originalcode);
    }
    
    public void typingCalculation  ()
    {
        corret_chars = (index*60/seconds) - errors  ; 
     
        System.out.println("corret_chars"+ corret_chars);
        wpm =  corret_chars/5 ; 
    }
    public  void  result() 
    {
       for (Map.Entry<Character,Integer> entry : chars.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue());
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
        jLabel4 = new javax.swing.JLabel();
        timerlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        original = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        userarea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        languagecombobox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("practice ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("language :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("time remaning : ");

        timerlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        timerlabel.setText("60");

        original.setColumns(20);
        original.setRows(5);
        jScrollPane1.setViewportView(original);

        userarea.setColumns(20);
        userarea.setRows(5);
        userarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userareaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(userarea);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("End ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        languagecombobox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        languagecombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "java", "c++", "python", "c#", "ruby and rails", "bootstrap", "css", "xamond", " " }));
        languagecombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languagecomboboxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("UserName :");

        usernamelabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernamelabel.setText("jLabel5");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("back ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(60, 60, 60))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(languagecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(timerlabel)))))
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(usernamelabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(usernamelabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(timerlabel)
                    .addComponent(languagecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:  
             typingCalculation();
                result();
         
    if (usernamelabel.getText() =="jLabel5")   
    {
        new Results(wpm,errors, chars).setVisible(true);
    }
    else 
    { 
        String User = usernamelabel.getText(); 
         new Results(wpm,errors, chars,User).setVisible(true);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void languagecomboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languagecomboboxActionPerformed
        try {
            getCode();
            Timing();
        } catch (IOException ex) {
            Logger.getLogger(PracticeInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_languagecomboboxActionPerformed

    private void userareaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userareaKeyPressed
       // System.out.println(evt.getKeyCode());
        if(evt.getKeyCode() != 16 && evt.getKeyCode()!=8) {
            boolean correctWord = true;
          
            if(evt.getKeyChar() == originalcode.charAt(index)) {
               ; 
            } else {
                if(chars.get(evt.getKeyChar()) == null) {
                    chars.put(evt.getKeyChar(), 1); 
                    errors++; 
                } else {
                    chars.put(evt.getKeyChar(), chars.get(evt.getKeyChar()) + 1);
                       errors++; 
                }
               // System.out.println(chars.get(evt.getKeyChar()));
                System.out.println(errors);
               
            }
            
            // Enter
             if(evt.getKeyCode() == 10) {

            }
            // Space
             if(evt.getKeyChar() == ' ') {

            }
            index++;
        }
        // Backspace
            if(evt.getKeyCode() == 8) {
                index--;
            }
    }//GEN-LAST:event_userareaKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PracticeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PracticeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PracticeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PracticeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PracticeInterface().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PracticeInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> languagecombobox;
    private javax.swing.JTextArea original;
    private javax.swing.JLabel timerlabel;
    private javax.swing.JTextArea userarea;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
