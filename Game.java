package unscramblegame;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author Madison Hara
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
    }
    /**
     * scramble method randomly scrambles a string
     * @param random
     * @param inputString = word from file
     * @return 
     */
    public static String scramble(Random random, String inputString) {
        // Convert your string into a simple char array:
        char a[] = inputString.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle, 
        for (int i = 0; i < a.length; i++) {
            int j = random.nextInt(a.length);
            // Swap letters
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return new String(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameTitle = new javax.swing.JLabel();
        scrambledWord = new javax.swing.JLabel();
        checkButton = new javax.swing.JButton();
        playerText = new javax.swing.JTextField();
        progressBar = new javax.swing.JProgressBar();
        progressLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Word Scramble Game");

        gameTitle.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        gameTitle.setForeground(new java.awt.Color(0, 51, 255));
        gameTitle.setText("Word Scramble");

        scrambledWord.setFont(new java.awt.Font("Eras Light ITC", 0, 24)); // NOI18N
        scrambledWord.setForeground(new java.awt.Color(0, 0, 153));
        scrambledWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scrambledWord.setText("[word]");
        scrambledWord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        checkButton.setText("Check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        progressLabel.setText("Progress:");

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 87, Short.MAX_VALUE)
                .addComponent(gameTitle)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(scrambledWord))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkButton))
                            .addComponent(playerText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gameTitle)
                        .addGap(81, 81, 81)
                        .addComponent(scrambledWord)
                        .addGap(37, 37, 37)
                        .addComponent(playerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkButton)
                            .addComponent(startButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(progressLabel)
                            .addComponent(nextButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        
        //Allow user to guess what the word is
        String guess = playerText.getText();
        //Check if user is correct and add to progress bar
        //if (guess.equalsIgnoreCase(word))                                     //not sure how I would check the guess back to the original word
        {                                                                       //maybe actions performed under start button event needs to be moved?
            
        }
        
    }//GEN-LAST:event_checkButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        
        playerText.setText("");
        
        // Open file of words to read from
        File myFile = new File("wordBank.txt");
        Scanner inputFile = new Scanner("wordBank.txt");
        //Read entire file
        for (int i = 1; i < myFile.length(); i++) {
            //Read a word, 1 line at a time
            String word = inputFile.nextLine();
            // Scrambles word
            Random r = new Random();
            String sWord = GameAssignment.scramble(r, word);
            // Displays word
            scrambledWord.setText(sWord);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        
        //Open file of words to read from
        File myFile = new File("wordBank.txt");
        Scanner inputFile = new Scanner("wordBank.txt");
        //Read entire file
        while (inputFile.hasNext()) {
            //Read a word, 1 line at a time
            String word = inputFile.nextLine();
            //Scrambles word
            Random r = new Random();                                            //not sure what this is
            String sWord = GameAssignment.scramble(r, word);
            //Displays word
            scrambledWord.setText(sWord);                                       //the scramble seems to be wrong, it turns to gibberish
        }
            //Close File
            inputFile.close();
    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel gameTitle;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField playerText;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JLabel scrambledWord;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
