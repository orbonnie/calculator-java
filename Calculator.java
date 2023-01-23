import java.io.*;

/** Methods for performing arithmetic calculations. */
class Arithmetic {
  public static float add(float num1, float num2) {
    return num1 + num2;
  }

  public static float subtract(float num1, float num2) {
    return num1 - num2;
  }

}

/** The calculator program. */
public class Calculator {
  public static void main(String[] args) {
    //run until break statement
    while (true) {
      //uses getUserInput fn to parse user input an d a sssign to input var
      String input = getUserInput("Enter your equation:");
      //checks to make sure ther is user input
      if (input == null) {
        System.out.println("Please enter an equation.");
        continue;
      }
      //split input on single space and return into array
      String[] tokens = input.split(" "); //["+", 4, 5]

      //assigns 0 index of tokens to operator variable
      String operator = tokens[0];
      //checks for "q" input for quit cmd
      if (operator.toLowerCase().equals("q")) {
        System.out.println("Quitting the program. Goodbye!");
        break;
      }

      //creates 2 float vars to hold input numbers
      Float num1, num2;
      //making sure that user input is a number(not letter, etc)
      try {
        //takes index 1 of tokens and assigns to num1 variable
        num1 = Float.parseFloat(tokens[1]);
        //checks if tokens has a length of 3
        if (tokens.length >= 3) {
          //if there is a second number takes tokens[2] of tokens
          //and assigns to num2 variable
          num2 = Float.parseFloat(tokens[2]);
          //if there is no second number in tokens[2], assign num2 to 0
        } else {
          num2 = 0f;
        }
        //checks to see if there is at least one number after operator
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Error: enter at least 1 number.");
        continue;
        //checks to see if input after operator is a number
      } catch (NumberFormatException e) {
        System.out.println("Error: not able to parse the numbers you entered.");
        continue;
      }

      Float result;
      //checks operator
      switch (operator) {  //if operator ==
        //checks if operator is +
        case "+":
          result = Arithmetic.add(num1, num2);
          break;

        //checks if operator is -
        case "-":
          result = Arithmetic.subtract(num1, num2);
          break;

        //if none of the cases match return null
        default:
          result = null;
          break;
      }
      //if result is null then tell user operator is invalid
      if (result == null) {
        System.out.println("Invalid operator.");
      //prints result
      } else {
        System.out.println("=> " + result);
      }
    }
  }

  /** Works exactly like Python's input() function. */
  static String getUserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + " ");
    try {
      BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
      inputLine = is.readLine();
      if (inputLine.length() == 0) {
        return null;
      }
    } catch (IOException e) {
      System.out.println("IOException: " + e);
    }
    return inputLine;
  }
}
