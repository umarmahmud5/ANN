package perceptronlearning;

import java.util.Random;

/**
 *
 * @author Umar Mahmud X-X-MMXVII
 */
public class Perceptron {

    int numberOfInputNeurons = 0;
    double[] weightVector;
    double threshold;   //for step function
    double biasWeight = 1;

    public void Train(double[][] inputs, int[] outputs, double threshold, double learningRate, int epoch) {
        this.threshold = threshold;
        int n = inputs[0].length;
        int p = outputs.length;
        weightVector = new double[n];
        Random r = new Random();    //for random assignment of weights
        //initialize weights
        for (int i = 0; i < n; i++) {
            //weightVector[i] = r.nextDouble();
            weightVector[i] = 0;        //0 weights
        }
        System.out.println("Weight Vector is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(weightVector[i] + "\t");
        }
        System.out.println(biasWeight);
        for (int i = 0; i < epoch; i++) {    //Stopping condition is number of epochs or convergence
            System.out.println();
            System.out.println("EPOCH NUMBER: " + (i + 1));
            int totalError = 0;
            for (int j = 0; j < p; j++) {
                int output = perceptronOutput(inputs[j]);
                int error = outputs[j] - output;
                totalError += error;
                for (int k = 0; k < n; k++) {
                    double delta = learningRate * inputs[j][k] * error;
                    weightVector[k] += delta;
                }
                //double biasFactor = learningRate * error;
                biasWeight += (learningRate * error);
                System.out.println("NEW Weight Vector is: ");
                for (int v = 0; v < n; v++) {
                    System.out.print(weightVector[v] + "\t");
                }
                System.out.println(biasWeight);
            }            
            if (totalError == 0) {
                System.out.println("The perceptron has converged");
                System.out.println();
                break;
            }
        }
    }

    public int perceptronOutput(double[] input) {
        double net = 0.0;
        for (int i = 0; i < input.length; i++) {
            net += weightVector[i] * input[i];
        }
        net += biasWeight;          //adding inductive bias
        if (net >= threshold) {     //step function
            //System.out.println("O = 1");
            return 1;
        } else {                      //bipolar
            //System.out.println("O = -1");
            return -1;
        }
    }
}
