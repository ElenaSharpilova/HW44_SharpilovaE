package kg.tutorialapp.weather

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentItemsDetails: Fragment(R.layout.fragment_items_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        val idFromArgs = arguments?.getLong(Long:: class.java.canonicalName)

        idFromArgs?.let { id ->
            val details = Data.itemDetails.find { it.id == id}

            details?.let {
                var iv_detail_icon = view?.findViewById<ImageView>(R.id.iv_detail_icon)
                iv_detail_icon?.setImageResource(details.icon)

                var tv_detail_name = view?.findViewById<TextView>(R.id.tv_detail_name)
                tv_detail_name?.text = details.name

                var tv_detail_creator  = view?.findViewById<TextView>(R.id.tv_detail_creator)
                tv_detail_creator?.text = details.creator

                var tv_detail_discription  = view?.findViewById<TextView>(R.id.tv_detail_description)
                tv_detail_discription?.text = details.description
            }

        }
    }

    companion object {
        fun newInstance (id: Long) : FragmentItemsDetails {
            val bundle = Bundle().apply {
                putLong(Long::class.java.canonicalName, id)
            }

            return FragmentItemsDetails().apply { arguments = bundle }

        }
    }
}