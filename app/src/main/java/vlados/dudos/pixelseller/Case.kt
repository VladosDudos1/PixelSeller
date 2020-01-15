package vlados.dudos.pixelseller

import android.content.Context
import android.view.View
import app.App

object Case {

    var openFragment = ""
    val listF = mutableListOf(
        ShopModel(0, R.drawable.pixel, "Pixel 4", App.context.getString(R.string.pixel4)),
        ShopModel(1, R.drawable.iphoneleven, "Iphone 11 Pro", App.context.getString(R.string.Iphone11)),
        ShopModel(2, R.drawable.iphonxsmax, "Iphone XS max", App.context.getString(R.string.iphoneXS)),
        ShopModel(3, R.drawable.honordvadtsat, "Honor 20", App.context.getString(R.string.Honor20)),
        ShopModel(4, R.drawable.honorten, "Honor 10", App.context.getString(R.string.Honor10)),
        ShopModel(5, R.drawable.xiaominote, "Xiaomi Note 8", App.context.getString(R.string.Xiaomi8)),
        ShopModel(6, R.drawable.xiaomimi, "Xiaomi Mi 10", App.context.getString(R.string.XiaomiMi)),
        ShopModel(7, R.drawable.pixelnew, "Pixel 3XL", App.context.getString(R.string.Pixel3))
    )
    val sharedPreferences = lazy { App.context.getSharedPreferences("app", Context.MODE_PRIVATE) }
}