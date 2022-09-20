public class TriangleValidator {

    public boolean validateTriangle(int[] sides) {
        if (sides.length != 3) {
            return false;
        }
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        return a + b > c && a + c > b && b + c > a;
    }
}
