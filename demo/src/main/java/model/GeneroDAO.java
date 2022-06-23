package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {
    
    //atributos
    Connection con; //objeto para la conexion
    PreparedStatement ps; //objeto para las sentencias preparadas
    ResultSet rs; //objeto para almacenar los resultados de las consultas
    String sql=null; // variable para almacenar las sentencias de SQL
    int r; 

    public List<GeneroVO>listar() throws SQLException{

        List<GeneroVO> generos= new ArrayList<>();
        sql="SELECT * FROM genero";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql); //prepara la sentencia SELECT
            System.out.println (ps);
            rs=ps.executeQuery(); //ejecuta la sentencia y guarda los resultados
            while(rs.next()){
                GeneroVO r=new GeneroVO();
                r.setIdGenero(rs.getInt("idGenero"));
                r.setNombreGenero(rs.getString("nombreGenero"));
                r.setEstadoGenero(rs.getBoolean("estadoGenero"));
                generos.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e) {
            System.out.println("No hay generos definidos"+e.getMessage());
        }finally{
            con.close();//cerrando la conexion 
        }
        return generos;
    }

public int registrar(GeneroVO genero) throws SQLException{
    sql="INSERT INTO genero(nombreGenero,estadoGenero) values(?,?)";
    try{
        con=Conexion.conectar(); //abrir conexión
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println (ps);
        ps.setString(1, genero.getNombreGenero());
        ps.setBoolean(2, genero.getEstadoGenero());
        System.out.println(ps);
        ps.executeUpdate(); //Ejecutar sentencia
        ps.close(); //cerrar sentencia
        System.out.println("El genero ha sido registrado exitosamente ");
    }catch(Exception e){
        System.out.println("Hubo un error al registrar el genero "+e.getMessage().toString());
    }
    finally{
        con.close();//cerrando conexión
    }
    return r;
}
public int estadoGenero(int idGenero, boolean estadoGenero) throws SQLException{
    sql="UPDATE genero SET idGenero= "+idGenero+"WHERE estadoGenero="+estadoGenero;
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
    return idGenero;
}

public int editGenero(int idGenero, String nombreGenero, boolean estadoGenero) throws SQLException{
    sql="UPDATE genero SET nombreGenero= "+nombreGenero+",estadoGenero="+estadoGenero+"  WHERE idGenero="+idGenero;
    System.out.println(sql);
    try{
        con=Conexion.conectar(); //abrir conexión
        ps=con.prepareStatement(sql); //preparar sentencia
        ps.executeUpdate(); //Ejecutar sentencia
        ps.close(); //cerrar sentencia
        System.out.println(ps);
        System.out.println("El genero se edito de forma correcta");
    }catch(Exception e){
        System.out.println("El genero no se pudo editar"+e.getMessage());
    }
    finally{
        con.close();//cerrando conexión
    }
    return idGenero;
}

public List<GeneroVO> listarGenero(int idGenero) throws SQLException{

    List<GeneroVO> genero=new ArrayList<>();
    sql="SELECT * FROM genero WHERE idGenero = "+idGenero;
    System.out.println("Se logro listar datos");
    try {
        con=Conexion.conectar();//genera la conexion
        ps=con.prepareStatement(sql);//prepara sentencia select
        rs=ps.executeQuery();//ejecutamos la sentencia y guardamos los resultados
        while (rs.next()){
            GeneroVO r=new GeneroVO();//crear un nuevo objeto
            r.setNombreGenero(rs.getString("nombreGenero"));
            r.setEstadoGenero(rs.getBoolean("estadoGenero"));
            genero.add(r);
        }
        ps.close();
        System.out.println("Se logro listar los generos ");
    } catch (Exception e) {
        System.out.println("NO se logro listar los generos"+e.getMessage());
    }finally{
        con.close();//cerrando la conexion
    }
    return genero;
}

public void eliminarGenero(int idGenero)throws SQLException{
    sql="DELETE FROM genero WHERE idGenero="+idGenero;
    
    System.out.println(sql);
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.executeUpdate(sql);
        ps.close();
        System.out.println("El genero se elimino de forma correcta");
    } catch (Exception e) {
       System.out.println("Error en la eliminacion del genero"+e.getMessage());
    }
    finally{
        con.close();
    }
}
}