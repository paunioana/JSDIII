import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from Spring container
        IAnimal firstDog = context.getBean("firstDog", IAnimal.class);
        IAnimal secondDog = context.getBean("secondDog", IAnimal.class);

        IAnimal myCat = context.getBean("myCat", IAnimal.class);
        System.out.println(firstDog==secondDog);
        // call methods on the bean
        System.out.println(firstDog.makeSound());
        System.out.println(secondDog.makeSound());

        System.out.println(myCat.makeSound());
        context.close();
    }
}