package com.company;

import javax.sound.midi.SysexMessage;

public class Snowman {
    int rows,columns, radius1, radius2, radius3, part1, part2, part3 = 0;
    int x1, y1, x2, y2, x3, y3, x4, y4 =0;
    String arr[][];
    String big[][];

    public void merge(int part){
        int position= part/2;
        int distance = 0;
        int increment = -1;
        System.out.println(part);
        System.out.println(this.rows);
        for(int i = part-1; i>0; i--)
        {
            for(int j = 0; j<part; j++)
            {
                if(arr[i][j] == "xx") {
                    distance = position - j;
                    if(part == this.part1) {
                        big[this.rows - i][this.columns / 2 - distance] = "xx";
                    }
                    else if(part == this.part2){
                        big[this.rows - (increment + this.part1)][this.columns / 2 - distance] = "xx";
                    }
                    else if(part == this.part3){
                        big[this.rows - (increment + this.part2)][this.columns / 2 - distance] = "xx";
                    }
                    else{
                        big[i][j] = "xx";
                    }
                    arr[i][j] = "";
                }
            }
            increment++;
        }
    }

    public void display(){
        for(int i = this.rows-1; i>= (this.rows/3)+2; i--)
        {
            for(int j = 0; j<this.columns; j++)
            {
                if(big[i][j] == "xx") {
                    System.out.print(big[i][j]);
                    big[i][j] = "";
                }
                else {
                    System.out.print("--");
                }
            }
            System.out.println();
        }
    }

    public void mergeLine(Boolean right){
        int inc = -10;
        for(int i = rows-1; i>=0; i--) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] == "x") {
                    if(right){
                        big[rows-i+part2][j+part1] = "xx";
                    }
                    else{
                        big[rows-i+part3][j-part2 - inc] = "xx";
                    }
                    arr[i][j] = "";
                }
                else {
                    arr[i][j] = "";
                }
            }
            inc ++;
        }
    }

    public void Snowman(int rows){
        this.rows = rows;
        this.columns = this.rows;
        this.big = new String[rows][columns];
        this.part1 = rows/5;
        this.part2 = rows - rows/5 - rows/2;
        this.part3 = rows - (this.part1 + this.part2);
        arr = new String[rows][columns];
        this.radius1 = this.part1/2;
        this.radius2 = this.part2/2;
        this.radius3 = this.part3/2;

        Circle c2 = new Circle();
        c2.Circle(this.part1, this.radius1-2);
        c2.completeCircle();
        arr = c2.getArr();
        merge(this.part1);

        Circle c3 = new Circle();
        c3.Circle(this.part2, this.radius2-2);
        c3.completeCircle();
        arr = c3.getArr();
        merge(this.part2);

        Circle c4 = new Circle();
        c4.Circle(this.part3, this.radius2-2);
        c4.completeCircle();
        arr = c4.getArr();
        merge(this.part3);

        x1 = (this.columns/2)+this.radius1;
        x2 = (this.columns/2)+this.radius1;
        y1 = (this.part1+(this.rows/4));
        y2 = (this.part2+(this.rows/4));
        x3 = rows - this.rows/4;
        y3 = rows - this.rows/4;
        x4 = rows - this.rows/4;
        y4 = rows - this.rows/4;
        System.out.println(x1 +", "+x2+", "+y1+", "+y2+", "+x3+", "+y3);

        Line l5 = new Line();
        l5.drawBresenhamLine(x1, y1, x3, y3, this.rows, this.columns);
        arr = l5.getResult();
        mergeLine(true);

        Line l6 = new Line();
        l6.drawBresenhamLine(x2, y2, x4, y4, this.rows, this.columns);
        arr = l6.getResult();
        mergeLine(false);

        display();
    }
}
