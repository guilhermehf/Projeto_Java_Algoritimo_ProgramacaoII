/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
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
           + "  " + produto.getcodCategoria().getId() + " ) ";
        JOptionPane.showMessageDialog(null, query);
        Conexao.executar(query);
        
    }
    public static void editar(Produto produto){
       
        String query = "UPDATE produto SET "
           + " nome =         '" + produto.getNome()           + "' , "
           + " preco =        '" + produto.getPreco()          + "' , "
           + " quantidade =  " + produto.getQuantidade()    + "  , "
           + " codCategoria =     " + produto.getCodCategoria().getId() + "    "
           + " WHERE id = " + produto.getId();
        Conexao.executar(query);
        
    }
    
    public static void excluir(int idProduto){
        String query = "DELETE FROM Produto "
                     + " WHERE id = " + idProduto;
        Conexao.executar(query);
    }
    
 /*   public static List<Cliente> getClientes(){
        List<Cliente> lista = new ArrayList<>();
        String query = "SELECT c.id, c.nome, c.email, "
                + " c.cpf_cnpj, c.tipo, c.receberEmail, "
                + " d.id, d.nome "
                + " FROM clientes c "
                + " INNER JOIN cidades d "
                + " ON c.codCidade = d.id ";
   
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
            
            try {
                
                while( rs.next() ){
                    Cidade cid = new Cidade();
                    cid.setId( rs.getInt( 7 ) );
                    cid.setNome( rs.getString( 8 ) );
                    Cliente cliente = new Cliente();
                    cliente.setCidade( cid );
                    cliente.setId( rs.getInt( 1 ) );
                    cliente.setNome( rs.getString( 2 ) );
                    cliente.setEmail( rs.getString( 3 ) );
                   
                    if( rs.getInt( 6 ) == 1 )
                        cliente.setReceberEmail( true );
                    else
                        cliente.setReceberEmail( false );
                  
                    if( rs.getString( 5 ).equals(Cliente.PESSOA_FISICA)){
                        // Aqui possui um erro que será corrigido
                        ClientePF pf = (ClientePF) cliente;
                        pf.setTipo( Cliente.PESSOA_FISICA );
                        pf.setCpf( rs.getString( 4 ) );
                        lista.add( pf );
                    }else{
                        // Aqui possui um erro que será corrigido
                        ClientePJ pj = (ClientePJ) cliente;
                        pj.setTipo( Cliente.PESSOA_JURIDICA );
                        pj.setCnpj(rs.getString( 4 ) );
                        lista.add( pj );
                    }
                }
                
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            
        }
        
        
        return lista;
    }
   */ 
    
    
  
    
    
    public static List<ClientePF> getClientesPF(){
        List<ClientePF> lista = new ArrayList<>();
        String query = 
            "SELECT c.id, c.nome, c.email, c.cpf_cnpj, "
                + " c.receberEmail, d.id, d.nome "
                + " FROM clientes c "
                + " INNER JOIN cidades d "
                + " ON c.codcidade = d.id "
                + " WHERE tipo = '" + Cliente.PESSOA_FISICA+"' ";
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                while ( rs.next()  ) {                    
                    Cidade cid = new Cidade();
                    cid.setId( rs.getInt( 6 ) );
                    cid.setNome( rs.getString( 7 ) );
                    
                    ClientePF cliente = new ClientePF();
                    cliente.setTipo( Cliente.PESSOA_FISICA );
                    cliente.setId( rs.getInt( 1 ) );
                    cliente.setNome( rs.getString( 2 ) );
                    cliente.setEmail( rs.getString( 3 ) );
                    cliente.setCpf( rs.getString( 4 ) );
                    if( rs.getInt( 5 ) == 1 ){
                        cliente.setReceberEmail(true);
                    }else{
                        cliente.setReceberEmail(false);
                    }
                    cliente.setCidade( cid );
                    lista.add( cliente );
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static List<ClientePJ> getClientesPJ(){
        List<ClientePJ> lista = new ArrayList<>();
        String query = 
            "SELECT c.id, c.nome, c.email, c.cpf_cnpj, "
                + " c.receberEmail, d.id, d.nome "
                + " FROM clientes c "
                + " INNER JOIN cidades d "
                + " ON c.codcidade = d.id "
                + " WHERE tipo = '" + Cliente.PESSOA_JURIDICA +"' ";
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                while ( rs.next()  ) {                    
                    Cidade cid = new Cidade();
                    cid.setId( rs.getInt( 6 ) );
                    cid.setNome( rs.getString( 7 ) );
                    
                    ClientePJ cliente = new ClientePJ();
                    cliente.setTipo( Cliente.PESSOA_JURIDICA );
                    cliente.setId( rs.getInt( 1 ) );
                    cliente.setNome( rs.getString( 2 ) );
                    cliente.setEmail( rs.getString( 3 ) );
                    cliente.setCnpj( rs.getString( 4 ) );
                    if( rs.getInt( 5 ) == 1 ){
                        cliente.setReceberEmail(true);
                    }else{
                        cliente.setReceberEmail(false);
                    }
                    cliente.setCidade( cid );
                    lista.add( cliente );
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    
    public static List<Cliente> getClientes(){
        List<Cliente> lista = new ArrayList<>();
        String query = 
            "SELECT c.id, c.nome, c.email, c.cpf_cnpj, "
                + " c.receberEmail, d.id, d.nome, c.tipo "
                + " FROM clientes c "
                + " INNER JOIN cidades d "
                + " ON c.codcidade = d.id ";
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                while ( rs.next()  ) {                    
                    Cidade cid = new Cidade();
                    cid.setId( rs.getInt( 6 ) );
                    cid.setNome( rs.getString( 7 ) );
                    
                    if( rs.getString( 8 ).equals(Cliente.PESSOA_FISICA )){
                    
                        ClientePF cliente = new ClientePF();
                        cliente.setTipo( Cliente.PESSOA_FISICA );
                        cliente.setId( rs.getInt( 1 ) );
                        cliente.setNome( rs.getString( 2 ) );
                        cliente.setEmail( rs.getString( 3 ) );
                        cliente.setCpf( rs.getString( 4 ) );
                        if( rs.getInt( 5 ) == 1 ){
                            cliente.setReceberEmail(true);
                        }else{
                            cliente.setReceberEmail(false);
                        }
                        cliente.setCidade( cid );
                        lista.add( cliente );
                    }else{
                        ClientePJ cliente = new ClientePJ();
                        cliente.setTipo( Cliente.PESSOA_JURIDICA );
                        cliente.setId( rs.getInt( 1 ) );
                        cliente.setNome( rs.getString( 2 ) );
                        cliente.setEmail( rs.getString( 3 ) );
                        cliente.setCnpj(rs.getString( 4 ) );
                        if( rs.getInt( 5 ) == 1 ){
                            cliente.setReceberEmail(true);
                        }else{
                            cliente.setReceberEmail(false);
                        }
                        cliente.setCidade( cid );
                        lista.add( cliente );
                    }
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
}
