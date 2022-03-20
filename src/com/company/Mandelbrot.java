package com.company;

import java.awt.geom.Rectangle2D;

//Этот класс является подклассом FractalGenerator.
public class Mandelbrot extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;
    /** метод позволяет генератору
     * фракталов определить наиболее «интересную» область комплексной плоскости
     * для конкретного фрактала. Методу в качестве
     * аргумента передается прямоугольный объект, и метод должен изменить поля
     * прямоугольника для отображения правильного начального диапазона для
     * фрактала. Этот метод
     * должен установить начальный диапазон в (-2 - 1.5i) - (1 + 1.5i). Т.е. значения x
     * и y будут равны -2 и -1.5 соответственно, а ширина и высота будут равны 3.
     **/
    public void getInitialRange (Rectangle2D.Double range){
        range.x=-2;
        range.y=-1.5;
        range.width=3;
        range.height=3;
    }
    /**Этот метод реализует итерационную функцию для фрактала Мандельброта.
     *Требуется два дабла для действительной и мнимой частей комплекса.
     * Вычисляется количество итераций для соответствующей координаты.
     **/
    public int numIterations(double x, double y)
    {
        //Начать итерацию с нуля
        int iteration = 0;
        //Инициализация zr и zim (реальная и действительная части)
        double zr = 0;
        double zim = 0;
        /*
        Вычислить Zn = Zn-1 ^ 2 + c, где значения представляют собой комплексные числа,
        представленные по zr и zim, Z0 = 0, а c - особая точка в
        фрактале, который мы отображаем (заданный x и y). Это повторяется
        до Z ^ 2 > 4 (абсолютное значение Z больше 2) или максимум
        достигнуто количество итераций.
        */
        while (iteration < MAX_ITERATIONS && zr * zr + zim * zim < 4)
        {
            double zrUpdated = zr * zr - zim * zim + x;
            double zimUpdated = 2 * zr * zim + y;
            zr = zrUpdated;
            zim = zimUpdated;
            iteration += 1;
        }
        /*
        В случае, если алгоритм дошел до значения MAX_ITERATIONS нужно
        вернуть -1, чтобы показать, что точка не выходит за границы.
        */
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }
        return iteration;
    }

}
