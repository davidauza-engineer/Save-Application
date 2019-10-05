package engineer.davidauza.saveapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int coins;

    public static final String PREFS_NAME = "MyPrefsFile";

    TextView coinsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        coins = settings.getInt("coins", coins);

        coinsTextView = findViewById(R.id.coins_text_view);
        displayCoins();
    }

    /**
     * This method add 500 coins and saves the changes
     */
    public void addCoins(View pView) {
        coins += 500;
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("coins", coins);
        editor.apply();
        displayCoins();
    }

    /**
     * This method display the coins in its corresponding TextView.
     */
    private void displayCoins() {
        String totalCoins = getString(R.string.total_coins) + " " +
                String.format(Locale.getDefault(), "%d", coins);
        coinsTextView.setText(totalCoins);
    }
}
