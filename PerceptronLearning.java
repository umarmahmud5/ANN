package perceptronlearning;

/**
 *
 * @author Umar Mahmud X-X-MMXVII
 */
public class PerceptronLearning {

    public static void main(String[] args) {
        Perceptron p = new Perceptron();
        double inputs[][] = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        int outputs[] = {1, 1, 1, -1};
        double learningRate = 0.1;
        double theta = 0.5;
        int epochs = 100;
        System.out.println("The training data is: ");
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs[0].length; j++) {
                System.out.print(inputs[i][j] + "\t");
            }
            System.out.println(outputs[i]);
        }
        p.Train(inputs, outputs, learningRate, theta, epochs);
        System.out.println("VERIFICATION");
        System.out.println("X"+"\t"+"Y"+"\t"+"T"+"\t"+"O");
        System.out.println(inputs[0][0] + "\t"+inputs[0][1]+"\t" + outputs[0] + "\t" + p.perceptronOutput(new double[]{1, 1}));
        System.out.println(inputs[1][0] + "\t"+inputs[1][1]+"\t" + outputs[1] + "\t" + p.perceptronOutput(new double[]{-1, 1}));
        System.out.println(inputs[2][0] + "\t"+inputs[2][1]+"\t" + outputs[2] + "\t" + p.perceptronOutput(new double[]{1, -1}));
        System.out.println(inputs[3][0] + "\t"+inputs[3][1]+"\t" + outputs[3] + "\t" + p.perceptronOutput(new double[]{-1, -1}));
        
    }
}
