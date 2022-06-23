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
    <div class="flex-fill flex-grow-1 ms-3">

        <h1>Lista de Generos</h1>
        <a type="button" class="btn btn-primary" href="genero?accion=abrirRegistrar">
            <i class="bi bi-plus-circle"></i> Agregar Genero
        </a>

        <table class="table table-hover table-bordered">

            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>
                    <center>Estado</center>
                </th>
                <th colspan="2">
                    <center>Acciones</center>
                </th>
            </tr>

            <c:forEach var="genero" items="${generos}">

                <tr>
                    <td>${genero.getIdGenero()}</td>
                    <td>${genero.getNombreGenero()}</td>
                    <c:if test="${genero.getEstadoGenero() == true}">
                        <td><span class="badge bg-success active">Activo</span></td>
                    </c:if>
                    <c:if test="${genero.getEstadoGenero() == false}">
                        <td><span class="badge bg-danger active">Inactivo</span></td>
                    </c:if>

                    <td>
                        <c:if test="${genero.getEstadoGenero() == true}">
                            <a genero="button" class="btn btn-danger btn-sm" onclick="cambiar"> 
              Inactivar
              </a>
                        </c:if>
                        <c:if test="${genero.getEstadoGenero() == false}">
                            <a genero="button" class="btn btn-success btn-sm">
              Activar
              </a>
                        </c:if>
                    </td>


                    <td>

                        <a genero="button" 
                        class="btn btn-info" 
                        name="control" 
                        href="genero?accion=editForm&idGenero=${genero.getIdGenero()}"
                        onclick="cambiar(event,'${genero.getIdGenero()}','genero')">>
                        Editar</a>

                        <a genero="button" 
                        href="genero?accion=eliminar&idGenero=${genero.getIdGenero()}"
                        class="btn btn-danger" 
                        onclick="borrar(event,'${genero.getIdGenero()}','genero')">
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