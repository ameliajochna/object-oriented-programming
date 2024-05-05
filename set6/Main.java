public class Main {
    public static void main(String[] args) {
        MyDictionary<Integer, String> dictionary = new MyDictionary<>();

        dictionary.add(1, "One");
        dictionary.add(2, "Two");
        dictionary.add(3, "Three");

        dictionary.printDictionary();

        System.out.println("Is key 2 in dictionary? " + dictionary.isKeyInDictionary(2));

        System.out.println("Value for key 1: " + dictionary.findValue(1));

        dictionary.removeKey(2);

        dictionary.printDictionary();
    }
}
