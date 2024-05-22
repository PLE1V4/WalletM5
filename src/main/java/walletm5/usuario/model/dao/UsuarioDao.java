package walletm5.usuario.model.dao;

import java.util.List;

import walletm5.usuario.model.entidad.Usuario;

public interface UsuarioDao {
	
	boolean guardar(Usuario usuario);
	boolean editar(Usuario usuario);
	Usuario obtenerPorId(int id);
	Usuario obtenerPorEmail(String email);
	List<Usuario> getUsuarios();

}
