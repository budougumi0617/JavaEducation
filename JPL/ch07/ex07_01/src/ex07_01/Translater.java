package ex07_01;

public class Translater {
	StringBuilder outputBuilder = new StringBuilder();

	public String getUnicode() {
		String resultString;
		outputBuilder.append("package ex07_01;");
		outputBuilder.append(" ");
		outputBuilder.append(" public class HelloWorldUnicode {");
		outputBuilder.append(" ");
		outputBuilder.append("/**");
		outputBuilder.append(" * @param args1");
		outputBuilder.append(" */");
		outputBuilder.append("public static void main(String[] args) {");
		outputBuilder.append("System.out.println(\"Hello, World\");");
		outputBuilder.append("}");
		outputBuilder.append("}");
		return convertToUnicode(outputBuilder.toString());
	}

	private static String convertToUnicode(String original) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < original.length(); i++) {
			sb.append(String.format("\\u%04X",
					Character.codePointAt(original, i)));
		}

		return sb.toString();
	}
}
