import java.util.Scanner;
public class MaiorMenor {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int quant = sc.nextInt();
		int contador=0, n=0,m=0, contadorMaior=0;
		int num[] = new int[quant];
		
		for(int i = 0; i < quant; i++) {
			num[i] = sc.nextInt();
			if(i > 0) {
				for(int a = i - 1; a >= 0; a-- ) {
					if(num[a] <= num[i]) {
						contadorMaior++;
					}
					else {
						continue;
					}
				}
					contador = 0;
					if(contadorMaior > 0) {
						for(int b = i - contadorMaior; b <= i; b++ ) {
							if(contador == 0) {
								m = num[b];
								System.out.println("m" + "Agora é " + m );
								num[i - contadorMaior] = num[i];
								System.out.println("O maior está no seu lugar");
								num[i] = m;
								System.out.println("posição" + i + "Agora é " + m);
								contador++;
							}
							else if(contador%2 == 0 && contador != 0) {
								m = num[b];
								num[b] = n;
								System.out.println("posição " + b + "Agora é " + n);
								contador++;
							}
							else if(contador%2 != 0){
								n = num[b];
								System.out.println("n" + "Agora é" + n);
								num[b] = m;
								System.out.println("posição" + b + "Agora é " + m);
								contador++;
							}
						}
						contadorMaior = 0;			
					}
			}
		}	
		for(int o = 0; o < quant; o++) {
			System.out.println(num[o]);
		}
	}
}