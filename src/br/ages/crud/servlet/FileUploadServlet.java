package br.ages.crud.servlet;

import br.ages.crud.bo.EmpresaBO;
import br.ages.crud.bo.FichaSimplificadaBO;
import br.ages.crud.util.Constantes;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Grava a imagem no savePath.
 * É necessário passar o input com o name "file"
 * Servlet implementation class FileUploadServlet
 * Para a empresa é necessário gravar em um outro path.
 * @author Luis Santana
 */
@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024
		* 15, maxFileSize = Constantes.PROJETO_ARQUIVO_MAX_BYTES, maxRequestSize = 1024 * 1024 * 15)

public class FileUploadServlet extends HttpServlet {
	Logger logger = Logger.getLogger("servlet.FileUploadServlet");
	private static final long serialVersionUID = 2L;
	private static ResourceBundle configPath = ResourceBundle.getBundle(Constantes.AMBIENTE_PROPERTIES);

	private static final String SAVE_DIR = configPath.getString(Constantes.PROJETO_UPLOAD_PATH);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			logger.debug("Iniciando o Upload");
			int idFicha = 0;
			boolean empresa = Boolean.valueOf(request.getParameter("empresa"));
			boolean fichaSimplificada = Boolean.valueOf(request.getParameter("fichaSimplificada"));
			this.criaPastas();
			String appPath = "";
			String savePath = SAVE_DIR+File.separator+"upload"+File.separator;
			if(fichaSimplificada){
				idFicha = Integer.valueOf(request.getParameter("idFicha"));
				if(idFicha == 0){
					idFicha = new FichaSimplificadaBO().getProximoIdFicha();
				}
				appPath = "fichas"+File.separator+"ficha-"+idFicha;
				savePath += appPath;
			}
			if (empresa){
				appPath = "logo";
				savePath += appPath;
			}
			File fileSaveDir = new File(savePath);

			if (!fileSaveDir.exists())
				fileSaveDir.mkdir();
			String fileName;
			Part part = request.getPart("file");
			
			fileName = extractFileName(part); //NAO TERMINEI PQ ALISSA ME EXPULSOU DA AGES :(
			if(fichaSimplificada){
				//gravar foto ficha-id/foto-ficha-id.extensao
				fileName = "foto-ficha-"+idFicha+"."+FilenameUtils.getExtension(fileName);
			}

			if(empresa){
				int idEmpresa = Integer.valueOf(request.getParameter("idEmpresa"));
				if(idEmpresa == 0){
					idEmpresa = new EmpresaBO().getLastIdEmpresa();
				}
				//gravar nome logo-empresa-1.jpg
				fileName = "logo-empresa-"+idEmpresa+"."+FilenameUtils.getExtension(fileName);			
			} 
			part.write(new File(savePath + File.separator + fileName).toString());

			request.setAttribute("msgSucesso", "Upload feito com sucesso!");
			logger.info("Executado o Upload em: " + savePath + " - " + fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	private void criaPastas(){
		File pastaTmp = new File(SAVE_DIR+File.separator+"upload"+File.separator);
		if(!pastaTmp.exists()){
			pastaTmp.mkdir();
		}
		pastaTmp = new File(SAVE_DIR+File.separator+"upload"+File.separator+"fichas"+File.separator);
		if(!pastaTmp.exists()){
			pastaTmp.mkdir();
		}
		pastaTmp = new File(SAVE_DIR+File.separator+"upload"+File.separator+"logo"+File.separator);
		if(!pastaTmp.exists()){
			pastaTmp.mkdir();
		}
	}

}