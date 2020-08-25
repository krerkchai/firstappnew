package cs.rmuti.example.mobile.firstappnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import cs.rmuti.example.mobile.firstappnew.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding :ActivityMainBinding
    private lateinit var drawer_layout:DrawerLayout
    private lateinit var navgation_view: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        drawer_layout = binding.drawerlayout
        navgation_view = binding.navView
        toggle = ActionBarDrawerToggle (this,drawer_layout,R.string.open,R.string.close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    //override fun onSupportNavigateUp(item:MenuItem): Boolean {


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_aboutme -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_contain,AboutmeFragment()).commit()
            }
            R.id.nav_contact -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_contain,ContactFragment()).commit()
            }
            R.id.nav_list -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_contain,AddListFragment()).commit()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    }
