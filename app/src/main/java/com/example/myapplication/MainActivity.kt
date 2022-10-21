import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.myapplication.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            dropDown()
        }
    }
}

@Composable
fun dropDown() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Time Table", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },
        content = { MyContent() }
    )
}

@Composable
fun MyContent(){

    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val mCities = listOf("G1","G2","G3","G4","G5")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {

        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text("Group")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            mCities.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label
                    mExpanded = false
                }) {
                    Text(text = label)
                }
            }
        }
        if(mSelectedText.equals("G1")){
            Image(
                painter = painterResource(id = R.drawable.g1),
                contentDescription = "G1",
                modifier = Modifier.fillMaxWidth()
            )
        }
        else if(mSelectedText.equals("G2")){
            Image(
                painter = painterResource(id = R.drawable.g2),
                contentDescription = "G2",
                modifier = Modifier.fillMaxWidth()
            )
        }
        else if(mSelectedText.equals("G3")){
            Image(
                painter = painterResource(id = R.drawable.g3),
                contentDescription = "G3",
                modifier = Modifier.fillMaxWidth()
            )
        }
        else if(mSelectedText.equals("G4")){
            Image(
                painter = painterResource(id = R.drawable.g4),
                contentDescription = "G4",
                modifier = Modifier.fillMaxWidth()
            )
        }
        else if(mSelectedText.equals("G5")){
            Image(
                painter = painterResource(id = R.drawable.g5),
                contentDescription = "G5",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    dropDown()
}
