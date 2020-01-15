package vlados.dudos.pixelseller

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_phone.*
import vlados.dudos.pixelseller.Case.sharedPreferences

class PhoneActivity : AppCompatActivity() {

    var shopModel: ShopModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        if (savedInstanceState == null) {
            val extras = intent.extras
            if (extras == null) {
                shopModel = null
            } else {
                shopModel = extras.getParcelable(MODEL_KEY)
            }
        } else {
            shopModel = savedInstanceState.getSerializable(MODEL_KEY) as ShopModel
        }

        shopModel?.let {
            img.setImageResource(it.image)
            description.text = it.description
            toolbar.title = it.text
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(baseContext).inflate(R.menu.toolbar_menu, menu)
        menu?.let {
            it.getItem(0).setOnMenuItemClickListener {
                shopModel?.apply {
                    val name = "fav${this.id}"
                    val result = sharedPreferences.value.getBoolean(name, false)

                    sharedPreferences.value.edit().putBoolean(name, !result).apply()
                    Toast.makeText(this@PhoneActivity, (!result).toString(), Toast.LENGTH_LONG)
                        .show()
                }

                true
            }
        }
        return super.onCreateOptionsMenu(menu)
    }

    companion object {
        private const val MODEL_KEY = "photo_model"

        fun newIntent(ac: Activity, model: ShopModel) =
            Intent(ac, PhoneActivity::class.java).apply {
                putExtra(MODEL_KEY, model)
            }
    }

}