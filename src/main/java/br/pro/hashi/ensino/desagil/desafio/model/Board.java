package br.pro.hashi.ensino.desagil.desafio.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

public class Board {
    private boolean[][] wall;
    private int numRows;
    private int numCols;


    public Board(String name) {

        // Abre um arquivo a partir de seu nome. Espera-se
        // que esse arquivo esteja em src/main/resources.
        URL url = getClass().getClassLoader().getResource(name);
        InputStream stream = null;
        try {
            stream = Objects.requireNonNull(url).openStream();
        } catch (IOException exception) {
            System.err.println("Não foi possível abrir o arquivo " + name);
            System.exit(1);
        }

        // Constrói um leitor para ler caracteres a partir de um arquivo aberto.
        // Queremos usar o método de conveniência readLine, mas ele não existe em
        // um leitor normal, então embrulhamos ele dentro de um BufferedReader.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {

            // Note que isto aqui é bem parecido com o que faríamos em Python!
            String[] words = reader.readLine().strip().split("\\s+");

            // Converte as palavras da primeira linha em inteiros.
            numRows = Integer.parseInt(words[0]);
            numCols = Integer.parseInt(words[1]);

            wall = new boolean[numRows][numCols];

            for (int i = 0; i < numRows; i++) {

                // Note que aqui não faz sentido usar strip ou split.
                String line = reader.readLine();

                for (int j = 0; j < numCols; j++) {

                    // A instrução switch não existe em Python, mas aqui é como se fosse uma
                    // sequência de if, else ifs e else. Para saber mais, consulte a página
                    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html.
                    switch (line.charAt(j)) {
                        case ' ':
                            wall[i][j] = false;
                            break;
                        case '#':
                            wall[i][j] = true;
                            break;
                        default:
                            throw new IOException("Configuração de tabuleiro deve ter apenas ' ' e '#'");
                    }
                }
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }
    }


    public boolean isWall(int row, int col) {
        return wall[row][col];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }
}
