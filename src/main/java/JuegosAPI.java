import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JuegosAPI {
    public static void main(String[] args) throws IOException {
        final Gson gson = new Gson();
        URL url = new URL("https://www.cheapshark.com/api/1.0/games?title=citiesskylines");
        try (Reader reader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)) {
            Juegos[] juegos = gson.fromJson(reader, Juegos[].class);
            generarHTML(juegos);
        }
    }

    private static void generarHTML(Juegos[] juegos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/callofduty.html"))) {
            writer.write("<html>");
            writer.write("<head><title>Resultados de la búsqueda</title></head>");
            writer.write("<body>");
            writer.write("<h1>Resultados de la búsqueda</h1>");
            writer.write("<table border=\"1\">");
            writer.write("<tr><th>ID</th><th>ID Steam</th><th>Nombre</th><th>Nombre Interno</th><th>Precio</th><th>Imagen</th></tr>");
            for (Juegos juego : juegos) {
                writer.write("<tr>");
                writer.write("<td>" + juego.gameID + "</td>");
                writer.write("<td>" + juego.steamAppID + "</td>");
                writer.write("<td>" + juego.external + "</td>");
                writer.write("<td>" + juego.internalName + "</td>");
                writer.write("<td>" + juego.cheapest + "€</td>");
                writer.write("<td><img src=\"" + juego.thumb + "\"/></td>");
                writer.write("</tr>");
            }
            writer.write("</table>");
            writer.write("</body>");
            writer.write("</html>");
        }
        System.out.println("Archivo HTML generado.");
    }
}