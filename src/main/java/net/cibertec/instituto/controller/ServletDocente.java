package net.cibertec.instituto.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cibertec.instituto.dao.MySqlDocenteDAO;
import net.cibertec.instituto.entity.Docente;

/**
 * Servlet implementation class ServletDocente
 */
@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MySqlDocenteDAO daoDocente = new MySqlDocenteDAO(); //crear objeto de la clase MySqlDocenteDAO
       
    public ServletDocente() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
		String nom, pat, mat, sexo, hijos, sue;
		
		//leer los controles del formulario (cajas, select)
		nom = request.getParameter("nombre");
		pat = request.getParameter("paterno");
		mat = request.getParameter("materno");
		sexo = request.getParameter("sexo");
		hijos = request.getParameter("hijos");
		sue = request.getParameter("sueldo");
		
		//crear objeto de la clase Docente
		Docente bean = new Docente();
		
		//setear los atributos del objeto "bean" con las variables
		bean.setNombre(nom);
		bean.setPaterno(pat);
		bean.setMaterno(mat);
		bean.setSexo(sexo);
		bean.setHijos(Integer.parseInt(hijos));
		bean.setSueldo(Double.parseDouble(sue));
		
		//invocar al metodo save
		daoDocente.save(bean);
		
		//direccionar a la pagina docente.jsp
		response.sendRedirect("docente.jsp");
	}

}
