
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
        Double startSum = Double.parseDouble(parseMe[0]);
        for(int i = 0; i < parseMe.length; i++){ //parseMe.length = # of operations to be done?

        }
        return null;
    }
}
