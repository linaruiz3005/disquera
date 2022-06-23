package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeneroDAO;
import model.GeneroVO;

public class Genero  extends HttpServlet{
    GeneroDAO gdao=new GeneroDAO();
    GeneroVO g=new GeneroVO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");
        System.out.println(accion);
        switch(accion){
            case "abrirRegistrar":
            abrirRegistrar(req, resp);
            break;

            case "listar":
            listar(req,resp);
            break;

            case "estadoGenero":
            estadoGenero(req,resp);
            break;

            case "eliminar":
            eliminar(req, resp);
            break;

            case "editForm":
            editForm(req, resp);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String accion=req.getParameter("accion");
        System.out.println(accion);

        switch(accion){
            case "add":
            addGenero(req, resp);
            break;

            case "edit":
            edit(req, resp);
            break;
        }
    }
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idGenero")!=null) {
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        try{
            gdao.eliminarGenero(g.getIdGenero());
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Genero Eliminado");
        }catch(Exception e){
            req.setAttribute("msje", "No se logro eliminar el genero" + e.getMessage());
            System.out.println("No se logro eliminar el genero" + e.getMessage());
        }finally{
            
        }
    }
    
    private void abrirRegistrar (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Genero/addGenero.jsp").forward(req, resp);
            System.out.println("El registro para el genero se abrio ");
        }catch(Exception e){
            System.out.println("El registro para el genero NO se abrio"+e.getMessage().toString());
        }
    }
    private void addGenero(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDAO gdao=new GeneroDAO();
        GeneroVO g=new GeneroVO();
        if(req.getParameter("nombreGenero")!=null){
            g.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("chkestado")!=null){
            g.setEstadoGenero(true);
        }
        else{
            g.setEstadoGenero(false);
        }
        try{
            gdao.registrar(g);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Registro exitoso");
        }catch(Exception e){
            System.out.println("No se pudo registrar el genero"+e.getMessage().toString());
        }
    }

    private void estadoGenero(HttpServletRequest req, HttpServletResponse resp) {
   
        if(req.getParameter("idGenero")!=null) {
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if(req.getParameter("estadoGenero") != null) {
            g.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
        }
        try{gdao.estadoGenero(g.getIdGenero(), g.getEstadoGenero());
            listar(req, resp);
            System.out.println("El estado es correcto");
        } catch (Exception e) {
            req.setAttribute("msje", "No se logro actualizar el estado del genero"+e.getMessage());
            System.out.println("No se logro actualizar el estado del genero"+e.getMessage().toString());
        }
    }    

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        GeneroVO g=new GeneroVO();
        GeneroDAO gdao=new GeneroDAO();
        try{
            List<GeneroVO> genero = gdao.listar();
            req.setAttribute("generos", genero);
            req.getRequestDispatcher("views/Genero/listGenero.jsp").forward(req, resp);
            System.out.println("Generos encontrados");
        }catch(Exception e){
            req.setAttribute("msje", "No se logo listrar los generos" + e.getMessage());
            System.out.println("No se pueden listar los generos" + e.getMessage());
        }
    }
    private void editForm(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDAO gdao=new GeneroDAO();
        GeneroVO g=new GeneroVO();
        if (req.getParameter("idGenero")!=null) {
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        try {
            List<GeneroVO> genero=gdao.listarGenero(g.getIdGenero());
            req.setAttribute("generos", genero);
            req.getRequestDispatcher("views/Genero/editGenero.jsp").forward(req, resp);

            System.out.println("Se listo de manera correcta");
        } catch (Exception e) {
            System.out.println("NO se logro listar "+e.getMessage().toString());
        }
    }
    private void edit(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idGenero")!=null) {
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if(req.getParameter("nombreGenero")!=null) {
            g.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("chkestado")!=null) {
            g.setEstadoGenero(Boolean.parseBoolean(req.getParameter("chkestado")));
        }
        try{
            gdao.estadoGenero(g.getIdGenero(), g.getEstadoGenero());
            listar(req, resp);
            System.out.println("El genero se modifico de forma correcta");
        }
        catch(Exception e){
            req.setAttribute("msj", "No se pudo modificar el genero"+e.getMessage());
            System.out.println("No se pudo modificar el genero" +e.getMessage());
        }
        finally{ 
            
        }
    }
}

