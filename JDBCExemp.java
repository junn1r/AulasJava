/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexemp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

        
public class JDBCExemp {
    public static void main(String[] args) {
        String conexao = "valor";
        
        try{
            Connection mysql = DriverManager.getConnection(
            "jdbc:mysql://localhost/agenda",
            "root",
            "1q"
            );
            String sql = "insert into contatos" + 
            "(nome, endereco, email)" +
            "values (?, ?, ?)";        
            
            PreparedStatement instrucao = mysql.prepareStatement(sql);
                mysql.prepareStatement(sql);
                
                instrucao.setString(1, "Pedro Cookie");
                instrucao.setString(2, "Av. fab, 60");
                instrucao.setString(3, "pedrocookie@gmail.com");
                
                instrucao.execute();
            System.out.println("Conectado");
        }catch (SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
