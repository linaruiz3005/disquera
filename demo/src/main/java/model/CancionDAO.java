package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CancionDAO {

    Connection con; //objeto para la conexion
    PreparedStatement ps; //objeto para las sentencias preparadas
    ResultSet rs; //objeto para almacenar los resultados de las consultas
    String sql=null; // variable para almacenar las sentencias de SQL
    int r;

    public List<CancionVO>listar() throws SQLException{

        List<CancionVO> canciones= new ArrayList<>();
        sql="SELECT * FROM cancion";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql); //prepara la sentencia SELECT
            System.out.println (ps);
            rs=ps.executeQuery(); //ejecuta la sentencia y guarda los resultados
            while(rs.next()){
                CancionVO r=new CancionVO();
                r.setIdCancion(rs.getInt("idCancion"));
                r.setNombreCancion(rs.getString("nombreCancion"));
                r.setFechaGrabacion(rs.getInt("fechaGrabacion"));
                r.setDuracionCancion(rs.getString("duracionCancion"));
                r.setEstadoCancion(rs.getBoolean("estadoCancion"));
                canciones.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e) {
            System.out.println("No hay cancines definidas"+e.getMessage());
        }finally{
            con.close();//cerrando la conexion 
        }
        return canciones;
    }
    
    public int registrarCan(CancionVO cancion) throws SQLException{
        sql="INSERT INTO cancion(nombreCancion,fechaGrabacion,duracionCancion,estadoCancion) values(?,?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println (ps);
            ps.setString(1, cancion.getNombreCancion());
            ps.setInt(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.getEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("La cancion ha sido registrada exitosamente ");
        }catch(Exception e){
            System.out.println("Hubo un error al registrar la cancion "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public int estadoCan(int idCancion, boolean estadoCancion) throws SQLException{
        sql="UPDATE cancion SET idCancion="+idCancion+"WHERE estadoCancion="+estadoCancion;
        System.out.println(sql);
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("El estado esta de forma correcta");
        }catch(Exception e){
            System.out.println("El estado esta de forma incorrecta"+e.getMessage());
        }
        finally{
            con.close();//cerrando conexión
        }
        return idCancion;
    }

    public int editCan(int idCancion, String nombreCancion,int fechaGrabacion, String duracionCancion, boolean estadoCancion) throws SQLException{
        sql="UPDATE cancion SET nombreCancion="+nombreCancion+",fechaGrabacion="+fechaGrabacion+",duracionCancion="+duracionCancion+",estadoCancion="+estadoCancion+"  WHERE idCancion="+idCancion;
        System.out.println(sql);
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println(ps);
            System.out.println("La cancion se edito de forma correcta");
        }catch(Exception e){
            System.out.println("La cancion no se pudo editar"+e.getMessage());
        }
        finally{
            con.close();//cerrando conexión
        }
        return idCancion;
    }

    public List<CancionVO>listarCancion(int idCancion) throws SQLException{

        List<CancionVO> listarCancion= new ArrayList<>();
        sql="SELECT * FROM cancion Where idCancion="+idCancion;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql); //prepara la sentencia SELECT
            System.out.println (ps);
            rs=ps.executeQuery(); //ejecuta la sentencia y guarda los resultados
            while(rs.next()){
                CancionVO r=new CancionVO();
                r.setIdCancion(rs.getInt("idCancion"));
                r.setNombreCancion(rs.getString("nombreCancion"));
                r.setFechaGrabacion(rs.getInt("fechaGrabacion"));
                r.setDuracionCancion(rs.getString("duracionCancion"));
                r.setEstadoCancion(rs.getBoolean("estadoCancion"));
                listarCancion.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e) {
            System.out.println("No hay canciones definidas"+e.getMessage());
        }finally{
            con.close();//cerrando la conexion 
        }
        return listarCancion;
    }

    public void eliminarCan(int idCancion)throws SQLException{
        sql="DELETE FROM cancion WHERE idCancion="+idCancion;
        
        System.out.println(sql);
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate(sql);
            ps.close();
            System.out.println("La cancion se elimino de forma correcta");
        } catch (Exception e) {
           System.out.println("Error en la eliminacion de la cancion"+e.getMessage());
        }
        finally{
            con.close();
        }
    }
    
}
