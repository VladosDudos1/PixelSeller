package vlados.dudos.pixelseller

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_phone.view.*
import kotlinx.android.synthetic.main.shop_view.view.*
import vlados.dudos.pixelseller.Case.listF

class ShopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val asd = inflater.inflate(R.layout.favorite_fragment, container, false)
        val rv2 = asd.findViewById(R.id.rv) as RecyclerView


        rv2.layoutManager = GridLayoutManager(activity, 2)
        rv2.adapter = ShopAdapterF(listF)
        return asd
    }


    private fun toShopProfile(shop: ShopModel) {
        ShopModelWrapper.shopModel = shop
        startActivity(Intent(PhoneActivity.newIntent(requireActivity(), shop)))
    }
    inner class ShopAdapterF (private val list: List<ShopModel>) : RecyclerView.Adapter<ShopAdapterF.ShopView>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ShopView(LayoutInflater.from(parent.context).inflate(R.layout.shop_view, parent, false))

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: ShopView, position: Int) {
            val shop = list[position]
            holder.itemView.shop_txt.text = shop.text
            Glide.with(holder.itemView.shop_img)
                .load(shop.image)
                .into(holder.itemView.shop_img)

            holder.itemView.setOnClickListener {
                toShopProfile(shop)
            }
        }
        inner class ShopView(view: View) : RecyclerView.ViewHolder(view)
    }
}



