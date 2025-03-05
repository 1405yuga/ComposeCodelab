package com.example.mycity.ui.data

import com.example.mycity.R
import com.example.mycity.ui.model.Category
import com.example.mycity.ui.model.PlaceDetails

object PlacesData {
    fun getPlaceDetailsListByCategory(category: Category): List<PlaceDetails>? {
        return allPlaces[category]
    }

    fun getAllCategoryInPair(): List<Pair<Int, String>> =
        allPlaces.keys.map { category -> Pair(category.categoryImage, category.name) }

    fun getPlacesInImageAndTitleByCategory(category: Category): List<Pair<Int, String>>? =
        allPlaces[category]?.map { placeDetails ->
            Pair(
                placeDetails.placeImage,
                placeDetails.placeName
            )
        }

    private val allPlaces = mapOf(
        Category.COFFEE_SHOPS to listOf(
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Cafe Coffee Day",
                "Popular café chain offering great coffee and snacks.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Brew Bliss",
                "Cozy café known for its handcrafted coffee and desserts.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Bean & Brew",
                "A modern coffee shop with a great ambiance and Wi-Fi.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "The Coffee House",
                "A peaceful spot for coffee lovers and book readers.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Cafe Espresso",
                "Best espresso and cappuccino in town with a quiet atmosphere.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Mocha Magic",
                "A charming coffee shop with unique flavored brews.",
                true
            )
        ),

        Category.RESTAURANTS to listOf(
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Annapurna Pure Veg",
                "A well-known vegetarian restaurant with a variety of dishes.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Ocean Grill",
                "Best seafood in town with a beachside view.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Shree Krishna",
                "Delicious South Indian food served with authentic flavors.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Flavours of Punjab",
                "Mouth-watering North Indian cuisine in a vibrant setting.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Tandoori Nights",
                "Famous for kebabs, biryanis, and live music.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Spice Symphony",
                "A fusion restaurant offering global cuisines.",
                false
            )
        ),

        Category.PARKS to listOf(
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Rajodi Park",
                "A well-maintained park with jogging tracks and kids' play area.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Agashi Park",
                "A peaceful retreat surrounded by greenery and flowers.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Viva Garden",
                "An urban park with benches, fountains, and open lawns.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Yazoo Park",
                "A fun amusement park with rides and games for kids.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Arnala Beach Park",
                "A scenic park near the beach perfect for evening walks.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Global City Garden",
                "A spacious park with a walking trail and yoga area.",
                true
            )
        ),

        Category.SHOPPING_CENTER to listOf(
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Reliance Trends",
                "Trendy clothing and accessories at affordable prices.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "D-Mart",
                "One-stop shop for groceries, clothes, and daily essentials.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Viva Mall",
                "A popular shopping mall with food courts and entertainment.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Local Market",
                "Traditional street shopping with fresh produce and clothes.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "City Center Mall",
                "Premium shopping destination with top brands and cinema.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Smart Bazaar",
                "Budget-friendly supermarket with discounts on household items.",
                false
            )
        ),

        Category.FORTS to listOf(
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Arnala Fort",
                "A historic fort located on an island, accessible by boat.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Bassein Fort",
                "A Portuguese-era fort with beautiful ruins and sea views.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Kelve Fort",
                "An ancient fort near Kelve Beach, perfect for history lovers.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Mahim Fort",
                "A lesser-known fort offering quiet exploration opportunities.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Vasai Fort",
                "One of the largest and most historic forts near Virar.",
                false
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Tung Fort",
                "A small hill fort with breathtaking views of the surroundings.",
                false
            )
        ),

        Category.BEACHES to listOf(
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Arnala Beach",
                "The most famous beach in Virar, known for its black sand and water sports.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Rajodi Beach",
                "A clean and peaceful beach, perfect for long walks.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Kalamb Beach",
                "Less crowded beach with stunning sunsets and horse rides.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Navapur Beach",
                "An offbeat beach known for its serenity and beauty.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Bhuigaon Beach",
                "A hidden gem with minimal crowd and beautiful landscapes.",
                true
            ),
            PlaceDetails(
                R.drawable.ic_launcher_background,
                "Suruchi Beach",
                "Lined with trees, this beach is perfect for picnics.",
                true
            )
        )
    )

}