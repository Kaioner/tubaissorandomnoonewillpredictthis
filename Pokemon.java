// Codigo base para o problema [DAA 001] Procurando Pokemons
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 21/09/2016
// ----------------------------------

import java.util.Scanner;

public class Pokemon {
    static int n;           // Quantidade de numeros
    static int perm[];      // Guardar a permutacao em si    
    static boolean used[];  // Indica se um numero ja foi usado
    static String name[];   // Nomes dos locais 
    static double dist[][]; // Matriz de distancias
    static double best;     // VariÃ¡vel para conter o custo otimo


    // Funcao recursiva para colocar numero na posicao 'pos'
    static void goPerm(int pos) {

	// Chegamos ao fim da permutacao, vamos imprimi-la
	if (pos == n) {
	    for (int i=0; i<n; i++)
		System.out.print(perm[i] + " ");
	    System.out.println();
	}

	// Vamos a meio da permutacao
	// Gerar numero nao usado para colocar nesta posicao
	else {
	    for (int i=0; i<n; i++)
		if (!used[i]) {
		    perm[pos] = i;
		    used[i] = true;
		    goPerm(pos+1);
		    used[i] = false;
		}
	}
    }    

    // ---------------------------------------------

    
    // Ler o input
    static void readInput() {

	Scanner stdin = new Scanner(System.in);

	// Ler a quantidade de locais
	n = stdin.nextInt();

	// Inicializar variÃ¡veis com tamanho adequado
	perm = new int[n];
	used = new boolean[n];
	name = new String[n];
	dist = new double[n][n];
	
	// Ler os os nomes
	for (int i=0; i<n; i++)
	    name[i] = stdin.next();

	// Ler a matriz de distancias
	for (int i=0; i<n; i++)
	    for (int j=0; j<n; j++)
		dist[i][j] = stdin.nextDouble();
    }

    // Resolver o problema
    static void solve() {
  
	// Iniciar a permutacao na posicao 0  
	goPerm(0);

	System.out.printf("%.2f\n", best);
    }

    // ---------------------------------------------
    
    public static void main(String args[]) {

	readInput();
	solve();

    }
}
