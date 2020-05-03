package clasesUtilidadGeneral;

import ds.desktop.notify.DesktopNotify;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import principal.Main;

public class ApiDolar {

    public static void call_me() throws Exception {

        String url = "http://ws.geeklab.com.ar/dolar/get-dolar-json.php";
        URL obj = new URL(url);
        try {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject myResponse = new JSONObject(response.toString());

            Main.getPrincipalAdmin().getLblLibre().setText(myResponse.getString("libre"));
        } catch (Exception e) {
            DesktopNotify.showDesktopMessage("   error de conexion   ", "    NO SE PUDO OBTENER\n    EL PRECIO DEL DOLAR", DesktopNotify.ERROR, 7000);
        }

    }
}
