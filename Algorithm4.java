/*
At the beginning I would like to explain that I had no idea what should exactly do the
argument which had to order the array of numbers, so I assumed that I can use it to randomize the variables.
*/
package algorithm4;
import java.util.Scanner;
/**
 *
 * @author Maciek
 */
public class Algorithm4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //The argument is firstly read here from user as variable "par"
        int par;
        System.out.print("Put in the parameter which will order the array.\n");
        Scanner input = new Scanner(System.in);
        par = input.nextInt();
        int[] seq = sequence(par);
        
        showSequence(seq);

        int maxDiff = returnMaxDiff(seq);
        
        System.out.print("Maximum difference between the neighboring elements of the array is "+maxDiff+"\n");
        
    }
    
    //The method which will create and randomize the array of the numbers
    
    public static int[] sequence(int par) {
        System.out.print("Put in the length of the array.\n");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        int[] tab = new int[n];
        
        for (int i = 0; i < n; i++) {
            tab[i] = (i+1)*(par-i); //In this loop program randomises the variables of the array using the parameter
        }
        return tab;
    }
    
    //This is helper method to show the consecutive values of the array
    public static void showSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i]+"\n");
        }
    }
    
    //In this method the program returns the value of the maximum difference
    //between the two neighboring variables
    public static int returnMaxDiff (int[] sequence) {
        if (sequence.length<2) {    //If the array is too short, program returns                                      
            return 0;               //nothing, because it needs at least two variables
        }                           //to return max. diff.
        
        int maxDiff = 0;                            //For the start, the variables are not compared, so there is no difference between the variables
        for (int i=1; i<sequence.length;i++) {      //In this loop the program is comparing
            int first = sequence[i-1];              //the variables, starting from the one stored
            int second = sequence[i];               //on position 0 and 1.
            
            int diff = Math.abs(second - first);    //"diff" is used to store the absolute value of the two
                                                    //compared elements, to return the absolute I used the method
                                                    //Math.abs() which handles tasks like this.
            
            if (maxDiff < diff) {                   //This is the condition to store the maximum difference
                maxDiff = diff;                     //for one iteration of the loop and if there comes bigger
            }                                       //the program stores the value.
        }
        
        return maxDiff;                             //If the loop has finished and there are no bigger
    }                                               //differences, returns the value of maximum.
}
