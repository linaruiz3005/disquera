package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CancionDAO;
import model.CancionVO;

public class Cancion extends HttpServlet {
    CancionDAO cdao=new CancionDAO();
    CancionVO c=new CancionVO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("Entró al DoGet de cancion");
        String accion=req.getParameter("accion");
        System.out.println(accion);
        switch(accion){
            case "abrirRegistrarCan":
            abrirRegistrarCan(req, resp);
            break;

            case "listarCan":
            listarCan(req,resp);
            break;

            case "estadoCancion":
            estadoCan(req, resp);
            break;

            case "eliminarCan":
            eliminarCan(req, resp);
            break;

            case "editCan":
            editCan(req, resp);
            break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("Entró al DoPost");
        String accion=req.getParameter("accion");
        System.out.println(accion);
        System.out.println();
        switch(accion){

            case "add":
            addCan(req, resp);
            break;

            case "edit":
            edit(req, resp);
            break;
        }
    }
    private void eliminarCan(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idCancion")!=null) {
            c.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try{
            cdao.eliminarCan(c.getIdCancion());
            resp.sendRedirect("cancion?accion=listarCan");
            System.out.println("Cancion Eliminada");
        }catch(Exception e){
            req.setAttribute("msje", "No se logro eliminar la cancion" + e.getMessage());
            System.out.println("No se logro eliminar la cancion" + e.getMessage());
        }finally{
            
        }
    }
    private void abrirRegistrarCan (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Cancion/addCancion.jsp").forward(req, resp);
            System.out.println("El registro para la cancion se abrio ");
        }catch(Exception e){
            System.out.println("El registro para la cancion NO se abrio"+e.getMessage().toString());
        }
    }
    private void addCan(HttpServletRequest req, HttpServletResponse resp) {
        CancionDAO cdao=new CancionDAO();
        CancionVO c=new CancionVO();
        if(req.getParameter("nombreCancion")!=null){
            c.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            c.setFechaGrabacion(Integer.parseInt(req.getParameter("fechaGrabacion")));
        }
        if(req.getParameter("duracionCancion")!=null){
            c.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("chkestado")!=null){
            c.setEstadoCancion(true);
        }
        else{
            c.setEstadoCancion(false);
        }
        try{
            cdao.registrarCan(c);
            resp.sendRedirect("cancion?accion=listarCan");
            System.out.println("Se registro la cancion de manera exitosa");
        }catch(Exception e){
            System.out.println("No se pudo registrar la cancion"+e.getMessage().toString());
        }
    }

    private void estadoCan(HttpServletRequest req, HttpServletResponse resp) {
   
        if(req.getParameter("idCancion")!=null) {
            c.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        if(req.getParameter("estadoCancion")!=null) {
            c.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion"))); 
        }
        try{
            cdao.estadoCan(c.getIdCancion(), c.getEstadoCancion());
            listarCan(req, resp);
            System.out.println("El estado esta de forma correcta");
        }catch(Exception e){
            req.setAttribute("msje", "No se logro cambiar el estado" + e.getMessage());
            System.out.println("No se logro cambiar el estado" + e.getMessage());
        }finally{
            
        }
    }

    private void listarCan(HttpServletRequest req, HttpServletResponse resp) {
        CancionVO c=new CancionVO();
        CancionDAO cdao=new CancionDAO();
        try{
            List<CancionVO> cancion = cdao.listar();
            req.setAttribute("canciones", cancion);
            req.getRequestDispatcher("views/Cancion/listCancion.jsp").forward(req, resp);
            System.out.println("Canciones encontradas");
        }catch(Exception e){
            req.setAttribute("msje", "No se logro listar las canciones" + e.getMessage());
            System.out.println("No se pueden listar las canciones" + e.getMessage());
        }
    }

    private void editCan(HttpServletRequest req, HttpServletResponse resp) {
        CancionDAO cdao=new CancionDAO();
        CancionVO c=new CancionVO();
        if (req.getParameter("idCancion")!=null) {
            c.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try {
            List<CancionVO> cancion=cdao.listarCancion(c.getIdCancion());
            req.setAttribute("canciones", cancion);
            req.getRequestDispatcher("views/Cancion/editCancion.jsp").forward(req, resp);

            System.out.println("Se listo de manera correcta ");
        } catch (Exception e) {
            System.out.println("NO se logro listar "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idCancion")!=null) {
            c.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        if(req.getParameter("nombreCancion")!=null) {
            c.setNombreCancion(req.getParameter("NombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            c.setFechaGrabacion(Integer.parseInt(req.getParameter("fechaGrabacion")));
        }
        if(req.getParameter("duracionCancion")!=null){
            c.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            c.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));
        }
        try{
            cdao.estadoCan(c.getIdCancion(), c.getEstadoCancion());
            listarCan(req, resp);
            System.out.println("La cancion se modifico de forma correcta");
        }
        catch(Exception e){
            req.setAttribute("msj", "No se pudo modificar la cancion"+e.getMessage());
            System.out.println("No se pudo modificar la cancion" +e.getMessage());
        }
    }

}
