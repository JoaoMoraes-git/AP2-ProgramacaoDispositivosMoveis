package br.com.ulbra.ap2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.ulbra.ap2.data.JogoRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogoScreen(
    onJogoClick: (Int) -> Unit
) {
    val jogos = JogoRepository.listar()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("GameDex") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = jogos,
                key = { it.id }
            ) { jogo ->
                JogoCard(
                    jogo = jogo,
                    onClick = { onJogoClick(jogo.id) }
                )
            }
        }
    }
}
