package vlados.dudos.pixelseller

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_phone.*


class PhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        ShopModelWrapper.shopModel?.let {
            img.setImageResource(it.image)
            description.text = it.description
            toolbar.title = it.text
        }
    }

    companion object {
        private const val MODEL_KEY = ""

        fun newIntent(activity: Activity, model: ShopModel) =
            Intent(activity, PhoneActivity::class.java).apply {
                putExtra(MODEL_KEY, model)
            }
    }



}
