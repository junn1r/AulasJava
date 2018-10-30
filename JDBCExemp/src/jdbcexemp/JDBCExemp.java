package jdbcexemp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.lang.String;

public class JDBCExemp {
    public static void main(String[] args) {
        String conexao = "valor";
        
        
        try{
           
            Connection mysql = DriverManager.getConnection(
            "jdbc:mysql://localhost/agenda",
            "root",
            "123456"
  
            );
            //insert contato
            String sql = "insert into contato" +
            "(nome, endereco, email)" + 
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
            //listar contato
          /*  Connection mysql = DriverManager().getConnection();
            String sql = "select * from contato" +
            
            PreparedStatment listar = mysql.prepareStatement(sql);
            listar.execute();
            
            Connection conn = new DriveManager().getConnection();
            PreparedStatement listar;
            
            try{
                listar = conn.prepareStatement("select * from contato");
                listar.execute();
                
            }catch (SQLException e){
                throw new RuntimeException();

            }
            */
          //listar
       
          
          
          //atualizar
          String sql = "update contato set nome =?" 
                   "endereco=?" 
                   "email=?" 
                   "where idContato =?";
          
         
            
          instrucao = mysql.prepareStatement(sql);
          instrucao.setString(1, "Lionel Messi");
          instrucao.setString(2, "rua cristiano ronaldo melhor do muno");
          instrucao.setString(3, "crisemeupai@gmail");
          instrucao.setInt(4, 4);
          
          int retorno = instrucao.executeUpdate();
          if (retorno > 0){
              System.out.printf("Novo registro alterado!");
          }else{
              System.out.println("Não foi possível alterar registro");
                      
          }
  
            System.out.println("Conectado"); 
        }catch(SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
