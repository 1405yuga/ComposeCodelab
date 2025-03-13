package com.example.flightsearch.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.R
import com.example.flightsearch.ui.data.FlightDetails
import com.example.flightsearch.ui.screens.FlightViewModel.Companion.factory
import kotlinx.coroutines.launch

enum class Screen {
    DisplayAll,
    DisplayFavorites
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: FlightViewModel = viewModel(factory = factory)
) {
    val flightList by viewModel.getAvailableFights().collectAsState(emptyList())
    val favoriteFlights by viewModel.getFavoriteFlights().collectAsState(emptyList())
    val coroutineScope = rememberCoroutineScope()
    var screen by rememberSaveable { mutableStateOf(Screen.DisplayAll) }
    val searchedQuery by viewModel.searchQuery.collectAsState("")
    var searchQuery by rememberSaveable { mutableStateOf(searchedQuery) }

    LaunchedEffect(searchedQuery) { searchQuery = searchedQuery }
    val filteredFlights =
        (if (screen == Screen.DisplayAll) flightList else favoriteFlights).filter {
            it.departureCode.contains(searchQuery, ignoreCase = true) ||
                    it.departureCode.contains(searchQuery, ignoreCase = true)
        }

    Log.d("SEARCH QUERY", "searched: $searchedQuery, search : $searchQuery")
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ScreenToggleButton(
            currentScreen = screen,
            onToggle = { screen = it })

        FlightSearchBar(
            query = searchQuery,
            onQueryChange = {
                searchQuery = it
                viewModel.setQuery(it)
            }
        )
        FlightsListDisplayScreen(
            flightsList = filteredFlights,
            onFavoriteClick = { flightDetails ->
                coroutineScope.launch {
                    if (flightDetails.isFavorite) viewModel.removeFromFavorite(flightDetails)
                    else viewModel.addToFavorite(flightDetails)
                }
            })
    }
}

@Composable
fun ScreenToggleButton(currentScreen: Screen, onToggle: (Screen) -> (Unit)) {
    val isFavorite = currentScreen == Screen.DisplayFavorites
    Button(onClick = {
        onToggle(if (currentScreen == Screen.DisplayAll) Screen.DisplayFavorites else Screen.DisplayAll)
    }) {
        Text(text = if (isFavorite) "Show All" else "Show Favorites")
    }
}

@Composable
fun FlightsListDisplayScreen(
    flightsList: List<FlightDetails>,
    onFavoriteClick: (FlightDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(flightsList) { item ->
            FlightCard(
                flightDetails = item,
                onFavoriteClick = onFavoriteClick
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        onActiveChange = { },
        placeholder = { Text("Search flights..") },
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "search icon")
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                OutlinedIconButton(onClick = { onQueryChange("") }) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear Search")
                }
            }
        }
    ) { }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightTopAppBar() {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun FlightCard(
    flightDetails: FlightDetails,
    onFavoriteClick: (FlightDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text("DEPART")
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(
                        text = flightDetails.departureCode,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = flightDetails.departureName)
                }
                Text("ARRIVE")
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = flightDetails.destinationCode,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = flightDetails.destinationName)
                }
            }
            OutlinedIconButton(onClick = { onFavoriteClick(flightDetails) }) {
                Icon(
                    imageVector = if (flightDetails.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Add to fav"
                )
            }
        }
    }
}

@Preview
@Composable
fun FlightListPreview() {
    val flights = List(10) {
        FlightDetails(
            departureCode = "ABC",
            destinationCode = "XYZ",
            departureName = "Abc is name",
            destinationName = "Xyz is loong name",
            isFavorite = false
        )
    }
    FlightsListDisplayScreen(flights, onFavoriteClick = {})
}

@Preview
@Composable
fun HomeScreenPreview() {
    Surface {
        HomeScreen()
    }
}