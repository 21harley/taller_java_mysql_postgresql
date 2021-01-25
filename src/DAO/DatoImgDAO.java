package DAO;

import Conexion.Conectar;
import VO.DatoImg;
import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class DatoImgDAO{

    public ArrayList<DatoImg> Listar_DatoImgVO(){
        ArrayList<DatoImg> list = new ArrayList<DatoImg>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM sitios;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        int in=0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DatoImg vo = new DatoImg();
                vo.setIdRegistro(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setLatitud(rs.getDouble(3));
                vo.setLongitud(rs.getDouble(4));
                vo.setFoto(rs.getBytes(5));
                list.add(vo);
                in++;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }


/*Metodo agregar*/
    public void Agregar_DatoImgVO(DatoImg vo){
        Conectar conec = new Conectar();
        String sql = "INSERT INTO sitios (idRegistro, nombre, latitud, longitud, foto)\n" +
"VALUES (NULL,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getLatitud());
            ps.setDouble(3, vo.getLongitud());
            ps.setBytes(4, vo.getFoto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }


/*Metodo Modificar*/
    public void Modificar_DatoImgVO(DatoImg vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE sitios SET nombre = ?, latitud = ?, longitud = ?, foto = ?\n" +
"WHERE idRegistro = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getLatitud());
            ps.setDouble(3, vo.getLongitud());
            ps.setBytes(4, vo.getFoto());
            ps.setInt(5, vo.getIdRegistro());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    public void Modificar_DatoImgVO2(DatoImg vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE sitios SET nombre = ?, latitud = ?, longitud = ? \n" +
"WHERE idRegistro = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getLatitud());
            ps.setDouble(3, vo.getLongitud());
            ps.setInt(4, vo.getIdRegistro());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

/*Metodo Eliminar*/
    public void Eliminar_DatoImgVO(DatoImg vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM sitios WHERE idRegistro = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getIdRegistro());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }


}
