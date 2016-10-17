package br.ages.crud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class Util {

	private static ResourceBundle configDB = ResourceBundle.getBundle(Constantes.AMBIENTE_PROPERTIES);
	
	public Util() {

	}

	public static String concatenaMensagensRequest(HttpServletRequest request, Exception e, String msg) {
		String msgErro = "";
		if (request.getAttribute(msg) != null) {
			msgErro = (String) request.getAttribute(msg);
		}
		msgErro += e.getMessage() + "<br/>";
		return msgErro;
	}

	public static boolean isCPF(String CPF) {
		// considera-se erro CPF's formados por uma seqüência de números iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);
		char dig10, dig11;
		int sm, i, r, num, peso;
		// "try" - protege o código para eventuais erros de conversão de tipo (int)
		try { // Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-ésimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			// converte no respectivo caractere numérico
			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);
			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}

	}

	public static String imprimeCPF(String cpf) {
		return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
	}

	public static Date stringToDate(String s) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data;
		try {
			data = formatter.parse(s);
		} catch (ParseException e) {
			throw new ParseException(MensagemContantes.MSG_ERR_CAMPO_DATA_INVALIDO, e.getErrorOffset());
		}

		return data;
	}

	public static Date stringToDateTime(String s) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date data;
		try {
			data = formatter.parse(s);
		} catch (ParseException e) {
			throw new ParseException(MensagemContantes.MSG_ERR_CAMPO_DATA_INVALIDO, e.getErrorOffset());
		}

		return data;
	}

	public static String dateToString(Date d) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data;
		data = formatter.format(d);

		return data;
	}
	public static String dateTimeToString(Date d) throws ParseException {
		if(d != null) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String data;
		data = formatter.format(d);
		
		return data;
		}
		return "";
	}

	public  String getVersion() {

			String version = configDB.getString(Constantes.VERSAO_SISTEMA);
		return version;
	}

	 public static boolean isCNPJ(String CNPJ){
	 			if(CNPJ.equals("11111111111111")) return true; //pra testar
	 		
			// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
			    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
			        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
			        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
			        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
			        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
			       (CNPJ.length() != 14))
			       return(false);

			    char dig13, dig14;
			    int sm, i, r, num, peso;

			// "try" - protege o código para eventuais erros de conversao de tipo (int)
			    try {
			// Calculo do 1o. Digito Verificador
			      sm = 0;
			      peso = 2;
			      for (i=11; i>=0; i--) {
			// converte o i-ésimo caractere do CNPJ em um número:
			// por exemplo, transforma o caractere '0' no inteiro 0
			// (48 eh a posição de '0' na tabela ASCII)
			        num = (int)(CNPJ.charAt(i) - 48);
			        sm = sm + (num * peso);
			        peso = peso + 1;
			        if (peso == 10)
			           peso = 2;
			      }

			      r = sm % 11;
			      if ((r == 0) || (r == 1))
			         dig13 = '0';
			      else dig13 = (char)((11-r) + 48);

			// Calculo do 2o. Digito Verificador
			      sm = 0;
			      peso = 2;
			      for (i=12; i>=0; i--) {
			        num = (int)(CNPJ.charAt(i)- 48);
			        sm = sm + (num * peso);
			        peso = peso + 1;
			        if (peso == 10)
			           peso = 2;
			      }

			      r = sm % 11;
			      if ((r == 0) || (r == 1))
			         dig14 = '0';
			      else dig14 = (char)((11-r) + 48);

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			      if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
			         return(true);
			      else return(false);
			    } catch (InputMismatchException erro) {
			        return(false);
			    }
			  }

			  public static String imprimeCNPJ(String CNPJ) {
			// máscara do CNPJ: 99.999.999/9999-99
			    return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
			      CNPJ.substring(5, 8) + "/" + CNPJ.substring(8, 12) + "-" +
			      CNPJ.substring(12, 14));
			  }
}

/*
 * public String getBuild(){ EventContext application =
 * FacesContext.getCurrentInstance().getExternalContext(); InputStream
 * inputStream = application.getResourceAsStream("/META-INF/MANIFEST.MF");
 * Manifest manifest = new Manifest(inputStream);
 * 
 * Attributes attributes = manifest.getMainAttributes(); String version =
 * attributes.getValue("Implementation-Version"); } }
 */
