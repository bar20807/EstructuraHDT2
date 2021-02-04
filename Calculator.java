public class Calculator{
	
	//Evaluate postfix expressions 
	public static double evaluatePostFix(String inputString){

			StackVector<Double> calcStack = new StackVector<Double>();
			String tempS = "";
			for(int i = 0; i<inputString.length(); i++){

				if(Character.isDigit(inputString.charAt(i))){
					tempS = tempS +"" + inputString.charAt(i);

				} else if(inputString.charAt(i)== ' '){
					if(!tempS.equals("")){
						calcStack.push(Double.parseDouble(tempS));
						//System.out.println("pushing " + tempS);
						tempS = "";
					} 

				} else if (validOperator(inputString.charAt(i))){
					double opB = calcStack.pop();
					double opA = calcStack.pop();
					double tempCalc = calculate(inputString.charAt(i), opA, opB);

					//System.out.println("popping " + opA + " and " + opB + " to " + inputString.charAt(i));
					//System.out.println("pushing " + tempCalc);
					calcStack.push(tempCalc);


				}

			}



			return calcStack.peek();
		}
		
		//Evaluate the operators of expressions
	
		public static boolean validOperator(char c){
			return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
		}
		
		
		//Calculate the result of operations

		private static double calculate (char operator, double operandA, double operandB){
			double result = 0;
			switch (operator){
				case '+':
					//System.out.println("+ detected");
					result = operandA + operandB;
					break;
				case '-':
					//System.out.println("- detected");
					result = operandA - operandB;
					break;
				case '*':
					//System.out.println("* detected");
					result = operandA * operandB;
					break;
				case '/':
					//System.out.println("/ detected");
					if(operandB == 0.0){
						System.out.println("Error: Division by Zero, please try again");
						System.exit(0);
					} else {
						result = operandA / operandB;
					}
					break;
				case '^':
					//System.out.println("^ detected");
					result = Math.pow(operandA, operandB);
					break;
			}
			return result;

		}
}