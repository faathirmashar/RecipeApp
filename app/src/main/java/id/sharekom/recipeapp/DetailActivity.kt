package id.sharekom.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.sharekom.recipeapp.data.model.Recipe
import id.sharekom.recipeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe = intent.getParcelableExtra<Recipe>(DETAIL_DATA)

        showData(recipe)
    }

    private fun showData(recipe: Recipe?) {
        binding.apply {
            recipe?.apply {
                tvName.text = name
                tvHeadline.text = headline
                tvDesc.text = description
                tvCal.text = calories
                tvCarbos.text = carbos
                tvFat.text = fats
                tvProtein.text = proteins
                tvTime.text = time
                tvDifficult.text = difficulty.toString()

                Glide.with(this@DetailActivity)
                    .load(image)
                    .into(ivDetailThumb)
            }
        }
    }

    companion object {
        const val DETAIL_DATA = "detail_data"
    }
}