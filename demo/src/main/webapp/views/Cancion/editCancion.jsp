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
      
            <h1>Actualizar Canciones</h1>
            <form method="post" action="cancion?control=edit&IdCancion=${cancion.getIdCancion()}">
                
                    <label for="nombreCancion">Nombre Cancion</label>
                    <input type="text" class="form-control" name="nombreCancion" id="nombreCancion" placeholder="Ingrese el nombre" value="${cancion.nombreCancion}"/>
                    <br>
                    <input type="text" class="form-control" name="fechaGrabacion" id="fechaGrabacion" placeholder="Ingrese la fecha " value="${cancion.fechaGrabacion}"/>
                    <label for="fechaGrabacion">Fecha Grabacion</label>
                    <br>
                    <input type="text" class="form-control" name="duracionCancion" id="duracionCancion" placeholder="Ingrese la duracion" value="${cancion.duracionCancion}"/>
                    <label for="duracionCancion">Duracion Cancion</label>
                
                    <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
                    <c:out value="${cancion.estadoCancion==false ? 'unchecked':'checked'}" default=""/>>
                    <label class="form-check-label" for="flexCheckChecked">
                    ${cancion.estadoCancion==false ? 'Marca la casilla para activar':'Desmarca la casilla para Inactivar'}
                    </label>
                    <button type="submit" class="btn btn-primary" name="accion" value="adit">Guardar</button>
                    </form>
                    </div> 
                </center>

</body>

</html>