package walletm5.usuario.model.service.impl;

import java.util.List;

import walletm5.usuario.model.dao.UsuarioDao;
import walletm5.usuario.model.entidad.Usuario;
import walletm5.usuario.model.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDao usuarioDao;
	
	

	public UsuarioServiceImpl(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public boolean registrarUsuario(Usuario usuario) {

		if(usuario != null 
				&& usuario.getNombres() !=null
				&& usuario.getApellidos() !=null 
				&& usuario.getEmail() != null
				&& usuario.getPassword() != null
				&& !usuario.getNombres().isBlank() 
				&& !usuario.getApellidos().isBlank()
				&& !usuario.getEmail().isBlank() 
				&& !usuario.getPassword().isBlank() 
				 ){
			
			return usuarioDao.guardar(usuario);
		} else {
			
			return false;
		}
	}

	@Override
	public boolean editarUsuario(Usuario usuario) {
		if(usuario.getId()>0) {
			usuarioDao.editar(usuario);
			return true;
		}
		return false;
	}

	@Override
	public Usuario obtenerUsuario(int id) {
		return usuarioDao.obtenerPorId(id);
	}
	
	

	@Override
	public Usuario obtenerPorEmail(String email) {
		return usuarioDao.obtenerPorEmail(email);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDao.getUsuarios();
	}

}
