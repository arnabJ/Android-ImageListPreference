package tk.arnabjportfolio.preference.imagelist.sample;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tk.arnabjportfolio.preference.imagelist.ImageListPreference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PrefsFragment())
                .commit();
    }

    public static class PrefsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference);

            PreferenceScreen prefScreen = this.getPreferenceScreen();

            Resources res = getResources();

            String[] entries = new String[] {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
            String[] entryValues = new String[] {"0", "1", "2", "3", "4"};
            Drawable[] entryImages = new Drawable[] {
                    res.getDrawable(R.drawable.image_item_a1, null),
                    res.getDrawable(R.drawable.image_item_a2, null),
                    res.getDrawable(R.drawable.image_item_a3, null),
                    res.getDrawable(R.drawable.image_item_a4, null),
                    res.getDrawable(R.drawable.image_item_a5, null)
            };

            ImageListPreference imgListPref1 = new ImageListPreference(getActivity());
            imgListPref1.setKey("pref_key_dynamic_image_list_pref_1");
            imgListPref1.setIcon(res.getDrawable(R.drawable.preference_icon_a, null));
            imgListPref1.setTitle("Dynamic Image List Preference 1");
            imgListPref1.setDialogTitle("Dynamic Image List Preference 1");
            imgListPref1.setEntries(entries);
            imgListPref1.setEntryValues(entryValues);
            /*
             * Pass the Drawable/Bitmap Array to setEntryImages() Method,
             * the second parameter requires boolean value true or false for setting roundedImage.
             * false = images will added as is.
             */
            imgListPref1.setEntryImages(entryImages, false);
            prefScreen.addPreference(imgListPref1);

            entryImages = new Drawable[] {
                    res.getDrawable(R.drawable.image_item_b1, null),
                    res.getDrawable(R.drawable.image_item_b2, null),
                    res.getDrawable(R.drawable.image_item_b3, null),
                    res.getDrawable(R.drawable.image_item_b4, null),
                    res.getDrawable(R.drawable.image_item_b5, null)
            };

            ImageListPreference imgListPref2 = new ImageListPreference(getActivity());
            imgListPref2.setKey("pref_key_dynamic_image_list_pref_2");
            imgListPref2.setIcon(res.getDrawable(R.drawable.preference_icon_b, null));
            imgListPref2.setTitle("Dynamic Image List Preference 2");
            imgListPref2.setDialogTitle("Dynamic Image List Preference 2");
            imgListPref2.setEntries(entries);
            imgListPref2.setEntryValues(entryValues);
            /*
             * Pass the Drawable/Bitmap Array to setEntryImages() Method,
             * the second parameter requires boolean value true or false for setting roundedImage.
             * true = images will be converted to circle and than added.
             */
            imgListPref2.setEntryImages(entryImages, true);
            prefScreen.addPreference(imgListPref2);
        }
    }
}
