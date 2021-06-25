package kg.tutorialapp.weather

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FragmentItems: Fragment (R.layout.fragment_items), MyAdapter.OnClickListener {

    private lateinit var myAdapter: MyAdapter
    lateinit var recyclerView : RecyclerView
    private lateinit var listener: FragmentItemsListener
    private lateinit var list : List <Any>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentItemsListener) listener = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        setup()
    }

    private fun setup () {

        list = Data.getLongListOfItems()

        myAdapter = MyAdapter(this)
        recyclerView.adapter = myAdapter
        myAdapter.setItems(list)


    }

    override fun onItemClick(position: Int) {
        val item = list[position] as Item
        listener.openFragmentItemDetails(item.id)
    }

    override fun onAdClick(position: Int) {
        val url = list[position] as String
        listener.openBrowser(url)
    }

}