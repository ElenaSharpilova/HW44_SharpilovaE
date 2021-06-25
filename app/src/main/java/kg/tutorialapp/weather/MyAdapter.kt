package kg.tutorialapp.weather

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.tutorialapp.weather.MyAdapter.Type.ADVERTISMENT
import kg.tutorialapp.weather.MyAdapter.Type.ITEM

class MyAdapter (private val listener : OnClickListener):RecyclerView.Adapter<BaseViewHolder<Any>>() {

    private val items = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return  when (viewType){
            ITEM -> MyViewHolder.create(parent, listener)
            else -> AdViewHolder.create(parent, listener)
        }
    }

    override fun onBindViewHolder(holder:BaseViewHolder<Any>, position: Int) {
        Log.i(MyAdapter.tag, "onBindViewHolder()")
        holder.bind(items[position])
    }

    override fun getItemCount() = items.count()

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is String -> ADVERTISMENT
            is Item -> ITEM
            else -> -1
        }
    }

    fun setItems (newItems: List<Any>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    object Type{
        const val ITEM = 0
        const val ADVERTISMENT = 1
    }

    companion object{
        const val tag = "ADAPTER"
    }

    interface OnClickListener {
        fun onItemClick (position: Int)
        fun onAdClick (position: Int)

    }

}