package kg.tutorialapp.weather

data class Item (
        val id : Long,
        val name : String,
        val icon : Int
)

data class ItemDetails (
        val id : Long,
        val name : String,
        val icon : Int,
        val creator : String,
        val description : String

)