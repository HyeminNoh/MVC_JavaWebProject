package dog.club.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dog.club.domain.DogVO;
import dog.club.persistence.DogDAO;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("(GET)Served at: ").append(request.getContextPath());

		String cmd="";
		cmd=request.getParameter("key");
		
		if(cmd.equals("join")) {
			response.sendRedirect("join.html");
		}
		else if(cmd.equals("login")) {
			response.sendRedirect("login.html");
		}
		else if(cmd.equals("logout")) {
			HttpSession session = request.getSession();
			if(session!=null) {
				session.invalidate();
			}
			response.sendRedirect("welcome.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("(POST)Served at: ").append(request.getContextPath());
		
		String cmd="";
		cmd=request.getParameter("key");
		
		if(cmd.equals("join")) {
			DogVO dogVO=new DogVO();
			
			DogDAO dogDAO=new DogDAO();
			
			dogVO.setUsername(request.getParameter("username"));
			dogVO.setId(request.getParameter("id"));
			dogVO.setPassword(request.getParameter("password"));
			dogVO.setDogname(request.getParameter("dogname"));
			dogVO.setDogage(Integer.parseInt(request.getParameter("dogage")));
			dogVO.setDogsex(request.getParameter("dogsex"));
			dogVO.setDogtype(request.getParameter("dogtype"));
			
			String temp="JOIN NOT OK";
			if(dogDAO.add(dogVO))temp="JOIN OK";
			
			request.setAttribute("result", temp);
			request.setAttribute("client",dogVO);
			
			RequestDispatcher view = request.getRequestDispatcher("join_result.jsp");
			view.forward(request, response);
		}
		
		else if(cmd.equals("logincheck")) {
			/*로그인하는 경우 기존 회원정보와 확인이 필요함, 따라서 logincheck로 id와 password확인*/
			HttpSession session = request.getSession();
			
			String id = request.getParameter("id");
			String pw = request.getParameter("password");
			
			DogDAO dogDAO=new DogDAO();
			DogVO loginClient = new DogVO();
			
			int check = dogDAO.loginCheck(id,pw);
			
			if(check==1){
				loginClient=dogDAO.loginClient(id,pw);
				session.setAttribute("loginclient",loginClient);
				
				RequestDispatcher view = request.getRequestDispatcher("main.jsp");
				view.forward(request, response);
			}
			else if(check==0){
				response.sendRedirect("login.html");
			}
			else if(check==-1){
				response.sendRedirect("login.html");
			}
		}
		doGet(request, response);
	}

}
