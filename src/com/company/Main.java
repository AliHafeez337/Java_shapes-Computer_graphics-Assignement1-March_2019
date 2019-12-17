package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter positive integers please.");
        System.out.println("Enter values less than 50..");

        int x1, y1, x2, y2, x3, y3 = 0;
        System.out.print("x1: ");
        x1 = input.nextInt();
        System.out.println();
        System.out.print("y1: ");
        y1 = input.nextInt();
        System.out.println();
        System.out.print("x2: ");
        x2 = input.nextInt();
        System.out.println();
        System.out.print("y2: ");
        y2 = input.nextInt();
        System.out.println();
        System.out.print("x3: ");
        x3 = input.nextInt();
        System.out.println();
        System.out.print("y3: ");
        y3 = input.nextInt();
        System.out.println();
        Triangle t1 = new Triangle();
        //t1.Triangle(10,0, 29, 28, 1, 20);
        t1.Triangle(x1, y1, x2, y2, x3, y3);

        int radius =0;
        System.out.println();
        System.out.println("Enter positive radius please");
        System.out.println();
        System.out.print("raidus: ");
        radius = input.nextInt();
        Circle c1 = new Circle();
        c1.Circle((radius*3), radius);
        c1.completeCircle();
        c1.display();

        System.out.println();
        System.out.println("Enter positive integer for sketch size please");
        System.out.println("Sketech size should be greater than 30 to see clear image");
        System.out.println("Sketech size must be greter than 16");
        System.out.println("Sketech size can not exceed 70");
        System.out.print("number of rows: ");
        int rows = input.nextInt();
        System.out.println();
        Snowman s1 = new Snowman();
        s1.Snowman(rows);
    }
}
