/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/**
 *
 * @author guilherme
 */
public class ListProduto extends javax.swing.JInternalFrame {
    
    private List<Produto> produtoSelecionado;

    /**
     * Creates new form ListProduto
     */
    public ListProduto() {
        initComponents();
        produtoSelecionado= new ArrayList<>();
        carregarTabela();
    }
    
    public void carregarTabela(){
        
        /*DefaultTableModel model = new DefaultTableModel();
        String[] colunas = {"Codigo","Nome","Tipo","preco"};
        
        
        model.setColumnIdentifiers(colunas);
        
        for(Produto pro:produtosSelecionados){
            
            Object[] linha = { pro.getId(),pro.getNome(),pro.getTipo(),pro.getPreco()};
            model.addRow(linha);
             
                   

                
        
            
        }
        tableProdutosSelecionados.setModel( model );
*/
        
        DefaultTableModel model = new DefaultTableModel();
        String[] colunas = {"Código", "Nome","Preco","Quantidade","Categoria"};
        
        model.setColumnIdentifiers(colunas);
        
        for(Produto pro:produtoSelecionado){
            
            Object[] linha = {pro.getId(), pro.getNome(),pro.getPreco(),pro.getQuantidade(),pro.getCategoria().getNome()};
            model.addRow(linha);
        }
        tableProduto.setModel(model);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduto = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Lista de Produto");

        tableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Preco", "Quantidade", "CodCategoria", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tableProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProduto;
    // End of variables declaration//GEN-END:variables
}
