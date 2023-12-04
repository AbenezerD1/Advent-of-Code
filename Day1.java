import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args){
        try {
            Scanner console = new Scanner(new File("src\\Calibrations.txt"));
            System.out.println(calibrationVal(console));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    public static int calibrationVal(Scanner console){
        int sum=0;
        while(console.hasNextLine()){
            String code = console.nextLine();
            sum += decodedVal(code);
        }
        return sum;
    }

    public static int decodedVal(String code){
        int[] nums = new int[code.length()];
        int start=0;
        for(int j=0; j<code.length(); j++){
            char val = code.charAt(j);
            if(val<='9' && val>='0') {
                nums[start] = Integer.parseInt(""+val);
                start++;
            }
        }

        if(start<2){
            return Integer.parseInt(nums[0]+""+nums[0]);
        }
        return Integer.parseInt(nums[0]+""+nums[start-1]);
    }
}



