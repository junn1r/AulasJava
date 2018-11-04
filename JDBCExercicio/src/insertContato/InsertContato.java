package insertContato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class InsertContato {
    public static void main(String[] args) {
        String conexao = "valor";
        
        try{
       
            Connection mysql = DriverManager.getConnection(
            "jdbc:mysql://localhost/agenda",
            "root",
            "123456"
  
            );
            System.out.println("Conectado");
            
            //insert contato
            String sql = "insert into contato," +
            "(nome, endereco, email)," + 
            "values (?, ?, ?)";
            
            PreparedStatement instrucao = mysql.prepareStatement(sql);
                mysql.prepareStatement(sql);
                
                instrucao.setString(1, "Pedro cookie");
                instrucao.setString(2, "av. fab, 60");
                instrucao.setString(3, "pedrocookie@gmail.com");
                
                instrucao.setString(1, "Joedson Rodrigues");
                instrucao.setString(2, "Rua terezina, 768");
                instrucao.setString(3, "joedson.junior73@gmail.com");
                
                instrucao.setString(1, "Lanayara Viana");
                instrucao.setString(2, "Novo horizonte");
                instrucao.setString(3, "laviana@gmail.com");
                
                instrucao.setString(1, "Cristiano Ronaldo");
                instrucao.setString(2, "infraero 2, 409");
                instrucao.setString(3, "cris@yahoo.com");
                
         
                instrucao.execute();
                
               
               
        }catch(SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
