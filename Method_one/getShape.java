import java.util.*;

public class getShape {
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);

        // Getting the amount of points
        System.out.println("The shape must have more than two points.");
        System.out.print("Enter the amount of points in the shape: ");
        int amountPoints = getInput.nextInt();

        if (amountPoints <= 2) {
            System.out.println("Invalid amount of points for a shape.");
            System.out.println("Exitting...");
            System.exit(0);
        }

        List<Integer> xcordinates = new ArrayList<Integer>();
        List<Integer> ycordinates = new ArrayList<Integer>();
        List<Double> lengths = new ArrayList<Double>();
        // looping till the number of points
        for (int i = 0; i < amountPoints; i++) {
            // Getting the x cordinate and saving it
            System.out.println("Enter the x cordinate of the point" + (i +1) + ": ");
            int xCordinate = getInput.nextInt();
            xcordinates.add(xCordinate);
            
            // Getting the y cordinate and saving it
            System.out.println("Enter the y cordinate of the point" + (i +1) + ": ");
            int yCordinate = getInput.nextInt();
            ycordinates.add(yCordinate);
        }
        getInput.close();

        // count the length of each point
        double total = 0;
        // in this loop we ingnore the last point
        for (int i = 0; i < (amountPoints - 1); i++) {
            double currentLength = Math.sqrt(((xcordinates.get(i + 1) - xcordinates.get(i))
                    * (xcordinates.get(i + 1) - xcordinates.get(i)))
                    + ((ycordinates.get(i + 1) - ycordinates.get(i)) * (ycordinates.get(i + 1) - ycordinates.get(i))));

            lengths.add(currentLength);
            
            total += currentLength;
        }
        
        // the last point 
        double lastLength = Math.sqrt(((xcordinates.get(0) - xcordinates.get(amountPoints - 1))
        * (xcordinates.get(0) - xcordinates.get(amountPoints - 1)))
        + ((ycordinates.get(0) - ycordinates.get(amountPoints - 1)) * (ycordinates.get(0) - ycordinates.get(amountPoints - 1))));
        
        total += lastLength;
        lengths.add(lastLength);
        
        // Printing the total
        parameter(total);
        Average(total, amountPoints);
        longestLength(lengths);
    }

    public static void parameter(double parameter) {
        System.out.println("The parameter of the shape is " + parameter);        
    }

    public static void Average(double total, int amountPoints) {
        double avg = total / amountPoints;
        System.out.println("The average of the shape length is " + avg);
    }

    public static void longestLength(List<Double> lengths) {
        double max = 0;
        for (double i : lengths) {
            if (i > max) {
                max = i;
            }
        }

        System.out.println("The longest path in this shape is " + max);
    }
}
