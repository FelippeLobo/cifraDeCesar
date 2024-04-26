/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cifraDeCesar;

/**
 *
 * @author felip
 */
public class CifraDeCesar {
    
    public static String cifraDeCesar(String texto, int chave) {
        StringBuilder textoCifrado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (Character.isLetter(letra)) {
                char limiteInferior, limiteSuperior;
                if (Character.isLowerCase(letra)) {
                    limiteInferior = 'a';
                    limiteSuperior = 'z';
                } else {
                    limiteInferior = 'A';
                    limiteSuperior = 'Z';
                }
                int valorAscii = (int) letra;
                int novoValorAscii = (valorAscii - limiteInferior + chave) % 26 + limiteInferior;
                textoCifrado.append((char) novoValorAscii);
            } else {
                textoCifrado.append(letra); // Mantém caracteres não alfabéticos
            }
        }
        return textoCifrado.toString();
    }

    public static void main(String[] args) {
        String textoOriginal = "Hello, World!";
        int chave = 3;
        String textoCifrado = cifraDeCesar(textoOriginal, chave);
        System.out.println("Texto cifrado: " + textoCifrado);
    }
}
