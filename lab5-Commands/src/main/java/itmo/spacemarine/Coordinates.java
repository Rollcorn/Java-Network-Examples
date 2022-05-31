package itmo.spacemarine;

import itmo.utils.MyException;

/**
 * class of coordinates
 */
public class Coordinates {

    private Long x;     // x coordinate

    private Double y;   // y coordinate

    /**
     * @return x coordinate
     */
    public Long getX() {
        return x;
    }

    /**
     * @param x
     * @throws MyException
     * check x and set it
     */
    public void setX(Long x) throws MyException {
        if (x == null) {
            throw new MyException("Координата x не должны быть пустыми");
        }
        this.x = x;
    }

    /**
     * @return y coordinate
     */
    public Double getY() {
        return y;
    }

    /**
     * @param y
     * @throws MyException
     * chek y and return it
     */
    public void setY(Double y) throws MyException {
        if (y == null) {
            throw new MyException("Координата y не должны быть пустыми");
        }
        this.y = y;
    }

    /**
     * @return write x and y into line
     */
    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
