package com.dicoding.edujourney.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.edujourney.R
import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.databinding.ItemGridCourseBinding

class GridCourseAdapter : RecyclerView.Adapter<GridCourseAdapter.CourseViewHolder>() {
    private var listCourse = ArrayList<Course>()
    var onItemClick: ((Course) -> Unit)? = null

    fun setCoursesFree(course: List<Course>?) {
        if (course == null) return
        this.listCourse.clear()
        for (i in course.indices) {
            if (course[i].price == 0) listCourse.add(course[i])
        }
        notifyDataSetChanged()
    }

    fun setCoursesRec(course: List<Course>?) {
        if (course == null) return
        this.listCourse.clear()
        for (i in course.indices) {
            if (course[i].recommended) listCourse.add(course[i])
        }
        notifyDataSetChanged()
    }



    inner class CourseViewHolder(private val binding: ItemGridCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Course) {
            with(binding) {
                Glide.with(itemView.context).load(course.image).apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                ).into(imgGridCourse)
                tvTitleGrid.text = course.title
                tvPrice.text =
                    if (course.price == 0) itemView.context.getString(R.string.price_free) else course.price.toString()
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listCourse[bindingAdapterPosition])
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

    override fun onBindViewHolder(holder: GridCourseAdapter.CourseViewHolder, position: Int) {
        val course = listCourse[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourse.size

}