public class BmiCalculator {
    public static void main(String[] args) {
        // Randomly generated heights (in meters) and weights (in kg) for 10 people
        double[] heights = {1.75, 1.60, 1.82, 1.68, 1.90, 1.55, 1.70, 1.78, 1.65, 1.85};
        double[] weights = {70.0, 90.0, 75.0, 55.0, 110.0, 42.0, 68.0, 95.0, 60.0, 88.0};
        
        printWellnessReport(heights, weights);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            
            System.out.printf("Person %d — Height: %.2f m, Weight: %.2f kg | BMI: %.2f | Status: %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }
}
