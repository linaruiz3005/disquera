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
    
            <h1>Lista de Canciones</h1>
            <a type="button" class="btn btn-primary" href="cancion?accion=abrirRegistrarCan">
                <i class="bi bi-plus-circle"></i> Agregar Cancion
            </a>
    
            <table class="table table-hover table-bordered">
    
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Fecha Grabacion</th>
                    <th>Duracion</th>
                    <th>
                        <center>Estado</center>
                    </th>
                    <th colspan="2">
                        <center>Acciones</center>
                    </th>
                </tr>
    
                <c:forEach var="cancion" items="${canciones}">
    
                    <tr>
                        <td>${cancion.getIdCancion()}</td>
                        <td>${cancion.getNombreCancion()}</td>
                        <td>${cancion.getFechaGrabacion()}</td>
                        <td>${cancion.getDuracionCancion()}</td>
                        <c:if test="${cancion.getEstadoCancion() == true}">
                            <td><span class="badge bg-success active">Activo</span></td>
                        </c:if>
                        <c:if test="${cancion.getEstadoCancion() == false}">
                            <td><span class="badge bg-danger active">Inactivo</span></td>
                        </c:if>
    
                        <td>
                            <c:if test="${cancion.getEstadoCancion() == true}">
                                <a cancion="button" class="btn btn-danger btn-sm" onclick="cambiar"> 
                  Inactivar
                  </a>
                            </c:if>
                            <c:if test="${cancion.getEstadoCancion() == false}">
                                <a cancion="button" class="btn btn-success btn-sm">
                  Activar
                  </a>
                            </c:if>
                        </td>
    
    
                        <td>
    
                            <a canciones="button" 
                            class="btn btn-info" 
                            name="control" 
                            href="cancion?accion=editCan&idCancion=${cancion.getIdCancion()}"
                            onclick="cambiarCan(event,'${cancion.getIdCancion()}','cancion')">>
                            Editar</a>
    
                            <a canciones="button" 
                            href="cancion?accion=eliminarCan&idCancion=${cancion.getIdCancion()}"
                            class="btn btn-danger" 
                            onclick="borrarCan(event,'${cancion.getIdCancion()}','cancion')">
                            Eliminar
                            </a>
    
                        </td>
                        <tr>
    
                </c:forEach>
    
    
            </table>
    
    
        </div>
        </center>
</body>

</html>