package com.company;

public class Line {
    String[][] arr;

    private int sign (int x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
    }

    public void drawBresenhamLine (int xstart, int ystart, int xend, int yend, int rows, int columns)
    {
        this.arr = new String[rows][columns];
        int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;

        dx = xend - xstart;
        dy = yend - ystart;

        incx = sign(dx);
        incy = sign(dy);

        if (dx < 0) dx = -dx;
        if (dy < 0) dy = -dy;

        if (dx > dy)
        {
            pdx = incx;     pdy = 0;
            es = dy;        el = dx;
        }
        else
        {
            pdx = 0;        pdy = incy;
            es = dx;        el = dy;
        }

        x = xstart;
        y = ystart;
        err = el/2;
        arr[x][y] = "x";
        System.out.println (x +", "+ y);

        for (int t = 0; t < el; t++)
        {
            err -= es;
            if (err < 0)
            {
                err += el;
                x += incx;
                y += incy;
            }
            else
            {
                x += pdx;
                y += pdy;
            }
            arr[x][y] = "x";
        }
    }
    public String[][] getResult(){
        return this.arr;
    }
}
