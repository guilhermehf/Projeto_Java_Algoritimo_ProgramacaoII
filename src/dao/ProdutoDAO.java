/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categorias;
import model.Produto;

/**
 *
 * @author guilherme
 */
public class ProdutoDAO {
    
    public static void inserir(Produto produto){
        
        String query = "INSERT INTO produtos "
           + "( nome, preco, quantidade, "
           + " codCategoria) VALUES ( "
           + " '" + produto.getNome()           + "' , "
           + "  " + produto.getPreco()          + "  , "
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
           + " codCategoria =     " + produto.getCategoria().getId() + "    "
           + " WHERE id = " + produto.getId();
        Conexao.executar(query);
        
    }
    
    
    public static void excluir(int idProduto){
        String query = "DELETE FROM produto "
                     + " WHERE id = " + idProduto;
        Conexao.executar(query);
    }
    
     public static List<Produto> getProduto(){
        List<Produto> lista = new ArrayList();
        String query = "Select p.id, p.nome,p.preco,p.quantidade, p.codCategoria,categorias.nome FROM produtos p INNER JOIN categorias ON categorias.id = p.codCategoria";
         ResultSet rs = Conexao.consultar(query);
        if(rs != null){
            try{
                while(rs.next()){
                    Produto pd = new Produto();
                    Categorias cat = new Categorias();
                    pd.setId(rs.getInt(1));
                    pd.setNome(rs.getString(2));
                    pd.setPreco(rs.getDouble(4));
                    pd.setQuantidade(rs.getInt(5));
                    cat.setId(rs.getInt(5));
                    cat.setNome(rs.getString(6));
                    pd.setCategoria(cat);
                    lista.add(pd);
                    
                    
                }
            } catch (Exception e){
                
            }
            
        }
        return lista;
    }
    
}
