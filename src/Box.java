import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

/**
 * Created by alvarpq on 2/14/2016.
 */
public class Box {
    Rectangle2D dimensions;
    double velX, velY;

    public Box(Rectangle2D dims)
    {
        dimensions = dims;
    }

    public Box(Rectangle2D dims, double initX, double initY)
    {
        dimensions = dims;
        double x = dims.getX();
        double y = dims.getY();
        double fullLength = Math.sqrt(Math.pow(x - initX, 2) + Math.pow(y - initY, 2));
        velX = (initX - x) / fullLength;
        velY = (initY - y) / fullLength;

    }

    public Box(double x, double y, int length, int height)
    {
        new Box(new Rectangle2D.Double(x, y, length, height));
    }

    public Box(double x, double y, int length, int height, double mouseX, double mouseY)
    {
        new Box(new Rectangle2D.Double(x, y, length, height), mouseX, mouseY);
    }

    public Rectangle2D getRectangle()
    {
        return dimensions;
    }

    public boolean intersects(Box intersector)
    {
        return dimensions.intersects(intersector.getRectangle());
    }

    public void update()
    {
        dimensions = new Rectangle2D.Double(dimensions.getX() + velX, dimensions.getY() + velY, dimensions.getWidth(), dimensions.getHeight());
    }

}
