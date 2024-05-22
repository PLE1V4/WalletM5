package walletm5.usuario.model.service;

import java.util.List;

import walletm5.usuario.model.entidad.Usuario;

public interface UsuarioService {
	
	boolean registrarUsuario(Usuario usuario);
	boolean editarUsuario(Usuario usuario);
	Usuario obtenerUsuario(int id);
	Usuario obtenerPorEmail(String email);
	List<Usuario> listarUsuarios();

}
