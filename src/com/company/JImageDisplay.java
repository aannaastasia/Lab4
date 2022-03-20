package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// Этот класс позволяет нам отображать наши фракталы. Он является производным от javax.swing.JComponent
public class JImageDisplay extends JComponent {
    //Управляет изображением, содержимое которого можно записать
    private BufferedImage image;
    /* Конструктор JImageDisplay должен принимать целочисленные
   значения ширины и высоты, и инициализировать объект BufferedImage новым
   изображением с этой шириной и высотой, и типом изображения TYPE_INT_RGB. */
    public JImageDisplay(int width, int height){
        image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    /* Конструктор также должен вызвать метод setPreferredSize()
 родительского класса метод с указанной шириной и высотой. Таким образом,
 когда компонент будет включен в пользовательский интерфейс, он
 отобразит на экране все изображение.
 */
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);
    }
    /* нужно всегда вызывать метод суперкласса paintComponent (g) так, чтобы объекты
     отображались правильно. Затем изображение втягивается в компонент. */

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);
    }
    // Устанавливает все пиксели в данных изображения черными
    public void clearImage(){
        int[] blankArray = new int[getWidth() * getHeight()];
        image.setRGB(0, 0, getWidth(), getHeight(), blankArray, 0, 1);
    }
    // Устанавливает пиксель определенного цвета
    public void drawPixel(int x, int y, int rgbColor)
    {
        image.setRGB(x, y, rgbColor);
    }
}
