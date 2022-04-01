package id.sharekom.recipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val calories: String? = null,
    val carbos: String? = null,
    val country: String? = null,
    val description: String? = null,
    val difficulty: Int? = 0,
    val fats: String? = null,
    val headline: String? = null,
    val id: String? = null,
    val image: String? = null,
    val name: String? = null,
    val proteins: String? = null,
    val thumb: String? = null,
    val time: String? = null
): Parcelable