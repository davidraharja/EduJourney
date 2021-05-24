package com.dicoding.edujourney.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.edujourney.core.source.local.entity.CourseEntity
import com.dicoding.edujourney.databinding.ItemGridCourseBinding

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    private var listCourse = ArrayList<CourseEntity>()
    fun setCourses(course: List<CourseEntity>?) {
        if (course == null) return
        this.listCourse.clear()
        this.listCourse.addAll(course)
        notifyDataSetChanged()
    }

    inner class CourseViewHolder(private val binding: ItemGridCourseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: CourseEntity) {
            with(binding) {
                Glide.with(itemView.context).load(course.image).apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)).into(imgGridCourse)
                tvTitleGrid.text = course.title
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        val itemCourseBinding =
            ItemGridCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemCourseBinding)
    }

    override fun onBindViewHolder(holder: CourseAdapter.CourseViewHolder, position: Int) {
        val course = listCourse[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourse.size
}