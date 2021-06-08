package com.dicoding.edujourney.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.databinding.ItemButtonCourseBinding

class SkillAdapter : RecyclerView.Adapter<SkillAdapter.SkillViewHolder>() {
    private var listSkill = ArrayList<Course>()
    var onItemClick: ((Course) -> Unit)? = null
    fun setSoftSkill(skill: List<Course>?) {
        if (skill == null) return
        this.listSkill.clear()
        for(i in skill.indices){
            if (skill[i].type == "SOFT") listSkill.add(skill[i])
        }
        notifyDataSetChanged()
    }
    fun setHardSkill(skill: List<Course>?) {
        if (skill == null) return
        this.listSkill.clear()
        for(i in skill.indices){
            if (skill[i].type == "HARD") listSkill.add(skill[i])
        }
        notifyDataSetChanged()
    }

    inner class SkillViewHolder(private val binding: ItemButtonCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(skill: Course) {
            with(binding) {
                tvTitleGrid.text = skill.title
            }
        }
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listSkill[bindingAdapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val itemButtonCourseBinding =
            ItemButtonCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SkillViewHolder(itemButtonCourseBinding)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val skill = listSkill[position]
        holder.bind(skill)
    }

    override fun getItemCount(): Int = listSkill.size
}