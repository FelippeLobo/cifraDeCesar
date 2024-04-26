/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifraDeCesar;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author felip
 */
public class Criptoanalise {

    public static String criptoanalise(String textoCifrado) {
        // Frequência de ocorrência das letras no idioma português
        Map<Character, Integer> frequenciaPortuguesa = new HashMap<>();
        frequenciaPortuguesa.put('a', 14810);
        frequenciaPortuguesa.put('b', 1380);
        frequenciaPortuguesa.put('c', 2780);
        frequenciaPortuguesa.put('d', 4120);
        frequenciaPortuguesa.put('e', 12500);
        frequenciaPortuguesa.put('f', 2190);
        frequenciaPortuguesa.put('g', 1030);
        frequenciaPortuguesa.put('h', 770);
        frequenciaPortuguesa.put('i', 6800);
        frequenciaPortuguesa.put('j', 470);
        frequenciaPortuguesa.put('k', 300);
        frequenciaPortuguesa.put('l', 4700);
        frequenciaPortuguesa.put('m', 2980);
        frequenciaPortuguesa.put('n', 6252);
        frequenciaPortuguesa.put('o', 10926);
        frequenciaPortuguesa.put('p', 4002);
        frequenciaPortuguesa.put('q', 1250);
        frequenciaPortuguesa.put('r', 6530);
        frequenciaPortuguesa.put('s', 7270);
        frequenciaPortuguesa.put('t', 4700);
        frequenciaPortuguesa.put('u', 5470);
        frequenciaPortuguesa.put('v', 210);
        frequenciaPortuguesa.put('w', 210);
        frequenciaPortuguesa.put('x', 510);
        frequenciaPortuguesa.put('y', 210);
        frequenciaPortuguesa.put('z', 210);

        // Contagem da ocorrência de cada letra no texto cifrado
        Map<Character, Integer> frequenciaTexto = new HashMap<>();
        for (char letra : textoCifrado.toCharArray()) {
            if (Character.isLetter(letra)) {
                letra = Character.toLowerCase(letra);
                int count = frequenciaTexto.getOrDefault(letra, 0);
                frequenciaTexto.put(letra, count + 1);
            }
        }

        // Encontrar a letra mais comum no texto cifrado
        char letraMaisComum = ' ';
        int maxOcorrencias = 0;
        for (Map.Entry<Character, Integer> entry : frequenciaTexto.entrySet()) {
            char letra = entry.getKey();
            int ocorrencias = entry.getValue();
            if (ocorrencias > maxOcorrencias) {
                maxOcorrencias = ocorrencias;
                letraMaisComum = letra;
            }
        }

        // Calcular a diferença entre as frequências
        int diferenca = letraMaisComum - 'e';

        // Decifrar o texto
        StringBuilder textoDecifrado = new StringBuilder();
        for (char letra : textoCifrado.toCharArray()) {
            if (Character.isLetter(letra)) {
                char decifrado = (char) (letra - diferenca);
                if (decifrado < 'a') {
                    decifrado += 26; // Tratamento para letras que passam abaixo de 'a'
                }
                textoDecifrado.append(decifrado);
            } else {
                textoDecifrado.append(letra);
            }
        }

        return textoDecifrado.toString();
    }

    public static void main(String[] args) {
        String textoCifrado = "Uifsf jt b tfdsfu ujnf jt tjy bcpvu uif jsbopst pg hbnft up nblf b mmfhbmmz buubdl. Gps bwbjmbcmf, uifjs efnboe't ejtdpwfsz jt uifjs cfuxffo dspxe -- uifz'sf nboz ejtdpwfsz. Uifsf't op efgjojufmz ublf uifz'sf tujdl, cvu uifsf't op epdups ublf uifz'sf lopxmz.";
        String textoDecifrado = criptoanalise(textoCifrado);
        System.out.println("Texto decifrado: " + textoDecifrado);
    }
}