package dog.club.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog.club.domain.BoardContent;
import dog.club.domain.DogVO;
import dog.club.persistence.BoardConDAO;

/**
 * Servlet implementation class BoardService
 */
@WebServlet("/BoardService")
public class BoardService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardService() {
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

		PrintWriter out = response.getWriter();
		
		String cmd="";
		String contno="";
		cmd=request.getParameter("key");
		contno=request.getParameter("contno");
		
		//내댕소 부분
				if(cmd.equals("dog_board")) {
					response.sendRedirect("dog_board.jsp");
				}
				else if(cmd.equals("add_board")) {
					response.sendRedirect("add_board.jsp");
				}
				else if(cmd.equals("view_board")) {
					if(contno!=null) {
						request.setAttribute("contno", contno);
						RequestDispatcher view = request.getRequestDispatcher("view_board.jsp");
						view.forward(request, response);
					}
				}
				else if(cmd.equals("delete_board")) {
					if(contno!=null) {
						BoardConDAO boardconDAO = new BoardConDAO();
						
						String temp="DELETE NOT OK";
						if(boardconDAO.delete(contno))temp="DELETE OK";
						
						RequestDispatcher view = request.getRequestDispatcher("dog_board.jsp");
						view.forward(request, response);
					}
				}
				else if(cmd.equals("update_board")) {
					if(contno!=null) {
						request.setAttribute("contno", contno);
						RequestDispatcher view = request.getRequestDispatcher("edit_board.jsp");
						view.forward(request, response);
					}
				}
				
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd="";
		String contno="";
		cmd=request.getParameter("key");
		contno=request.getParameter("contno");
		
		if(cmd.equals("add_board")) {
			HttpSession session = request.getSession();
			DogVO client=(DogVO)session.getAttribute("loginclient");
			
			String realFolder = request.getServletContext().getRealPath("/FileUpload");
			String fileFullpath="";

			BoardContent addcontent = new BoardContent();
			BoardConDAO boardDAO = new BoardConDAO();
			
			int size = 10*1024*1024;
			
			MultipartRequest multi=new MultipartRequest(request,realFolder,size,"utf-8",new DefaultFileRenamePolicy());
			 
	        //파일 객체 얻기
			String title=multi.getParameter("title");
			String content=multi.getParameter("content");
			String filename = multi.getFilesystemName("ImageFile");
			if(filename!=null) {
			   	fileFullpath=realFolder+"/"+filename;
			   }
			else if(filename==null) {
			   	fileFullpath="FileUpload/default_img.jpg";
			}
		    
		    addcontent.setTitle(title);
		    addcontent.setImagefile(fileFullpath);
		    addcontent.setId(client.getId());
		    addcontent.setContent(content);
		    
		    String temp="ADD NOT OK";
			if(boardDAO.add(addcontent))temp="ADD OK";

			request.setAttribute("result", temp);
			request.setAttribute("addCon", addcontent);
			
			RequestDispatcher view = request.getRequestDispatcher("fileUpload.jsp");
			view.forward(request, response);
		}
		
		else if(cmd.equals("update_board")) {
			if(contno!=null) {
				String realFolder = request.getServletContext().getRealPath("FileUpload");
				String fileFullpath="";
				
				BoardConDAO boardconDAO = new BoardConDAO();
				BoardContent previous = boardconDAO.checkboard(contno);
				BoardContent updatecontent = new BoardContent();
				int size = 10*1024*1024;
				
				MultipartRequest multi=new MultipartRequest(request,realFolder,size,"utf-8",new DefaultFileRenamePolicy());
				 
		        //파일 객체 얻기
				String title=multi.getParameter("title");
				String content=multi.getParameter("content");
			    String filename = multi.getFilesystemName("ImageFile");
			    if(filename!=null) {
			    	fileFullpath=realFolder+"/"+filename;
			    }
			    else if(filename==null) {
			    	fileFullpath=previous.getImagefile();
			    }
			    
			    updatecontent.setNo(Integer.parseInt(contno));
			    updatecontent.setTitle(title);
			    updatecontent.setImagefile(fileFullpath);
			    updatecontent.setId(previous.getId());
			    updatecontent.setContent(content);
				
			    boardconDAO.update(updatecontent);
			    
			    request.setAttribute("updatecon", updatecontent);
				RequestDispatcher view = request.getRequestDispatcher("edit_result.jsp");
				view.forward(request, response);
			}
		}
		doGet(request, response);
	}

}
