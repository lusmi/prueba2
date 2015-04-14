
package connectionoracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Connectionoracle {

 public Connection abrirconeccion(){
       Connection cn=conecciondb.conectar();
       return cn;
    }
    
    public static void main(String[] args) {
         Connectionoracle co= new Connectionoracle();
       
//        if (conecciondb.conectar() == null) {
//            System.out.println("la conección falló");
//        } else {
//            System.out.println("la conección fué un éxito");
//            
//        }
        
        //metodo que inserta un registro en la base de datos
      // co.insert();
       //metodo que muestra los registros de la base de datos
       //co.Select();
         //metodo que elimina registros mediante un ID
        // co.Delete(4);
         //metodo que modifica un registros la la base de datos mediante un ID
         co.Update(2, "Maria Anita", "Sanchez", "Vilcamango", 76454543);
    }
    
    public void insert(){
        
        Statement st=null;
        String query= "insert into persona values(4,'Amtony','Esmyro','Rito',78876744)";
        try {
            st=abrirconeccion().createStatement();
            st.executeUpdate(query);
            abrirconeccion().commit();
            abrirconeccion().close();
            System.out.println("Se insertó satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
        try {
                abrirconeccion().rollback();
                abrirconeccion().close();
        } catch (Exception x) {
            }
           
        }
    }
    
    public void Select(){
        Statement st=null;
        ResultSet rs=null;
        String query="select * from persona";
        try {
            st = abrirconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {                
                System.out.println("ID:"+rs.getInt("idpersona")+", Nombre:"+rs.getString("nombre")+", Apellido_pat:"+rs.getString("apellido_pat")+
                        ", Apellido_mat:"+rs.getString("apellido_mat")+", DNI:"+rs.getInt("dni"));
            }
            abrirconeccion().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                abrirconeccion().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void Delete(int id){
    Statement st=null;
    String query ="delete from persona where idpersona="+id;
        try {
            st=abrirconeccion().createStatement();
            st.executeUpdate(query);
            abrirconeccion().commit();
            abrirconeccion().close();
            System.out.println("Se eliminó satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                abrirconeccion().rollback();
                abrirconeccion().close();
            } catch (Exception ex) {
            }
        }
    }
    public void Update(int id, String nombre, String apellido_pat, String apellido_mat, int dni){
    Statement st=null;
    String query = "update persona set nombre ='"+nombre+"', apellido_pat='"
            +apellido_pat+"', apellido_mat='"+apellido_mat+"', DNI="+dni+" where idpersona="+id;
        try {
            st=abrirconeccion().createStatement();
            st.executeUpdate(query);
            abrirconeccion().commit();
            abrirconeccion().close();
            System.out.println("Se actualizó satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                abrirconeccion().rollback();
                abrirconeccion().close();
            } catch (Exception ex) {
            }
        }
    }
    
}
    
    
