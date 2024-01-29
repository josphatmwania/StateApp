//package com.josphat.stateapp.screens
//
//import android.widget.Toast
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.ViewModel
//import com.josphat.stateapp.ui.theme.StateAppTheme
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//
//
//@Composable
//fun ScreeTimeCounter(
//    modifier: Modifier = Modifier,
//    viewModel: ScreeTimeCounterVM = androidx.lifecycle.viewmodel.compose.viewModel(),
//) {
//    val state = viewModel.uiState.collectAsState()
//    val context = LocalContext.current
//
//    Column(
//        modifier = modifier.padding(16.dp),
//    ) {
//        Text(
//            "You have had ${state.value.glassCount} glasses of water today!",
//            modifier = Modifier.padding(vertical = 28.dp),
//        )
//
//        Row(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth(),
//        ) {
//            Button(
//                onClick = {
//                    if (state.value.glassCount >= 6) {
//                        Toast.makeText(
//                            context,
//                            "Congratulations for Hydrating",
//                            Toast.LENGTH_SHORT,
//                        ).show()
//                    }
//                    viewModel.onIncrement()
//                },
//            ) {
//                Text(text = "Add ")
//            }
//            Button(
//                onClick = {
//                    if (state.value.glassCount <= 1) {
//                        Toast.makeText(
//                            context,
//                            "Stop! You're dehydrating",
//                            Toast.LENGTH_SHORT,
//                        ).show()
//                    }
//                    viewModel.onDecrement()
//                },
//            ) {
//                Text(text = "Remove")
//            }
//        }
//    }
//}
//
//class GlassCounterVM : ViewModel() {
//
//    private var _uiState = MutableStateFlow(GlassCounterState())
//    val uiState: StateFlow<GlassCounterState> = _uiState.asStateFlow()
//
//    fun onIncrement() {
//        _uiState.update { state ->
//            state.copy(
//                glassCount = state.glassCount + 1,
//            )
//        }
//    }
//
//    fun onDecrement() {
//        _uiState.update { state ->
//            state.copy(
//                glassCount = state.glassCount - 1,
//            )
//        }
//    }
//}
//
//data class GlassCounterState(
//    val glassCount: Int = 0,
//)
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    StateAppTheme {
//        GlassCounter()
//    }
//}