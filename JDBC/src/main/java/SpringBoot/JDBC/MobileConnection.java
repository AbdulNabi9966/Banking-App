package SpringBoot.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MobileConnection {

		@Autowired
		DataSource dataSource;

	    private static final String updateMobile ="update mobiles set name=?,price=?,ram=?,storage=? where mobile_id=?";
	    private static final String deleteMobile ="delete from mobiles where mobile_id=?";


	public int insertMobiles(List<Mobiles> mobs) {

	    	int result=0;
	try {
		
		for(Mobiles mob:mobs) {
			String instemp="insert into mobiles values(name,price,ram,storage,seq.nextval)";
			
			instemp =instemp.replace("name", "'"+mob.getName()+"'")
			.replace("price",Long.toString(mob.getPrice()))
			.replace("ram", Long.toString(mob.getRam()))
			.replace("storage", Long.toString(mob.getStorage()));
			System.out.println(instemp);

				Statement stmt =  dataSource.getConnection().createStatement();
			result +=  stmt.executeUpdate(instemp);

		}

	} catch (SQLException e) {
		e.printStackTrace();
	}	
			return result;

	    }


	    public int insertMobile(Mobiles mob) {

	    	int result=0;
	try {
		String instemp="insert into mobiles values(name,price,ram,storage,seq.nextval)";

		if(mob!=null) {
			
			instemp =instemp.replace("name", "'"+mob.getName()+"'")
					.replace("price",Long.toString(mob.getPrice()))
					.replace("ram", Long.toString(mob.getRam()))
					.replace("storage", Long.toString(mob.getStorage()));
					System.out.println(instemp);
			
			System.out.println(instemp);

				Statement stmt =  dataSource.getConnection().createStatement();
			result =stmt.executeUpdate(instemp);

		}

	} catch (SQLException e) {
		e.printStackTrace();
	}	
			return result;

	    }

	    public int updateMobile(int mb) {
	    	Mobiles mob = new Mobiles();
	    	int result=0;
	try {
	            //update mobiles set name=?,price=?,ram=?,storage=? where mobile_id=?
				PreparedStatement preparestmt =  dataSource.getConnection().prepareStatement(updateMobile);
				//
				preparestmt.setString(1, mob.getName());
				preparestmt.setInt(2, mob.getPrice());
				preparestmt.setInt(3, mob.getRam());
				preparestmt.setInt(4, mob.getStorage());
				preparestmt.setInt(5, mb);
				
					 result =preparestmt.executeUpdate();


			} catch (SQLException e) {
				e.printStackTrace();
			}
	return result;

	    }


	    public int deleteMobile(int mobile_id) {
	    	int result=0;
	    	try {
	    				PreparedStatement preparestmt =  dataSource.getConnection().prepareStatement(deleteMobile);
	    				preparestmt.setInt(1, mobile_id);
	    			    result =preparestmt.executeUpdate();
	    			} catch (SQLException e) {
	    				e.printStackTrace();
	    			}
	    	return result;

	    }


	    public List<Mobiles> getMobiles(){
	    	List<Mobiles> mobiles = new ArrayList<Mobiles>();
	          Mobiles mob;

			try {

				Statement stmt = dataSource.getConnection().createStatement();
			ResultSet rs =stmt.executeQuery("select * from mobiles");			
				while(rs.next()) {
					mob=new Mobiles();
					mob.setName(rs.getString("name"));
					mob.setPrice(rs.getInt("price"));
					mob.setRam(rs.getInt("ram"));
					mob.setStorage(rs.getInt("storage"));
					mob.setMobile_id(rs.getInt("mobile_id"));
					mobiles.add(mob);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
	return mobiles;


	    }


		public  Mobiles getMobile(int mobile_id) {

			Mobiles mob =new Mobiles();

			try {

				Statement stmt = dataSource.getConnection().createStatement();
			ResultSet rs =stmt.executeQuery("select * from mobiles where mobile_id=" +mobile_id);			
				while(rs.next()) {
					mob=new Mobiles();
					mob.setName(rs.getString("name"));
					mob.setPrice(rs.getInt("price"));
					mob.setRam(rs.getInt("ram"));
					mob.setStorage(rs.getInt("storage"));
					mob.setMobile_id(rs.getInt("mobile_id"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
	return mob;
		}

}
