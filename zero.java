import java.util.Scanner;
 public class zero{
  public static void main(String args[]) {
   Scanner sc = new Scanner(System.in);
   int quant = sc.nextInt();
   int num[][] = new int[quant][3];
   int contador = 0;
   for(int i = 0; i < quant; i++) {
    num[i][0] = sc.nextInt();
    num[i][2] = 0;
    if(i == 0) {
     num[0][1] = num[0][0];
    }
    else if(num[i][0] != 0){
     num[i][1] = num[i - 1][1] + num[i][0];
    }
    else{
     for(int j = i - 1; j >= 0; j--) {
      if(num[j][0] != 0 && num[j][2] == 0) {
       num[j][2] = 1;
       num[i][1] = num[j][1] - num[j][0];
       break;
      }
      else {
       continue;
      }
     }
    }
   }
   System.out.println(num[quant - 1][1]);
  }
 }
