
package dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase encargada de proveer propietarios de forma aleatoria.
 * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
 */
public class OwnerRandom {

    /**
     *
     */
    private static String [] names ={"Josval","Luis","Andrés","Aurora","Bernarda","Florentino","Pedro","Felipe","Jesús",
                            "Israel","Julio","María","Ines","Barbará","Luisa","Gustavo","Madelín","Victor","Lisbet"};

    /**
     *
     */
    private static String [] surnames ={"Diaz", "Blanco","Valido","Fajardo","Perez","Puerto","Fajardo","Curbelo",
            "Marrero","Viera","Martinez","Sarmiento"};

    /**
     *
     */
    private static Set<String> idsGenerate = new TreeSet<String>();

    /**
     *
     */
    private static Random random = new Random();

    /**
     *
     */
    public OwnerRandom() {
    }

    /**
     *
     * @param min
     * @param max
     * @return
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    private int getRandomInt(int min, int max) {

        return random.nextInt(max - min) + min;
    }

    /**
     *
     * @return
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    public JSONArray getOwners() {
        JSONArray array =new JSONArray();

        int countOwner = getRandomInt(10,50);
        while (countOwner > 0){
            array.add(generateOwner());
            countOwner--;
        }
        return array;
    }

    /**
     *
     * @return
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    private JSONObject generateOwner() {
        JSONObject owner = new JSONObject();
        owner.put("identidad",generateIdentity());
        int x = getRandomInt(0,1001);
        String name = ( x % 2==0 ? generateFirstName()+" "+generateFirstName(): generateFirstName());
        owner.put("nombre",name);
        owner.put("apellidos",generateLastName()+" "+generateLastName());
        return owner;
    }

    /**
     *
     * @return
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    private String generateFirstName() {
        int index = getRandomInt(0,names.length-1);
        return names[index];
    }

    /**
     *
     * @return
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    private String generateLastName() {
        int index = getRandomInt(0,surnames.length-1);
        return surnames[index];
    }

    /**
     *
     * @return
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    private String generateIdentity() {
        String ci=null;
        do {
            int year = getRandomInt(0, 99);
            int month = getRandomInt(1, 12);
            int day = getRandomInt(1, 28);
            int invoice= getRandomInt(0, 99999);
            ci= String.format("%02d",year)+String.format("%02d",month)+String.format("%02d",day)+String.format("%05d",invoice);
        }while(idsGenerate.contains(ci)==true);
        idsGenerate.add(ci);
        return ci;
    }
}
