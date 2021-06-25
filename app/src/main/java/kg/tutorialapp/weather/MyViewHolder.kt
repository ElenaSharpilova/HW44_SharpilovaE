package kg.tutorialapp.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView:View) : BaseViewHolder<Any>(itemView) {
    lateinit var iv_icon : ImageView
    lateinit var tv_name : TextView
    lateinit var button_1: Button

    override fun bind (item : Any){
        item as Item
        itemView.run {
            iv_icon = findViewById(R.id.iv_icon)
            tv_name = findViewById(R.id.tv_name)
            iv_icon.setImageResource(item.icon)
            tv_name.text = item.name
        }

    }


    companion object {
        fun create (parent: ViewGroup, listener: MyAdapter.OnClickListener) : MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_my_viewholder, parent, false)
            val holder = MyViewHolder(view)
            holder.itemView.setOnClickListener{
                listener.onItemClick(holder.adapterPosition)
            }

            holder.itemView.run {
                val button = findViewById<Button>(R.id.button)
                    button.setOnClickListener {
                        listener.onButtonClick(holder.adapterPosition)
                }
            }

            return holder
        }
    }
}