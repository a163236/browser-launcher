import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var profileName by remember { mutableStateOf("") }
        var isExpanded by remember { mutableStateOf(false) }

        Column(Modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
            TextField(value = profileName, onValueChange = { profileName = it })
            ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = it }) {
                TextField(value = "", onValueChange = {}, readOnly = true, trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                }, modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = {
                    isExpanded = false
                }) {
                    DropdownMenuItem(onClick = {}, text = { Text("afa") })
                    DropdownMenuItem(onClick = {}, text = { Text("afa") })
                    DropdownMenuItem(onClick = {}, text = { Text("afa") })
                }
            }
            Button(onClick = {
                val command = listOf(
                    "open",
                    "-na",
                    "Google Chrome",
                    "--args",
                    "--user-data-dir=/tmp/browser-profiles/$profileName",
                    "--temp-profile"
                )
                val processBuilder = ProcessBuilder(command)
                processBuilder.start()
            }) {
                Text(profileName)
            }
        }
    }
}