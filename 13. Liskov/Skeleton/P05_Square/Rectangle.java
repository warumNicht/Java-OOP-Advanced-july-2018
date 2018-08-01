package P05_Square;

class Rectangle {
    protected int m_width;
    protected int m_height;


    public Rectangle(int m_width, int m_height) {
        this.m_width = m_width;
        this.m_height = m_height;
    }

    public int getWidth() {
        return m_width;
    }

    public int getHeight() {
        return m_height;
    }

    public int getArea() {
        return m_width * m_height;
    }
}
