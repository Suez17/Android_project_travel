package bddRequest;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by fpite on 17/05/2017.
 */

public class BackgroundTask extends AsyncTask <String, Void, String> {

    Context ctx;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];

        /*String IpAdress = "";
        try {
            InetAddress thisIp = InetAddress.getLocalHost();
            IpAdress = thisIp.getHostAddress();
        } catch(UnknownHostException e) {
                e.printStackTrace();
        }

        System.out.println("ADRESSE : " + IpAdress);*/

        String destinationUrl = "http://172.19.1.57/testbdandroid/" + method + ".php";

        try {
            URL url = new URL(destinationUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            String[] dataField = null;
            String data = "";

            if (method.equals("register")) {
                dataField = new String[] {"userLastname", "userFirstname", "userAge", "userPhone", "userCity", "userMail", "userLogin", "userPass"};
            }

            else if (method.equals("login")) {
                dataField = new String[] {"userLogin", "userPass"};
            }

            else if (method.equals("create_group")) {
                dataField = new String[] {"groupName", "groupDestination", "startDate", "endDate", "groupMaxMembers"};
            }

            else if (method.equals("search_group")) {
                dataField = new String[] {"groupDestination", "startDate", "endDate", "groupMaxMembers"};
            }

            if (dataField != null) {
                int i;
                for (i = 0; i < dataField.length; i++) {
                    data += URLEncoder.encode(dataField[i], "UTF-8") + "=" + URLEncoder.encode(params[i + 1], "UTF-8");
                    if (i < dataField.length - 1) {
                        data += "&";
                    }
                }

                bufferedWriter.write(data);
                bufferedWriter.flush();
            }

            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();

            if (method.equals("login") || method.equals("recup_country") || method.equals("search_group")) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")); //iso-8859-1

                String response = "";
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    response += line.trim();
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            }

            else {
                inputStream.close();
            }

            httpURLConnection.disconnect();
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}
