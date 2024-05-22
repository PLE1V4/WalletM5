package walletm5.usuario.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import walletm5.shared.dao.DAO;
import walletm5.usuario.model.dao.UsuarioDao;
import walletm5.usuario.model.entidad.Usuario;

public class UsuarioDaoImpl extends DAO implements UsuarioDao {

	@Override
	public boolean guardar(Usuario usuario) {
		
		String nombres= usuario.getNombres();
		String apellidos= usuario.getApellidos();
		String email = usuario.getEmail();
		String password = usuario.getPassword();
		
		String query="insert into usuarios (nombres,apellidos,email,contrasena)";
		query+=" values('"+nombres+"','"+apellidos+"','"+email+"','"+password+"')";
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public boolean editar(Usuario usuario) {

		String nombres= usuario.getNombres();
		String apellidos= usuario.getApellidos();
		String email = usuario.getEmail();
		String password = usuario.getPassword();
		
		String query="update  usuarios ";
		query+=" set nombres='"+nombres+"', apellidos='"+apellidos+"', email='"+email+"',contrasena='"+password+"'";
		query+=" where id="+usuario.getId();
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public Usuario obtenerPorId(int id) {
		try {
			Usuario usuario=null;
		
		
			String query="select user_id,nombres,apellidos,email,contrasena from usuarios where user_id="+id;
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
					int idUser=rsl.getInt("user_id");
					String nombres=rsl.getString("nombres");
					String apellidos= rsl.getString("apellidos");
					String email= rsl.getString("email");
					String password = rsl.getString("contrasena");
				
					usuario= new Usuario(idUser,nombres,apellidos, email,password);
				
			}
			
			return usuario;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	
	

	@Override
	public Usuario obtenerPorEmail(String email) {
		try {
			Usuario usuario=null;		
		
			String query="select user_id,nombres,apellidos,email,contrasena from usuarios where email='"+email+"'";
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
					int idUser=rsl.getInt("user_id");
					String userNombres=rsl.getString("nombres");
					String serApellidos= rsl.getString("apellidos");
					String userEmail= rsl.getString("email");
					String userPassword = rsl.getString("contrasena");
				
					usuario= new Usuario(idUser,userNombres,serApellidos, userEmail,userPassword);
				
			}
			
			return usuario;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Usuario> getUsuarios() {
		
		try {
			List<Usuario> listado= new ArrayList<>();
		
		
			String query="select user_id, nombres,apellidos,email, contrasena from usuarios";
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
				
					int id = rsl.getInt("user_id");
					String nombres=rsl.getString("nombres");
					String apellidos= rsl.getString("apellidos");
					String email= rsl.getString("email");
					String password = rsl.getString("contrasena");
				
					Usuario user= new Usuario(id,nombres,apellidos,email,password);
					listado.add(user);
				
			}
			
			return listado;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
