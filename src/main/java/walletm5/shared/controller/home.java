package walletm5.shared.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import walletm5.cuenta.model.dao.CuentaDao;
import walletm5.cuenta.model.dao.impl.CuentaDaoImpl;
import walletm5.cuenta.model.entidad.Cuenta;
import walletm5.cuenta.model.service.CuentaService;
import walletm5.cuenta.model.service.impl.CuentaServiceImpl;
import walletm5.moneda.model.dao.MonedaDao;
import walletm5.moneda.model.dao.impl.MonedaDaoImpl;
import walletm5.moneda.model.entidad.Moneda;
import walletm5.moneda.model.service.MonedaService;
import walletm5.moneda.model.service.impl.MonedaServiceImpl;
import walletm5.usuario.model.dao.UsuarioDao;
import walletm5.usuario.model.dao.impl.UsuarioDaoImpl;
import walletm5.usuario.model.entidad.Usuario;
import walletm5.usuario.model.service.UsuarioService;
import walletm5.usuario.model.service.impl.UsuarioServiceImpl;
import walletm5.wallet.model.dao.WalletDao;
import walletm5.wallet.model.dao.impl.WalletDaoImpl;
import walletm5.wallet.model.entidad.Wallet;
import walletm5.wallet.model.service.WalletService;
import walletm5.wallet.model.service.impl.WalletServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class home
 */
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao;
	private WalletDao walletDao;
	private CuentaDao cuentaDao;
    private UsuarioService usuarioService;
    private WalletService walletService;
    private CuentaService cuentaService;
    private MonedaDao monedaDao;
    private MonedaService monedaService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		usuarioDao = new UsuarioDaoImpl();
		usuarioService = new UsuarioServiceImpl(usuarioDao);
		walletDao = new WalletDaoImpl();
		walletService = new WalletServiceImpl(walletDao);
		cuentaDao = new CuentaDaoImpl();
		cuentaService = new CuentaServiceImpl(cuentaDao); 
		monedaDao = new MonedaDaoImpl();
		monedaService = new MonedaServiceImpl(monedaDao);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int userId = (Integer) session.getAttribute("userId");
		Usuario user = usuarioService.obtenerUsuario(userId);
		Wallet wallet = walletService.getWalletByUser(userId);
		Cuenta cuenta = cuentaService.obtenerPorNumero(wallet.getAccNumber());
		Moneda currency = monedaService.obtenerPorId(cuenta.getId_moneda());
		
		req.setAttribute("userNombres", user.getNombres() );
		req.setAttribute("userApellidos",user.getApellidos());
		req.setAttribute("accBalance",cuenta.getSaldo());
		req.setAttribute("currencySymbol",currency.getCurrency_symbol());
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("/view/home.jsp");
		dispatcher.forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
