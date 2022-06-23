<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.main.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='css/estilos.css'>
    <title>Disquera</title>
</head>

<body>

  <center>
    <div class="flex-fill flex-grow-1 ms-3">
  
        <h1>Actualizar Generos</h1>
        
          <form method="post" action="genero?control=edit&IdGenero=${genero.getIdGenero()}">
                  <label for="nombreGenero">Nombre Genero</label>
                  <input type="text" name="nombreGenero" id="nombreGenero" class="form-control" value="${genero.getIdGenero()}">
          
                  <label for="chkestado"> Activo</label>
                  <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input">
            
                  <button type="submit" class="btn btn-primary" name="accion" value="edit">Guardar</button>
              
          </form>
        </div> 
      </center>
</body>

</html>