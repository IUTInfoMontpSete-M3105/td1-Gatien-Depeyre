package main;
import java.util.Scanner;


public class Scan{
    Scanner sc = new Scanner(System.in);

    public String ecoute(String message){
        System.out.println(message);
        return sc.next();
    }

    public int ecouteInt(String message){
        System.out.println(message);
        return sc.nextInt();
    }
}
