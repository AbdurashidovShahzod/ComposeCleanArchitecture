package uz.unzosoft.composecleanarchitecture.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeDetails.ActiveDetailsScreen
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeList.ActiveListScreen
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.resource.Screen
import uz.unzosoft.composecleanarchitecture.presentation.ui.theme.ComposeCleanArchitectureTheme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ActiveListScreen.route
                    ) {
                        composable(route = Screen.ActiveListScreen.route) {
                            ActiveListScreen(navController)
                        }
                        composable(route = Screen.ActiveDetailsScreen.route+ "{activeId ]") {
                            ActiveDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}
