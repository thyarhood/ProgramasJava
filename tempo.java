import java.util.Scanner;

public class tempo{
 public static void main(String args[]){
  Scanner sc = new Scanner(System.in);
  int eventos;
  eventos = sc.nextInt();
  int contadorE = 0,contadorR = 0;
  String info[][] = new String[eventos][5];
  for(int linha = 0; linha < eventos; linha++){
   for(int coluna = 0; coluna < 2; coluna++){
    info[linha][coluna] = sc.next();
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
        System.out.println(info[verifica][1] + " " + info[verifica][2]);
       }
       else{
       System.out.println(info[verifica][1] + " " + "-1");
       }
    
   }

  }

 }
}
