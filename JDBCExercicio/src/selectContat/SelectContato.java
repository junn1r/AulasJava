package selectContat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectContato {
     public static void main(String[] args) {
               
         try {
            Connection mysql = DriverManager.getConnection(
            "jdbc:mysql://localhost/agenda",
            "root",
            "123456"
            );
            
          System.out.println("Conectado\n");
          
          Statement listar = mysql.createStatement();
          
          //select contato
          String sql = "select * from contato";
          ResultSet result = listar.executeQuery(sql);
          
          while(result.next()) {
            /*int id = result.getInt("idContato");
            String nome = result.getString("nome");
            String endereco = result.getString("endereco");
            String email = result.getString("email");
            */
            System.out.println("" + result.getInt("idContato"));
            System.out.println("Nome: " + result.getString("nome"));
            System.out.println("Endereço: " + result.getString("endereco"));
            System.out.println("E-mail: " + result.getString("email"));
            
        }
            }catch(Exception e){
             System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e.getMessage());
            }
        }
    }

