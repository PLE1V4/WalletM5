package walletm5.shared.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import walletm5.transaction.model.dao.TransactionDao;
import walletm5.transaction.model.dao.impl.TransactionDaoImpl;
import walletm5.transaction.model.entidad.Transaction;
import walletm5.transaction.model.service.TransactionService;
import walletm5.transaction.model.service.impl.TransactionServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Movimientos
 */
public class Movimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TransactionDao transactionDao;
	private TransactionService transactionService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movimientos() {
    	transactionDao = new TransactionDaoImpl();
    	transactionService = new TransactionServiceImpl(transactionDao);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");	
		List<Transaction> transactions = transactionService.getTransactionsByUser(userId);
		
		request.setAttribute("transactions", transactions);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/view/movimientos.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
