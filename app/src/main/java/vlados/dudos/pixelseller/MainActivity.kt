package vlados.dudos.pixelseller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.shop_fragment.*

class MainActivity : AppCompatActivity() {


    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showShopFragment()




        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigation_bar)


        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.shoping -> {
                    showShopFragment()
                }

                R.id.settings -> {
                    showSettingsFragment()
                }
            }
            true
        }
    }

    fun replaceFragment(fmt: Fragment) {
        manager.beginTransaction().replace(R.id.fragmet_holder, fmt).addToBackStack(null).commit()
    }

    fun showShopFragment(){
        replaceFragment(ShopFragment())
    }

    fun showSettingsFragment(){
        replaceFragment(SettingsFragment())
    }

}
