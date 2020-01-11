package vlados.dudos.pixelseller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.shop_fragment.*

class ShopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.shop_fragment, container, false)
        return view
    }


    fun replaceFragment(fmt: Fragment) {
        fragmentManager!!.beginTransaction().replace(R.id.fragmet_holder, fmt).addToBackStack(null).commit()
    }

    private fun clickItem(shopModel: ShopModel) {
        replaceFragment(PixelFragment())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = mutableListOf<ShopModel>()



        for (i in 0..7) {
            var phone = ShopModel(R.drawable.pixel, "Pixel 4")
            list.add(phone)
        }


        rv_shop.adapter = ShopAdapter(list, ::clickItem)
        rv_shop.layoutManager = GridLayoutManager(activity, 2)
    }

}