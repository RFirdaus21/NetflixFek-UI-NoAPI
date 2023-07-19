/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Database.Database;
import Helper.*;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rfirdaus
 */
public class MovieManager extends javax.swing.JFrame {
    private Object movieId;
    /**
     * Creates new form MovieManager
     */
    public MovieManager() {
        initComponents();
        this.initSelectedMovie();
        this.initTable();
        
    }

    public Object getMovieId() {
        return movieId;
    }

    public void setMovieId(Object movieId) {
        this.movieId = movieId;
    }
    
    
    
    private void initSelectedMovie(){
        this.movieId = new Object();
    }
    
    private void initTable() {
        try{
            String query = "SELECT * FROM netflix_film";
            ResultSet resultSetMovie = Database.getInstance().resultQuery(query);

            // Create a table model to hold the data
            DefaultTableModel tableModelMovies = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            // Retrieve column metadata
            ResultSetMetaData metaData = (ResultSetMetaData) resultSetMovie.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                tableModelMovies.addColumn(columnName);
            }

            // Populate the table model with data
            while (resultSetMovie.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSetMovie.getObject(i);
                }
                tableModelMovies.addRow(rowData);
            }

            // Set the table model on the table
            tableMovies.setModel(tableModelMovies);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
     
     private void resetTableMovie(){
         this.initTable();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btn_movieAdd = new javax.swing.JButton();
        btn_movieRemove = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMovies = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel5.setText("Movies List");

        btn_movieAdd.setText("Add");
        btn_movieAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_movieAddMouseClicked(evt);
            }
        });

        btn_movieRemove.setText("Remove");
        btn_movieRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_movieRemoveMouseClicked(evt);
            }
        });

        btn_back.setText("<<");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        tableMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Title", "Year", "Director", "Genre", "Cast", "Synopsis", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMoviesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMovies);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_back)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(btn_movieAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_movieRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_movieAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_movieRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        new AdminPage().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void tableMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMoviesMouseClicked
        int selectedRow = tableMovies.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tableMovies.getModel();
            
            this.setMovieId(model.getValueAt(selectedRow, 0));
        }
    }//GEN-LAST:event_tableMoviesMouseClicked

    private void btn_movieRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_movieRemoveMouseClicked
        String query = "SELECT image FROM netflix_film WHERE id="+this.getMovieId();
        String ImageName = Database.getInstance().resultQuery(query, "image");
        
        query = "DELETE FROM netflix_film WHERE id="+this.getMovieId();
        boolean successQuery = Database.getInstance().manipulationQuery(query);
        
        if(!successQuery){
            JOptionPane.showMessageDialog(null,"Failed Delete Movie");
            return;
        }
        
        boolean succesRemoveImage = ImageRemover.removeImage(ImageName);
        
        if(!succesRemoveImage){
            JOptionPane.showMessageDialog(null,"Failed Delete Movie");
            return;
        }
        
        this.resetTableMovie();
        JOptionPane.showMessageDialog(null,"Success Delete Movie");
    }//GEN-LAST:event_btn_movieRemoveMouseClicked

    private void btn_movieAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_movieAddMouseClicked
        dispose();
        new AddMovie().setVisible(true);
    }//GEN-LAST:event_btn_movieAddMouseClicked

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
            java.util.logging.Logger.getLogger(MovieManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_movieAdd;
    private javax.swing.JButton btn_movieRemove;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableMovies;
    // End of variables declaration//GEN-END:variables
}