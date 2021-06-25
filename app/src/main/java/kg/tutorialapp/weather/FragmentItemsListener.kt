package kg.tutorialapp.weather

interface FragmentItemsListener {
    fun openFragmentItemDetails (id: Long)

    fun openBrowser (url: String)
}