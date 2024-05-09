import java.util.List;
public class Juegos {
        String gameID;
        String steamAppID;
        String cheapest;
        String cheapestDealID;
        String external;
        String internalName;
        String thumb;
        @Override
        public String toString() { return "ID: " + gameID + "\n\t ID Steam: " + steamAppID + " \n\t Nombre: " + external + " \n\t Nombre Interno: " + internalName + " \n\t Precio: " + cheapest + "€" + "\n\t" + thumb;}
}