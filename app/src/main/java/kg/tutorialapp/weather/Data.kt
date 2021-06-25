package kg.tutorialapp.weather

object Data {
    val items = listOf<Item>(
            Item(1, "Java", R.drawable.ic_baseline_emoji_nature_24),
            Item(2, "Kotlin", R.drawable.ic_baseline_android_24),
            Item(3, "Dart", R.drawable.ic_baseline_nature_people_24)
    )

    val itemDetails = listOf<ItemDetails>(
            ItemDetails(1, "Java", R.drawable.ic_baseline_emoji_nature_24, " Sun Microsystems", "///"),
            ItemDetails(2, "Kotlin", R.drawable.ic_baseline_android_24, "Jet Brains", "///"),
            ItemDetails(3, "Dart", R.drawable.ic_baseline_nature_people_24, "Google", "///")

    )

    fun getLongListOfItems(): MutableList <Any> {
        val list = mutableListOf<Any>()
        for (i in 1..100){
            list.addAll(items)
            if (i % 3 == 0)
                list.add("http://kundaliniyoga.ru/novosti/2019/mezhdunarodnyy-trening-uchiteley-kundalini-yogi-perepodgotovka-po-spetsialnosti-prakticheskaya-psikh/")

        }
        return list
    }
}