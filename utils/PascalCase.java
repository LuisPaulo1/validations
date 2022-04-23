public class PascalCase {

	public static String toPascalCase(String texto) {

		if (texto != null && !texto.isBlank()) {
			StringBuilder sb = new StringBuilder();
			String[] palavras = texto.split(" ");

			for (int i = 0; i < palavras.length; i++) {
				String p = palavras[i].toLowerCase();
				String primeiraLetra = String.valueOf(p.charAt(0));
				p = primeiraLetra.toUpperCase() + p.substring(1);
				sb.append(p + " ");
			}
			return sb.toString().trim();
		}

		return texto;
	}

}
