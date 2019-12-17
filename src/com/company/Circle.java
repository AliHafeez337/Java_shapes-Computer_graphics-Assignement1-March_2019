package com.company;

public class Circle extends Midpoint {
    int rows,columns, radius = 0;
    String arr[][];

    public void Circle(int rows, int radius){
        this.rows = rows;
        this.columns = this.rows;
        this.radius = radius;
        arr = new String[rows][columns];

        Midpoint m1 = new Midpoint();
        m1.Midpoint(this.rows, this.columns, this.radius);
        arr = m1.getResult();
    }

    public void completeCircle(){
        for(int i = rows-1; i>=0; i--)
        {
            for(int j = columns-1; j >= columns/2; j--){
                if(arr[i][j] == "xx"){
                    arr[i][columns - j] = "xx";
                    arr[rows-i][j] = "xx";
                }
            }
        }
    }

    public void display(){
        for(int i = rows-1; i>=0; i--)
        {
            for(int j = 0; j<columns; j++)
            {
                if(arr[i][j] == "xx") {
                    System.out.print(arr[i][j]);
                    arr[i][j] = "";
                }
                else {
                    System.out.print("--");
                }
            }
            System.out.println();
        }
    }
    public String[][] getArr(){
        return this.arr;
    }
}
