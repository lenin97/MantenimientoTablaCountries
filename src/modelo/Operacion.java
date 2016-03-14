package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.Conexion;


public class Operacion {

	public void actualizarByCountryName(String ctrName, String ctrId ,String regId) throws ClassNotFoundException, SQLException{
		
		int iregId= Integer.parseInt(regId);
		String sql="update countries set region_id=?, country_id=? where country_name=?";
		
		Connection cn = Conexion.cnHR();
		PreparedStatement pst=cn.prepareStatement(sql);
	    pst.setInt(1, iregId);
	    pst.setString(2, ctrId);
	    pst.setString(3, ctrName);
	    pst.executeUpdate();
	    pst.close();
	    cn.close();
			
		
	}//actualizar empleado
	
	
     public void addCountry(String ctrName, String ctrId ,String regId) throws ClassNotFoundException, SQLException{
		
		int iregId=Integer.parseInt(regId);
    	String sql="insert into countries values(?,?,?)";
		
		Connection cn = Conexion.cnHR();
		
		PreparedStatement pst=cn.prepareStatement(sql);
		pst.setString(1, ctrId);
		pst.setString(2, ctrName);
		pst.setInt(3, iregId);
	    pst.executeUpdate();
	    pst.close();
	    
	    cn.close();
			
		
	}
     
     public void deleteCountry(String ctrName) throws ClassNotFoundException, SQLException{
 		
 		String sql="delete from countries where country_name=?";
 		
 		Connection cn = Conexion.cnHR();
 		
 		PreparedStatement pst=cn.prepareStatement(sql);
 		pst.setString(1, ctrName);
 		pst.executeUpdate();
 		pst.close();
 	    
 	    cn.close();
 			
 		
 	}
     
     public List searchCountry(int RegId) throws ClassNotFoundException, SQLException{
  		
  		List lista = null;
    	String sql="select * from countries where region_id=?";
  		
  		Connection cn = Conexion.cnHR();
  		
  		PreparedStatement pst=cn.prepareStatement(sql);
  		pst.setInt(1, RegId);
  		ResultSet rs= pst.executeQuery();
  		lista = new ArrayList<Countries>();
  		
  		Countries aux;
        while (rs.next()) {
		      aux= new Countries(rs.getString("country_id"),
		    		  rs.getString("country_name"),
		    		  rs.getInt("region_id"));
			lista.add(aux);
		}
        
        rs.close();
        pst.close();
        cn.close();
        
        return lista;		
  			
  		
  	}
     
     public List tableCountries() throws ClassNotFoundException, SQLException{
   		
   		List lista = null;
     	String sql="select * from countries";
   		
   		Connection cn = Conexion.cnHR();
   		
   		PreparedStatement pst=cn.prepareStatement(sql);
   		ResultSet rs= pst.executeQuery();
   		lista = new ArrayList<Countries>();
   		
   		Countries aux;
         while (rs.next()) {
 		      aux= new Countries(rs.getString("country_id"),
 		    		  rs.getString("country_name"),
 		    		  rs.getInt("region_id"));
 			lista.add(aux);
 		}
         
         rs.close();
         pst.close();
         cn.close();
         
         return lista;		
   			
   		
   	}
     
    public String Compatibilidad(String ctrId, String ctrName, String regId) throws ClassNotFoundException, SQLException {
    	 String str="";
    	 int j=0;
    	 int iregId= Integer.parseInt(regId);
    	 ResultSet rs= null;
 		 Boolean state1=false, state2=false, state3=false;
 		 Connection cn = Conexion.cnHR();
 		 String sql;
 		 Statement pst;
    	 
    	 if (ctrId.length()==0) {
    		 str="Ingrese un Country_id.";			
		}
    	 if (ctrName.length()==0) {
    		 str=str+"\nIngrese un Country_name.";	
		}
    	 if (regId.length()==0) {
    		 str=str+"\nIngrese una Region_id.";	
		}
    	 
    	 for(int i=ctrId.length()-1; i>=0; i--) {
 	        if(Character.isUpperCase(ctrId.charAt(i))==false) {
 	            j++;
 	        }
 	     }
    	 
    	 if ((j>0 && j<=ctrId.length())) {
				str=str+"\nEl Country_id es en mayusculas.";
			}
    	 if ((ctrId.length()!=2) && (ctrId.length()!=0)) {
             str= str+"\nEl Country_id tiene dos letras.";         
          }
    	 
    	    sql= "select country_id from countries";
			pst = cn.createStatement();			
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				if (rs.getObject("country_id").equals(ctrId)) {
					state1= true;
				};				
			}			
			if (state1) {
				str= str+"\nEl Country_id ya existe.";  
			}
			rs.close();
	        pst.close();
	        
	        sql= "select COUNTRY_NAME from countries";
			pst = cn.createStatement();
			rs = pst.executeQuery(sql);		
			while (rs.next()) {
				if (rs.getObject("country_name").equals(ctrName)) {
					state2= true;
				};				
			}
			if (state2) {
				str= str+"\nEl Country_name ya existe.";  
			}
			rs.close();
	        pst.close();
	        
	        cn.close();
			  	 
    	 
    	 return str;
		
	}   
	
    public List tableRegions() throws ClassNotFoundException, SQLException{
   		
   		List lista = null;
   		int regId;
     	String sql="select * from regions";
   		
   		Connection cn = Conexion.cnHR();
   		
   		PreparedStatement pst=cn.prepareStatement(sql);
   		ResultSet rs= pst.executeQuery();
   		lista = new ArrayList<Regions>();
   		
   		Regions aux;
         while (rs.next()) {
 		      aux= new Regions(rs.getInt("region_id"),
 		    		  rs.getString("region_name"));
 			lista.add(aux);
 		}
         
         rs.close();
         pst.close();
         cn.close();
         
         return lista;		
   			
   		
   	}
       
    
}
