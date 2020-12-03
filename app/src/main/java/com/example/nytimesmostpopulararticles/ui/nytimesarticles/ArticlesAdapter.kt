package com.example.nytimesmostpopulararticles.ui.nytimesarticles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesmostpopulararticles.databinding.ItemArticleBinding
import com.example.nytimesmostpopulararticles.models.Article
import com.example.nytimesmostpopulararticles.BR

class ArticlesAdapter :
    ListAdapter<Article, ArticlesAdapter.ArticlesViewHolder>(
        ArticleItemDiff
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticlesViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Article) {
            binding.setVariable(BR.article, item)
        }

    }

}

object ArticleItemDiff : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return (oldItem.id == newItem.id)
    }
}
