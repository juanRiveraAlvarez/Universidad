import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Programa2{
  public static void main(String[] args){

    try{
      
      File file = new File("test_pr2.txt");
      Scanner sc = new Scanner(file);
      int acum  = 0;

      while(sc.hasNextLine()){
        String data = sc.nextLine().toLowerCase();
        for(int i = 0; i<data.length(); i++){
          if(data.charAt(i) == ' ' || i == 0){
            if(data.length() - 1 - i >= 2){
              if(data.charAt(i+1) == 'n' && data.charAt(i+2) == 'o'){
                if(data.length() - 1 - i == 2 || data.charAt(i+3) == ' '){
                  acum = acum + 1;
                }
              }else if(i == 0 && data.charAt(i) == 'n' && data.charAt(i+1) == 'o' && data.charAt(i+2) == ' '){
                  acum = acum + 1;
              }
            }
          }

        }
      }

      System.out.println(acum);


    }catch(Exception e){
      System.out.println("Error -> "+e);
    }

  }
}
