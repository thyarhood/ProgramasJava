import java.util.Scanner;
import java.util.ArrayList;

public class tempo{
 public static void main(String args[]){
  Scanner sc = new Scanner(System.in);
  int eventos;
  eventos = sc.nextInt();
  int contadorE = 0,contadorR = 0,contadorTamanho = 0,contadorMaior = 0,contador = 0,m = 0, n = 0;
  boolean repetido = false;
  ArrayList<Integer>listaAmigos = new ArrayList<Integer>();
  String info[][] = new String[eventos][5];
  for(int linha = 0; linha < eventos; linha++){
   for(int coluna = 0; coluna < 2; coluna++){
    info[linha][coluna] = sc.next();
    if(linha == 0 && coluna == 1 && info[0][0].equals("R")){
     int a = Integer.parseInt(info[linha][1]);
     listaAmigos.add(a);
     contadorTamanho++;
    }
    if(linha > 0 && coluna == 1 && info[linha][0].equals("R")){
     repetido = false;
     for(int i = linha - 1; i >= 0; i--){
      if(info[i][1].equals(info[linha][1])){
       repetido = true;
       break;
      }
     }
     if(repetido == false){
      int a = Integer.parseInt(info[linha][coluna]);
      listaAmigos.add(a);
      contadorTamanho++;
     }
    }
   }

info[linha][2] = "0";
info[linha][3] = "mexe";
info[linha][4] = "naoUsado";

    if(linha > 0 && !info[linha][0].equals("T") && !info[linha - 1][0].equals("T")){
     for(int mudaTempo = linha - 1; mudaTempo >= 0; mudaTempo--){
      if(info[mudaTempo][3].equals("mexe")){
      int temporaria = Integer.parseInt(info[mudaTempo][2]) + 1;
      info[mudaTempo][2] = Integer.toString(temporaria);
      }
     } 
    }

    else if(linha > 0 && info[linha][0].equals("T")){
     for(int mudaTempo = linha - 1; mudaTempo >= 0; mudaTempo--){
      if(info[mudaTempo][3].equals("mexe")){
      int temporaria = Integer.parseInt(info[mudaTempo][2]) + Integer.parseInt(info[linha][1]);
      info[mudaTempo][2] = Integer.toString(temporaria);
      }
     }
    }

    if(linha > 0){
     for(int verifica = 0; verifica <= linha; verifica++){
      if(info[verifica][0].equals("R") && !info[verifica][3].equals("naoMexe")){
       for(int verifica2 = verifica + 1; verifica2 <= linha; verifica2++){
        if(info[verifica2][0].equals("E") && info[verifica][1].equals(info[verifica2][1])){
         info[verifica][3] = "naoMexe";
	 break;
        }
        else{
         continue;
        }
       }
      }
     }
    }
  }
  
  int vet[][] = new int[contadorTamanho][2];
  for(int o = 0; o < contadorTamanho; o++){
   vet[o][0] = listaAmigos.get(o);
   if(o > 0){
    for(int a = o - 1; a >= 0; a--){
     if(vet[a][0] < vet[o][0]){
      contadorMaior++;
     }
     else{
     continue;
     }
    }
    contador  = 0;
    if(contadorMaior > 0){
     for(int b = o - contadorMaior; b <= o; b++){
      if(contador == 0){
       m = vet[b][0];
       vet[o - contadorMaior][0] = vet[o][0];
       vet[o][0] = m;
       contador++;
      }
      else if(contador%2 == 0 && contador != 0){
       m = vet[b][0];
       vet[b][0] = n;
       contador++;
      }
      else if(contador%2 != 0){
       n = vet[b][0];
       vet[b][0] = m;
       contador++;
      }
     }
     contadorMaior = 0;
    }
   }
  }

  for(int verifica =0; verifica < eventos; verifica++){
   contadorE = 0;
   contadorR = 0;
   if(info[verifica][0].equals("R") && !info[verifica][4].equals("usado")){
    info[verifica][4] = "usado";
    contadorR++;
    for(int verifica2 = verifica + 1; verifica2 < eventos; verifica2++){
     if(info[verifica2][0].equals("E") && info[verifica2][1].equals(info[verifica][1])){
      contadorE++;
     }
      if(info[verifica2][0].equals("R") && info[verifica2][1].equals(info[verifica][1])){
       int temporaria = Integer.parseInt(info[verifica2][2]) + Integer.parseInt(info[verifica][2]);
       info[verifica][2] = Integer.toString(temporaria);
       contadorR++;
       info[verifica2][4] = "usado";
      }
    }
       if(contadorE == contadorR){
        for(int p = 0; p < contadorTamanho; p++){
         int temporaria = Integer.parseInt(info[verifica][1]);
         if(temporaria == vet[p][0]){
          vet[p][1] = Integer.parseInt(info[verifica][2]);
         }
        }
       }
       else{
        for(int p = 0; p < contadorTamanho; p++){
         int temporaria = Integer.parseInt(info[verifica][1]);
         if(temporaria == vet[p][0]){
           vet[p][1] = -1;
         }
        }
       }  
   }
  } 
  
  for(int i = contadorTamanho - 1; i >= 0; i--){
   System.out.println(vet[i][0] + " " + vet[i][1]);
  }

 }
}
