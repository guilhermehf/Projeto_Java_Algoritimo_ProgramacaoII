/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author guilherme
 */
public class ProdutoDAO {
    
    public static void inserir(Produto produto){
        
        String query = "INSERT INTO produto "
           + "( nome, preco, quantidade, "
           + " codCategoria) VALUES ( "
           + " '" + produto.getNome()           + "' , "
           + " '" + produto.getPreco()          + "' , "
           + "  " + produto.getQuantidade()    + " , "
           + "  " + produto.getCategoria().getId() + " ) ";
        JOptionPane.showMessageDialog(null, query);
        Conexao.executar(query);
        
    }
    
    public static void editar(Produto produto){
        
        
        String query = "UPDATE produto SET "
           + " nome =         '" + produto.getNome()           + "' , "
           + " preco =        '" + produto.getPreco()          + "' , "
           + " quantidade =     '" + produto.getQuantidade()                    + "' , "
           + " categoria =  " + produto.categoria()    + "  , "
           + " codCategoria =     " + produto.getCategoria().getId() + "    "
           + " WHERE id = " + produto.getId();
        Conexao.executar(query);
        
    }
    
    
    public static void excluir(int idProduto){
        String query = "DELETE FROM produto "
                     + " WHERE id = " + idProduto;
        Conexao.executar(query);
    }
    
}
