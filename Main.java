import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        Random random = new Random();
        String letters = "qwertyuiopasdfghjklzxcvbnm";

        for (int a = 0; a < 10000; a++) {
            double distance = random.nextDouble(0, 100);
            double radius = random.nextDouble(0, 100);
            String name = "";
            int length = random.nextInt(5, 15);
            for (int i = 0; i < length; i++) {
                name += letters.charAt(random.nextInt(0, letters.length()));
            }
            MyTestingClass star = new MyTestingClass(name, distance, radius);
            table.put(star, name);
        }

        table.print();
        System.out.print("In each bucket we have: ");
        for (int i = 0; i < table.size(); i++) {
            System.out.print(table.countElements(i)+ ", ");
        }
        System.out.println( "the total number is " + table.numOfElements());




    }
}