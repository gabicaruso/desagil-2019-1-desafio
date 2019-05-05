package br.pro.hashi.ensino.desagil.desafio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

public class Board {
    boolean[][] wall;
    int numRows;
    int numCols;


    void load(String name) throws IOException {

        // Abre um arquivo a partir de seu nome. Espera-se
        // que esse arquivo esteja em src/main/resources.
        URL url = getClass().getClassLoader().getResource(name);
        InputStream stream = Objects.requireNonNull(url).openStream();

        // Constrói um leitor para ler caracteres a partir de um arquivo aberto.
        // Queremos usar o método de conveniência readLine, mas ele não existe em
        // um leitor normal, então embrulhamos ele dentro de um BufferedReader.
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        // Note que isto aqui é bem parecido com o que faríamos em Python!
        String[] words = reader.readLine().strip().split("\\s+");

        // Converte as palavras da primeira linha em inteiros.
        numRows = Integer.parseInt(words[0]);
        numCols = Integer.parseInt(words[1]);

        wall = new boolean[numRows][numCols];

        for (int i = 0; i < numRows; i++) {

            // Note que aqui não faz sentido usar strip ou split.
            String line = reader.readLine();

            int f = 0;

            for (char e : line.toCharArray()) {
                if (e == '#') {
                    wall[i][f] = true;
                }
                else {
                    wall[i][f] = false;
                }
                f++;
            }

            System.out.println(line);
        }

        reader.close();
    }
}
