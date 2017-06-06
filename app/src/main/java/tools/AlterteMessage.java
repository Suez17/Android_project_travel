package tools;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by Michael on 05/06/2017.
 */

public class AlterteMessage {
    public AlterteMessage(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Alerte");
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
