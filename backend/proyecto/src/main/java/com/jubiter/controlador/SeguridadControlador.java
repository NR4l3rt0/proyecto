

package com.jubiter.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este controlador sirve de ejemplo para ser devuelto cuando se hace uso de SpringSecurity
 * en la funcionalidad del aplicativo.
 * 
 * @author nr_alberto
 *
 */
@RestController
@RequestMapping("/auth")
public class SeguridadControlador {

	/**
	 * Método devuelto tras autenticarse.
	 * 
	 * @return una página simple embellecida con CSS.
	 */
	@GetMapping("/login")
	public String informar() {
		return "<html>"
				+ "<head>"
				+ "<style> "
				+ "div {"
					+ " width: 20rem;"
					+ " height: 6.5rem;"
					+ " background-color: red;"
					+ " position: relative;"
					+ " animation-name: example;"
					+ " animation-duration: 4s;"
					+ " animation-iteration-count: 3;"
					+ " margin: auto;"
					+ "}"		
					+ "@keyframes example {"
					+ "  0%   {background-color:red; left:0px; top:0px;}"
					+ "  25%  {background-color:yellow; left:200px; top:0px;}"
					+ "  50%  {background-color:blue; left:200px; top:200px;}"
					+ "  75%  {background-color:green; left:0px; top:200px;}"
					+ "  100% {background-color:red; left:0px; top:0px;}"
					+ "	}"
					+ "h1 {"
					+ "font: italic small-caps bold 2.5rem/3rem Georgia, serif;"
					+ "text-align: center;"
					+ "}>"
					+ "</style>"
					+ "</head>"
					+ "<body> "
						+ "<div>"
							+ "<h1>"
								+ "Biendvenido, ¡admin! "
							+ "</h1>"
						+ "</div>" 
				+ "</body>"
			+ "</html>";
	}
}

