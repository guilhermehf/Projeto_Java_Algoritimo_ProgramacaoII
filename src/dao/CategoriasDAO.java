package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Categorias;


/**
 *
 * @author assparremberger
 */
//Alterar o codigo para categorias
public class CategoriasDAO {
    
    public static void inserir(Categorias cat){
        String query = "INSERT INTO categorias "
                + " ( nome ) VALUES ( "
                + " '" + cat.getNome() + "'  ); ";
        Conexao.executar( query );
    }
    
    public static void editar(Categorias cat){
        String query = "UPDATE cidades SET "
                + " nome =  '" + cat.getNome() + "' "
                + " WHERE id = " + cat.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(Categorias cat){
        String query = "DELETE FROM cidades "
                    + " WHERE id = " + cat.getId();
        Conexao.executar( query );
    }
    
    public static List<Categorias> getCidades(){
        List<Categorias> lista = new ArrayList<>();
        String query = "SELECT id, nome "
                     + " FROM cidades ORDER BY nome ";
        ResultSet rs = Conexao.consultar(query);
        if( rs != null ){
            try {
                while ( rs.next() ) {                    
                    Categorias cat = new Categorias();
                    cat.setId( rs.getInt( 1 ) );
                    cat.setNome( rs.getString( 2 ) );
                    lista.add( cat );
                }
            } catch (Exception e) {
            }
        }
        return lista;
    }
    
    public static Categorias getCategoriasById( int idCategorias ){
        String query = "SELECT id, nome "
                     + " FROM cidades "
                     + " WHERE id = " + idCategorias;
        ResultSet rs = Conexao.consultar(query);
        if( rs != null ){
            try {
                rs.next();                  
                    Categorias cat = new Categorias();
                    cat.setId( rs.getInt( 1 ) );
                    cat.setNome( rs.getString( 2 ) );
                    return cat;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
    
}
