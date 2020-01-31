package vlados.dudos.pixelseller

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import kotlinx.android.synthetic.main.activity_phone.*

class PhoneActivity : AppCompatActivity() {

    var shopModel: ShopModel? = null

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

//        shopModel?.let{
//            if(it.)
//        }
    }

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

    companion object {
        private const val MODEL_KEY = "phone_model"

        fun newIntent(activity: Activity, model: ShopModel) =
            Intent(activity, PhoneActivity::class.java).apply {
                putExtra(MODEL_KEY, model)
            }
    }
}
