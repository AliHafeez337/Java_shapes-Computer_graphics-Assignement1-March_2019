package com.company;

public class Triangle extends Line {

    int rows = 50, columns = 50;
    String[][] arr =  new String[rows][columns];
    String[][] temp =  new String[rows][columns];
    public void mergeArray(){
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<columns; j++)
            {
                if(temp[i][j] == "x"){
                        arr[i][j] = "x";
                        temp[i][j] = "";
                }
            }
        }
    }

    public void display(){
        for(int i = rows-1; i>=0; i--)
        {
            for(int j = 0; j<columns; j++)
            {
                if(arr[i][j] == "x") {
                    System.out.print(arr[i][j]);
                    arr[i][j] = "";
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    public void Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        Line l1 = new Line();
        Line l2 = new Line();
        Line l3 = new Line();
        l1.drawBresenhamLine(x1, y1, x2, y2, rows, columns);
        temp = l1.getResult();
        mergeArray();

        l2.drawBresenhamLine(x2, y2, x3, y3, rows, columns);
        temp = l2.getResult();
        mergeArray();

        l3.drawBresenhamLine(x3, y3, x1, y1, rows, columns);
        temp = l3.getResult();
        mergeArray();

        display();
    }

}
