import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.FileNotFoundException;
import java.util.UUID;

public class I3Route implements Route {

    private Gson gson;
    private I3Parser p;

    public I3Route() throws FileNotFoundException {
        gson = new Gson();
        p = new I3Parser();
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // Retrieve the key
        String key = request.queryParams("key");
        key = key.toLowerCase();

        // Get the shortcut
        Shortcut shortcut = p.getMapping(key);

        // return
        return gson.toJson(shortcut);

    }


    /**
     * Securely generates a random ID.
     * https://stackoverflow.com/questions/24876188/how-big-is-the-chance-to-get-a-java-uuid-randomuuid-collision
     */
    private static String generateUniqueId() {
        return String.valueOf(UUID.randomUUID());
    }
}
