package updateContato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class UpdateContato {
    public static void main(String[] args) {
           try {
               Connection mysql = DriverManager.getConnection(
               "jdbc:mysql://localhost/agenda",
               "root",
               "123456"
               );
               
               System.out.println("Conectado");
              
            //atualizar contato
            String sql = "update contato set nome = ?, endereco = ?, email = ? where idContato = ?";
            
            PreparedStatement instrucao = mysql.prepareStatement(sql);
            
            instrucao.setString(1, "Luis Suarez");
            instrucao.setString(2, "rua ronaldo07, 436");
            instrucao.setString(3, "cris@melhordomundo.com");
            instrucao.setInt(4, 4);
            
            int retorno = instrucao.executeUpdate();
            if (retorno > 0){
                System.out.println("Registro alterado!");
            }else{
                System.out.println("Não foi possível alterar o registro!");
            }
               
            
           }catch (Exception e){
               System.out.println("Ocorreu um erro!");
               throw new RuntimeException(e.getMessage());
           }
    }
}
