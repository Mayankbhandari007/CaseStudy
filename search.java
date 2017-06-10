package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchProd
 */
public class searchProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter pw=response.getWriter();
		String search=request.getParameter("search");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"system",
					"oracle");
			
			ArrayList<String> al = null;
            ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
			String query="select * from products1 where sc_id = (select sc_id from sub_cat where sc_name = ?) or c_id = (select c_id from category where c_name = ?) or prod_name=?";
			

			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, search);
			ResultSet rs=ps.executeQuery(query);
			
			while (rs.next()) {
                al = new ArrayList<String>();
 
                al.add(rs.getString(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(4));
                al.add(rs.getString(5));
                al.add(rs.getString(6));
 
                System.out.println("al :: " + al);
                result.add(al);
            }
 
            request.setAttribute("result", result);
            RequestDispatcher view = request.getRequestDispatcher("search.jsp");
            view.forward(request, response);
            con.close();
            System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
