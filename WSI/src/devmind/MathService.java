package devmind;

public class MathService {
    private Integer number = 10;

    public Integer divideNumberBy(Integer dividend) {
        return number / dividend;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
