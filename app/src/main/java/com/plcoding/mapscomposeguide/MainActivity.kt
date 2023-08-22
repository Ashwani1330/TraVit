package com.plcoding.mapscomposeguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import com.plcoding.mapscomposeguide.LayoutsX.Topbar
import com.plcoding.mapscomposeguide.presentation.MapScreen
import com.plcoding.mapscomposeguide.ui.theme.MapsComposeGuideTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapsComposeGuideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    ModalDrawer(
                        drawerContent = {},
                        drawerState = drawerState
                    )
                    {
                        Scaffold(
                            topBar = {
                                androidx.compose.material.TopAppBar(
                                    title = {
                                        Text(text = "TraVit")
                                    },
                                    navigationIcon = {
                                        IconButton(onClick = {
                                            scope.launch {
                                                drawerState.open()
                                            }
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Menu,
                                                contentDescription = "Menu"
                                            )
                                        }
                                    },
                                    actions = {
                                        IconButton(onClick = {
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.LocationOn,
                                                contentDescription = "Locations"
                                            )

                                        }
                                        IconButton(onClick = { /*TODO*/ }) {
                                            Icon(
                                                imageVector = Icons.Default.DirectionsBus,
                                                contentDescription = "Bus_Icon"
                                            )
                                        }
                                    }
                                )
                            }
                        ) { contentPadding ->
                            MapScreen()

                        }

                    }

                }

            }

        }
    }
}