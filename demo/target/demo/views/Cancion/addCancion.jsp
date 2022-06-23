<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='css/estilos.css'>
    <title>Disquera</title>
</head>

<body>
    <center>
        <div>
            <h1>Registro de Canciones</h1> 
            <form action="cancion" method="post">
                   <b>
                    <label for="nombreCancion">Nombre Cancion</label>
                    <br>
                    <input type="text" name="nombreCancion" id="nombreCancion" class="form-control">
                    <label for="fechaGrabacion">Fecha Grabacion</label>
                    <br>
                    <input type="number" name="fechaGrabacion" id="fechaGrabacion" class="form-control">
                    <label for="duracionCancion">Duracion Cancion</label>
                    <br>
                    <input type="number" name="duracionCancion" id="duracionCancion" class="form-control">
                    <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input">
                    <label for="chkestado"> Activo</label>
                    <button type="submit" class="btn btn-primary" name="accion" value="add">Guardar</button>
                    </b>
                
            </form>
            </div>
        </center>
</body>

</html>