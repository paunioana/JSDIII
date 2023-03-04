package ro;
import lombok.Data;

@Author(
            name = "Andrew M",
            date = "12/02/2022"
    )
@Data
    class MyBean {
    public String beanieName;
    public int power;


        @SuppressWarnings(value = "unchecked")
        public void sayHello() {
            System.out.println("Hello!");
        }
    }

