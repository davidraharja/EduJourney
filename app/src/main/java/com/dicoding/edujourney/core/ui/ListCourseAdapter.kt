package com.dicoding.edujourney.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.edujourney.R
import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.databinding.ItemListCourseBinding

class ListCourseAdapter : RecyclerView.Adapter<ListCourseAdapter.ListCourseViewHolder>() {
    private var listCourse = ArrayList<Course>()
    var onItemClick: ((Course) -> Unit)? = null

    fun setOwnedCourse(course: List<Course>?) {
        if (course == null) return
        this.listCourse.clear()
        this.listCourse.addAll(course)
        notifyDataSetChanged()
    }

    inner class ListCourseViewHolder(private val binding: ItemListCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Course) {
            with(binding) {
                Glide.with(itemView.context).load(course.image).apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                ).into(imgListCourse)
                tvTitleList.text = course.title
            }
        }
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listCourse[bindingAdapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCourseViewHolder {
        val itemListCourseBinding =
            ItemListCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListCourseViewHolder(itemListCourseBinding)
    }

    override fun onBindViewHolder(holder: ListCourseViewHolder, position: Int) {
        val course = listCourse[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourse.size
}