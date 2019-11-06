
import java.io.*;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Adresse adresse = new Adresse();
        adresse.setStrasse("Ringstr. 1");
        adresse.setOrt("Musterstadt");

        Person hugo = new Person();
        hugo.setName("Hugo Schmidt");
        hugo.setAdresse(adresse);

        Person erika = new Person();
        erika.setName("Erika Schmidt");
        erika.setAdresse(adresse);

        ArrayList<Person> arList = new ArrayList<>();
        arList.add(erika);
        arList.add(hugo);

        try {
            FileOutputStream fos = new FileOutputStream("PersonenData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arList);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            System.out.println("error");
        }

        try {
            FileInputStream fis = new FileInputStream("PersonenData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arList = (ArrayList<Person>) ois.readObject();
            System.out.println();

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(arList.get(0).getAdresse().hashCode());
        System.out.println(arList.get(1).getAdresse().hashCode());
        System.out.println(arList);
    }
}
