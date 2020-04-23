package main.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class serves as an entry point for the program. This class serves as a control for the 
 * program.
 * @author kelseycloud
 *
 */
public class Main {

    public static int days = 0;
    public static boolean isNight = true;
    public static boolean isDay = false;
    
    public static ArrayList<Farm> farms = new ArrayList<Farm>();
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the name of your first Farm: ");
        farms.add(new Farm(scan.nextLine()));
        
    }
}
