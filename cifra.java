import java.util.Scanner;
public class cifra {
 public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);
  String palavra = sc.next();
  int a = palavra.length();
  int contadorConsoantes = 0;
  int tamanhoNovaPalavra;
  for(int b = 0; b < a; b++) {
	if(!palavra.substring(b,b + 1).equals("a") && !palavra.substring(b,b + 1).equals("e") && !palavra.substring(b,b + 1).equals("i") && !palavra.substring(b,b + 1).equals("o") && !palavra.substring(b,b+ 1).equals("u")) {
	 contadorConsoantes++;
	}
  }
  tamanhoNovaPalavra = a + 2*contadorConsoantes;
  String palavraNova[] = new String[tamanhoNovaPalavra];
  int contador = 0, contador2 = 0, moveLetras = 0;
  String recebeVogal = "",recebeVogal2 = "",proximaVogal = "", proximaConsoante = "";
  String letras[] = new String[27];
  letras[0] = "a";
  letras[1] = "b";
  letras[2] = "c";
  letras[3] = "d";
  letras[4] = "e";
  letras[5] = "f";
  letras[6] = "g";
  letras[7] = "h";
  letras[8] = "i";
  letras[9] = "j";
  letras[10] = "h";
  letras[11] = "i";
  letras[12] = "j";
  letras[13] = "k";
  letras[14] = "l";
  letras[15] = "m";
  letras[16] = "n";
  letras[17] = "o";
  letras[18] = "p";
  letras[19] = "q";
  letras[20] = "r";
  letras[21] = "s";
  letras[22] = "t";
  letras[23] = "u";
  letras[24] = "v";
  letras[25] = "x";
  letras[26] = "z";
  
  for(int b = 0; b < a; b++) {
	if(!palavra.substring(b,b + 1).equals("a") && !palavra.substring(b,b + 1).equals("e") && !palavra.substring(b,b + 1).equals("i") && !palavra.substring(b,b + 1).equals("o") && !palavra.substring(b,b + 1).equals("u")) {
	 for(int d = 0; d < 27; d++ ) {
	  if(letras[d].equals(palavra.substring(b,b + 1))) {
	   palavraNova[moveLetras] = letras[d];
	   moveLetras++;
	   for(int e = d + 1; e < 27; e++) {		
		contador++;
		 if(letras[e].equals("a") || letras[e].equals("e") || letras[e].equals("i") && letras[e].equals("o") || letras[e].equals("u")) {
		  recebeVogal = letras[e];
		  break;
		 }
	   }
	   for(int e = d - 1; e >= 0; e--) {		
		contador2++;
		if(letras[e].equals("a") || letras[e].equals("e") || letras[e].equals("i") || letras[e].equals("o") || letras[e].equals("u")) {
		 recebeVogal2 = letras[e];
		 break;
		}
	   }
	   if(contador < contador2) {
		   proximaVogal = recebeVogal;
		   palavraNova[moveLetras] = proximaVogal;
		   moveLetras++;
	   }
	   else if(contador > contador2){
		proximaVogal = recebeVogal2;
		palavraNova[moveLetras] = proximaVogal;
		moveLetras++;
	   }
	   else {
		proximaVogal = recebeVogal2;
		palavraNova[moveLetras] = proximaVogal;
		moveLetras++;
	   }
	   contador = 0;
	   contador2 = 0;
	   
	   if(!letras[d + 1].equals("a") && !letras[d + 1].equals("e") && !letras[d + 1].equals("i") && !letras[d + 1].equals("o") && !letras[d + 1].equals("u")) {
		proximaConsoante = letras[d + 1];
		palavraNova[moveLetras] = proximaConsoante;
	    moveLetras++;
	   }
	   else {
		proximaConsoante = letras[d + 2];
	    palavraNova[moveLetras] = proximaConsoante;
		moveLetras++;  
	   }
	   
	
	  }
     }
	}
	else {
	 palavraNova[moveLetras] = palavra.substring(b,b + 1);
	 moveLetras++;
	}
	   
  }
  
  for(int h = 0; h < tamanhoNovaPalavra; h++) {
	  System.out.printf(palavraNova[h]);
  }
  
  
 }
}
