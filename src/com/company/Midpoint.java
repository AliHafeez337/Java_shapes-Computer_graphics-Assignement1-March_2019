package com.company;

public class Midpoint {
    int r, xc, yc, x0, y0 = 0;
    String[][] arr;

    public void Midpoint(int rows, int columns, int radius){
        this.arr = new String[rows][columns];
        if (radius < rows && radius < columns){
            this.xc = rows/2;
            this.yc = columns/2;
            this.r = radius;
            int p0 = 5/4 - this.r;
            this.x0 = xc;
            this.y0 = yc + r;

            while (y0 >= yc) {
                arr[x0][y0] = "xx";
                if (p0 < 0) {
                    x0++;
                    p0 = p0 + 2 * x0 + 2 + 1;
                } else {
                    x0++;
                    y0--;
                    p0 = p0 + 2 * x0 + 1 - 2 * y0 + 2;
                }
            }
        }
    }
    public String[][] getResult(){
        return arr;
    }
}
