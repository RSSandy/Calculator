import java.util.ArrayList;

public class Backend {

    private static ArrayList<String> ongoing;

    public Backend(){
        ongoing = new ArrayList<String>();
    }

    public String addToArray(String add){
        ongoing.add(add);
        Double rv = Double.parseDouble(add) * 10;
        System.out.println("\n" + add+ "\n");
        return Double.toString(rv);
    }

    public void clear(){
        ongoing.clear();
    }
}
