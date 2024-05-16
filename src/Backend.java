import java.math.BigDecimal;
import java.math.RoundingMode;

public class Backend {


    public Backend(){
        
    }

    /*general idea:
     * whenever user presses '=' , 
     * -> we get the string that is in numberField
     * -> we parse it for x, /, + , and - using .split()
     * -> we use a loop to run through the fragments 
     * -> and apply their respective functions to op1 and op2 
     * -> once loop finishes, return the finalValue.toString()
     */
    public String compute(String add){
        String[] parseMe = add.split(" ");
        String ans = parseMe[0];
        for(int i = 0; i < parseMe.length - 1; i = i + 2){ //parseMe.length = # of operations to be done?
            System.out.println("op1: " + ans + "\nfunction: " + parseMe[i + 1] + "\nop2: " + parseMe[i + 2]);
            ans = computeHelper(ans, parseMe[i + 1], parseMe[i + 2]);
            System.out.println("\t\tans: " + ans);
        }
        return ans;
    }

    public String computeHelper(String op1, String function, String op2){
        //System.out.println("op1: " + op1 + "\nfunction: " + function + "\nop2: " + op2);
        String func = function.strip();
        int scale = op1.length() + op2.length();
        try{
            BigDecimal operand1 = BigDecimal.valueOf(Double.parseDouble(op1));
            BigDecimal operand2 = BigDecimal.valueOf(Double.parseDouble(op2));
            switch(func){
                case "+":
                    return operand1.add(operand2).toString();
                case "-":
                    return operand1.subtract(operand2).toString();
                case "X": 
                    return operand1.multiply(operand2).toString();
                case "/":
                    return operand1.divide(operand2, scale, RoundingMode.HALF_UP).toString();
            }
        }
        catch(NumberFormatException e){
            return "ERROR: Number is formatted incorrectly";
        }
       return null;
    }
}
