import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Nombre: José Rodrigo Barrera García Carné: 20807
 * Universidad del Valle de Guatemala
 * 
 */

public class PostfixCalculator{
	

	public static void main (String [] args){

		Scanner sc = new Scanner(System.in);
		boolean state = true;

		System.out.println("\n Bienvenido a la calculadora Infix a Postfix de Rodrigo!");

		while(state == true){

			try {
				
				//Read the text file
			      File myObj = new File("ArchivoText.txt");
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			        String data = myReader.nextLine();
			        String postfix = Converter.toPostFix(data);
			        //Show the results in postfix
					System.out.println("Postfix: " + postfix);
					System.out.println("Respuesta: " + Calculator.evaluatePostFix(postfix));
					
					menu();
			      }
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("Ha ocurrido un error!");
			      e.printStackTrace();
			    }
		}
	
	}


	public static void menu(){
		
		boolean state = true;
		Scanner sc = new Scanner(System.in);

		while(state){
			
			//Option´s menu
			System.out.println("\n ¿Que acción deseas realizar nuevamente?: \n");
			System.out.println("1: Intentar con la siguiente expresión");
			System.out.println("2: Salir");
			System.out.print("Input: ");
			String input = sc.nextLine();
			
			if (input.equals("1")){
				state = false;
			} else if ( input.equals("2")){
				System.exit(0);
			} else {
				System.out.println("Error: Invalid input");
			}

		}
		

	}
}