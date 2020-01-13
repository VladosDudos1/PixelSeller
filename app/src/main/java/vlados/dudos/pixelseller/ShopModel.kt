package vlados.dudos.pixelseller

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShopModel(
    val image: Int,
    val text: String,
    val description: String
): Parcelable