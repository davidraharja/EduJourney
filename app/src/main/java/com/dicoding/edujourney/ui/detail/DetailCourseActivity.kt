package com.dicoding.edujourney.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.edujourney.R
import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.databinding.ActivityDetailCourseBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailCourseActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var detailBinding: ActivityDetailCourseBinding
    private val viewModel: DetailViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val course = intent.getParcelableExtra<Course>(EXTRA_COURSE)
        if (course != null) {
            viewModel.setCourse(course.courseId)
        }
        viewModel.detailCourse.observe(this,{
            detailCourse ->
            if (detailCourse != null){
                populateCourse(detailCourse)
            }
        })
    }

    private fun populateCourse(detailCourse: Course) {
        with(detailBinding){
            tvOverview.text = detailCourse.description
            tvTitleDetail.text = detailCourse.title
            button.text = if(detailCourse.price == 0) getString(R.string.price_free) else detailCourse.price.toString()
            Glide.with(this@DetailCourseActivity).load(detailCourse.image).apply(
                RequestOptions.placeholderOf(
                    R.drawable.ic_loading
                ).error(R.drawable.ic_error)
            ).into(imgDetailCourse)
            val state = detailCourse.isBought
            setBoughtState(state)
            button.setOnClickListener{
                viewModel.setEnroll()
                Toast.makeText(applicationContext, getString(R.string.enroll_success),Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setBoughtState(state: Boolean) {
        if(state){
            detailBinding.button.text = getString(R.string.enrolled)
            detailBinding.button.isEnabled = false
        }
        else {
            detailBinding.button.isEnabled = true
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}