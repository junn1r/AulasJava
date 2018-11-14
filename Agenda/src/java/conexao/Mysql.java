package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class Mysql {
    public Connection conecta(){
        String host = "jdbc:mysql://localhost/agenda";
        String usuario = "root";
        String senha = "1q";
        Connection conexao = null;
        
        try{
        DriverManager.registerDriver(new Driver());
            conexao = DriverManager.getConnection(
                host, usuario, senha
    );
        }catch (SQLException ex){
            System.out.println("Não foi possível conectar!");
    }
        return conexao;
  }
}       