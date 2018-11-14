<%-- 
    Document   : criar-contato
    Created on : 13/11/2018, 20:09:25
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Not Found</title>
    </head>
    <body>
        <h1>Criar Contato</h1>
        <form action='/Agenda/SaveContact' method='post'>
            NOME: <input type="text" name="nome"/><br>
            EMAIL: <input type ="text" name="email"/><br>
            ENDERECO: <input type="text" name="text"/><br>
            DATA DE NASCIMENTO: <input type="text" name="data_nascimento"/><br>
            <button type='submit'>Criar Contato</button>                           
                                       
        </form>
    </body>
</html>
