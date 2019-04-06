package com.example.user.contactbook;

import android.support.design.internal.NavigationMenu;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class Profile extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //string anar jonno
        textView = findViewById(R.id.con_nameId);

//        receive String data
        Bundle bundle = getIntent().getExtras();
        //condition dite hobe
        if(bundle!=null){
            String name=bundle.getString("tag");
            textView.setText(name);
        }

        //For Custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //for back button...but age  setSupportActionBar(toolbar); tarpor
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //For Floating Action Menu
        FabSpeedDial fabSpeedDial = findViewById(R.id.fabSpeedDial);

        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;//false: don't show menu
            }
            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                Toast.makeText(Profile.this,""+menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
            @Override
            public void onMenuClosed() {

            }
        });//end floating action menu


        //Fragment Set korar jonno

        tabLayout = findViewById(R.id.tabSecondtId);
        appBarLayout = findViewById(R.id.appBarId);
        viewPager = findViewById(R.id.viewSecondId);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding FragmentName
        adapter.AddFragment(new FragmentShare(),"Share");
        adapter.AddFragment(new FragmentHistory(),"History");
        adapter.AddFragment(new FragmentFavourite(),"Favourite");

        //Adapter Step
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


    //For making Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    //OptionMenu gula tik moto kaj korano
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Search Option", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "Place On Home Screen", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "Delete Contact", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item4:
                Toast.makeText(this, "Block Contact", Toast.LENGTH_SHORT).show();
                return true;



            default:
                return super.onOptionsItemSelected(item);

        }
    }//Option menu tik moto kaj korano ekhanei sesh
}

