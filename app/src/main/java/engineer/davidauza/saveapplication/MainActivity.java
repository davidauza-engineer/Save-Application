package engineer.davidauza.saveapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        coinsTextView.setText("Coins: " + Integer.toString(coins));
    }

    /**
     * This method add 500 coins and saves the changes
     *
     * @param pView
     */
    public void addCoins(View pView) {
        coins += 500;
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("coins", coins);
        editor.commit();
        coinsTextView.setText("Coins: " + Integer.toString(coins));
    }
}
