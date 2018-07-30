package pl.sda.java;


import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);

        System.out.println("Gra kółko i krzyżyk,\nPodaj rozmiar planszy na jakiej chcesz zagrać:");
        int dimension = sc.nextInt();

        char[][] board = new char[dimension][dimension];

        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                board[i][j] = ' ';
            }
        }

        // Ustawienie pierwszego gracza
        char currentPlayer = 'x';


        while(true) {
            for(int i = 0; i < dimension; i++) {
                for(int j = 0; j < dimension; j++) {
                    System.out.print(board[i][j]);

                    if(j != dimension - 1) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();

                if(i != dimension - 1) {
                    for (int j = 0; j < dimension; j++) {
                        System.out.print("-");
                        if (j != dimension - 1) {
                            System.out.print("-+-");
                        }
                    }
                    System.out.println();
                }
            }

            System.out.println("Podaj współrzędną wiersza zaczynając od 0:");
            int x = sc.nextInt();

            System.out.println("Podaj współrzędną kolumny zaczynając od 0:");
            int y = sc.nextInt();

            if(board[x][y] == ' ') {
                board[x][y] = currentPlayer;

                if(currentPlayer == 'x') {
                    currentPlayer = 'o';
                } else {
                    currentPlayer = 'x';
                }
            } else {
                System.out.println("Pole już jest zajęte, wybierz jeszcze raz");
            }

            // Sprawdzenie zwycięztwa po wierszach

            for(int i = 0; i < dimension; i++) {
                int countX = 0;
                int countO = 0;

                for(int j = 0; j < dimension; j++) {
                    if(board[i][j] == 'x') {
                        countX++;
                    } else if(board[i][j] == 'o') {
                        countO++;
                    }
                }

                if(countX == dimension) {
                    System.out.println("Wygrał X");

                    System.out.println();
                    return;
                } else if(countO == dimension) {

                    return;
                }
            }

            // Sprawdzenie zwycięztwa po kolumnach

            for(int i = 0; i < dimension; i++) {
                int countX = 0;
                int countO = 0;

                for(int j = 0; j < dimension; j++) {
                    if(board[j][i] == 'x') {
                        countX++;
                    } else if(board[j][i] == 'o') {
                        countO++;
                    }
                }

                if(countX == dimension) {
                    System.out.println("Wygrał X");
                    return;
                } else if(countO == dimension) {
                    System.out.println("Wygrało O");
                    return;
                }
            }

            // Sprawdzenie zwycięztwa po przekątnej

            {
                int countX = 0;
                int countO = 0;

                for (int i = 0; i < dimension; i++) {
                    if (board[i][i] == 'x') {
                        countX++;
                    } else if (board[i][i] == 'o') {
                        countO++;
                    }
                }

                if (countX == dimension) {
                    System.out.println("Wygrał X");
                    return;
                } else if (countO == dimension) {
                    System.out.println("Wygrało O");
                    return;
                }
            }

            // Sprawdzenie zwycięztwa po przekątnej
            {
                int countX = 0;
                int countO = 0;

                for (int i = 0; i < dimension; i++) {
                    if (board[i][dimension - i - 1] == 'x') {
                        countX++;
                    } else if (board[i][dimension - i - 1] == 'o') {
                        countO++;
                    }
                }

                if (countX == dimension) {
                    System.out.println("Wygrał X");
                    return;
                } else if (countO == dimension) {
                    System.out.println("Wygrało O");
                    return;
                }
            }

            // Remis - jeżeli plansza jest pusta to można grać dalej w innym wypadku jest REMIS

            {
                boolean tableIsEmpty = false;
                for(int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        if(board[i][j] == ' ') {
                            tableIsEmpty = true;
                            break;
                        }
                    }
                }

                if(!tableIsEmpty) {
                    System.out.println("Remis");
                    return;
                }
            }
        }
    }
}