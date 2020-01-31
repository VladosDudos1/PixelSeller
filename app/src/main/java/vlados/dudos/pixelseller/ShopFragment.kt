package vlados.dudos.pixelseller

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.shop_fragment.*
import vlados.dudos.pixelseller.Case.openFragment
import java.lang.Exception

class ShopFragment : Fragment() {

    private var listHolder = mutableListOf<ShopModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listHolder = mutableListOf(
            ShopModel(0, R.drawable.pixel, "Pixel 4", getString(R.string.pixel4)),
            ShopModel(1, R.drawable.iphoneleven, "Iphone 11 Pro", getString(R.string.Iphone11)),
            ShopModel(2, R.drawable.iphonxsmax, "Iphone XS max", getString(R.string.iphoneXS)),
            ShopModel(3, R.drawable.honordvadtsat, "Honor 20", getString(R.string.Honor20)),
            ShopModel(4, R.drawable.honorten, "Honor 10", getString(R.string.Honor10)),
            ShopModel(5, R.drawable.xiaominote, "Xiaomi Note 8", getString(R.string.Xiaomi8)),
            ShopModel(6, R.drawable.xiaomimi, "Xiaomi Mi 10", getString(R.string.XiaomiMi)),
            ShopModel(7, R.drawable.pixelnew, "Pixel 3XL", getString(R.string.Pixel3))
        )

        val lb = { s:ShopModel->
            startActivity(PhoneActivity.newIntent(requireActivity(), s))
        }

        rv_shop.adapter = ShopAdapter(listHolder, lb)
        rv_shop.layoutManager = GridLayoutManager(activity, 2)
    }

//    override fun clickItem(shopModel: ShopModel) {
//        startActivity(PhoneActivity.newIntent(requireActivity(), shopModel))
//    }
}
//
//interface IClickItemModel {
//    fun clickItem(shopModel: ShopModel)
//}