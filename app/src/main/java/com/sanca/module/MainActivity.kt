package com.sanca.module

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.sanca.module.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) {

            replaceFragment(HomeFragment(), "Home")
        }

        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close )

//            ganti warna togle
            toggle.drawerArrowDrawable.color = ContextCompat.getColor(this@MainActivity, R.color.white)

            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.nav_home->{
                        replaceFragment(HomeFragment(), it.title.toString())
                    }
                    R.id.nav_materi->{
                        replaceFragment(MateriFragment(), it.title.toString())
                    }
                    R.id.nav_tentang->{
                        replaceFragment(TentangFragment(), it.title.toString())
                    }
                    R.id.nav_keluar->{
                        Toast.makeText(this@MainActivity, "item 4 di klik", Toast.LENGTH_LONG).show()
                    }
                }
                true
            }
        }


    }

//    function untuk mengganti fragment
    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.frame_layout, fragment)
    fragmentTransaction.commit()
    binding.drawerLayout.closeDrawer(GravityCompat.START)
    supportActionBar?.title = title
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            true
        }

        return super.onOptionsItemSelected(item)
    }


//    ganti warna icon
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)

        val changeColorItems = listOf(
            R.id.nav_home, R.id.nav_materi, R.id.nav_tentang, R.id.nav_keluar
        )

        for (itemId in changeColorItems) {
            val menuItem = menu?.findItem(itemId)
            menuItem?.let { changeIconColor(it, R.color.white) }
        }

        return true
    }

    private fun changeIconColor(menuItem: MenuItem, colorId: Int) {
        val icon = menuItem.icon
        if (icon != null && icon is Drawable) {
            val wrappedIcon = DrawableCompat.wrap(icon)
            DrawableCompat.setTint(wrappedIcon, ContextCompat.getColor(this, colorId))
            menuItem.icon = wrappedIcon
        }
    }









}