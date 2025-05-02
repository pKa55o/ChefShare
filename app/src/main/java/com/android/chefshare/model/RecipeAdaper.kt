import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.chefshare.R
import com.android.chefshare.databinding.ItemEventRecipeBinding
import com.android.chefshare.model.Post
import com.bumptech.glide.Glide

class RecipeAdapter(
    private val posts: List<Post>,
    private val onClick: (Post) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemEventRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        private var vote = 0

        fun bind(post: Post) {
            binding.tvRecipeTitle.text = post.mota ?: "Tên món ăn"
            binding.tvIngredients.text = "Nguyên liệu: ${post.mota ?: "..."}"
            binding.tvAuthor.text = "Tác giả ID: ${post.idNguoidung ?: "Ẩn danh"}"

            // Vote count từ field có thể là string, ta ép kiểu:
            vote = post.soluongNguoithich?.toIntOrNull() ?: 0
            binding.tvVoteCount.text = vote.toString()

            binding.btnUpvote.setOnClickListener {
                vote++
                binding.tvVoteCount.text = vote.toString()
            }

            binding.btnDownvote.setOnClickListener {
                vote--
                binding.tvVoteCount.text = vote.toString()
            }

            // Load ảnh nếu có URL thumbnail
            if (!post.thumbnail.isNullOrEmpty()) {
                Glide.with(binding.root.context)
                    .load(post.thumbnail)
                    .placeholder(R.drawable.sample_food)
                    .centerCrop()
                    .into(binding.imgRecipe)
            } else {
                binding.imgRecipe.setImageResource(R.drawable.sample_food)
            }

            // Click mở chi tiết
            binding.root.setOnClickListener {
                onClick(post)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEventRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = posts.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }
}
