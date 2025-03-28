package dao;

import model.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO extends DAO {	
	public CarroDAO() {
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Carro carro) {
		boolean status = false;
		try {
			String sql = "INSERT INTO carro (placa, modelo, marca, ano, garagem_id) "
		               + "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement st = conexao.prepareStatement(sql);
		    st.setString(1, carro.getPlaca());
			st.setString(2, carro.getModelo());
			st.setString(3, carro.getMarca());
			st.setInt(4, carro.getAno());
			st.setInt(5, carro.getGaragemId());
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Carro get(int id) {
		Carro carro = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro WHERE id="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	carro = new Carro(rs.getInt("id"), 
	        	                 rs.getString("placa"), 
	        	                 rs.getString("modelo"),
	        	                 rs.getString("marca"),
	        	                 rs.getInt("ano"),
	        	                 rs.getInt("garagem_id"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carro;
	}
	
	public List<Carro> get() {
		return get("");
	}

	public List<Carro> getOrderByID() {
		return get("id");		
	}
	
	public List<Carro> getOrderByPlaca() {
		return get("placa");		
	}
	
	public List<Carro> getOrderByModelo() {
		return get("modelo");		
	}
	
	public List<Carro> getOrderByMarca() {
		return get("marca");		
	}
	
	public List<Carro> getByGaragem(int garagemId) {
		List<Carro> carros = new ArrayList<Carro>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro WHERE garagem_id = " + garagemId;
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Carro c = new Carro(rs.getInt("id"), 
	        	                   rs.getString("placa"), 
	        	                   rs.getString("modelo"),
	        	                   rs.getString("marca"),
	        	                   rs.getInt("ano"),
	        	                   rs.getInt("garagem_id"));
	            carros.add(c);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}
	
	private List<Carro> get(String orderBy) {
		List<Carro> carros = new ArrayList<Carro>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Carro c = new Carro(rs.getInt("id"), 
	        	                   rs.getString("placa"), 
	        	                   rs.getString("modelo"),
	        	                   rs.getString("marca"),
	        	                   rs.getInt("ano"),
	        	                   rs.getInt("garagem_id"));
	            carros.add(c);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}
	
	public boolean update(Carro carro) {
		boolean status = false;
		try {  
			String sql = "UPDATE carro SET placa = ?, modelo = ?, marca = ?, ano = ?, garagem_id = ? WHERE id = ?";
			PreparedStatement st = conexao.prepareStatement(sql);
		    st.setString(1, carro.getPlaca());
			st.setString(2, carro.getModelo());
			st.setString(3, carro.getMarca());
			st.setInt(4, carro.getAno());
			st.setInt(5, carro.getGaragemId());
			st.setInt(6, carro.getId());
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM carro WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Carro getByPlaca(String placa) {
		Carro carro = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro WHERE placa = '" + placa + "'";
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	carro = new Carro(rs.getInt("id"), 
	        	                 rs.getString("placa"), 
	        	                 rs.getString("modelo"),
	        	                 rs.getString("marca"),
	        	                 rs.getInt("ano"),
	        	                 rs.getInt("garagem_id"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carro;
	}
}