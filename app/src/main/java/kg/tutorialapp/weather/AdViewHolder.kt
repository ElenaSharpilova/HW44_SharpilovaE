package kg.tutorialapp.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AdViewHolder (itemView: View) : BaseViewHolder<Any>(itemView) {
    lateinit var  tv_url : TextView

    override fun bind (item : Any){
        item as String
        itemView.findViewById<TextView>(R.id.tv_url).text = item

    }

    companion object {
        fun create (parent: ViewGroup, listener: MyAdapter.OnClickListener): AdViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_ad_viewholder, parent, false)
            return AdViewHolder(view).apply {
                itemView.setOnClickListener{
                    listener.onAdClick(adapterPosition)
                }
            }
        }
    }
}