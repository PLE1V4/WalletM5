package walletm5.shared.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import walletm5.contact.model.dao.ContactoDao;
import walletm5.contact.model.dao.impl.ContactoDaoImpl;
import walletm5.contact.model.entidad.Contacto;
import walletm5.contact.model.service.ContactoService;
import walletm5.contact.model.service.impl.ContactoServiceImpl;
import walletm5.cuenta.model.dao.CuentaDao;
import walletm5.cuenta.model.dao.impl.CuentaDaoImpl;
import walletm5.cuenta.model.entidad.Cuenta;
import walletm5.cuenta.model.service.CuentaService;
import walletm5.cuenta.model.service.impl.CuentaServiceImpl;
import walletm5.transaction.model.dao.TransactionDao;
import walletm5.transaction.model.dao.impl.TransactionDaoImpl;
import walletm5.transaction.model.entidad.Transaction;
import walletm5.transaction.model.service.TransactionService;
import walletm5.transaction.model.service.impl.TransactionServiceImpl;
import walletm5.wallet.model.dao.WalletDao;
import walletm5.wallet.model.dao.impl.WalletDaoImpl;
import walletm5.wallet.model.entidad.Wallet;
import walletm5.wallet.model.service.WalletService;
import walletm5.wallet.model.service.impl.WalletServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private WalletDao walletDao;
	private CuentaDao cuentaDao;
	private TransactionDao transactionDao;
    private WalletService walletService;
    private CuentaService cuentaService;
    private TransactionService transactionService;
    
    
   
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		walletDao = new WalletDaoImpl();
		walletService = new WalletServiceImpl(walletDao);
		cuentaDao = new CuentaDaoImpl();
		cuentaService = new CuentaServiceImpl(cuentaDao); 
		transactionDao = new TransactionDaoImpl();
		transactionService = new TransactionServiceImpl(transactionDao);
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		Wallet wallet = walletService.getWalletByUser(userId);
		Cuenta cuenta = cuentaService.obtenerPorNumero(wallet.getAccNumber());
		
		
		request.setAttribute("saldo",cuenta.getSaldo());
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/view/deposit.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");		
		double amount = Double.parseDouble(request.getParameter("depositAmount"));
		Wallet wallet = walletService.getWalletByUser(userId);
		Cuenta cuenta = cuentaService.obtenerPorNumero(wallet.getAccNumber());
		Transaction transaction = new Transaction();
		boolean resultado;
		
		if(amount > 0 ) {
			cuenta.setSaldo(cuenta.getSaldo() + amount );
			cuentaService.editar(cuenta);
			transaction.setAmount(amount);
			transaction.setSernderId(userId);
			transaction.setReceiverId(cuenta.getNumeroCuenta());
			transaction.setTipo(1);
			transactionService.guardar(transaction);
			resultado = true;
			
		}else {
			resultado = false;
		}
		
		String url = resultado? "/home" : "/view/error.jsp"; 
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
