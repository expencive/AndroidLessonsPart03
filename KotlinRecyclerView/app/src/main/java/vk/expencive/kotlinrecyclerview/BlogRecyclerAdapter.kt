package vk.expencive.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_list.view.*
import vk.expencive.kotlinrecyclerview.models.BlogPost

class BlogRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<BlogPost> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )

    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BlogViewHolder -> {
                holder.bind(items[position])}
        }
    }

    override fun getItemCount(): Int = items.size

    fun submintList (blogList: List<BlogPost>){
        items = blogList
    }


    class BlogViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        val blogImage: ImageView = itemView.blog_image
        val blogTitle = itemView.blog_title
        val blogAuthor = itemView.blog_author

        fun bind (blogPost: BlogPost){
            blogTitle.setText(blogPost.title)
            blogAuthor.setText(blogPost.username)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)
            
        }

    }
}

