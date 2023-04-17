package devmind.springinitializr.model;

import lombok.Data;

@Data
public class MathService {
    int firstNumber;
    int secondNumber;
    String operation;
    public MathService(int firstNumber, int secondNumber, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public int calculate() throws NullPointerException {
        Operation op = Operation.valueOfLabel(operation);
        return switch (op) {
            case SUM -> this.firstNumber + this.secondNumber;
            case SUBTRACT -> this.firstNumber - this.secondNumber;
            case DIVIDE -> this.firstNumber / this.secondNumber;
            case MULTIPLY -> this.firstNumber * this.secondNumber;
        };
    }
}
