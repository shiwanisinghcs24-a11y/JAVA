import java.util.Scanner;


class InputScanner {
   
    Scanner scanner = new Scanner(System.in);
}


abstract class Shape extends InputScanner {
    // The two integers
    int dim1, dim2;

    
    abstract void getInput();

    
    abstract void printArea();
}


class Rectangle extends Shape {
    
    @Override
    void getInput() {
        System.out.println("Enter the dimensions of the rectangle (length and breadth):");
        
        dim1 = scanner.nextInt(); // length
        dim2 = scanner.nextInt(); // breadth
    }

    @Override
    void printArea() {
        // Area = length * breadth
        double area = dim1 * dim2;
        System.out.println("Area of Rectangle = " + area);
    }
}


class Triangle extends Shape {

    @Override
    void getInput() {
        System.out.println("Enter the dimensions of the triangle (base and height):");
        // 'scanner' is inherited
        dim1 = scanner.nextInt(); // base
        dim2 = scanner.nextInt(); // height
    }

    @Override
    void printArea() {
        
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle = " + area);
    }
}


class Circle extends Shape {
    
    @Override
    void getInput() {
        System.out.println("Enter the dimension of the circle (radius):");
        // 'scanner' is inherited
        dim1 = scanner.nextInt(); // radius
    }

    @Override
    void printArea() {
       
        double area = 3.14 * dim1 * dim1;
        System.out.println("Area of Circle = " + area);
    }
}


public class ShapeDemo {

    public static void main(String[] args) {

        // Create objects
        Rectangle r = new Rectangle();
        Triangle t = new Triangle();
        Circle c = new Circle();

       
        r.getInput();
        t.getInput();
        c.getInput();

        // --- 2. Print all areas last ---
        r.printArea();
        t.printArea();
        c.printArea();

       
        r.scanner.close();
    }
}
