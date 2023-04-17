package devmind.springinitializr.model;

import lombok.Getter;

@Getter
public enum Operation {
    SUM("sum"),
    SUBTRACT("subtract"),
    DIVIDE("divide"),
    MULTIPLY("multiply");

    public final String label;

    Operation(String label) {
        this.label = label;
    }

    public static Operation valueOfLabel(String label) {
        for (Operation e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }


}
