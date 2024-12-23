package GitHub;
public class Areas {
    
    public void rect_area() {
        int l = 10; // Length of the rectangle
        int b = 20; // Breadth of the rectangle
        int area;   // Variable to store the area
        
        area = l * b; // Calculating area
        System.out.println("Area of Rectangle: " + area); // Printing the area
    }
    
    public void tri_area() {
    	int l = 5; // Length of the rectangle
        int b = 6; // Breadth of the rectangle
        double area;   // Variable to store the area
        
        area = 0.5* l * b; // Calculating area
        System.out.println("Area of Triangle: " + area); // Printing the area
    }
    
    public static void main(String[] args) {
        Areas a = new Areas(); // Creating an object of the Areas class
        a.rect_area(); // Calling the rect_area method
        a.tri_area();
    }
}
