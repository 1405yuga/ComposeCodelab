package com.example.mycity.ui.data

import com.example.mycity.ui.model.Category
import com.example.mycity.ui.model.PlaceDetails

object PlacesData {
    fun getPlaceDetailsListByCategory(category: Category): List<PlaceDetails>? {
        return allPlaces[category]
    }

    fun getAllCategory(): List<Category> = allPlaces.keys.toList()

    private val allPlaces = mapOf(
        Category.COFFEE_SHOPS to listOf(
            PlaceDetails(
                "Cafe Coffee Day",
                "Popular café chain offering great coffee and snacks.",
                false
            ),
            PlaceDetails(
                "Brew Bliss",
                "Cozy café known for its handcrafted coffee and desserts.",
                true
            ),
            PlaceDetails(
                "Bean & Brew",
                "A modern coffee shop with a great ambiance and Wi-Fi.",
                false
            ),
            PlaceDetails(
                "The Coffee House",
                "A peaceful spot for coffee lovers and book readers.",
                true
            ),
            PlaceDetails(
                "Cafe Espresso",
                "Best espresso and cappuccino in town with a quiet atmosphere.",
                false
            ),
            PlaceDetails("Mocha Magic", "A charming coffee shop with unique flavored brews.", true)
        ),

        Category.RESTAURANTS to listOf(
            PlaceDetails(
                "Annapurna Pure Veg",
                "A well-known vegetarian restaurant with a variety of dishes.",
                true
            ),
            PlaceDetails("Ocean Grill", "Best seafood in town with a beachside view.", false),
            PlaceDetails(
                "Shree Krishna",
                "Delicious South Indian food served with authentic flavors.",
                true
            ),
            PlaceDetails(
                "Flavours of Punjab",
                "Mouth-watering North Indian cuisine in a vibrant setting.",
                false
            ),
            PlaceDetails("Tandoori Nights", "Famous for kebabs, biryanis, and live music.", false),
            PlaceDetails("Spice Symphony", "A fusion restaurant offering global cuisines.", false)
        ),

        Category.PARKS to listOf(
            PlaceDetails(
                "Rajodi Park",
                "A well-maintained park with jogging tracks and kids' play area.",
                true
            ),
            PlaceDetails(
                "Agashi Park",
                "A peaceful retreat surrounded by greenery and flowers.",
                true
            ),
            PlaceDetails(
                "Viva Garden",
                "An urban park with benches, fountains, and open lawns.",
                true
            ),
            PlaceDetails(
                "Yazoo Park",
                "A fun amusement park with rides and games for kids.",
                false
            ),
            PlaceDetails(
                "Arnala Beach Park",
                "A scenic park near the beach perfect for evening walks.",
                true
            ),
            PlaceDetails(
                "Global City Garden",
                "A spacious park with a walking trail and yoga area.",
                true
            )
        ),

        Category.SHOPPING_CENTER to listOf(
            PlaceDetails(
                "Reliance Trends",
                "Trendy clothing and accessories at affordable prices.",
                false
            ),
            PlaceDetails(
                "D-Mart",
                "One-stop shop for groceries, clothes, and daily essentials.",
                false
            ),
            PlaceDetails(
                "Viva Mall",
                "A popular shopping mall with food courts and entertainment.",
                false
            ),
            PlaceDetails(
                "Local Market",
                "Traditional street shopping with fresh produce and clothes.",
                true
            ),
            PlaceDetails(
                "City Center Mall",
                "Premium shopping destination with top brands and cinema.",
                false
            ),
            PlaceDetails(
                "Smart Bazaar",
                "Budget-friendly supermarket with discounts on household items.",
                false
            )
        ),

        Category.FORTS to listOf(
            PlaceDetails(
                "Arnala Fort",
                "A historic fort located on an island, accessible by boat.",
                false
            ),
            PlaceDetails(
                "Bassein Fort",
                "A Portuguese-era fort with beautiful ruins and sea views.",
                false
            ),
            PlaceDetails(
                "Kelve Fort",
                "An ancient fort near Kelve Beach, perfect for history lovers.",
                false
            ),
            PlaceDetails(
                "Mahim Fort",
                "A lesser-known fort offering quiet exploration opportunities.",
                false
            ),
            PlaceDetails(
                "Vasai Fort",
                "One of the largest and most historic forts near Virar.",
                false
            ),
            PlaceDetails(
                "Tung Fort",
                "A small hill fort with breathtaking views of the surroundings.",
                false
            )
        ),

        Category.BEACHES to listOf(
            PlaceDetails(
                "Arnala Beach",
                "The most famous beach in Virar, known for its black sand and water sports.",
                true
            ),
            PlaceDetails(
                "Rajodi Beach",
                "A clean and peaceful beach, perfect for long walks.",
                true
            ),
            PlaceDetails(
                "Kalamb Beach",
                "Less crowded beach with stunning sunsets and horse rides.",
                true
            ),
            PlaceDetails(
                "Navapur Beach",
                "An offbeat beach known for its serenity and beauty.",
                true
            ),
            PlaceDetails(
                "Bhuigaon Beach",
                "A hidden gem with minimal crowd and beautiful landscapes.",
                true
            ),
            PlaceDetails(
                "Suruchi Beach",
                "Lined with trees, this beach is perfect for picnics.",
                true
            )
        )
    )

}