package vlados.dudos.pixelseller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.shop_view.view.*

class ShopAdapter(val list: List<ShopModel>, val interfaceObject: (ShopModel) -> Unit) :
    RecyclerView.Adapter<ShopAdapter.ShopView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_view, parent, false)
        return ShopView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ShopView, position: Int) {
        val shop = list[position]

        Glide.with(holder.itemView.shop_img)
            .load(shop.image)
            .into(holder.itemView.shop_img)

        holder.itemView.shop_txt.text = shop.text
        holder.itemView.setOnClickListener {
            interfaceObject(shop)
        }
    }

    class ShopView(view: View) : RecyclerView.ViewHolder(view)
}
