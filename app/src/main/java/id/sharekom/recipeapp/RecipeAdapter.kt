package id.sharekom.recipeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.sharekom.recipeapp.data.model.Recipe
import id.sharekom.recipeapp.databinding.ItemRecepiBinding

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private var recipes: List<Recipe> = ArrayList()
    private lateinit var onItemClickListener: OnItemClickListener

    fun setData(recipes: List<Recipe>) {
        this.recipes = recipes
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    inner class RecipeViewHolder(private val binding: ItemRecepiBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(recipe: Recipe) {
            binding.tvName.text = recipe.name
            binding.tvHeadline.text = recipe.headline
            binding.tvTime.text = recipe.time

            Glide.with(binding.root)
                .load(recipe.thumb)
                .apply(RequestOptions().override(360))
                .into(binding.ivThumb)

            binding.root.setOnClickListener { onItemClickListener.setOnClickListener(recipe) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = ItemRecepiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    interface OnItemClickListener{
        fun setOnClickListener(recipe: Recipe)
    }
}