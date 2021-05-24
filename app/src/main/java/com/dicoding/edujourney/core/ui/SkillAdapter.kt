package com.dicoding.edujourney.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.edujourney.core.source.local.entity.SkillEntity
import com.dicoding.edujourney.databinding.ItemListCourseBinding

class SkillAdapter : RecyclerView.Adapter<SkillAdapter.SkillViewHolder>() {
    private var listSkill = ArrayList<SkillEntity>()
    fun setSkill(skill: List<SkillEntity>?) {
        if (skill == null) return
        this.listSkill.clear()
        this.listSkill.addAll(skill)
        notifyDataSetChanged()
    }

    inner class SkillViewHolder(private val binding: ItemListCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(skill: SkillEntity) {
            with(binding) {
                Glide.with(itemView.context).load(skill.image).apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                ).into(imgListCourse)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val itemListCourseBinding =
            ItemListCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SkillViewHolder(itemListCourseBinding)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val skill = listSkill[position]
        holder.bind(skill)
    }

    override fun getItemCount(): Int = listSkill.size
}